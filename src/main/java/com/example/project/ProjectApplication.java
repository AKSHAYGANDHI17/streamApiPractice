package com.example.project;

import com.example.beans.Employee;
import com.example.beans.Programs;
import com.example.config.ProjectConfig;
import com.example.services.ExampleServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.LineNumberInputStream;
import java.util.Arrays;
import java.util.List;
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



	}
}
