package com.ezsocsi.javacollections;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class JavaCollections {
    int sumOfIntegers(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

    int sumOfListOfLists(List<List<Integer>> numbers) {
        return numbers.stream().flatMap(List::stream).mapToInt(Integer::intValue).sum();
    }

    int sumOfIntegersFromOneToHundred() {
        return IntStream.range(1, 101).sum();
    }

    List<String> filterAllTheNamesStartingWithH(List<String> names) {
        return names.stream().filter(i -> i.startsWith("H")).collect(Collectors.toList());
    }

    int findMax(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).max().orElse(-1);
    }

    int findMaxInAListOfList(List<List<Integer>> numbers) {
        return numbers.stream().flatMap(List::stream).mapToInt(Integer::intValue).max().orElse(-1);
    }

    String findMaxFromStrings(List<String> numbers) {
        Integer max = numbers.stream().mapToInt(Integer::parseInt).max().orElse(-1);
        return max.toString();
    }

    List<Integer> createIntegerList(int... numbers) {
        return IntStream.of(numbers).boxed().collect(Collectors.toList());
    }

    List<String> createStringList(List<Integer> numbersInt) {
        return numbersInt.stream().map(Object::toString).collect(Collectors.toList());
    }

    int averageOfIntegers(List<Integer> numbers) {
        Double average = numbers.stream().mapToInt(Integer::intValue).average().orElse(-1);
        return average.intValue();
    }

    List<Person> sortByAge(List<Person> persons) {
        Comparator<Person> comparator = (p1, p2) -> Integer.compare(p1.getAge(), p2.getAge());
        return persons.stream().sorted(comparator).collect(Collectors.toList());
    }

    List<String> getTheNames(List<Person> persons) {
        return persons.stream().map(Person::getName).collect(Collectors.toList());
    }

    List<Person> makePersonsYounger(List<Person> persons, int age) {
        persons.stream().map(person -> setAge(person, age)).collect(Collectors.toList());
        return persons;
    }

    private Person setAge(Person person, int age) {
        person.setAge(person.getAge() - age);
        return person;
    }

    List<Person> findYoungerThan(List<Person> persons, int age) {
        return persons.stream().filter(person -> person.getAge() < age).collect(Collectors.toList());
    }
}
