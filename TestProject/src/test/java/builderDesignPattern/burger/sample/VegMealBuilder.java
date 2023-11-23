package builderDesignPattern.burger.sample;

public class VegMealBuilder extends MealBuilder {

	private Meal meal;

	@Override
	public void addBriyani() {
		this.meal.setBriyani("biryani");

	}

	@Override
	public void addBread() {
		this.meal.setBread("Bread");

	}

	@Override
	public void addColdDrink() {
		this.meal.setColdDrink("coldDrink");
	}

	@Override
	public void addCurry() {
		this.meal.setCurry("goby");
	}

	@Override
	public Meal build() {
		return meal;
	}

}
