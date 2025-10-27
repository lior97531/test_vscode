package Tar_kita1_sol;

public class Main {
    public static void main(String[] args) {
        question1_Task t1 = new question1_Task("Ontime", 5, 5);
        question1_Task t2 = new question1_Task("early", 5, 3);
        question1_Task t3 = new question1_Task("late", 5, 8);

        question3_TeamMember e1 = new question3_TeamMember("1", "123456", 10000);
        question3_TeamMember e2 = new question3_TeamMember("2", "654321", 30000);

        e1.AddTask(t1);
        e1.AddTask(t2);
        System.out.println(e1.calcBonus());

        e2.AddTask(t3);
        e2.AddTask(t1);
        e2.AddTask(t3);
        System.out.println(e2.calcBonus());
    }
}
