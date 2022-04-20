package swedishgreet;

import greet.Greeting;

public class SwedishGreeting implements Greeting {
    @Override
    public String greet() {
        return "Hej!";
    }
}
