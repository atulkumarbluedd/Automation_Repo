package abstract_factory_designPattern.UIFactory;

 

public class Application {
	private Button button;
	private CheckBox checkbox;
	public Application(UIFactory factory) {
		button= factory.createButton();
		checkbox=factory.creaCheckBox();
		System.err.println();
	}
	public void paint() {
		button.paint();
		checkbox.paint();
	}
}
