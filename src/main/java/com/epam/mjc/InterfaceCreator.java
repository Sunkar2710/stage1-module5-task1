package com.epam.mjc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            for (String value : x) {
                if (!Character.isUpperCase(value.charAt(0))) return false;
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            for (Integer value : List.copyOf(x)) {
                if (value % 2 == 0) x.add(value);
            }
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            values.removeIf(value ->
                            !Character.isUpperCase(value.charAt(0)) ||
                            !value.endsWith(".") ||
                            !(value.split(" ").length > 3)
            );
            return values;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> map = new HashMap<>();
            x.forEach(value -> map.put(value, value.length()));
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }
}
