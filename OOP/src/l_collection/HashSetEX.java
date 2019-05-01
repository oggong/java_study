package l_collection;

import java.util.*;

public class HashSetEX {

	public static void main(String[] args) {

		HashSet list = new HashSet();
		list.add("rabbit");
		list.add("zebra");
		list.add("fox");
		list.add("fox");
		list.add("zebra");
		list.add("lion"); // set은 순서를 저장하지 않는 것

		System.out.println(list);
	}

}
