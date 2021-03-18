package com.example.demo.cmm.util;

import java.util.function.Consumer;
import java.util.function.Function;

import org.springframework.stereotype.Component;
@FunctionalInterface
public interface CompareToIgnoreCase {
	public int ignore(String s);

}
// public Function<String, Integer> ignore = String::compareToIgnoreCase;