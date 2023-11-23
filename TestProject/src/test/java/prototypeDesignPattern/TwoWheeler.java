package prototypeDesignPattern;

public class TwoWheeler extends Vehicle {

	public boolean isElectric;
	public TwoWheeler(String engine, String model, String price, boolean isElectric) {
		super(engine, model, price);
		this.isElectric=isElectric;
		 
	}

	
}
