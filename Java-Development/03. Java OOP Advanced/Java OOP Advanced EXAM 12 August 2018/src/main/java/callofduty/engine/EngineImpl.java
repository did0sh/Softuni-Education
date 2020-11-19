package callofduty.engine;

import callofduty.interfaces.InputReader;
import callofduty.interfaces.MissionManager;
import callofduty.interfaces.OutputWriter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EngineImpl {
    private InputReader reader;
    private OutputWriter writer;
    private MissionManager commandManager;

    public EngineImpl(InputReader reader, OutputWriter writer, MissionManager commandManager) {
        this.reader = reader;
        this.writer = writer;
        this.commandManager = commandManager;
    }

    public void run(){
        String input;
        while (true){
            input = this.reader.readLine();
            List<String> commands = Arrays.stream(input.split("\\s+")).collect(Collectors.toList());
            switch (commands.get(0)){
                case "Agent":
                   this.writer.println(this.commandManager.agent(commands));
                    break;
                case "Request":
                    this.writer.println(this.commandManager.request(commands));
                    break;
                case "Status":
                    this.writer.println(this.commandManager.status(commands));
                    break;
                case "Complete":
                    this.writer.println(this.commandManager.complete(commands));
                    break;
            }

            if (commands.get(0).equals("Over")){
                this.writer.println(this.commandManager.over(commands));
                break;
            }
        }
    }
}
