

public class System_apps {
	
	@SuppressWarnings("deprecation")
	public void notepad() {
		Runtime rs = Runtime.getRuntime();
		try {
			rs.exec("notepad");
		} catch (Exception j) {
			System.out.println("cant find notepad");
		}
	}

	@SuppressWarnings("deprecation")
	public void mspaint() {
		Runtime rs = Runtime.getRuntime();
		try {
			rs.exec("mspaint");
		} catch (Exception f) {
			System.out.println("can't find mspaint");
		}
	}
}

