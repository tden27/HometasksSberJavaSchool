package lesson4.displaysContent;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Scanner;

public class DisplayContent {
    private static void readContent(String url) throws IOException {
        Object content = new URL(url).getContent();

        if (content instanceof InputStream) {
            InputStream contentStream = (InputStream) content;
            try (Scanner contentScanner = new Scanner(contentStream)) {
                while (contentScanner.hasNext()) {
                    System.out.println(contentScanner.next());
                }
            }
        } else {
            throw new IOException("Неподдерживаемый тип контента");
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in); // System.in закрывать не нужно

        do {
            System.out.println("Введите URL");
            String url = scanner.nextLine();

            try {
                readContent(url);

                break;
            } catch (MalformedURLException e) {
                System.out.println("Указан неверный URL!");
            } catch (UnknownHostException e) {
                System.out.println("Неизвестный хост!");
            } catch (IOException e) {
                System.out.println("Невозможно получить контент сайта. " + e.getMessage());
                throw e;
            }

            System.out.println("Попробуйте снова");
        } while (true);
    }
}
