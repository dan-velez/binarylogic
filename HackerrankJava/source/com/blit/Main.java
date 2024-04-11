package com.blit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	
	public static void main (String[] args) {
		System.out.println("Hackerrank.");
		System.out.println("===========");

		System.out.println("Reverse Arrays");
		List<Integer> A = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println(Main.reverseArray(A)	);

		System.out.println("Hour Glass Sum");
		List<List<Integer>> mat = Arrays.asList(
			Arrays.asList(1, 2, 3, 0, 0, 0),
			Arrays.asList(0, 4, 0, 0, 0, 0),
			Arrays.asList(5, 6, 7, 0, 0, 0),
			Arrays.asList(0, 0, 0, 0, 0, 0),
			Arrays.asList(0, 0, 0, 0, 0, 0),
			Arrays.asList(0, 0, 0, 0, 0, 0)
		);

		System.out.println(hourglassSum(mat));
	}

	public static int hourglassSum (List<List<Integer>> arr) {

		int row = 0;
		int col = 0;
		Integer max = null;
		
		for (int i = 0; i <= 16; i++) {
			System.out.println("ROW: "+row);
			System.out.println("COL: "+col);
			System.out.println("INDEX: "+i);
			
			int[] hourGlass = {
				arr.get(row).get(col), arr.get(row).get(col+1), arr.get(row).get(col+2),
				arr.get(row+1).get(col+1),
				arr.get(row+2).get(col), arr.get(row+2).get(col+1), arr.get(row+2).get(col+2) 
			};
			
			int sum = Main.arrSum(hourGlass);
			if (max == null) max = sum;
			else if (sum > max) max = sum;

			col = col+1;
			if (col == 4) {
				col = 0;	
				row = row+1;
			}
			if (row == 4) break;

			for (int j : hourGlass) System.out.print(j+", ");
			System.out.println("\n");
		}
		
		return max;
	}

	public static int arrSum (int[] arr) {
		int res = 0;
		for (int i = 0; i < arr.length; i++) res = res+arr[i];
		return res;
	}

   public static List<Integer> reverseArray (List<Integer> a) {
        List<Integer> res = new ArrayList<>();
        for (int i = a.size()-1; i >= 0; i--) {
			res.add(a.get(i));
        }
        return res;
    }

}