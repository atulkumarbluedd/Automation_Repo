package prototypeDesignPattern;

import java.util.HashMap;
import java.util.Map;

public class VehicleRegistry {

	private static Map<String, Vehicle> map = new HashMap<>();
	static {
		/* base objects which user can clone them or reuse as per need*/
		map.put("TWO", new TwoWheeler("120", "royal", "100000", false));
		map.put("FOUR", new FourWheelerVehicle("1230", "hexa", "2121", false,true));
	}

	public Vehicle getVehicle(String vehicle) throws CloneNotSupportedException {
		return map.get(vehicle).clone();
	}
}
