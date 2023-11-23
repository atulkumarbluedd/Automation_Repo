package abstract_factory_designPattern.UIFactory;

import abstract_factory_designPattern.OS.WIN.WinButton;
import abstract_factory_designPattern.OS.WIN.WinCheckBox;

public class WINUIFactory implements UIFactory {

	@Override
	public Button createButton() {
		// TODO Auto-generated method stub
		return new WinButton();
	}

	@Override
	public CheckBox creaCheckBox() {
		// TODO Auto-generated method stub
		return new WinCheckBox();
	}

}
