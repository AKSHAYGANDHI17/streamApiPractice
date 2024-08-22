package com.example.project;

import com.example.beans.Employee;
import com.example.beans.Programs;
import com.example.config.ProjectConfig;
import com.example.services.ExampleServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.LineNumberInputStream;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
		var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
		Programs vehicle = context.getBean(Programs.class);
		List<Integer>  evenNumbers = vehicle.getExampleServices().getEvenNo();
		System.out.println("The Even Number is " + evenNumbers);
		List <Employee>  empDeatils = vehicle.getExampleServices().getEmpDetails();
		System.out.println("The Employees  is " + empDeatils);
		List<Integer> number =  Arrays.asList(10,20,30);

		int sumNumber1 = number.stream().reduce(1,(i, j) -> i + j);
        int multiplyNumber1 = number.stream().reduce(1,(i, j) -> i * j);

		List<Integer> sumNumber = Collections.singletonList(number.stream().mapToInt(i -> i).sum());
		System.out.println(sumNumber1);
        System.out.println(multiplyNumber1);

		int minNo = number.stream().min(Integer::compareTo).orElse(0);
		System.out.println("Min vale" + minNo);

		int maxNo = number.stream().max(Integer::compareTo).orElse(0);
		System.out.println("Max vale" + maxNo);

		IntSummaryStatistics stats = number.stream()
				.mapToInt(Integer::intValue)
				.summaryStatistics();

		int minNumber = stats.getMin();
		int maxNumber = stats.getMax();

		System.out.println("stats: " + stats);
		System.out.println("The minimum number is: " + minNumber);
		System.out.println("The maximum number is: " + maxNumber);



	}
}
