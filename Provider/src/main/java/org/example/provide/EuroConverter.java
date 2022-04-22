package org.example.provide;

import org.example.convert.Address;
import org.example.convert.Converter;

@Address("euro")
public class EuroConverter implements Converter {

    public EuroConverter(){
        System.out.println("Converter created");
    }
    @Override
    public Double convert(Double amount) {

        return null;
    }

}
