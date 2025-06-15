package behaviouralpatterns.chainofresponsibility;

public class Main {
    public static void main(String[] args) {
        AuthorizationHandler authorizationHandler = new AuthorizationHandler();
        Logger logger = new Logger();
        Login login = new Login();
        authorizationHandler.setNext(logger);
        logger.setNext(login);
        authorizationHandler.process("AUTH");
        authorizationHandler.process("LOGGER");
        authorizationHandler.process("Login");

    }
}


abstract class ConnectionChain {
    protected ConnectionChain next;

    public void setNext(ConnectionChain next) {
        this.next = next;
    }

    abstract void process(String type);
}

class AuthorizationHandler extends ConnectionChain {
    @Override
    void process(String type) {
        if (type.equals("AUTH")) {
            System.out.println("Auth handled");
        } else {
            next.process(type);
        }
    }
}


class Logger extends ConnectionChain {
    @Override
    void process(String type) {
        if (type.equals("LOGGER")) {
            System.out.println("Logger handled");
        } else {
            next.process(type);
        }
    }
}

class Login extends ConnectionChain {
    @Override
    void process(String type) {
        if (type.equals("Login")) {
            System.out.println("Logged in");
        } else {
            System.out.println("End of chain");
        }
    }
}
