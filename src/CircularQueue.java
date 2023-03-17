import java.util.Scanner;

public class CircularQueue {
    private char[] queue;
    private int front;
    private int rear;
    private int size;

    public CircularQueue(int size) {
        this.size = size;
        queue = new char[size];
        front = -1;
        rear = -1;
    }

    public boolean isEmpty() {
        return (front == -1 && rear == -1);
    }

    public boolean isFull() {
        return ((rear + 1) % size == front);
    }

    public void enqueue(char data) {
        if (isFull()) {
            System.out.println("Очередь заполнена.");
            return;
        } else if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % size;
        }
        queue[rear] = data;
        System.out.println("Элемент " + data + " был добавлен в конец очереди.");
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Очередь пуста.");
            return;
        } else if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % size;
        }
        System.out.println("Элемент был удален из начала очереди.");
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Очередь пуста.");
            return;
        } else {
            System.out.print("Очередь: ");
            int i = front;
            while (i != rear) {
                System.out.print(queue[i] + " ");
                i = (i + 1) % size;
            }
            System.out.println(queue[rear]);
        }
    }


//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Введите размер очереди: ");
//        int size = scanner.nextInt();
//        CircularQueue queue = new CircularQueue(size);
//
//        while (true) {
//            System.out.println("\nВыберите действие:");
//            System.out.println("1. Проверка пустоты очереди.");
//            System.out.println("2. Проверка заполненности очереди.");
//            System.out.println("3. Добавление элемента в конец очереди.");
//            System.out.println("4. Удаление элемента из начала очереди.");
//            System.out.println("5. Вывод очереди на экран.");
//            System.out.println("6. Выход.");
//
//            int choice = scanner.nextInt();
//
//            switch (choice) {
//                case 1:
//                    if (queue.isEmpty()) {
//                        System.out.println("Очередь пуста.");
//                    } else {
//                        System.out.println("Очередь не пуста.");
//                    }
//                    break;
//                case 2:
//                    if (queue.isFull()) {
//                        System.out.println("Очередь заполнена.");
//                    } else {
//                        System.out.println("Очередь не заполнена.");
//                    }
//                    break;
//                case 3:
//                    System.out.print("Введите элемент для добавления: ");
//                    int data = scanner.nextInt();
//                    queue.enqueue(data);
//                    break;
//                case 4:
//                    queue.dequeue();
//                    break;
//                case 5:
//                    queue.display();
//                    break;
//                case 6:
//                    System.exit(0);
//                default:
//                    System.out.println("Ошибка ввода.");
//            }
//        }
//    }
}
