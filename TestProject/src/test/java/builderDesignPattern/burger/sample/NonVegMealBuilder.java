package builderDesignPattern.burger.sample;

public class NonVegMealBuilder extends MealBuilder {
	private Meal meal;

	public NonVegMealBuilder() {
		meal = new Meal();
	}

	@Override
	public void addBriyani() {
		this.meal.setBriyani("chicken");

	}

	@Override
	public void addBread() {
		this.meal.setBread("Bread");

	}

	@Override
	public void addColdDrink() {
         this.meal.setColdDrink("cold drink");
	}

	@Override
	public void addCurry() { 
		this.meal.setCurry("Curry");
	}

	@Override
	public Meal build() {
		// TODO Auto-generated method stub
		return meal;
	}
}
