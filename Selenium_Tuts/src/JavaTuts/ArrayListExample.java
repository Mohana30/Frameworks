package JavaTuts;

import java.util.ArrayList;

public class ArrayListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ArrayList size is dynamically growing and can access/insert the values at anytime
		ArrayList<Integer> ar = new ArrayList<Integer>();
		ar.add(123);
		ar.add(456);
		System.out.println(ar);
		ar.remove(1);
		System.out.println(ar);
		ar.add(13);
		//ArrayList accepts duplicate values
		ar.add(13);
		ar.add(23);
		ar.add(56);
		System.out.println(ar.get(2));
		System.out.println(ar);
		System.out.println(ar.contains(456));
		//It will give the first index of the duplicate value
		System.out.println(ar.indexOf(13));
		System.out.println(ar.isEmpty());
		System.out.println(ar.size());
	}

}
