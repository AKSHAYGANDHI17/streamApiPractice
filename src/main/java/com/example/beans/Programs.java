package com.example.beans;

import com.example.services.ExampleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Programs {



    final public ExampleServices exampleServices;

    @Autowired
    public Programs(ExampleServices exampleServices) {
        this.exampleServices = exampleServices;
    }

    public ExampleServices getExampleServices() {
        return exampleServices;
    }


}
