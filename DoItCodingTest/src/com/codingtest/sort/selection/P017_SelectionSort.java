package com.codingtest.sort.selection;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Selection Sort
 * - 대상에서 가장 크거나 작은 데이터를 찾아 선택/swap연산을 반복하면서 정렬
 * - 시간 복잡도: O(n^2)
 * @author : crtEvent
 * @date   : 2022. 11. 20.
 */
public class P017_SelectionSort {
	
	public void runPrompt() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("입력할 수의 개수를 입력해 주세요.");
		int dataSize = sc.nextInt();
		
		System.out.println("데이터를 입력해 주세요.");
		int[] dataArr = new int[dataSize];
		for(int i = 0; i < dataSize; i++) {
			dataArr[i] = sc.nextInt();
		}
		
		doDescendingSelectionSort(dataArr);
		sc.close();
	}
	
	public void doDescendingSelectionSort(int[] dataArr) {
		// runMySolution(dataArr);
		runSolution(dataArr);
	}
	
	public void runMySolution(int[] dataArr) {
		System.out.printf("데이터: %s\n", Arrays.toString(dataArr));
		int loopIdx = 0;
		
		for(int i = 0; i < dataArr.length - 1; i++) {
			System.out.printf("Loop %d\n", loopIdx+1);
			for(int j = loopIdx; j < dataArr.length - 1; j++) {
				if(dataArr[loopIdx] < dataArr[j+1]) {
					int tmep = dataArr[loopIdx];
					dataArr[loopIdx] = dataArr[j+1];
					dataArr[j+1] = tmep;
				}
			}
			System.out.printf(" %s\n", Arrays.toString(dataArr));
			loopIdx++;
		}
		System.out.println("내림차순 정렬 완료!");
	}
	
	public void runSolution(int[] dataArr) {
		for(int i = 0; i < dataArr.length; i++) {
			int Max = i;
			for(int j = i+1; j < dataArr.length; j++) {
				if(dataArr[j] > dataArr[Max]) { // 최대값을 찾는다
					Max = j;
				}
			}
			if(dataArr[i] < dataArr[Max]) {
				int temp = dataArr[i];
				dataArr[i] = dataArr[Max];
				dataArr[Max] = temp;
			}
			System.out.printf(" %s\n", Arrays.toString(dataArr));
		}
		
		System.out.println("내림차순 정렬 완료!");
	}

	public static void main(String[] args) {
		P017_SelectionSort p = new P017_SelectionSort();
		p.runPrompt();
		
	}

}
