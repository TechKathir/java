package structuralpatterns.adapterpattern;

public class Main {
    public static void main(String[] args) {
        Mac mac = new Mac();
        KeyboardAdapter keyboardAdapter = new KeyboardAdapter(mac);
        keyboardAdapter.connectKeyboard();
    }
}

interface Keyboard {
    void connectKeyboard();
}

class KeyboardAdapter implements Keyboard {
    private final Mac mac;

    public KeyboardAdapter(Mac mac) {
        this.mac = mac;
    }

    @Override
    public void connectKeyboard() {
        mac.wiredKeyboard();
    }
}

class Mac {
    public void wiredKeyboard() {
        System.out.println("Mac bluetoothKeyboard");
    }
}
