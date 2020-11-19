import config.Constants;
import http.*;

public class Application {

    private static final String HEADERS = "" +
            "Date: 17/01/2019\r\n" +
            "Host: localhost:8000\r\n" +
            "Content-Type: application/xml\r\n" +
            "Cookie: lang=en; Sess=lsn3Xeg2\r\n"
    ;

    public static void main(String[] args) {
        HttpRequest postRequest = new HttpRequestImpl("" +
                "POST /url HTTP/1.1\r\n" +
                HEADERS +
                "\r\n" +
                "name=Yum&quantity=50&price=10");

        HttpRequest secondPostRequest = new HttpRequestImpl("" +
                "POST /url HTTP/1.1\r\n" +
                "Cookie: JSession=c3zdsDDD341v\r\n" +
                "\r\n" +
                "name=Yum&quantity=50&price=10");


        HttpRequest getResourceRequest = new HttpRequestImpl("" +
               "GET /url HTTP/1.1\r\n" +
                "Host: localhost:8000\r\n" +
                "Cookie: lang=en; theme=dark; locale=bg_EN; JSession=58vzsdfg");

        HttpResponse httpResponse = new HttpResponseImpl();
        httpResponse.setStatusCode(StatusCode.OK);
        postRequest.getHeaders().forEach(httpResponse::addHeader);

        System.out.println(new String(httpResponse.getBytes(), Constants.CHARSET));

        System.out.println("Cookies: ------------------------------");

        postRequest.getCookies()
                .forEach(cookie -> System.out.printf("%s <-> %s%n", cookie.getKey(), cookie.getValue()));

        secondPostRequest.getCookies()
                .forEach(cookie -> System.out.printf("%s <-> %s%n", cookie.getKey(), cookie.getValue()));

        getResourceRequest.getCookies()
                .forEach(cookie -> System.out.printf("%s <-> %s%n", cookie.getKey(), cookie.getValue()));
    }
}
