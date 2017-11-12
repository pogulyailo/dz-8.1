import java.util.Random;
import java.util.concurrent.Semaphore;

public class Library {
    private final int MIN_READ_TIME = 1000;
    private final int MAX_READ_TIME = 5000;
    private final int DOOR_TRAVEL_TIME = 500;
    private final int DOOR_CAPACITY = 1;

    private final Semaphore librarySemaphore;
    private final Semaphore doorSemaphore;

    public Library (int maxAmount){
        librarySemaphore = new Semaphore(maxAmount, true);
        doorSemaphore = new Semaphore(DOOR_CAPACITY, true);
    }
    public void Visitors ()throws InterruptedException{
        Random random = new Random(System.currentTimeMillis());
        String threadName = Thread.currentThread().getName();

        if (!librarySemaphore.tryAcquire()) {
            System.out.println(threadName + " waiting for the entrance to the library ");
            librarySemaphore.acquire();
        }
        System.out.println(threadName + " went to the door from the street ");

    }
}
