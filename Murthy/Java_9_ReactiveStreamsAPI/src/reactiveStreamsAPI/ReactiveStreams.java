package reactiveStreamsAPI;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class ReactiveStreams {

	public static void main(String[] args) {
		 // Create a Publisher
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();

        // Create a Subscriber
        Flow.Subscriber<String> subscriber = new Flow.Subscriber<>() {
            private Flow.Subscription subscription;

            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                this.subscription = subscription;
                subscription.request(1); // Request first item
            }

            @Override
            public void onNext(String item) {
                System.out.println("Received: " + item);
                subscription.request(1); // Request next item
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("All data received!");
            }
        };

        // Connect Subscriber to Publisher
        publisher.subscribe(subscriber);

        // Publish some data asynchronously
        System.out.println("Publishing items...");
        publisher.submit("Hello");
        publisher.submit("Reactive");
        publisher.submit("Streams");

        publisher.close(); // Complete the stream

	}

}
