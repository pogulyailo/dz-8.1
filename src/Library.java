import java.util.Random;
import java.util.concurrent.Semaphore;

public class Library {
    private final int MIN_READ_TIME = 1000;
    private final int MAX_READ_TIME = 5000;
    private final int DOOR_TRAVEL_TIME = 500;


    private final Semaphore librarySemaphore;
    private final Semaphore doorSemaphore;

    public Library (int maxAmount){
        librarySemaphore = new Semaphore(maxAmount, true);
        doorSemaphore = new Semaphore(DOOR_TRAVEL_TIME, true);
    }

    public void Visitors ()throws InterruptedException {
        Random random = new Random(System.currentTimeMillis());
        String threadName = Thread.currentThread().getName();

        System.out.println(threadName + " came to the entrance to the library ");
        System.out.println(threadName + " went to the door from the street ");

        if (!librarySemaphore.tryAcquire()) {
            System.out.println(threadName + " waiting for the entrance to the library ");
            librarySemaphore.acquire();
        }
        doorSemaphore.acquire();
        System.out.println(threadName + " passes through the door inside ");
        Thread.sleep(DOOR_TRAVEL_TIME);
        System.out.println(threadName + " went through the door inside ");

        System.out.println(threadName + " entered the library ");
        doorSemaphore.release();

        System.out.println(" read book");
        Thread.sleep((MAX_READ_TIME - MIN_READ_TIME) + MIN_READ_TIME);

        doorSemaphore.acquire();
        System.out.println(threadName + " passes through the door to the outside ");
        Thread.sleep(DOOR_TRAVEL_TIME);
        System.out.println(threadName + " walked through the door to the outside ");

        System.out.println(threadName + " left the library ");
        doorSemaphore.release();

        librarySemaphore.release();
    }
}