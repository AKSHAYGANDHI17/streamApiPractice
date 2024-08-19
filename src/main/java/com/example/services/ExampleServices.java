package com.example.services;

import com.example.interfaces.Example1;
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

    public ExampleServices(Example1 evenodd) {
        this.evenodd = evenodd;
    }

    public List<Integer> getEvenNo() {
        return evenodd.evenOdd();
    }
}
