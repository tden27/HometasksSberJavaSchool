package lesson4.terminal.exeptions;

public class NonNumericCharacterExeption extends Throwable {
    String message = "Введен нечисловой символ! Пожалуйста вводите только цифры";

    @Override
    public String getMessage() {
        return message;
    }
}
