package Observer;
public class ObserverTest {
    public static void main(String[] args) {
        //Creating Three Subscribers
		FirstMessageSubscriber firstMessageSubscriber = new FirstMessageSubscriber();
		SecondMessageSubscriber secondMessageSubscriber = new SecondMessageSubscriber();
		ThirdMessageSubscriber thirdMessageSubscriber = new ThirdMessageSubscriber();
 
		//Creating Message Publisher
		MessagePublisher messagePublisher = new MessagePublisher();
 
		//Register two Subscribers to get notifications on any update
		messagePublisher.register(firstMessageSubscriber);
		messagePublisher.register(secondMessageSubscriber);
 
		//firstMessageSubscriber and secondMessageSubscriber will receive the update
		messagePublisher.notifyUpdate(new Message("This is First Message"));
		System.out.println("---------------------------------------------------------------");
 
		/*Now UnRegister firstMessageSubscriber so that
		it won't get notification on any update*/
		messagePublisher.unregister(firstMessageSubscriber);
		messagePublisher.unregister(thirdMessageSubscriber);
		//Now Register one more Subscriber to get notifications on any update
		messagePublisher.register(thirdMessageSubscriber);
 
		//secondMessageSubscriber and thirdMessageSubscriber will receive the update
		messagePublisher.notifyUpdate(new Message("This is Second Message"));
    }
}
