package lesson4.terminal;

import lesson4.terminal.exeptions.NonNumericCharacterExeption;

import java.util.Scanner;

public class PinValidator {
    private static PinValidator instance;
    private StringBuilder pinCode = new StringBuilder();

    private PinValidator(){}
    public static PinValidator getInstance(){ // #3
        if(instance == null){
            instance = new PinValidator();
        }
        return instance;
    }

    public int valid(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите пин-код: ");
        while (pinCode.length()<4) {
            try {
                String number = scanner.next();
                if (number.matches("\\d")) pinCode.append(number);
                else throw new NonNumericCharacterExeption();
            } catch (NonNumericCharacterExeption e) {
                ViewMessage.viewMessage(e.getMessage());
            }
        }
        return Byte.parseByte(String.valueOf(pinCode));
    }
}
