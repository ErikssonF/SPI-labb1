package org.example.consumer;

import org.example.convert.Converter;

import java.util.Scanner;
import java.util.ServiceLoader;

public class Main {

    public static void main(String[] args) {

        ServiceLoader<Converter> serviceLoader = ServiceLoader.load(Converter.class);

        Scanner scan = new Scanner(System.in);

        System.out.println("test");

        double amount = scan.nextDouble();

        serviceLoader.stream()
                .map(ServiceLoader.Provider::get)
                .filter(converter ->
                        converter
                                .getClass()
                                .getSimpleName()
                                .startsWith("Euro")).
                forEach(greetingProvider ->
                        System.out.println(greetingProvider.convert(amount)));


    }
}
