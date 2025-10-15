package com.wipro;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectorsPractice {

	public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // Using filter, map, and collect
        List<Integer> evenSquares = numbers.stream()          // Create a stream from the list
            .filter(n -> n % 2 == 0)                         // Filter out even numbers
            .map(n -> n * n)                                 // Map each even number to its square
            .collect(Collectors.toList());                    // Collect the results into a List

        // Print the result
        System.out.println(evenSquares);                      // Output: [4, 16, 36, 64, 100]
        
        
        System.out.println(numbers.stream().filter(n -> n==100).collect(Collectors.toList()));
        
        System.out.println(numbers.stream().dropWhile(n->n<=4).collect(Collectors.toList()));
       
        StringBuilder sb = new StringBuilder();
        sb.append("hi");
        sb.append("bye");
        
        String counter = sb.toString();
        
        System.out.println(counter);
        
    }
}
