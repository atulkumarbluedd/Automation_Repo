package builderDesignPattern.burger.sample;

public class Main {
	public static void main(String[] args) {
		/**
		 *  Using builder we have created the object and we as implementer of
		 *   builder pattern need to assure that this is not inconsistent object.
		 */
		Burger burger = new Burger.BurgerBuilder().mionese(true).onion(true).build();
//		Meal meal = new MealDirector(new VegMealBuilder()).prepareMeal();
		//https://github.com/shabbirdwd53/design_patterns/blob/main/builder/src/main/java/MealDirector.java
	}

}
