package contact;

public class Contact {
	private final String contactID;
	private String contactFirstName;
	private String contactLastName;
	private String contactPhoneNumber;
	private String contactAddress;
	
	public Contact(String id, String frstName,String lstName, String phoneNum, String address) {
        validateInputs(id, frstName, lstName, phoneNum, address);
		
		this.contactID = id;
		this.contactFirstName = frstName;
		this.contactLastName = lstName;
		this.contactPhoneNumber = phoneNum;
		this.contactAddress = address;
				
	}
	
	private void validateInputs(String id, String frstName, String lstName, String phoneNum, String address) {
		if (id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid Id");
		}
	    if (frstName == null || frstName.length() > 10) {
	        throw new IllegalArgumentException("Invalid first name");
	    }
	    if (lstName == null || lstName.length() > 10) {
	        throw new IllegalArgumentException("Invalid last name");
	    }
	    if (phoneNum == null || phoneNum.length() != 10) {
	        throw new IllegalArgumentException("Invalid phone number");
	    }
	    if (address == null || address.length() > 30) {
	        throw new IllegalArgumentException("Invalid address");
	    }
	}
	
    // Getter and setter methods	
	public String getId() {
		return contactID;
	}
	
	public String getFirstName() {
		return contactFirstName;
	}
	public void setFirstName(String frstName) {
		this.contactFirstName = frstName;
	}
	
	public String getLastName() {
		return contactLastName;
	}
	public void setLastName(String lstName) {
		this.contactFirstName = lstName;
	}
	
	public String getPhoneNumber() {
		return contactPhoneNumber;
	}
	public void setPhoneNumber(String phnNum) {
		this.contactFirstName = phnNum;
	}
	
	public String getAddress() {
		return contactAddress;
	}
	public void setAddress(String adrs) {
		this.contactFirstName = adrs;
	}
	
}
