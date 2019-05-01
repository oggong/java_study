package b_info;

public class Person {

	private String name;
	private String id;
	private String tel;
	private String gender;
	private int age;
	private String home;

	public Person() {

	} // 기본 생성자 생성

	// alt + shift + s 해서 자동 생성 소스 활용 !
	public Person(String name, String id, String tel, String gender, int age, String home) {
		super();
		this.name = name;
		this.id = id;
		this.tel = tel;
		this.gender = gender;
		this.age = age;
		this.home = home;
	}

//========================================================생성자 setter // getter

	public String toString() { // 출력할때 깨끗하게 해주려고 toString 만 오버라이딩 함!
		return name + "\t" + id + "\t" + tel + "\t" + gender + "\t" + age + "\t" + home + "\n";
	}

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

}
