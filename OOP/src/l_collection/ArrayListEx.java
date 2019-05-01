package l_collection;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListEx {

	public static void main(String[] args) {

		ArrayList list = new ArrayList(4);
		list.add("rabbit");
		list.add("zebra");
		list.add("fox");
		list.add("cat");
		list.add("ant");
		list.add("lion");
		list.add(100);
		list.add(200);

//		for(String str : list) {
//			System.out.println(str);
//		}
		System.out.println(list.toString());

		list.set(2, "dog");
		System.out.println(list);

		list.remove(4);
		System.out.println(list);

		Collections.sort(list);
		System.out.println(list);

//		for (int i = 0; i < list.size(); i++) {
//			String str = (String) list.get(i);
//			System.out.println(str);
//		}
	}
}
