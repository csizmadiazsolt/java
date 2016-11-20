package com.ezsocsi.javacollections;


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class JavaCollectionsTest {
    private JavaCollections javaCollections;

    private Person person1 = new Person("Harold", 47);
    private Person person2 = new Person("John", 41);
    private Person person3 = new Person("Root", 31);
    private Person person4 = new Person("Shaw", 30);

    @Before
    public void setup() {
        javaCollections = new JavaCollections();
    }

    @Test
    public void createAListOfIntegersFromArray() {
        List<Integer> numbers = Arrays.asList(1, 7, 5, 2);
        assertEquals(numbers, javaCollections.createIntegerList(1, 7, 5, 2));
    }

    @Test
    public void convertAListOfIntegersToAListOfStrings() {
        List<Integer> numbersInt = Arrays.asList(1, 7, 5, 2);
        List<String> numbersStr = Arrays.asList("1", "7", "5", "2");
        assertEquals(numbersStr, javaCollections.createStringList(numbersInt));
    }

    @Test
    public void returnTheSumOfIntegers() {
        List<Integer> numbers = Arrays.asList(1, 7, 5, 2);
        assertEquals(15, javaCollections.sumOfIntegers(numbers));
    }

    @Test
    public void returnTheAverageOfIntegers() {
        List<Integer> numbers = Arrays.asList(1, 7, 5, 3);
        assertEquals(4, javaCollections.averageOfIntegers(numbers));
    }

    @Test
    public void returnTheSumOfIntegersInAListOfLists() {
        List<List<Integer>> numbers = Arrays.asList(Arrays.asList(1, 7), Arrays.asList(5, 2));
        assertEquals(15, javaCollections.sumOfListOfLists(numbers));
    }

    @Test
    public void returnTheSumOfIntegersFromOneToHundred() {
        assertEquals(5050, javaCollections.sumOfIntegersFromOneToHundred());
    }

    @Test
    public void filterAllTheNamesStartingWithH() {
        List<String> names = Arrays.asList("Harold", "John", "Root", "Shaw");
        assertEquals(Collections.singletonList("Harold"), javaCollections.filterAllTheNamesStartingWithH(names));
    }

    @Test
    public void findTheMaxValue() {
        List<Integer> numbers = Arrays.asList(1, 7, 5, 2);
        assertEquals(7, javaCollections.findMax(numbers));
    }

    @Test
    public void findTheMaxValueInAListOfLists() {
        List<List<Integer>> numbers = Arrays.asList(Arrays.asList(1, 7), Arrays.asList(5, 2));
        assertEquals(7, javaCollections.findMaxInAListOfList(numbers));
    }


    @Test
    public void findTheMaxValueFromListOfStrings() {
        List<String> numbers = Arrays.asList("1", "7", "5", "2");
        assertEquals("7", javaCollections.findMaxFromStrings(numbers));
    }

    @Test
    public void sortPersonsByTheirAge() {
        List<Person> persons = Arrays.asList(person1, person2, person3, person4);
        List<Person> expected = Arrays.asList(person4, person3, person2, person1);
        assertEquals(expected, javaCollections.sortByAge(persons));
    }

    @Test
    public void getTheNames() {
        List<Person> persons = Arrays.asList(person1, person2, person3, person4);
        List<String> names = Arrays.asList("Harold", "John", "Root", "Shaw");
        assertEquals(names, javaCollections.getTheNames(persons));
    }

    @Test
    public void makeEveryPersonTenYearsYounger() {
        List<Person> persons = Arrays.asList(person1, person2, person3, person4);

        Person person5 = new Person("Harold", 37);
        Person person6 = new Person("John", 31);
        Person person7 = new Person("Root", 21);
        Person person8 = new Person("Shaw", 20);
        List<Person> expected = Arrays.asList(person5, person6, person7, person8);

        assertTrue(expected.equals(javaCollections.makePersonsYounger(persons, 10)));
    }

    @Test
    public void findThoseWhoAreYoungerThanForty() {
        List<Person> persons = Arrays.asList(person1, person2, person3, person4);
        List<Person> expected = Arrays.asList(person3, person4);

        assertEquals(expected, javaCollections.findYoungerThan(persons, 40));
    }
}
