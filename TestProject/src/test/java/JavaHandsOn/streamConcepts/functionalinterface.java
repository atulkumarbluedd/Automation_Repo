package JavaHandsOn.streamConcepts;

public class functionalinterface {
	/**
	 * SAM >> single abstract method in the interface why we create annonimous class
	 * >> reason is whenver we feel we are not going to create object of this class
	 * again and again then we go with annonimous class
	 */

	public static void main(String[] args) {
		/* inner class*/
		A obj = new A() {
			public void show() {
				System.out.println("hellow");
			}
		};
		obj.show();

	}
}

@FunctionalInterface
interface A {
	void show();

	/* all methods of object class can be overridden */
	String toString();

}
