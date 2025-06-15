import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class Main {
    public Integer roll;
    public String studentName;

    public static void main(String[] args) throws Exception {

        SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>();
        publisher.subscribe(new PrintSubscriber());


        System.out.println("Submitting items...");

        for (int i = 0; i < 10; i++) {
            publisher.submit(i);
        }

        Thread.sleep(1000);
        publisher.close();
    }


}



class PrintSubscriber implements Flow.Subscriber<Integer> {

    private Flow.Subscription subscription;


    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(2);
    }

    @Override
    public void onNext(Integer item) {
        System.out.println("Received item: " + item);
//        subscription.request(1);
    }

    @Override
    public void onError(Throwable error) {
        System.out.println("Error occurred: " + error.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("PrintSubscriber is complete");
    }
}