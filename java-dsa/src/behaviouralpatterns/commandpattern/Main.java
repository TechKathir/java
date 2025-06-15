package behaviouralpatterns.commandpattern;

public class Main {
    public static void main(String[] args) {
        Tv tv = new Tv();
        TvOffCommand tvOffCommand = new TvOffCommand(tv);
        TvOnCommand tvOnCommand = new TvOnCommand(tv);
        TvRemote tvRemote = new TvRemote();
        tvRemote.setOffCommand(tvOffCommand);
        tvRemote.setOnCommand(tvOnCommand);
        tvRemote.onTv();
        tvRemote.offTv();
    }
}

interface Command{
    void execute();
}

class Tv {
    public void on(){
        System.out.println("TV On");
    }
    public void off(){
        System.out.println("TV Off");
    }
}

class TvOnCommand implements Command{
    private final Tv tv;
    public TvOnCommand(Tv tv){
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.on();
    }
}

class TvOffCommand implements Command{
    private final Tv tv;
    public TvOffCommand(Tv tv){
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.off();
    }
}

class TvRemote{
    private Command onCommand;
    private Command offCommand;
    public void setOnCommand(Command onCommand){
        this.onCommand = onCommand;
    }

    public void setOffCommand(Command offCommand){
        this.offCommand = offCommand;
    }
    public void onTv(){
        onCommand.execute();
    }
    public void offTv(){
        offCommand.execute();
    }
}