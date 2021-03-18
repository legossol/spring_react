package com.example.demo.cmm.util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;
public class CustomChild extends Custom{
	private static final Logger LOG = LoggerFactory.getLogger(CustomChild.class);

    public CustomChild(int age, String color) {
        super(age, color);
    }

    CustomChild(Integer age, String color, Integer healty) {
        super(age, color, healty);
    }

    @Override
    public void turnOnPc() {
        LOG.debug("CustomChild turned on");
    }

    @Override
    public void turnOffPc() {
        LOG.debug("CustomChild turned off");
    }

    @Override
    public Double calculateValue(Double initialValue) {

        Function<Double, Double> function = super::calculateValue;
        final Double pcValue = function.apply(initialValue);
        LOG.debug("First value is:" + pcValue);
        return pcValue + (initialValue / 10);

    }

}
