package JavaHandsOn;

public class newtest2 extends newtest {
    public void test() {
        System.out.println(" from second class !");

    }

    public static void main(String[] args) {
        newtest newtest2= new newtest2();
        ((JavaHandsOn.newtest2) newtest2).test();
    }

}
