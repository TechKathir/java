package behaviouralpatterns.mediatorpattern;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GroupChat groupChat = new GroupChat();
//        groupChat.addUser();
        User user = new User("One", groupChat);
        User user1 = new User("Two", groupChat);
        User user2 = new User("Three", groupChat);
        User user3 = new User("Four", groupChat);
        groupChat.addUser(user);
        groupChat.addUser(user1);
        groupChat.addUser(user2);
        groupChat.addUser(user3);
        user.sendMessage("Hello, everyone!");
        user2.sendMessage("Hi there!");
    }
}

interface Mediator {
    void sendMessage(String message, User user);

    void addUser(User user);
}

class User {
    String name;
    Mediator mediator;

    public User(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public void receiveMessage(String message) {
        System.out.println(name + ": Receiving: " + message);
    }

    public void sendMessage(String message) {
        System.out.println(name + ": Message Sending...");
        mediator.sendMessage(message, this);
    }
}

class GroupChat implements Mediator {
    List<User> users = new ArrayList<>();

    @Override
    public void sendMessage(String message, User user) {
        users.forEach(v -> {
            if (user != v) {
                v.receiveMessage(message);
            }
        });
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }
}