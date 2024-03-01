package cs207.linear;

import java.util.Comparator;

public class StringComparePQ {
  public static void main(String[] args) throws Exception {
  	/*  Create a priority queue with a comparator for string length
		*   If lengths are equal, compare strings alphabetically.
    */
		BuiltinPriorityQueue<String> pq = new BuiltinPriorityQueue<>(10, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				int diff = s1.length() - s2.length();
				if (diff != 0) {
					return diff;
				}
				return s1.compareTo(s2);
			}
		});

		// Add strings
		pq.put("Trung");
		pq.put("James");
		pq.put("Patterson");
		pq.put("Adam");
		pq.put("Sam");

		while (!pq.isEmpty()) {
			System.out.println(pq.get());
		}
  } // main
} // class StringCompare
