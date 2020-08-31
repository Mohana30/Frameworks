package JavaTuts;


import java.util.HashSet;
import java.util.Iterator;

public class SetExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> hs = new HashSet<String>();
		hs.add("A");
		hs.add("B");
		hs.add("C");
		System.out.println(hs);
		hs.add("C");
		System.out.println(hs);
		System.out.println(hs.isEmpty());
		System.out.println(hs.size());
		System.out.println(hs.remove("A"));
		System.out.println(hs);
		//We dono the index of elements since this set is arranging the elements in a random manner
		//So navigate the elements with the help of iterator
		
	
		Iterator<String> i = hs.iterator();
		//What if you want to travel to the last element will you write the .next n times??? we need to use while loop
		
		while(i.hasNext()) {
			System.out.println(i.next());
		}	
		
	}

}
