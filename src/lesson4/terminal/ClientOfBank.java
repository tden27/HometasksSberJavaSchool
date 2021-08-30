package lesson4.terminal;

public class ClientOfBank {
    private String name;
    private double money;
    private final byte pin;

    public ClientOfBank(String name, double money, byte pin){
        this.name = name;
        this.money = money;
        this.pin = pin;
    }

    public double getMoney() {
        return money;
    }

    public int getPin() {
        return pin;
    }

    public void setMoney(double money) {
        this.money += money;
    }
}
