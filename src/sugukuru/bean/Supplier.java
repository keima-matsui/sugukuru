package sugukuru.bean;

public class Supplier {

	private String id;
	private String supplierName;
	private String readerName;
	private String postAddress;
	private String address;
	private String phoneNumber;
	private String memo;
	private String date;

	/**
	 *
	 * @param supplierName
	 * @param readerName
	 * @param postAddress
	 * @param address
	 * @param phoneNumber
	 * @param memo
	 * Insert時に生成してDaoに渡すためのオブジェクトを生成するコンストラクタ
	 */
	public Supplier(String supplierName, String readerName, String postAddress,
			String address, String phoneNumber, String memo) {
		this.supplierName = supplierName;
		this.readerName = readerName;
		this.postAddress = postAddress;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.memo = memo;
	}

	/**
	 *
	 * @param id
	 * @param supplierName
	 * @param readerName
	 * @param postAddress
	 * @param address
	 * @param phoneNumber
	 * @param memo
	 * @param date
	 * Daoから取得したデータを一覧表示
	 */
	public Supplier(String id, String supplierName, String readerName, String postAddress,
			String address, String phoneNumber, String memo, String date) {
		this.id = id;
		this.supplierName = supplierName;
		this.readerName = readerName;
		this.postAddress = postAddress;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.memo = memo;
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public String getReaderName() {
		return readerName;
	}

	public String getPostAddress() {
		return postAddress;
	}

	public String getAddress() {
		return address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getMemo() {
		return memo;
	}

	public String getDate(){
		return date;
	}
}
