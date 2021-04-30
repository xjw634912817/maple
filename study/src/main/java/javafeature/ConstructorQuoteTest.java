package javafeature;

import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConstructorQuoteTest {

    public static void main(String[] args) {
        // base use method
        People people = new People("Base 1");
        People people2 = new People("Base 2");
        List<String> names = Stream.of(people, people2).map(People::getName).collect(Collectors.toList());
        System.out.println(JSONObject.valueToString(names));

        List<String> names2 =
                Arrays.asList("Grace Hopper", "Barbara Liskov", "Ada Lovelace",
                        "Karen Spärck Jones");
        List<People> peopleList = names2.stream().map(People::new).collect(Collectors.toList());
        System.out.println(peopleList);

        System.out.println(" ------------  split  --------------");

        // copy constructor
        People origin = new People("Origin");
        List<People> originalList = Stream.of(origin).collect(Collectors.toList());
        People after = originalList.get(0);

        System.out.println("origin == after : " + (origin == after));
        System.out.println(after);
        origin.setName("Change name");
        System.out.println(after);

        System.out.println(" ------------  split  --------------");

        // revert
        origin.setName("Origin");
        List<People> copyList = Stream.of(origin).map(People::new).collect(Collectors.toList());
        People copy = copyList.get(0);
        System.out.println("origin == copy : " + (origin == copy));
        System.out.println(copy);
        origin.setName("Change name");
        System.out.println(copy);

        System.out.println(" ------------  split  --------------");

        // variable constructor
        List<People> finalList = names2.stream().map(name -> name.split(" ")).map(People::new).collect(Collectors.toList());
        System.out.println(finalList);

        System.out.println(" ------------  split  --------------");

        // toArray
        People[] peopleArray = names2.stream().map(People::new).toArray(People[]::new);
        for (People people1 : peopleArray) {
            System.out.println(people1);
        }
    }

    static class People {
        private String name;

        public People() {
        }

        public People(String name) {
            this.name = name;
        }

        public People(String... names) {
            this.name = String.join(",", names);
        }


        public People(People people) {
            this.name = people.name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "People{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

}
