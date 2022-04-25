package org.example.provide;

import org.example.convert.Converter;
import org.example.convert.CurrencyType;

@CurrencyType("Dkk")
public class DkkConverter implements Converter {

    @Override
    public Float convert(Float amount) {

        return Math.round((amount*0.72f) * 100.0f) / 100.0f;
    }
}
