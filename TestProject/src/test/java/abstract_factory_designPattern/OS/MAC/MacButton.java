package abstract_factory_designPattern.OS.MAC;

import abstract_factory_designPattern.UIFactory.Button;

public class MacButton implements Button {

	@Override
	public void paint() {
		System.out.println("mac Button");

	}

}
