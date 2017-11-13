import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner in = null;

        System.out.print("Number people - ");
        int peopleCount = in.nextInt();

        System.out.print("Limit libraries - ");
        int maxAmount = in.nextInt();

        in.nextLine();

        Library library = new Library(maxAmount);
        for (int i = 0; i < peopleCount; i++) {
            new Thread(() -> {
                try {
                    library.Visitors();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
