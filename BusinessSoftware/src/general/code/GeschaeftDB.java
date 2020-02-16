package general.code;

public class GeschaeftDB {

	private static GeschaeftDB geschaeftInstance;
	private String currentAccountName;
	private boolean isMitarbeiter;

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
	
	public void setLoginStatus(boolean isMitarbeiter) {
		this.isMitarbeiter = isMitarbeiter;
	}
	
	public boolean isMitarbeiter() {
		return isMitarbeiter;
	}

}
