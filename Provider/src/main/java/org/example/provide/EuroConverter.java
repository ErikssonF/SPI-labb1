package org.example.provide;

import org.example.convert.Converter;
import org.example.convert.CurrencyType;

@CurrencyType("Euro")
public class EuroConverter implements Converter {

    @Override
    public Float convert(Float amount) {

        return Math.round((amount*0.097f) * 100.0f) / 100.0f;
    }
}
