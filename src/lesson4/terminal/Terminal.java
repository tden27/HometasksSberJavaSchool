package lesson4.terminal;

public interface Terminal {

    //  Проверить состояние счета
    void checkAccount();

    //  Снять деньги
    boolean withdrawMoney();

    //  Положить деньги
    boolean putMoney();
}
