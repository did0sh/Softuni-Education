package p02_services;

public class SmsNotificationService implements NotificationService {

    private boolean isActive;

    public SmsNotificationService(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public void sendNotification() {
        System.out.println("Code for resetting the password: A7yT.");
    }

    @Override
    public boolean isActive() {
        return this.isActive;
    }
}
