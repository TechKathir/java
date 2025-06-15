package structuralpatterns.bridgepattern;

public class Main {
    public static void main(String[] args) {
        Tv tv = new Tv();
        ButtonRemote buttonRemote = new ButtonRemote(tv);
        buttonRemote.turnOn();
        buttonRemote.turnOff();

        TouchRemote touchRemote= new TouchRemote(tv);
        touchRemote.turnOn();
        touchRemote.turnOff();
    }
}

interface Device{
    void on();
    void off();
}

class Tv implements Device{
    @Override
    public void on() {
        System.out.println("Tv On");
    }

    @Override
    public void off() {
        System.out.println("Tv Off");
    }
}

class Projector implements Device{
    @Override
    public void on() {
        System.out.println("Projector On");
    }

    @Override
    public void off() {
        System.out.println("Projector Off");
    }
}


abstract class Remote{
    protected final Device device;
    public Remote(Device device){
        this.device = device;
    }
    abstract void turnOn();
    abstract void turnOff();
}

class ButtonRemote extends Remote{
    public ButtonRemote(Device device) {
        super(device);
    }
    @Override
    void turnOn() {
        System.out.println("Button Remote On");
        device.on();
    }
    @Override
    void turnOff() {
        System.out.println("Button Remote Off");
        device.off();
    }
}

class TouchRemote extends Remote{
    public TouchRemote(Device device) {
        super(device);
    }
    @Override
    void turnOn() {
        System.out.println("Touch Remote On");
        device.on();
    }
    @Override
    void turnOff() {
        System.out.println("Touch Remote Off");
        device.off();
    }
}