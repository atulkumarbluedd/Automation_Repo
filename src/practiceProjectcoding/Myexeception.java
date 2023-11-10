package practiceProjectcoding;

import java.util.Iterator;
import java.util.LinkedList;

public class Myexeception extends Exception {
	Myexeception(String s) {
		super(s);
	}

	public static void main(String[] args) {

		try {

			throw new Myexeception("hello world");
		} catch (Myexeception e) {

			System.out.println(" caught Exception");
			System.out.println(e.getMessage());
		}

	}
}