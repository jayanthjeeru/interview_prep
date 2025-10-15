package com.nokia.handson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsPractice {

	public static void main(String[] args) {
		 List<List<String>> listOfLists = Arrays.asList(
		            Arrays.asList("Reflection", "Collection", "Stream"),
		            Arrays.asList("Structure", "State", "Flow"),
		            Arrays.asList("Sorting", "Mapping", "Reduction", "Stream")
		        );
		 
				List<String> list = listOfLists.stream().flatMap(List::stream)
						.filter(x -> x.toLowerCase().contains("s")).map(x -> x = x + "ss").sorted()
						.collect(Collectors.toList());
				
				
				System.out.println(list);
				
				System.out.println(listOfLists.stream().flatMap(List::stream).anyMatch(x -> x.contains("S")));
				
				
				List<Map<String,String>> li = new ArrayList<>();
				
				Map<String,String> map1 = new HashMap<>();
				map1.put("map1", "value");
				map1.put("nodeid", "1");
				li.add(map1);
				
				
				Map<String,String> map2 = new HashMap<>();
				map2.put("map1", "value");
				map2.put("nodeid", "2");
				li.add(map2);
				
				Map<String,String> map3 = new HashMap<>();
				map3.put("map1", "value");
				map3.put("nodeid", "3");
				li.add(map3);
				
				System.out.println(li);
				Map<String, Map<String, String>> newMap = li.stream()
					    .collect(Collectors.toMap(
					        map -> map.get("nodeid"), // keyMapper: extract "nodeid" as key
					        map -> map,                // valueMapper: keep the original map as value
					        (existing, replacement) -> existing // mergeFunction: in case of duplicate keys, keep the first one
					    ));
				
				
				System.out.println(newMap);
				
				
				System.out.println();
				
				List<String> neids = li.stream().map(x -> x.get("nodeid")).collect(Collectors.toList());
				
				System.out.println(neids);
				
				System.out.println();
				
			System.out.println(	newMap.entrySet().stream().map(x-> x.getValue()).collect(Collectors.toList()));
			
			System.out.println();
			System.out.println();
			
			List<String> strings = Arrays
		              .asList("apple", "banana", "cherry", "dat111111111e", "grapefruit");
			
			
			System.out.println(strings.stream().max(Comparator.comparing(x -> x.length())).get());
			
			System.out.println(strings.stream().mapToInt(x -> x.length()).max());
			
			System.out.println();
			
			List<Integer> integers = Arrays
		              .asList(1,2,3,4);
			
			
			
			System.out.println(integers.stream().max(Comparator.comparing(x->x)).get());
			
			System.out.println(integers.stream().min(Comparator.comparing(x->x)).get());
			
			
			
			System.out.println();
			
			
			List<Person> persons = Arrays.asList(
				    new Person("Alice", 25),
				    new Person("Bob", 30),
				    new Person("Charlie", 35)
				);
			
			
		 
			System.out.println(persons.stream().mapToInt(x -> x.age).average());
			
			System.out.println();
			
			
			
			
			
			 List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10, 11, 12, 13, 14, 15);
			 
			 System.out.println(numbers.stream().anyMatch(x -> isPrime(x)));
			 
			 System.out.println();
			 
			 
			 List<Integer> list1 = Arrays.asList(1, 3, 5, 7, 9);
			 List<Integer> list2 = Arrays.asList(2, 4, 6, 8, 10);
			 List<Integer> mergedList = Stream.concat(list1.stream(), list2.stream())
			                                 .sorted()
			                                 .collect(Collectors.toList());
			 System.out.println(mergedList);
			 
			 System.out.println();
			 
			 List<Integer> listinter1 = Arrays.asList(1, 2, 3, 4, 5);
			 List<Integer> listinter2 = Arrays.asList(3, 4, 5, 6, 7);
			 
			 listinter1.stream().filter(x -> listinter2.contains(x)).forEach(System.out::println);
			 
			 System.out.println();
			 
			 List<String> listinter11 = Arrays.asList("hi","hello","hi");
			 Map<String, Long> countMap = listinter11.stream()
					    .collect(Collectors.groupingBy(x ->
					        x, // Use the number itself as the key
					        Collectors.counting() // Count how many times each number occurs
					    ));
			 
			 System.out.println(countMap);
			 
			 System.out.println();
			 
			 List<Integer> numbersWithDuplicates = Arrays.asList(1, 2, 3, 2, 4, 1, 5, 6, 5);
			 List<Integer> uniqueNumbers = numbersWithDuplicates
			                                        .stream()
			                                        .distinct()
			                                        .collect(Collectors.toList());
			 
			 
			 System.out.println(uniqueNumbers);
			 
			 
			 System.out.println();
			 
			 
			 int[] array = {4, 2, 7, 1, 5, 3, 6};
			 int k = 3; // Find the 3rd smallest element
			 int kthSmallest = Arrays.stream(array)
			                        .sorted()
			                        .skip(k - 1)
			                        .findFirst()
			                        .orElse(-1);
			 System.out.println(kthSmallest);
			 
			 System.out.println();
			 
			 
			 List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
			 Map<Boolean, List<Integer>> partitioned = numbers1
			                         .stream()
			                         .collect(Collectors.partitioningBy(n -> n % 2 == 0));
			 List<Integer> evenNumbers = partitioned.get(true);
			 List<Integer> oddNumbers = partitioned.get(false);
			 System.out.println("Even numbers: " + evenNumbers);
			 System.out.println("Odd numbers: " + oddNumbers);
			 
			 
			 
			 
	}
	
	public static boolean isPrime(int number) {
		  if (number <= 1) {
		    return false;
		  }
		  for (int i = 2; i <= Math.sqrt(number); i++) {
		    if (number % i == 0) {
		        return false;
		    }
		  }
		  return true;
		}
	
}

class Person {
	String name;
	int age;
	
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
}
