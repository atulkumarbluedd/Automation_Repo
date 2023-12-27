package com.coco.Tests;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class sample {
	public static void main(String[] args) {

		// Creating an empty Stack
		Stack<Integer> stack = new Stack<Integer>();

		// Use add() method to add elements into the Stack
		stack.add(322);

		int[] arr = stack.stream().mapToInt(i -> i).toArray();
		System.out.println(Arrays.toString(arr));

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		String ss = list.stream().map(String::valueOf).collect(Collectors.joining());
		System.out.println(ss + ">>>>>>>>>>>>>>>>>>>>>>>");

// Using Stream mapToInt(ToIntFunction mapper) 
// and displaying the corresponding IntStream 
		list.stream().mapToInt(num -> num).forEach(System.out::println);
		StringBuilder builder = new StringBuilder();
		builder.append("hel00");
		builder.setLength(1212);
		int len = builder.length();
		System.out.println(len);

	}
	@Test
	public void printPrime(){
		IntStream.range(2,20).forEach(System.out::println);
		int num=15;
		while (num!=0){
			boolean flag=false;

			for(int i=2;i<=(int)Math.sqrt(num);i++){
				if(num%i==0) {
					flag=true;
					break;
				}
			}
//			if(!flag) System.out.println(STR."number is prime \{num}");
			num--;
		}
	}

}
