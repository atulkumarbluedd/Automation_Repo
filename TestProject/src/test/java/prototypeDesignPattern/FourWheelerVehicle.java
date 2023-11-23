package prototypeDesignPattern;

public class FourWheelerVehicle extends Vehicle {

	private boolean isAutomatic;
	private boolean isDeseal;

	public FourWheelerVehicle(String engine, String model, String price, boolean isAutomatic, boolean isDeseal) {
		super(engine, model, price);
		this.isAutomatic = isAutomatic;
		this.isDeseal = isDeseal;

	}

	protected FourWheelerVehicle clone() throws CloneNotSupportedException {
        return (FourWheelerVehicle) super.clone();
    }

}
