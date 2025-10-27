package Tar_kita1_sol;

import java.util.List;
import java.util.ArrayList;

public class question2_Employee {
    protected String _name;
    protected String _id;
    protected ArrayList<question1_Task> _TaskList = new ArrayList<question1_Task>();
    protected int _salary;
    protected int _bonus;

    public question2_Employee(String name, String id, int salary) {
        _name = name;
        _id = id;
        _salary = salary;
    }

    public void AddTask(question1_Task task) {//adding task to the list
        _TaskList.add(task);
    }

    public int get_salary() {
        return _salary;
    }

    public void set_salary(int _salary) {
        this._salary = _salary;
    }

    public int getBonus() {
        return (this._bonus);
    }

    public void setBonus(int num) {
        this._bonus = num;
    }


    public int calcBonus() {
        return 0;
    }
}
