package lesson4.terminal.exeptions;

public class NotEnoughMoneyExeption extends Throwable {
    String message = "Недостаточно средств";

    @Override
    public String getMessage() {
        return message;
    }
}
