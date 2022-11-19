package com.codingtest.sort.bubble;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Bubble sort
 * - 인접한 요소끼리 비교하고, swap 연산을 수행하며 정렬하는 방식
 * - 시간복잡도: O(n^2)
 * @author : crtEvent
 * @date   : 2022. 11. 19.
 */
public class P015_BubbleSort {
	
	public void runPrompt() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("입력할 수의 개수를 입력해 주세요.");
		int dataSize = sc.nextInt();
		
		System.out.println("데이터를 입력해 주세요.");
		int[] dataArr = new int[dataSize];
		for(int i = 0; i < dataSize; i++) {
			dataArr[i] = sc.nextInt();
		}
		
		doAscendingBubbleSort(dataArr);
		sc.close();
	}
	
	public void doAscendingBubbleSort(int[] dataArr) {
		runMySolution(dataArr);
		//runSolution(dataArr);
		
	}
	
	public void runMySolution(int[] dataArr) {
		System.out.printf("데이터: %s\n", Arrays.toString(dataArr));
		int swapCount = 0, repeatCount = 1;
		
		while(swapCount != 1) {
			swapCount = 1;
			System.out.printf("Loop %d\n", repeatCount);
			for(int i = 0; i < dataArr.length-1; i++) {
				if(dataArr[i] > dataArr[i+1]) {
					int temp = dataArr[i];
					dataArr[i] = dataArr[i+1];
					dataArr[i+1] = temp;
					swapCount++;
				}
				System.out.printf(" %d. %s\n", i+1, Arrays.toString(dataArr));
			}
			repeatCount++;
		}
		
		System.out.println("오름차순 정렬 완료!");
	}
	
	public void runSolution(int[] dataArr) {
		for(int i = 0; i < dataArr.length - 1; i++) {
			for(int j = 0; j < dataArr.length - 1 - i; j++) {
				if(dataArr[j] > dataArr[j + 1]) {
					int temp = dataArr[j];
					dataArr[j] = dataArr[j + 1];
					dataArr[j + 1] = temp;
				}
			}
		}
		System.out.printf("데이터: %s\n", Arrays.toString(dataArr));
		System.out.println("오름차순 정렬 완료!");
	}
	
	public static void main(String[] args) {
		P015_BubbleSort p = new P015_BubbleSort();
		p.runPrompt();
	}

}
