package lesson10;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        for (Integer integer : readInt()) {
            Task task = new Task(integer);
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Поток " + Thread.currentThread().getName() + " рассчитал факториал числа: " + integer + " = " + task.factorial());
                }
            });
            thread.start();
        }
    }

    private static List<Integer> readInt() {
        List<Integer> integerList = new ArrayList<>();
        File file = new File("src\\main\\resources\\numbers.txt");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (bufferedReader.ready()){
                integerList.add(Integer.parseInt(bufferedReader.readLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return integerList;
    }
}
