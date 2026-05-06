import java.util.Scanner;
public class KRSMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        KRSQueue queue = new KRSQueue();

        int choice;
        do {
            System.out.println("\n=== KRS Approval Queue Menu ===");
            System.out.println("1.  Add Student to Queue (Enqueue)");
            System.out.println("2.  Process KRS Approval (Dequeue 2)");
            System.out.println("3.  Show All Students in Queue");
            System.out.println("4.  Show First Two Students");
            System.out.println("5.  Show Last Student (Rear)");
            System.out.println("6.  Check Queue Status (empty/full)");
            System.out.println("7.  Show Statistics");
            System.out.println("8.  Clear Queue");
            System.out.println("0.  Exit");
            System.out.print("Choose: ");
            choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("NIM   : "); String nim = sc.nextLine();
                    System.out.print("Name  : "); String name = sc.nextLine();
                    System.out.print("Study Program : "); String sp = sc.nextLine();
                    System.out.print("Class : "); String cl = sc.nextLine();
                    queue.enqueue(new Student(nim, name, sp, cl));
                    break;
                case 2: queue.approveKRS(); break;
                case 3: queue.printAll(); break;
                case 4: queue.printFirstTwo(); break;
                case 5: queue.viewRear(); break;
                case 6:
                    System.out.println("Empty: " + queue.isEmpty());
                    System.out.println("Full : " + queue.isFull());
                    break;
                case 7: queue.printStats(); break;
                case 8: queue.clear(); break;
                case 0: System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 0);
        sc.close();
    }
}
