package com.java.collection.lamdas;

import com.java.collection.helper.Country;
import com.java.collection.helper.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LamdaPredicateExample {
    public static void main(String[] args) {
        findCountry();
        predicateMethodExample();
        passPredicateArgument();
    }


    private static List<Integer> eval(List<Integer> values,Predicate<Integer> predicate) {
        return values.stream().filter(predicate).collect(Collectors.toList());
    }

    public static void findCountry(){
        List<Country> countries = new ArrayList<>();
        countries.add(new Country("India", 1342512000));
        countries.add(new Country("Hungary", 9845000));
        countries.add(new Country("Poland", 38485000));
        countries.add(new Country("Latvia", 1978000));
        countries.add(new Country("Vietnam", 95261000));
        countries.add(new Country("Sweden", 9967000));
        countries.add(new Country("Iceland", 337600));
        countries.add(new Country("Israel", 8622000));
        countries.add(new Country("Iran", 80840713));

        Predicate<Country> p1 = c -> c.getName().startsWith("I") && c.getPopulation() > 100000;

        countries.stream().filter(p1).forEach(System.out::println);
    }

    private static void predicateMethodExample(){
        int[] nums = {2, 3, 1, 5, 6, 7, 8, 9, 12};

        IntPredicate p1 = n -> n > 3;
        IntPredicate p2 = n -> n < 9;

        Arrays.stream(nums).filter(p1.and(p2)).forEach(System.out::println);

        System.out.println("**********");

        IntPredicate p3 = n -> n == 6;
        IntPredicate p4 = n -> n == 9;

        Arrays.stream(nums).filter(p3.or(p4)).forEach(System.out::println);

        System.out.println("**********");

        Arrays.stream(nums).filter(p1.negate()).forEach(System.out::println);
    }

    private static void passPredicateArgument(){
        List<Integer> list = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12).collect(Collectors.toList());

        List<Integer> all = eval(list, n -> true);
        System.out.println(all);

        List<Integer> evenValues = eval(list, n -> n % 2 == 0);
        System.out.println(evenValues);

        List<Integer> greaterThanSix = eval(list, n -> n > 6);
        System.out.println(greaterThanSix);
    }
}
