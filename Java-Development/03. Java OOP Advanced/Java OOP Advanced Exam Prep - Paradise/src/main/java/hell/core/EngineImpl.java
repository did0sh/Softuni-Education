package hell.core;

import hell.commands.*;
import hell.io.ConsoleInputReader;
import hell.io.ConsoleOutputWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EngineImpl implements Engine {
    private ConsoleInputReader reader;
    private ConsoleOutputWriter writer;
    private AllCommands allCommands;

    public EngineImpl(ConsoleInputReader reader, ConsoleOutputWriter writer) {
        this.reader = reader;
        this.writer = writer;
        this.allCommands = new AllCommands();
    }

    @Override
    public void run() throws IOException, NoSuchFieldException, IllegalAccessException {
        String input;
        while (true){
            input = reader.readLine();
            String[] data = input.split("\\s+");
            String command = data[0];

            if (command.equalsIgnoreCase("quit")){
                writer.writeLine(this.allCommands.executeQuit());
                break;
            }

            switch (command){
                case "Hero":
                    writer.writeLine(this.allCommands.executeHero(data[1], data[2]));
                    break;
                case "Item":
                    writer.writeLine(this.allCommands.executeItem(data[1], data[2],
                            Integer.parseInt(data[3]),Integer.parseInt(data[4]),
                            Integer.parseInt(data[5]),Integer.parseInt(data[6]),Integer.parseInt(data[7])));
                    break;
                case "Recipe":
                    List<String> items = new ArrayList<>();
                    for (int i = 8; i < data.length ; i++) {
                        items.add(data[i]);
                    }
                    writer.writeLine(this.allCommands.executeRecipe(data[1], data[2],
                            Integer.parseInt(data[3]),Integer.parseInt(data[4]),
                            Integer.parseInt(data[5]),Integer.parseInt(data[6]),Integer.parseInt(data[7]), items));
                    break;
                case "Inspect":
                    writer.writeLine(this.allCommands.executeInspect(data[1]));
                    break;
            }
        }
    }
}
