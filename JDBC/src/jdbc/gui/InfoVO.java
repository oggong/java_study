package jdbc.gui;

// VO(Value of ) = DTO(Data Transfer Object) 데이터 전송 객체 

// 서로 다른 값들을 정리해주는 class 

// constructor 생성

public class InfoVO {

	String name;
	String id;
	String tel;
	String gender;
	int age;
	String home;

	public InfoVO() {
	}

	public InfoVO(String name, String id, String tel, String gender, int age, String home) {
		super();
		this.name = name;
		this.id = id;
		this.tel = tel;
		this.gender = gender;
		this.age = age;
		this.home = home;
	}

	// setter / getter 생성
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	// 한줄에 출력하기 위해
	public String toString() {
		return name + "\t" + id + "\t" + tel + "\t" + gender + "\t" + age + "\t" + home + "\n";
	}

}
