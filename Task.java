public class Task{
    private String Tname;
    private int ExpectedTime;
    private int ActuallTime;
public String getName(){
    return(this.Tname);
}
public int getExpectedTime(){
    return(this.ExpectedTime);
}

public int getActuallTime(){
    return(this.ActuallTime);
}

public void setName(String name){
    this.Tname=name;
}

public void setExpectedTime(int time){
    this.ExpectedTime=time;
}
public void setActuallTime(int time){
    this.ActuallTime=time;
}
public int TaskComplition(){ //returns a positive number if the time took to complete the task was greater then the expected time
    return(this.ActuallTime-this.ExpectedTime);
}






}