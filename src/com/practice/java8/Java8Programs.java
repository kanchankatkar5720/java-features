package com.practice.java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8Programs
{
    public static void main(String[] args) {
        String[] array = {"apple", "banana", "apple", "orange", "banana", "apple"};
        //Count number of occurances
        Map<String, Long> occurrences = Arrays.stream(array)
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        occurrences.forEach((key, count) -> System.out.println(key + ": " + count));

        System.out.println("\nif occurance is 1 then print ");
        occurrences.entrySet().stream().filter(entry->entry.getValue()==1).forEach(System.out::println);
        //How To Find Duplicate Characters In A String In Java?
        System.out.println("\nFind Duplicate Characters In A String ");
        String str = "programming";

        Map<Character, Long> charCount = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        charCount.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));


        List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);

        int max = listOfIntegers.stream().max(Comparator.naturalOrder()).get();
        System.out.println("Maximum Element : "+max);

        int min = listOfIntegers.stream().min(Comparator.naturalOrder()).get();
        System.out.println("Minimum Element : "+min);

        //merge two unsorted arrays into single sorted array without duplicates
        int[] a = new int[] {4, 2, 5, 1};
        int[] b = new int[] {8, 1, 9, 5};

        int[] c = IntStream.concat(Arrays.stream(a), Arrays.stream(b))
                .sorted().distinct().toArray();

        System.out.println(Arrays.toString(c));

        // two string are anagram or not
        String s1 = "RaceCar";
        String s2 = "CarRaceing";

        s1 = Stream.of(s1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());

        s2 = Stream.of(s2.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());

        if (s1.equals(s2))
        {
            System.out.println("Two strings are anagrams");
        }
        else
        {
            System.out.println("Two strings are not anagrams");
        }

        //calculate sum of numbers
        int i = 15623;

        Integer sumOfDigits = Stream.of(String.valueOf(i)
                .split("")).mapToInt(Integer::parseInt).sum();

        System.out.println(sumOfDigits);


        String input = "This is an example string.";

        // Define vowels to be removed
        String vowels = "aeiouAEIOU";

        // Remove vowels using streams
        String result = input.chars()  // Convert the string to an IntStream
                .filter(c1 -> !vowels.contains(Character.toString((char) c1)))  // Filter out vowels
                .mapToObj(c1 -> (char) c1)  // Convert int to Character
                .map(String::valueOf)  // Convert Character to String
                .collect(Collectors.joining());  // Join the characters back into a single string

        System.out.println("Original string: " + input);
        System.out.println("String without vowels: " + result);


        input.chars().mapToObj(ch->(char)ch)
                .filter(ch->!("aeiouAEIOU").contains(ch.toString()))
                .forEach(System.out::print);

        //Find duplicate words from String

        String sentence = "alex brian charles alex charles david eric david";

        List<String> wordsList = Arrays.stream(sentence.split(" ")).collect(Collectors.toList());

        Set<String> tempSet = new HashSet<>();

        List<String> duplicateWords = wordsList.stream()
                .filter(w -> !tempSet.add(w))
                .collect(Collectors.toList());

        System.out.println(duplicateWords);

        Map<String, Long> countWords = wordsList.stream().collect(Collectors.groupingBy(s->s, Collectors.counting()));
        countWords.entrySet().stream().filter(entry -> entry.getValue()>1)
                .forEach(entry->System.out.println(entry.getKey() +" :: " +entry.getValue()));



    }

}
