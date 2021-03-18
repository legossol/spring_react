package com.example.demo.cmm.util;
@FunctionalInterface
public interface CompareToIgnoreCase {
	public int ignore(String s);

}
// public Function<String, Integer> ignore = String::compareToIgnoreCase;