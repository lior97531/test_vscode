package Tar_kita1_sol;

import java.util.List;
import java.util.ArrayList;


public class question3_TeamMember extends question2_Employee {
    public question3_TeamMember(String name, String id, int salary) {
        super(name, id, salary);
    }

    public int calcBonus() {  //calculating the bonus based on the time it took to complete each task (early - factor*2 onTime-factor late-non
        int bonus = 0;
        boolean noTask = this._TaskList.isEmpty();//making sure that the list is not empty
        int Listsize = this._TaskList.size();
        int factor = this._salary / Listsize;
        if (!noTask) {
            for (question1_Task task : _TaskList) {
                if (task.TaskComplition() < 0) {
                    bonus += factor * 2;
                } else if (task.TaskComplition() == 0) {
                    bonus += factor;
                }
            }
        }


        return bonus;
    }

}
