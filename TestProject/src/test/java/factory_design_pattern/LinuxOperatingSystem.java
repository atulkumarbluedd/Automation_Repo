package factory_design_pattern;

public class LinuxOperatingSystem extends OperatingSystem {
	LinuxOperatingSystem(String version, String operatingSystem) {
		super(version, operatingSystem);
	}

	@Override
	public void setDir(String dir) {
		/**
		 * here we use linux commands
		 */
	}

	@Override
	public void removeDir(String dir) {
		/**
		 * here we use linux commands
		 */

	}
}
