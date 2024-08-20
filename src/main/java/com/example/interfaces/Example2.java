package com.example.interfaces;

import com.example.beans.Employee;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public interface Example2 {

    public List<Employee> empDeatils();
}
