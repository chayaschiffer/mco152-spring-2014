package schiffer.interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueNumbers {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Set<Integer> set = new HashSet<Integer>();

		System.out.println("Enter ten numbers");

		for (int i = 0; i < 10; i++) {
			int num = input.nextInt();
			if (!set.contains(num)) {
				set.add(num);
			}
		}
		System.out.println(set);
		
		
		HashMap<Integer, Integer> list = new HashMap<Integer, Integer>();
		System.out.println("Enter 10 digits");
		for(int i=0;i<10;i++){
			int num = input.nextInt();
			if(list.containsKey(num)){
				int value = list.get(num);
				list.put(num, ++value);
			}
			else{
				list.put(num, 1);
			}
		}
		System.out.println(list);
	}

}

/*
 * Set is different than a list
 * In a hash set, each element is mapped, placed in a certain position based on hashing algorithm 
 * now, with set, o(1). 
 * o notation is a way of describing  how efficient an algorithm is. 
 * Efficiency, in this case, is describing how many comparisons you have to do before entering
 * item into a list.

 *
 *O Notation
 *o(1)
 *o(n)- by using hash set, change from o(n) to o(1)
 *o(lg n)
 *o(n lg n)
 *o(n^2)
 *
 *
 *sets will not give you a guaranteed order
 *sets are ordered based on how algorithm put it in to internal structure
 *can't know before
 
 *advantage of set is to look up whether something exists
 *it's much more efficient than lists with exists
 *
 *
 *Map, maps keys to values
 *keys must be unique
 *
 *
 *Numeric objects like Integer, Long are immutable so try not to use them unnecessarily 
 *
 *map.put(word, i++)
 *this increments i after the method is called
 *map.put(word, ++i)
 *this increments i before the method is called
 */

