import interfaces.Appender;
import interfaces.Layout;
import models.ReportLevel;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Controller {
    private static final String APPENDERS_FILE_PATH = "appenders.";
    private static final String LAYOUTS_FILE_PATH = "layouts.";

    public Appender readAppender(String[] info) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        String layoutType = info[1];
        Class<Layout> layoutClass = (Class<Layout>) Class.forName(LAYOUTS_FILE_PATH + layoutType);
        Layout layout = layoutClass.newInstance();

        String appenderType = info[0];
        Class<Appender> appenderClass = (Class<Appender>) Class.forName(APPENDERS_FILE_PATH + appenderType);
        Constructor<Appender> constructor = appenderClass.getDeclaredConstructor(Layout.class);
        Appender appender = constructor.newInstance(layout);

        if (info.length > 2){
            String reportLevelType = info[2];
            appender.setReportLevel(ReportLevel.valueOf(reportLevelType));
        }
        return appender;
    }
}
