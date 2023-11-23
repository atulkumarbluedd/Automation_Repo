package abstract_factory_designPattern.UIFactory;

import abstract_factory_designPattern.OS.MAC.MacButton;
import abstract_factory_designPattern.OS.MAC.MacCheckBox;
import abstract_factory_designPattern.OS.WIN.WinButton;

public class MacUIFactory implements UIFactory {

	@Override
	public Button createButton() {
		// TODO Auto-generated method stub
		return new MacButton();
	}

	@Override
	public CheckBox creaCheckBox() {
		// TODO Auto-generated method stub
		return new MacCheckBox();
	}

}
