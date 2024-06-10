package user.model;

public class UserVO {

	private String id;
	private String pwd;
	private String name;
	private String nickname;
	private String address;
	private String account;
	private String location;

	public UserVO(String id,String pwd,String name,String nickname,String address,String account,String location) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.nickname = nickname;
		this.address = address;
		this.account = account;
		this.location = location;
	}

	public String getId() {
		return id;
	}

	public String getPwd() {
		return pwd;
	}
	public String getName() {
		return name;
	}
	public String getNickname() {
		return nickname;
	}
	public String getAddress() {
		return address;
	}
	public String getAccount() {
		return account;
	}
	public String getLocation() {
		return location;
	}

	public boolean matchPassword(String curPwd) {
		return pwd.equals(curPwd);
	}

	public void changePassword(String newPwd) {
		this.pwd =newPwd;
	}
}
