import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

// Processor that transforms data
class MyProcessor extends SubmissionPublisher<Integer> implements Flow.Processor<Integer, Integer> {

    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        System.out.println("[Processor] Subscribed");
        subscription.request(1); // request first item
    }

    @Override
    public void onNext(Integer item) {
        System.out.println("[Processor] Processing item: " + item);
        submit(item * 2); // transform and publish
        subscription.request(1); // request next item
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("[Processor] Error: " + throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("[Processor] Completed");
        close(); // close processor (publisher)
    }
}

// Subscriber that consumes processed data
class MySubscriber implements Flow.Subscriber<Integer> {

    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        System.out.println("[Subscriber] Subscribed");
        subscription.request(1); // request first item
    }

    @Override
    public void onNext(Integer item) {
        System.out.println("[Subscriber] Received: " + item);
        subscription.request(1); // request next item
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("[Subscriber] Error: " + throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("[Subscriber] Completed");
    }
}

public class ReactiveStreamDemo {

    public static void main(String[] args) throws InterruptedException {
        SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>();
        MyProcessor processor = new MyProcessor();
        MySubscriber subscriber = new MySubscriber();

        // Chain the publisher → processor → subscriber
        publisher.subscribe(processor);    // processor acts as subscriber
        processor.subscribe(subscriber);   // processor acts as publisher

        // Publish data
        for (int i = 1; i <= 5; i++) {
            System.out.println("[Main] Publishing: " + i);
            publisher.submit(i);
        }

        // Close publisher when done
        publisher.close();

        // Wait for all items to be processed
        Thread.sleep(1000);
    }
}

