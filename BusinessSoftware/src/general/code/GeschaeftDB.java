package general.code;

public class GeschaeftDB {

	private static GeschaeftDB geschaeftInstance;
	private String currentAccountName;
	private boolean isMitarbeiter;
	
	private GeschaeftDB() {
		//private no-arg constructor needed
	}

	/**
	 * if no instance is created yet, it creates one
	 * @return new Instance for {@link GeschaeftDB}
	 */
	public static GeschaeftDB getInstance() {
		if (geschaeftInstance == null) {
			geschaeftInstance = new GeschaeftDB();
		}

		return geschaeftInstance;
	}

	/**
	 * deletes the current instance by setting the instance to null
	 */
	public void deleteInstance() {
		isMitarbeiter = false;
		geschaeftInstance = null;
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
