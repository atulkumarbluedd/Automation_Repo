package factory_design_pattern;

public class WindowsOperatingSystem extends OperatingSystem {
	public WindowsOperatingSystem(String version, String architecture) {
		super(version, architecture);
	}

	@Override
	public void setDir(String dir) {
		/**
		 * here we use windows commands
		 */

	}

	@Override
	public void removeDir(String dir) {
		/**
		 * here we use windows commands
		 */

	}
}
