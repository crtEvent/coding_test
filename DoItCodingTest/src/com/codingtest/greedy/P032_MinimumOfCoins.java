package com.codingtest.greedy;

import java.util.Scanner;

/**
 * Q. P032_동전의 최소 개수 구하기
 * @author : crtEvent
 * @date   : 2022. 11. 28.
 */
public class P032_MinimumOfCoins {
	
	private static int[] coinType = {10, 100, 1000, 5000, 10000, 50000};
	
	public static void runPrompt() {
		Scanner sc = new Scanner(System.in);
		System.out.println("가격을 입력해 주세요.");
		int price = sc.nextInt();
		
		getMinimumOfCoins(price);
		sc.close();
	}
	
	public static void getMinimumOfCoins(int price) {
		runMySolution(price);
		//runSolution(price);
	}
	
	public static void runMySolution(int price) {
		int countCoin = 0;
		for(int i = coinType.length - 1; i >= 0; i--) {
			countCoin += price / coinType[i];
			price = price % coinType[i];
			System.out.printf("비교할 동전=%d, coinNum=%d, price=%d\n", coinType[i], countCoin, price);
			
			if(price == 0) {
				break;
			}
		}
		System.out.printf("필요한 최소 동전 개수는=%d개\n", countCoin);
	}
	
	public static void runSolution(int price) {
		int count = 0;
		for(int i = coinType.length - 1; i >= 0; i--) {
			if(coinType[i] <= price) { // 현재 동전이 price보다 작거나 같으면 추가
				count += (price / coinType[i]);
				price = price % coinType[i];
			}
		}
		System.out.printf("필요한 최소 동전 개수는=%d개\n", count);
	}
	
	public static void main(String[] args) {
		runPrompt();
	}

}
