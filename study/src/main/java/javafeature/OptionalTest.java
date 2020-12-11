package javafeature;

import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {
        Optional<Object> emptyOptional = Optional.empty();
        Object o = emptyOptional.orElse("123");
        System.out.println(o);

        Optional<String> nonNullOptional = Optional.of("non-null");
        nonNullOptional.ifPresent(System.out::println);
        nonNullOptional.filter(value -> value.equals("non-null")).ifPresent(value -> System.out.println("filter equal"));
        nonNullOptional.filter(value -> value.equals("non-null2")).ifPresent(value -> System.out.println("filter not equal"));
    }
}
