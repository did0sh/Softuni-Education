package main.java.p02_ExtendedHttpParser.config;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Constants {

    public static final Charset CHARSET = StandardCharsets.UTF_8;

    public static final String HTTP_LINE_SEPARATOR = "\r\n";
    public static final String HTTP_VERSION = "HTTP/1.1";
    public static final String HEADERS_SEPARATOR = ": ";
    public static final String PARAMS_DELIMITER = "&";
    public static final String PARAMS_SEPARATOR = "=";
    public static final String REQUEST_LINE_SEPARATOR = " ";

}
