package cresla.commandManager;

import cresla.entities.containers.ModuleContainer;
import cresla.enums.ModuleTypes;
import cresla.enums.ReactorTypes;
import cresla.interfaces.*;
import cresla.io.ConsoleInputReader;
import cresla.io.ConsoleOutputWriter;
import cresla.models.modules.BaseModule;
import cresla.models.modules.CooldownSystem;
import cresla.models.modules.CryogenRod;
import cresla.models.modules.HeatProcessor;
import cresla.models.reactors.BaseReactor;
import cresla.models.reactors.CryoReactor;
import cresla.models.reactors.HeatReactor;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CommandManager implements Manager {
    private ConsoleInputReader reader;
    private ConsoleOutputWriter writer;

    private Map<Integer, BaseReactor> allReactors;
    private Map<Integer, BaseModule> allModules;
    private int id;

    public CommandManager() {
        this.id = 1;
        this.writer = new ConsoleOutputWriter();
        this.reader = new ConsoleInputReader();
        this.allReactors = new LinkedHashMap<>();
        this.allModules = new LinkedHashMap<>();
    }

    public void run() throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {
        String output = null;

        while (true) {
            List<String> arguments = Arrays.stream(this.reader.readLine().split(" ")).collect(Collectors.toList());
            switch (arguments.get(0)) {
                case "Reactor":
                    output = this.reactorCommand(arguments);
                    this.writer.writeLine(output);
                    break;
                case "Module":
                    output = this.moduleCommand(arguments);
                    this.writer.writeLine(output);
                    break;
                case "Report":
                    output = this.reportCommand(arguments);
                    this.writer.writeLine(output);
                    break;
                case "Exit":
                    output = this.exitCommand(arguments);
                    this.writer.writeLine(output);
                    break;
            }

            if (arguments.get(0).equalsIgnoreCase("exit")) {
                break;
            }
        }
    }

    @Override
    public String reactorCommand(List<String> arguments) {
        StringBuilder sb = new StringBuilder();
        ReactorTypes type = ReactorTypes.valueOf(arguments.get(1).toUpperCase());
        int additionalParam = Integer.parseInt(arguments.get(2));
        int moduleCapacity = Integer.parseInt(arguments.get(3));
        Container container = new ModuleContainer(moduleCapacity);

        switch (type) {
            case CRYO:
                CryoReactor reactor = new CryoReactor(container, this.id, additionalParam);
                this.allReactors.put(reactor.getId(), reactor);
                sb.append(String.format("Created Cryo Reactor - %d", this.id));
                break;
            case HEAT:
                HeatReactor heatReactor = new HeatReactor(container, this.id, additionalParam);
                this.allReactors.put(heatReactor.getId(), heatReactor);
                sb.append(String.format("Created Heat Reactor - %d", this.id));
                break;
        }

        this.id++;
        return sb.toString();
    }

    @Override
    public String moduleCommand(List<String> arguments) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {
        StringBuilder sb = new StringBuilder();
        int reactorId = Integer.parseInt(arguments.get(1));
        ModuleTypes type = ModuleTypes.valueOf(arguments.get(2).toUpperCase());
        int additionalParam = Integer.parseInt(arguments.get(3));

        switch (type) {
            case CRYOGENROD:
                CryogenRod cryogenRod = new CryogenRod(this.id, additionalParam);
                sb.append(String.format("Added CryogenRod - %d to Reactor - %d", this.id, reactorId));
                this.allModules.put(cryogenRod.getId(), cryogenRod);
                this.allReactors.get(reactorId).addEnergyModule(cryogenRod);
                break;
            case COOLDOWNSYSTEM:
                CooldownSystem cooldownSystem = new CooldownSystem(this.id, additionalParam);
                sb.append(String.format("Added CooldownSystem - %d to Reactor - %d", this.id, reactorId));
                this.allModules.put(cooldownSystem.getId(), cooldownSystem);
                this.allReactors.get(reactorId).addAbsorbingModule(cooldownSystem);
                break;
            case HEATPROCESSOR:
                HeatProcessor heatProcessor = new HeatProcessor(this.id, additionalParam);
                sb.append(String.format("Added HeatProcessor - %d to Reactor - %d", this.id, reactorId));
                this.allModules.put(heatProcessor.getId(), heatProcessor);
                this.allReactors.get(reactorId).addAbsorbingModule(heatProcessor);
                break;
        }

        this.id++;
        return sb.toString();
    }

    @Override
    public String reportCommand(List<String> arguments) {
        int id = Integer.parseInt(arguments.get(1));
        if (this.allModules.containsKey(id)) {
            return this.allModules.get(id).toString();
        } else {
            return this.allReactors.get(id).toString();
        }
    }

    @Override
    public String exitCommand(List<String> arguments) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        int cryoReactorsCount = this.allReactors.values().stream()
                .filter(reactor -> reactor.getClass().getSimpleName().equals("CryoReactor"))
                .collect(Collectors.toList()).size();

        int heatReactorsCount = this.allReactors.values().stream()
                .filter(reactor -> reactor.getClass().getSimpleName().equals("HeatReactor"))
                .collect(Collectors.toList()).size();

        int absorbingModulesCount = this.allModules.values().stream()
                .filter(module -> module.getClass().getSimpleName().equals("CooldownSystem") ||
                        module.getClass().getSimpleName().equalsIgnoreCase("HeatProcessor"))
                .collect(Collectors.toList()).size();

        int energyModulesCount = this.allModules.values().stream()
                .filter(module -> module.getClass().getSimpleName().equals("CryogenRod"))
                .collect(Collectors.toList()).size();

        long totalEnergy = 0;
        long totalHeat = 0;

        totalEnergy = this.allReactors.entrySet().stream()
                .mapToLong(reactor -> reactor.getValue().getTotalEnergyOutput()).sum();

        totalHeat = this.allReactors.entrySet().stream().
                mapToLong(reactor -> reactor.getValue().getTotalHeatAbsorbing()).sum();

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Cryo Reactors: %d%nHeat Reactors: %d%n" +
                        "Energy Modules: %d%nAbsorbing Modules: %d%nTotal Energy Output: %d%n" +
                        "Total Heat Absorbing: %d", cryoReactorsCount, heatReactorsCount, energyModulesCount, absorbingModulesCount,
                totalEnergy, totalHeat));
        return sb.toString();
    }
}
