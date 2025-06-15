package behaviouralpatterns.observerpattern;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User Ravi = new User("Ravi");
        Ravi.mobileNotification = true;
        Ravi.webNotification = true;
        User jack = new User("Jack");
        jack.mobileNotification = true;
        jack.webNotification = false;
        NotificationObserver observer = new NotificationObserver();
        observer.addNotify(new YoutubeWeb(jack));
        observer.addNotify(new YoutubeWeb(Ravi));
        observer.addNotify(new YoutubeMobile(jack));
        observer.addNotify(new YoutubeMobile(Ravi));
        observer.sendNotification("Design Pattern Playlist A-Z");
    }
}

interface NotificationUpdate{
    void notify(String message);
}

class YoutubeMobile implements NotificationUpdate{
    User user;
    public YoutubeMobile(User user){
        this.user = user;
    }

    @Override
    public void notify(String message) {
        if(user.mobileNotification){
            System.out.println(user.name+ " Mobile Notification: " + message);
        }
    }
}

class YoutubeWeb implements NotificationUpdate{
    User user;
    public YoutubeWeb(User user){
        this.user = user;
    }

    @Override
    public void notify(String message) {
        if(user.webNotification){
            System.out.println(user.name+ " Web Notification: " + message);
        }
    }
}

class User{
    String name;
    boolean mobileNotification;
    boolean webNotification;
    public User(String name){
        this.name = name;
    }
}

class NotificationObserver {
    List<NotificationUpdate> updateList = new ArrayList<>();
    public void addNotify(NotificationUpdate notificationUpdate){
        updateList.add(notificationUpdate);
    }
    public void sendNotification(String message){
        for(NotificationUpdate notificationUpdate: updateList){
            notificationUpdate.notify(message);
        }
    }
}
