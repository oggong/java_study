package j_useful;

public enum Names {

	// 상수를 클래스처럼 취급
	GILDONG("개발자") {
		String salary() {
			return "추가급여대상";
		}
	},
	GILJA("디자이너"), GILJUN("팀장");

	String job;

	Names(String job) {
		this.job = job;
	}

	String salary() {
		return "고정급여";
	}
}
