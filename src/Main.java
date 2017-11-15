import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Number people - ");
                Scanner in;
                int peopleCount = scanner.nextInt();

                System.out.print("Limit libraries - ");
                int maxAmount = scanner.nextInt();

                scanner.nextLine();

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
