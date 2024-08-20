package com.example.services;

import com.example.beans.Employee;
import com.example.interfaces.Example1;
import com.example.interfaces.Example2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ExampleServices {

    //public List<Integer> evenNo = Collections.emptyList();
    @Autowired
    final public Example1 evenodd;

    @Autowired
    final public Example2 empDetails;



    public List<Integer> getEvenNo() {
        return evenodd.evenOdd();
    }
    public Example2 getEmpDetails() {
        return empDetails;
    }

}

    public ExampleServices(Example1 evenodd, Example2 empDetails) {
        this.evenodd = evenodd;
        this.empDetails = empDetails;
    }



