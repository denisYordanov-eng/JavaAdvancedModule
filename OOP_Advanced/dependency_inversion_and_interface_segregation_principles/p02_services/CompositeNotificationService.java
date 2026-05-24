package p02_services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompositeNotificationService implements NotificationService {
    private List<NotificationService> notificationServices;

    public CompositeNotificationService() {
        this.notificationServices = new ArrayList<NotificationService>();
    }

    public void addService(NotificationService notificationService) {
        this.notificationServices.add(notificationService);
    }


    @Override
    public boolean isActive() {
        return !this.notificationServices.isEmpty();
    }

    @Override
    public void sendNotification() {
        for (NotificationService notificationService : this.notificationServices) {
            if(notificationService.isActive()) {
                notificationService.sendNotification();
            }
        }
    }
}
