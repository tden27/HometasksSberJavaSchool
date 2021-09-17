package lesson9;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Person> someCollection = new ArrayList<>();
        someCollection.add(new Person("Ivan", 39));
        someCollection.add(new Person("Sergey", 12));
        someCollection.add(new Person("Andrey", 68));
        someCollection.add(new Person("Igor", 25));
        someCollection.add(new Person("Maria", 30));

        Map<String, Person> m = Streams.of(someCollection).
                filter(p -> (p.getAge() > 20)).
                transform( p -> new Person(p.getName(), p.getAge() + 30)).
                toMap(Person::getName, p -> p);

        for (Map.Entry<String, Person> entry : m.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
