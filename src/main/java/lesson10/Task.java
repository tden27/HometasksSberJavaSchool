package lesson10;

public class Task {

    private final int number;

    public Task(int number){
        this.number = number;
    }

    public long factorial(){
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result = result * i;
        }
        return result;
    }
}
