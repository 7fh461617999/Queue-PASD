public class KRSQueue {
    static final int MAX_QUEUE = 10;      // max students waiting
    static final int MAX_SERVED = 30;     // max total students a DPA can handle

    Student[] data;
    int front, rear, size;
    int totalServed;   // counts approved students

    public KRSQueue() {
        data = new Student[MAX_QUEUE];
        front = 0; rear = -1; size = 0; totalServed = 0;
    }

    // ---- basic checks ----
    boolean isEmpty() { return size == 0; }
    boolean isFull()  { return size == MAX_QUEUE; }

    void clear() {
        front = 0; rear = -1; size = 0;
        System.out.println("Queue has been cleared.");
    }

    // ---- enqueue ----
    void enqueue(Student dt) {
        if (isFull()) { System.out.println("Queue is full!!! Max " + MAX_QUEUE + " students."); return; }
        if (totalServed >= MAX_SERVED) {
            System.out.println("DPA capacity reached (" + MAX_SERVED + " students). Cannot accept more.");
            return;
        }
        rear = (rear + 1) % MAX_QUEUE;
        data[rear] = dt;
        size++;
        System.out.printf("%s added to queue at position %d\n", dt.name, size);
    }

    // ---- dequeue 2 students (KRS approval session) ----
    void approveKRS() {
        if (isEmpty()) { System.out.println("No students in queue."); return; }
        System.out.println("=== KRS Approval Session ===");
        int count = Math.min(2, size);  // approve up to 2
        for (int i = 0; i < count; i++) {
            Student s = data[front];
            front = (front + 1) % MAX_QUEUE;
            size--;
            totalServed++;
            System.out.print("KRS Approved: ");
            s.print();
        }
        System.out.println("Students approved this session: " + count);
        System.out.println("Total approved so far: " + totalServed);
    }

    // ---- show all students in queue ----
    void printAll() {
        if (isEmpty()) { System.out.println("Queue is empty."); return; }
        System.out.println("--- All students in queue ---");
        int i = front;
        int count = 0;
        while (count < size) {
            data[i].print();
            i = (i + 1) % MAX_QUEUE;
            count++;
        }
        System.out.println("Total in queue: " + size);
    }

    // ---- show first 2 students ----
    void printFirstTwo() {
        if (isEmpty()) { System.out.println("Queue is empty."); return; }
        System.out.println("--- First two students in queue ---");
        int count = Math.min(2, size);
        int i = front;
        for (int j = 0; j < count; j++) {
            data[i].print();
            i = (i + 1) % MAX_QUEUE;
        }
    }

    // ---- show last student (rear) ----
    void viewRear() {
        if (isEmpty()) { System.out.println("Queue is empty."); return; }
        System.out.println("--- Last student in queue ---");
        data[rear].print();
    }

    // ---- statistics ----
    void printStats() {
        System.out.println("Total in queue now   : " + size);
        System.out.println("Total approved       : " + totalServed);
        System.out.println("Remaining DPA slots  : " + (MAX_SERVED - totalServed));
        int notYetApproved = totalServed + size; // everyone registered so far
        System.out.println("Students not yet approved (still in queue): " + size);
    }
}
