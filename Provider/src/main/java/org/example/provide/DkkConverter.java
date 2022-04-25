package org.example.provide;

import org.example.convert.Address;
import org.example.convert.Converter;

@Address("Dkk")
public class DkkConverter implements Converter {

    @Override
    public Float convert(Float amount) {

        return Math.round((amount*0.72f) * 100.0f) / 100.0f;
    }
}
