import java.util.PriorityQueue;

public class QueuePractice {
    class Student {
        String name;
        double cgpa;

        Student (String name, double cgpa) {
            this.name = name;
            this.cgpa = cgpa;
        }
    }

    public void sort() {
        PriorityQueue<Student> queue = new PriorityQueue<>((s1, s2) -> {
            if (s1.cgpa < s2.cgpa) {
                return 1;
            } else if (s1.cgpa > s2.cgpa) {
                return -1;
            } else {
                return 0;
            }
        });

        Student student1 = new Student("Nandini", 3.2);
        Student student2 = new Student("Anmol", 3.6);
        Student student3 = new Student("Palak", 4.0);
        queue.add(student1);
        queue.add(student2);
        queue.add(student3);

        while (!queue.isEmpty()) {
            System.out.println(queue.remove().cgpa);
        }
    }

    public static void main(String[] args) {
        QueuePractice queuePractice = new QueuePractice();
        queuePractice.sort();
    }
}
