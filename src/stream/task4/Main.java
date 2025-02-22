package stream.task4;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
//Несовершеннолетних
        Stream<Person> minor = persons.stream();
        System.out.println(minor.filter(x -> x.getAge() < 18).count());
        //Призывников
        Stream<Person> conscript = persons.stream();
        System.out.println(conscript.filter(x -> x.getAge() < 28 && x.getAge() > 17).map(Person::getFamily).collect(Collectors.toList()));
        //Работоспособных
        Stream<Person> efficiency = persons.stream();
        System.out.println(efficiency
                .filter(x -> (x.getSex().equals(Sex.MAN) && x.getAge() < 65 && x.getAge() > 17) ||
                        (x.getSex().equals(Sex.WOMAN) && x.getAge() < 60 && x.getAge() > 17))
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList()));
    }

}