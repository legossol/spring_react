package com.example.demo.cmm.util;

import java.util.ArrayList;
import java.util.List;

public class CustomUtil {
	static final CustomPredicate<Custom> after2010Predicate = (c) -> (c.getAge() > 2010);
	static final CustomPredicate<Custom> blackPredicate = (c) -> "black".equals(c.getColor());

    public static List<Custom> filter(final List<Custom> inventory, final CustomPredicate<Custom> p) {

        final List<Custom> result = new ArrayList<>();
        inventory.stream().filter(p::filter).forEach(result::add);

        return result;
    }

    static void repair(final Custom custom) {
        if (custom.getHealty() < 50) {
        	custom.setHealty(100);
        }
    }

}
