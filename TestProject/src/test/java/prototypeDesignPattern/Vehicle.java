package prototypeDesignPattern;

public abstract class Vehicle implements Cloneable {
	private String engine;
	public String model;
	public String price;

	/**
	 * constructor
	 * 
	 * @param engine
	 */
	public Vehicle(String engine, String model, String price) {
		this.engine = engine;
		this.model = model;
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	protected Vehicle clone() throws CloneNotSupportedException {
		return (Vehicle) super.clone();
	}

}
