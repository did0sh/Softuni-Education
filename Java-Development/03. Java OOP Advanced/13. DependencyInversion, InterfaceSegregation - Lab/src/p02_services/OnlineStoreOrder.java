package p02_services;

import java.util.Arrays;
import java.util.List;

public class OnlineStoreOrder {

    private List<NotificationService> emailNotification;
    private List<NotificationService> smsNotification;

    public OnlineStoreOrder(NotificationService... services) {
        this.emailNotification = Arrays.asList(services);
        this.smsNotification = Arrays.asList(services);
    }

    public void process() {
        for (NotificationService emailNotificationService : this.emailNotification) {
            if (emailNotificationService.isActive()){
                emailNotificationService.sendNotification();
            }
        }

        for (NotificationService smsNotificationService : this.smsNotification) {
            if (smsNotificationService.isActive()){
                smsNotificationService.sendNotification();
            }
        }
    }
}
