package lesson4.terminal.exeptions;

public class NotFoundClientExeption extends Throwable {
    String message = "Клиент не найден";

    @Override
    public String getMessage() {
        return message;
    }
}
