package l_collection;

import java.util.*;

public class HashSetLotto {

	public static void main(String[] args) {

		HashSet<Integer> lotto = new HashSet<Integer>();
		while (lotto.size() < 6) {
			int su = (int) ((Math.random() * 45) + 1);
			lotto.add(su);
		}

//		for (int i = 0; i < 6; i++) {
//			int su = (int) ((Math.random() * 45) + 1);
//			lotto.add(su);
//		}
		System.out.println(lotto);
		ArrayList<Integer> list = new ArrayList<Integer>(lotto);
		Collections.sort(list);
		System.out.print(list);
	}

}
