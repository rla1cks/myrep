package bankapplication;

public class Join {
	
	//필드
	private String id;
	private String password;
	private int val;


	//생성자
	public Join(String id, String password, int val) {
		this.id = id;
		this.password = password;
		this.val = val;
	}

	//메소드
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}	


}
