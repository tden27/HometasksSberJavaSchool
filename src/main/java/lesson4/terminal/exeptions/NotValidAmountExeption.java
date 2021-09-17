package lesson4.terminal.exeptions;

public class NotValidAmountExeption extends Throwable {
    String message = "Сумма должна быть кратна 100";

    @Override
    public String getMessage() {
        return message;
    }
}
