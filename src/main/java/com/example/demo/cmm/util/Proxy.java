package com.example.demo.cmm.util;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.stereotype.Component;

import com.example.demo.uss.domain.User;

@Component
public class Proxy{
	
	public Consumer<String> print = System.out::print;
	public Function<Object, String> string = String::valueOf;
	public Function<String, Integer> integer = Integer :: valueOf;
	public BiFunction<String,String, Integer> mySkip = (t, u) -> (integer.apply(t) - 1) * integer.apply(u);
	public Function<String, Object> intValue = Integer :: valueOf;
	public BiPredicate<String, String> equals = String :: equals;
	public BiFunction<Integer, Integer, Integer> random =(t,u)->(int)(Math.random()*(u-t))+t;
	public Function<Integer, int[]> intArr = int[] :: new;
	public Supplier<LocalDate> today = () -> LocalDate.now();
	public Supplier<LocalTime> time = () -> LocalTime.now();
	public BiFunction<String,String, File> mkDir = File::new;
	public BiFunction<File,String, File> mkFile = File::new;
	public Supplier<User> newUser = User::new;

	public static Function<Double,Double> absNum = Math::abs;
    public static Function<Double,Double> ceiNum = Math::ceil;
    public static Function<Double,Double> floNum = Math::floor;
    public static BiFunction<Integer,Integer,Integer> bigOne = Math::max; 
    public static BiFunction<Integer,Integer,Integer> smOne = Math::min;
    public static Supplier<Double> ranOne = Math::random;
    public static Function<Double,Double> cloOne = Math::rint;
    public static Function<Double,Long> loOne = Math::round;


}
