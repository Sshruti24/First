package test;

import java.util.ArrayList;
import java.util.Iterator;

interface details {
	void show();

}

public class Task implements details {

	@Override
	public void show() {
		System.out.println("Get Details");
	}

	public static void main(String[] args) {

		Task ob = new Task();
		ob.show();

		// Collection

		ArrayList list = new ArrayList();
		list.add("Hello Word");
		list.add("Wlcome");
		list.add(86);

		Iterator i = list.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());

			// String
			String s1 = "Java";
			String s2 = new String("Java");

			System.out.println(s1.equals(s2));
			System.out.println(s1 == s2);

		}

	}
}
