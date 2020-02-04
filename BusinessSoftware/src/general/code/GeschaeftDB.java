package general.code;

public class GeschaeftDB {

	private static GeschaeftDB geschaeftInstance;
	private String currentAccountName;

	public static GeschaeftDB getInstance() {
		if (geschaeftInstance == null) {
			geschaeftInstance = new GeschaeftDB();
		}

		return geschaeftInstance;
	}

	public void deleteInstance() {
		geschaeftInstance = new GeschaeftDB();
	}

	public String getCurrentAccountName() {
		return currentAccountName;
	}

	public void setCurrentAccountName(String currentAccountName) {
		this.currentAccountName = currentAccountName;
	}

}
