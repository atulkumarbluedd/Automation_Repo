package factory_design_pattern;

public abstract class OperatingSystem {
	private String version;
	private String architecture;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getArchitecture() {
		return architecture;
	}

	public void setArchitecture(String architecture) {
		this.architecture = architecture;
	}

	OperatingSystem(String version, String architecture) {
		this.version = version;
		this.architecture = architecture;

	}

	/**
	 * Abstract methods which are implemented by sub classes
	 * 
	 * @param dir
	 */

	public abstract void setDir(String dir);

	public abstract void removeDir(String dir);

}
