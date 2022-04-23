package org.example.consumer;

import org.example.convert.Converter;

import java.util.ServiceLoader;

public class getConverter {
    ServiceLoader<Converter> serviceLoader = ServiceLoader.load(Converter.class);

    public void toEuro(Float amount) {

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

    public void toDollar(Float amount) {

        serviceLoader.stream()
                .map(ServiceLoader.Provider::get)
                .filter(converter ->
                        converter
                                .getClass()
                                .getSimpleName()
                                .startsWith("Dkk")).
                forEach(greetingProvider ->
                        System.out.println(greetingProvider.convert(amount)));

    }
}
