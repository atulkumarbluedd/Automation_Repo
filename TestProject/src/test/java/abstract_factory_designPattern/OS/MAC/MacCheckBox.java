package abstract_factory_designPattern.OS.MAC;

import abstract_factory_designPattern.UIFactory.CheckBox;

public class MacCheckBox implements CheckBox{

	@Override
	public void paint() {
		 System.out.println("mac checkbox");
		
	}

}
