public enum Week {
    ONE{
        public void sample(){
            System.out.println("Hello from ONE");
        }
    },
    TWO,
    THREE;

    public void sample() {
        System.out.println("Hello from sample");
    }
    Week(){
        System.out.println("called");
    }
}
