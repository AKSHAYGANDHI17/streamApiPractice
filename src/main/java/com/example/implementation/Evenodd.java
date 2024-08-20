package com.example.implementation;

import com.example.interfaces.Example1;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class Evenodd implements Example1 {

    @Override
    public List<Integer> evenOdd() {
        List<Integer> number =  Arrays.asList(10,7,9,3,7,20,46,78);

        List<Integer> evenNumber = number.stream().filter( i->i % 2 == 0).collect(Collectors.toList());

        return evenNumber;
    }
}
