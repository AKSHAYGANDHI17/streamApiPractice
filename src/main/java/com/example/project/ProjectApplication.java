package com.example.project;

import com.example.beans.Employee;
import com.example.beans.Programs;
import com.example.config.ProjectConfig;
import com.example.services.ExampleServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.LineNumberInputStream;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
		var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
		Programs vehicle = context.getBean(Programs.class);
		List<Integer> evenNumbers = vehicle.getExampleServices().getEvenNo();
		System.out.println("The Even Number is " + evenNumbers);
		List<Employee> empDeatils = vehicle.getExampleServices().getEmpDetails();
		System.out.println("The Employees  is " + empDeatils);
		List<Integer> number = Arrays.asList(10, 20, 30);

		int sumNumber1 = number.stream().reduce(1, (i, j) -> i + j);
		int multiplyNumber1 = number.stream().reduce(1, (i, j) -> i * j);

		List<Integer> sumNumber = Collections.singletonList(number.stream().mapToInt(i -> i).sum());
		System.out.println(sumNumber1);
		System.out.println(multiplyNumber1);

		int minNo = number.stream().min(Integer::compareTo).orElse(0);
		System.out.println("Min value " + minNo);

		int maxNo = number.stream().max(Integer::compareTo).orElse(0);
		System.out.println("Max value " + maxNo);

		IntSummaryStatistics stats = number.stream()
				.mapToInt(Integer::intValue)
				.summaryStatistics();

		int minNumber = stats.getMin();
		int maxNumber = stats.getMax();

		System.out.println("stats: " + stats);
		System.out.println("The minimum number is: " + minNumber);
		System.out.println("The maximum number is: " + maxNumber);

		//Convert a string list to integer list and parse it to integer

		List<String> sringNumbers = Arrays.asList("2", "8", "89", "23", "67", "90", "55");
		List<Integer> newSnumber = sringNumbers.stream().map(Integer::parseInt).collect(Collectors.toList());
		System.out.println(newSnumber);

		List<String> numberNull = Arrays.asList("10", "20", null, "30", null, "");

		List<String> numList = numberNull.stream().filter(Objects::nonNull).filter(str -> !str.trim().isEmpty()).collect(Collectors.toList());
		System.out.println(numList);

		List<String> stringList = Arrays.asList("Tata", "Consultancy", "Services", "Metlife");

		String lists = stringList.stream().collect(Collectors.joining(","));
		System.out.println(lists);

		long countoString = Arrays.stream(lists.split(",")).count();
		System.out.println(countoString);

		String value = "akshay";
		List<String> values = Arrays.stream(value.split("")).collect(Collectors.toList());
		System.out.println(values);

		List<Character> valuess = value.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
		System.out.println(valuess);

		Map<Character, Long> valuesss = value.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));


		Optional<Integer> thirdHigh = number.stream().sorted((a, b) -> b - a).skip(2).findFirst();
		System.out.println(thirdHigh);


		List<Integer> setOfnum = Arrays.asList(10, 6, 8, 90, 4, 78, 9, 7, 88, 45, 46, 34, 39);

		List<Integer> setofEven = setOfnum.stream().filter(e -> e % 2 == 0).collect(Collectors.toList());
		System.out.println(setofEven);
		int EvenSum = setOfnum.stream().filter(e -> e % 2 == 0).reduce(0, (e, j) -> e + j);
		System.out.println(EvenSum);

        setofEven.stream().forEach(System.out::println);
    }
}
