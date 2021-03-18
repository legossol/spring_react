package com.example.demo.cmm.util;
@FunctionalInterface
public interface CustomPredicate<T> {
	boolean filter(T c);
}
