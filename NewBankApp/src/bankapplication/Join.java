package bankapplication;

public class Join {
	
	//�ʵ�
	private String id;
	private String password;
	private int val;


	//������
	public Join(String id, String password, int val) {
		this.id = id;
		this.password = password;
		this.val = val;
	}

	//�޼ҵ�
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
