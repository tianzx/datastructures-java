package datastructures.tree234;
/**
 * encapsulation data distinguish object
 * @author tianzx
 *
 */
public class KeyItem {
	private int id;
	private int businessData;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the businessData
	 */
	public int getBusinessData() {
		return businessData;
	}
	/**
	 * @param businessData the businessData to set
	 */
	public void setBusinessData(int businessData) {
		this.businessData = businessData;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "KeyItem [id=" + id + ", businessData=" + businessData + "]";
	}
}
