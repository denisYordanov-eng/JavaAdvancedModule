package p02_services;

public class Main {
    public static void main(String[] args) {
        NotificationService smsNotification = new SmsNotificationService(true);
        NotificationService emailNotification = new EmailNotificationService(true);


        CompositeNotificationService composite = new CompositeNotificationService();
        composite.addService(smsNotification);
        composite.addService(emailNotification);

        OnlineStoreOrder onlineStoreOrder = new OnlineStoreOrder(composite);
        onlineStoreOrder.process();
    }
}
