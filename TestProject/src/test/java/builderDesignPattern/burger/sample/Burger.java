package builderDesignPattern.burger.sample;

public class Burger {
	private String size;
	private boolean egg;
	private boolean extraChese;
	private boolean mionese;
	public boolean onion;
	public boolean lettuce;

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public boolean isEgg() {
		return egg;
	}

	public void setEgg(boolean egg) {
		this.egg = egg;
	}

	public boolean isExtraChese() {
		return extraChese;
	}

	public void setExtraChese(boolean extraChese) {
		this.extraChese = extraChese;
	}

	public boolean isMionese() {
		return mionese;
	}

	public void setMionese(boolean mionese) {
		this.mionese = mionese;
	}

	public boolean isOnion() {
		return onion;
	}

	public void setOnion(boolean onion) {
		this.onion = onion;
	}

	public boolean isLettuce() {
		return lettuce;
	}

	public void setLettuce(boolean lettuce) {
		this.lettuce = lettuce;
	}

	private Burger(BurgerBuilder burgerBuilder) {
		/**
		 * Here we can add validation for example weight of the burger should be 100 gm
		 * etc.
		 */
		System.out.println("burger is created");
	}

	// Return same object everytime that is builder instance
	// Once build method invoke return actual object.
	public static class BurgerBuilder {
		private String size;
		private boolean egg;
		private boolean extraChese;
		private boolean mionese;
		public boolean onion;
		public boolean lettuce;

		public BurgerBuilder size(String size) {
			this.size = size;
			return this;
		}

		public BurgerBuilder egg(boolean egg) {
			this.egg = egg;
			return this;
		}

		public BurgerBuilder extraChese(boolean extraChese) {
			this.extraChese = extraChese;
			return this;
		}

		public BurgerBuilder mionese(boolean mionese) {
			this.mionese = mionese;
			return this;
		}

		public BurgerBuilder onion(boolean onion) {
			this.onion = onion;
			return this;
		}

		public BurgerBuilder lettuce(boolean lettuce) {
			this.lettuce = lettuce;
			return this;
		}

		public Burger build() {
			return new Burger(this);
		}

	}

}
