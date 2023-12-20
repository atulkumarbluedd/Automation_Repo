package JavaHandsOn.streamConcepts;

public class functionalinterface {
    /**
     * SAM >> single abstract method in the interface why we create annonimous class
     * >> reason is whenver we feel we are not going to create object of this class
     * again and again then we go with annonimous class
     */


    /**
     * in java 8 we have below functional interfaces
     * predicate -> boolean result
     * consumer -> no result
     * supplier -> no i/p only it supplies
     * Functions -> have i/p and o/p
     *
     * @param args
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

    /* all methods of object class can be overridden but it can have only one abstract method defined by user */
    String toString();

}
