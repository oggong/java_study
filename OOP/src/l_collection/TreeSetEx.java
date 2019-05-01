package l_collection;

import java.util.*;

public class TreeSetEx {

	public static void main(String[] args) {
		TreeSet set = new TreeSet();

		set.add("사자");
		set.add("고양이");
		set.add("낭만고양이");
		set.add("오리");
		set.add("날아");
		set.add("올라");
		set.add("저하늘");
		set.add("멋진");
		set.add("달이");
		set.add("될게요");
		set.add("사자");
		set.add("사자");

		System.out.println(set);
		System.out.println(set.subSet("d", "s"));
		System.out.println(set.headSet("d"));
		System.out.println(set.tailSet("d"));

	}

}
