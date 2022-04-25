package org.example.consumer;

import org.example.convert.Converter;

import java.util.ServiceLoader;

public class GetConverter {

    ServiceLoader<Converter> serviceLoader = ServiceLoader.load(Converter.class);

    public void toEuro(Float amount) {

        serviceLoader.stream()
                .map(ServiceLoader.Provider::get)
                .filter(converter ->
                        converter
                                .getClass()
                                .getSimpleName()
                                .startsWith("Euro"))
                                .forEach(convertProvider ->
                        System.out.println(convertProvider.convert(amount)));

    }

    public void toDkk(Float amount) {

        serviceLoader.stream()
                .map(ServiceLoader.Provider::get)
                .filter(converter ->
                        converter
                                .getClass()
                                .getSimpleName()
                                .startsWith("Dkk"))
                                .forEach(convertProvider ->
                        System.out.println(convertProvider.convert(amount)));

    }
}
