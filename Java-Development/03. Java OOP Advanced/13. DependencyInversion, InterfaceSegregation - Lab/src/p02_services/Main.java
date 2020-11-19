package p02_services;

public class Main {
    public static void main(String[] args) {
        NotificationService service = new EmailNotificationService(true);
        NotificationService notActiveService = new EmailNotificationService(false);

        NotificationService smsActive = new SmsNotificationService(true);
        NotificationService smsNotActive = new SmsNotificationService(false);


        OnlineStoreOrder storeOrder = new OnlineStoreOrder(service, notActiveService, smsActive, smsNotActive);
        storeOrder.process();
    }
}
