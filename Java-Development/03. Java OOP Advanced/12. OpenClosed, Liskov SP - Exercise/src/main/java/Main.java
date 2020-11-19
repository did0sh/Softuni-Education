import interfaces.Appender;
import interfaces.Logger;
import models.MessageLogger;
import models.ReportLevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Controller controller = new Controller();
        List<Appender> appenders = new ArrayList<>();

        int count = Integer.parseInt(reader.readLine());

        for (int i = 0; i < count; i++) {
            String[] info = reader.readLine().split("\\s+");
            Appender appender = controller.readAppender(info);
            appenders.add(appender);
        }

        Logger logger = new MessageLogger(appenders.toArray(new Appender[appenders.size()]));

        String command;

        while (!"end".equalsIgnoreCase(command = reader.readLine())){
            String[] tokens = command.split("\\|");
            ReportLevel reportLevel = ReportLevel.valueOf(tokens[0]);
            String date = tokens[1];
            String message = tokens[2];
            String methodName = "";

            switch (reportLevel){
                case INFO:
                    methodName = "logInfo";
                    break;
                case WARNING:
                    methodName = "logWarning";
                    break;
                case ERROR:
                    methodName = "logError";
                    break;
                case CRITICAL:
                    methodName = "logCritical";
                    break;
                case FATAL:
                    methodName = "logFatal";
                    break;
            }
            
            Method method = Logger.class.getDeclaredMethod(methodName, String.class, String.class);
            method.invoke(logger, date, message);
        }

        System.out.print(logger);
    }
}

