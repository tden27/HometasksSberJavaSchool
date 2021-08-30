package lesson4.terminal;

import lesson4.terminal.exeptions.NotEnoughMoneyExeption;
import lesson4.terminal.exeptions.NotFoundClientExeption;
import lesson4.terminal.exeptions.NotValidAmountExeption;

import java.util.HashSet;
import java.util.Set;

public class TerminalServer {
    private static TerminalServer instance;
    private static Set<ClientOfBank> clientsOfBank = new HashSet<>();
    static {
        clientsOfBank.add(new ClientOfBank("Ivanov Ivan", 1200, 1234));
        clientsOfBank.add(new ClientOfBank("Sergeev Sergey", 8200, 4321));
        clientsOfBank.add(new ClientOfBank("Nikolaev Nikolay", 0, 7777));
        clientsOfBank.add(new ClientOfBank("Denisov Denis", 300, 1212));
        clientsOfBank.add(new ClientOfBank("Vasiliev Vasiliy", 1200, 3589));
    }

    private TerminalServer(){}
    public static TerminalServer getInstance(){ // #3
        if(instance == null){
            instance = new TerminalServer();
        }
        return instance;
    }

    public double checkAccount(int pin){
        try {
            return getClientOfBank(pin).getMoney();
        } catch (NotFoundClientExeption e) {
            ViewMessage.viewMessage(e.getMessage());
            return 0;
        }
    }

    public boolean withdrawMoney(int pin, double sum) throws NotEnoughMoneyExeption, NotFoundClientExeption, NotValidAmountExeption {
        if (sum%100 != 0) throw new NotValidAmountExeption();
        if (getClientOfBank(pin).getMoney() < sum) throw new NotEnoughMoneyExeption();
        return true;
    }

    public boolean putMoney(int pin, double sum) throws NotValidAmountExeption, NotFoundClientExeption {
        if (sum%100 != 0) throw new NotValidAmountExeption();
        ClientOfBank clientOfBank = getClientOfBank(pin);
        clientOfBank.setMoney(sum);
        ViewMessage.viewMessage("Ваш текущий баланс: " + clientOfBank.getMoney());
        return true;
    }

    public ClientOfBank getClientOfBank(int pin) throws NotFoundClientExeption {
        for (ClientOfBank clientOfBank : clientsOfBank) {
            if (clientOfBank.getPin() == pin) return clientOfBank;
        }
        throw new NotFoundClientExeption();
    }

}
