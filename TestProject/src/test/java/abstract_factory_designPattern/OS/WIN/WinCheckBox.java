package abstract_factory_designPattern.OS.WIN;

import abstract_factory_designPattern.UIFactory.CheckBox;

public class WinCheckBox implements CheckBox{

	@Override
	public void paint() {
		 System.out.println("Win checkBox");
		
	}

}
