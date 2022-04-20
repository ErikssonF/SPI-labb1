package org.example.provide;

import org.example.greet.Greeting;

public class SwedishGreeting implements Greeting {
    @Override
    public String greet() {
        return "Hej!";
    }
}
