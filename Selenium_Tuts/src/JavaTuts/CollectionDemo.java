package JavaTuts;

import java.util.ArrayList;

public class CollectionDemo {
	public static void main(String[] args) {
		int a[] = { 4, 4, 6, 5, 3, 6, 2, 9, 5, 9 };
		// I want to print the number with times of repetition and one unique number
		// which is not duplicated

		ArrayList<Integer> ar = new ArrayList<Integer>();
		for (int i = 0; i < a.length; i++) {
			int k = 0;
			if (!ar.contains(a[i])) {
				ar.add(a[i]);
				k++;

				for (int j = i + 1; j < a.length; j++) {
					if (a[i] == a[j]) {
						k++;
					}
				}System.out.println("Value " + a[i] + " repeated " + k + " times");
				if(k==1)
				{
					System.out.println("Unique number is : "+a[i]);
				}
			}
			}
		

	}

}
