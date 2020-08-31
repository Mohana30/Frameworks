package JavaTuts;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExample {

	public static void main(String[] args) {
		//
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		hm.put(0, 123);
		hm.put(1, 123);
		hm.put(22, 123);
		hm.put(3, 123);
		//output will be null since the key '2' is not present in the HashMap 
		System.out.println(hm.get(2));
		//Now output will be the value of the key 22
		System.out.println(hm.get(22));
		hm.remove(22);
		System.out.println(hm.get(22));
		//make all the values placed in the Set
		Set sn = hm.entrySet();
		Iterator i = sn.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());//If you run like this it will produce the output as like below
			//		0=123
			//		1=123
			//		3=123				//Since we have the key and value present in the HashMap
		}
			i = sn.iterator();
		while(i.hasNext()) {
			
			Map.Entry mp = (Map.Entry)i.next();
			
			System.out.println("Key : "+mp.getKey());
			System.out.println("Value : "+mp.getValue());
		}
		
		
	}
}
