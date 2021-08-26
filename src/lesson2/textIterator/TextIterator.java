package lesson2.textIterator;

import java.io.*;
import java.util.*;

public class TextIterator {
    public static List<String> textList = new ArrayList<>();
    public static List<String> lines = new ArrayList<>();

    public static void textReader(){
        try (BufferedReader fileReader = new BufferedReader(new FileReader(
                new File("C:\\Users\\t_den\\IdeaProjects\\HometasksSberJavaSchool\\resources\\text.txt")))) {
            StringBuilder sb = new StringBuilder();
            while (fileReader.ready()) {
                String s = fileReader.readLine();
                sb.append(s);
                lines.add(s);
            }
            System.out.println(sb);
            System.out.println(lines);
            String s = sb.toString().toLowerCase(Locale.ROOT);
            String[] strings = s.split("[^а-яА-Я]+");
            System.out.println(Arrays.toString(strings));
            textList = Arrays.asList(strings);
            System.out.println("Всего количество слов: " + textList.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        textReader();

        //  1. Подсчитайте количество различных слов в файле
        Set<String> stringSet = new HashSet<>(textList);
        System.out.println("Количество различных слов в файле: " + stringSet.size());

        //  2. Выведите на экран список различных слов файла,
        //  отсортированный по возрастанию их длины (компаратор сначала по длине слова, потом по тексту).
        textList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        }.thenComparing(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        }));
        for (String s : textList) System.out.println(s);

        //  3. Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле
        HashMap<String, Integer> stringCountMap = new HashMap<>();
        for (String s : textList) {
            if (stringCountMap.containsKey(s)) {
                stringCountMap.replace(s, stringCountMap.get(s) + 1);
            } else stringCountMap.put(s, 1);
        }
        for (Map.Entry<String, Integer> entry : stringCountMap.entrySet()) {
            System.out.println(entry.getKey() + " встречается " + entry.getValue() + " раз");
        }

        //  4. Выведите на экран все строки файла в обратном порядке.
        for (String s : lines) {
            char[] chars = s.toCharArray();
            for (int i = chars.length - 1; i >= 0; i--) {
                System.out.print(chars[i]);
            }
            System.out.println();
        }

        //  5. Реализуйте свой Iterator для обхода списка в обратном порядке.

        //  6. Выведите на экран строки, номера которых задаются пользователем в произвольном порядке.
        int numLine = 0;
        try {
            numLine = queryOutputLine();
            System.out.println(lines.get(numLine-1));
        }catch (IndexOutOfBoundsException e){
            System.out.println("Строки с таким номером не существует");
        }
        catch (ClassCastException | InputMismatchException e){
            System.out.println("Введен неправильный номер строки");
        }
    }

    // метод запрашивает номер строки
    public static int queryOutputLine() throws ClassCastException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер строки которую необходимо вывести на экран: ");
        return scanner.nextInt();
    }
}
