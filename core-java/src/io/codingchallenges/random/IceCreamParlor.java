package io.codingchallenges.random;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author rajesh
 *
 */
public class IceCreamParlor {

	public static void main(String[] args) {
		int[] icecreamPrice = { 3, 5, 5,7,2,9,2,29 };
		int amount = 10;
		System.out.println(Arrays.toString(getIceCreamsImproved(icecreamPrice, amount)));
		System.out.println(Arrays.toString(findChoices(icecreamPrice, amount)));

	}

	// brut force logic; time comple log(n2)
	public static int[] getIceCreams(int[] menu, int amount) {
		
		int[] result = new int[2];
		for (int i = 0; i < menu.length; i++) {
			for (int j = 0; j < menu.length; j++) {
				if (i != j) {
					if (menu[i] + menu[j] == amount) {
						result[0] = i;
						result[1] = j;
						return result;
					}
				}

			}
		}
		return null;
	}

	// us

	public static int[] getIceCreamsImproved(int[] menu, int amount) {
		int[] result = new int[2];
		Map<Integer, Integer> iceCreamMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < menu.length; i++) {
				if (!iceCreamMap.containsKey(amount - menu[i])) {
					iceCreamMap.put(menu[i], i);
				} else {
					result[0] = i;
					result[1] = iceCreamMap.get(menu[i]);
					return result;
				}
		}
		return null;
		
	}
	
	public static int[] findChoices(int[] menu, int money) {
		System.out.println("menu: "+Arrays.toString(menu));
		int[] result = new int[2];
		int[] sortedMenu = menu.clone();
		Arrays.sort(sortedMenu);
		System.out.println("sortedMenu: "+Arrays.toString(sortedMenu));
		for (int i = 0; i < menu.length; i++) {
			int complement =  money - sortedMenu[i];
			int location = Arrays.binarySearch(sortedMenu, complement);
			if(location >=0 && location <= sortedMenu.length) {
				result[0] = i;
				result[1] = location;
				return result;
			}
			
		}
		
		return null;
		
	}
}
