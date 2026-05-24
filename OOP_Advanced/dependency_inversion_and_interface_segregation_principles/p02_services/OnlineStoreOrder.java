package p02_services;

public class OnlineStoreOrder {

    private NotificationService notificationService;


    public OnlineStoreOrder(NotificationService first) {
        this.notificationService = first;

    }

    public void process() {
        if (this.notificationService.isActive())
            this.notificationService.sendNotification();
    }
}
