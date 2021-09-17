package lesson4.terminal;

import lesson4.terminal.exeptions.NotEnoughMoneyExeption;
import lesson4.terminal.exeptions.NotFoundClientExeption;
import lesson4.terminal.exeptions.NotValidAmountExeption;

import java.util.Scanner;

public class TerminalImpl implements Terminal {
    private final TerminalServer server;
    private final PinValidator pinValidator;
    private int pin;

    public TerminalImpl(){
        server = TerminalServer.getInstance();
        pinValidator = PinValidator.getInstance();
        pin = pinValidator.valid();
    }

    @Override
    public void checkAccount() {
        if (server.checkAccount(pin) != 0)
        ViewMessage.viewMessage("Ваш баланс: " + server.checkAccount(pin) + " руб.");
    }

    @Override
    public boolean withdrawMoney() {
        ViewMessage.viewMessage("Введите запрашиваемую сумму: ");
        Scanner scanner = new Scanner(System.in);
        double sum = scanner.nextDouble();
        try {
            return server.withdrawMoney(pin, sum);
        } catch (NotEnoughMoneyExeption | NotFoundClientExeption | NotValidAmountExeption e) {
            ViewMessage.viewMessage(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean putMoney() {
        ViewMessage.viewMessage("Введите сумму, которую хотите положить: ");
        Scanner scanner = new Scanner(System.in);
        double sum = scanner.nextDouble();
        try {
            return server.putMoney(pin, sum);
        } catch (NotValidAmountExeption | NotFoundClientExeption e) {
            ViewMessage.viewMessage(e.getMessage());
            return false;
        }
    }
}
