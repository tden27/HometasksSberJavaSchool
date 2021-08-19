package lesson1.temperatureConverter;

import java.util.Scanner;

public class TemperatureConverter {

    public static void main(String[] args) {
        System.out.print("Укажите какую температуру необходимо конвертировать: ");
        Scanner scanner = new Scanner(System.in);
        float temperatureCelsius = Float.parseFloat(scanner.nextLine());
        System.out.print("Укажите в какую еденицу измерения температуры необходимо конвертировать (Фаренгейт или Кельвин): ");
        String unitOfMeasure = scanner.nextLine();
        if (unitOfMeasure.equalsIgnoreCase("Фаренгейт"))
            System.out.println("Температура " + temperatureCelsius + "С равна " + temperatureConverterToFahrenheit(temperatureCelsius) + "F");
        else if (unitOfMeasure.equalsIgnoreCase("Кельвин"))
            System.out.println("Температура " + temperatureCelsius + "С равна " + temperatureConverterToKelvin(temperatureCelsius) + "K");
        else System.out.println("Неизвестная еденица измерения");
    }

    public static float temperatureConverterToFahrenheit (float celsius){
        return (9.0f/5.0f)*celsius + 32;
    }

    public static float temperatureConverterToKelvin (float celsius){
        return celsius + 273.15f;
    }
}
