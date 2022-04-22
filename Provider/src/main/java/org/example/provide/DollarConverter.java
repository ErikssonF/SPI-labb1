package org.example.provide;

import org.example.convert.Converter;

public class DollarConverter implements Converter {

    @Override
    public Double convert(Double amount) {
        return amount*0.10;
    }
}
