import java.util.Random;
import java.util.Scanner;

public class QueueSimulator {
    private static final int QUEUE_MAX_SIZE = 50;
    private static final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(QUEUE_MAX_SIZE);
        System.out.print("Введите символ для окончания программы: ");
        char stopChar = scanner.nextLine().charAt(0);
        while (true) {
            int X = random.nextInt(100);
            int elements = random.nextInt(3) + 1;
            if (X % 2 == 0) {
                for (int i = 0; i < elements; i++) {
                    if (queue.isFull()) {
                        break;
                    }
                    char elem = (char) (random.nextInt(26) + 65);
                    queue.enqueue(elem);
                }
            } else {
                for (int i = 0; i < elements; i++) {
                    if (queue.isEmpty()) {
                        break;
                    }
                    queue.dequeue();
                }
            }
            queue.display();
            System.out.print("Нажмите Enter для продолжения или " + stopChar + " для выхода: ");
            String input = scanner.nextLine();
            if (!input.isEmpty() && input.charAt(0) == stopChar) {
                break;
            }
        }
    }
}