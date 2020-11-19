import contracts.BoatCreator;
import contracts.BoatSimulatorController;
import contracts.CommandHandler;
import contracts.EngineCreator;
import controllers.BoatSimulatorControllerImpl;
import Core.BoatCreatorImpl;
import Core.CommandHandlerImpl;
import Core.Engine;
import Core.EngineCreatorImpl;

public class Main {
    public static void main(String[] args) {
        BoatSimulatorController controller = new BoatSimulatorControllerImpl();
        BoatCreator boatCreator = new BoatCreatorImpl();
        EngineCreator engineCreator = new EngineCreatorImpl();
        CommandHandler commandHandler = new CommandHandlerImpl(controller, boatCreator, engineCreator);
        Engine engine = new Engine(commandHandler);

        engine.run();

    }
}
