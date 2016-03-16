package sugukuru.bean;

public class Employee {
	private String id;
	private String lastName;
	private String firstName;
	private int postId;
	private int positionId;
	private String email;

	public Employee(String id, String lastName, String firstName, int postId, int positionId, String email) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.postId = postId;
		this.positionId = positionId;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public int getPostId() {
		return postId;
	}

	public int getPositionId() {
		return positionId;
	}

	public String getEmail(){
		return email;
	}
}
