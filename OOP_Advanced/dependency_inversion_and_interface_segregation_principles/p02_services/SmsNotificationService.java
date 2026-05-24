package p02_services;

public class SmsNotificationService implements NotificationService {

    private  boolean active;

    public SmsNotificationService(boolean active) {
        this.active = active;
    }
    @Override
    public boolean isActive() {
        return this.active;
    }

    @Override
    public void sendNotification() {
        System.out.println("No sms notification service.");
    }
}
