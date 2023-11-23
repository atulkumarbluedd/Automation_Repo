package abstract_factory_designPattern.OS.WIN;

import abstract_factory_designPattern.UIFactory.Button;

public class WinButton implements Button{

	@Override
	public void paint() {
		 System.out.println("Win Button");
		
	}

}
