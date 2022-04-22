package org.example.provide;

import org.example.convert.Converter;

public class EuroConverter implements Converter {

    public EuroConverter(){
        System.out.println("Converter created");
    }
    @Override
    public Double convert(Double amount) {

        return amount*0.097;
    }

}
