package abstract_factory_designPattern.UIFactory;

public class Main {

	public static void main(String[] args) {
		Application application= new Application(new MacUIFactory());
		application.paint();
	}
}
