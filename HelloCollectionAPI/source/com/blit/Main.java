package com.blit;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;

public class Main {
	public static void main (String[] args) {

		// Lists
		List<String> names = new ArrayList<String>();
		names.add("Tim");
		names.add("Daniel");
		names.add("Alleye");
		names.add("Seth");
		names.add("Prakash");
		names.add("Belinda");
		names.add("Seth");
		names.add("Hana");
		names.add("Kashaf");
		names.add("Beth");
		names.add("Bethany");

		// Print out names in brackets [].
		System.out.println(names + " " + names.size());
		Collections.sort(names); // Alphabetical order.
		System.out.println(names);

		// Psuedo-Random Order
		Collections.shuffle(names);
		System.out.println(names);

		// Sets
		Set<String> hashNames = new HashSet<>(); // Shorthand. Ignore 2nd <>.
		//Collections.addAll(hashNames, names.get(0));
		hashNames.addAll(names); // Remove duplicates. Creates a set.
		System.out.println(hashNames);

		// Tree Set
		Set<String> treeNames = new TreeSet<>();
		treeNames.addAll(names); // Sorts. TreeSets are ordered.
		treeNames.add("David");
		System.out.println(treeNames);
		
		// List insertion.
		String name = names.get(4);
		System.out.println(name);
		names.remove(4);
		names.remove("Tim");
		System.out.println(names);

		// Remove all names that start with 'B'.
		// Make a copy of the list to edit while iterating.
		List<String> tempNames = new ArrayList<>();
		tempNames.addAll(names);

		for(String s: tempNames) {
			if(s.charAt(0) == 'B') {
				names.remove(s);
			}
		}
		System.out.println(names + " " + names.size());

		// Deque
		System.out.println("Deques:");
		Deque<String> deque = new ArrayDeque<>();

		// Queue
		deque.add("Cat");
		deque.add("Dog");
		deque.add("frog");
		deque.add("Monkey");
		deque.add("Hamster");
		deque.add("Tiger");
		deque.add("Snake");

		// Prints out in brackets [].
		System.out.println(deque);
		// Remove from front of queue.
		String pet = deque.poll();
		pet = deque.poll();
		pet = deque.peek();
		pet = deque.pollLast(); // Pull from the other end of deque.
		pet = deque.getFirst();
		pet = deque.removeFirst();
		System.out.println(pet);
		System.out.println(deque);

		// Stacks.
		System.out.println("Stacks:");
		Deque<String> stack = new LinkedList<>(); // LL is a type of deque.
		stack.push("Apple");
		stack.push("Orange");
		stack.push("Grapes");
		stack.push("Mango");
		stack.push("Pineapple");
		stack.push("Mango");
		stack.push("Orange");

		System.out.println(stack);
		String fruit = stack.pop();
		System.out.println(fruit);

		// Maps
		// Not iterable.
		System.out.println("Maps:");
		Map<String, Integer> map = new TreeMap<>(); // TreeMap is ordered.
		map.put("Flour", 6);
		map.put("Apples", 11);
		map.put("Salt", 3);
		map.put("Sugar", 15);
		map.put("Wheat", 2);
		map.put("Apple pies", 5);
		System.out.println(map); // Print k/v pairs.

		for(String s : map.keySet()) { // Print out using methods.
			System.out.println(s+": "+map.get(s));
		}

		Collection c = map.values();
		System.out.println(c); // Print out the values.

		System.out.println("Entry:");
		for(Entry<String, Integer> e : map.entrySet()) {
			System.out.println(e);
		}

		// Update a value.
		map.put("Apples", 26);
		System.out.println(map);

		// Map in a map.
		Map<Map<String, String>, Map<Integer, String>> dumbMap= new HashMap<>();
	}
}