import java.util.List;
import java.util.ArrayList;

public class Employee {
    protected String _name;
    protected String _id;
    protected ArrayList<Task> _TaskList;
    protected int _salary;
protected int _bonus;

public int getBonus(){
    return(this._bonus);
}
public void setBonus(int num){
this._bonus=num;
}


public int calcBonus(){
    return 0;
}


}
