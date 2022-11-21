package com.codingtest.sort.insertion;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author : crtEvent
 * @date   : 2022. 11. 21.
 */
public class P018_CalculateWatingTime {
	
	public void runPrompt() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("입력할 수의 개수를 입력해 주세요.");
		int dataSize = sc.nextInt();
		
		System.out.println("데이터를 입력해 주세요.");
		int[] dataArr = new int[dataSize];
		for(int i = 0; i < dataSize; i++) {
			dataArr[i] = sc.nextInt();
		}
		
		calculateWatingTime(dataArr);
		sc.close();
	}
	
	public void calculateWatingTime(int[] dataArr) {
		// runMySolution(dataArr)
		runSolution(dataArr);
	}
	
	public void runMySolution(int[] dataArr) {
		System.out.println("데이터: "+Arrays.toString(dataArr));
		// [삽입정렬] 오름차순 정렬
		for(int i = 1; i < dataArr.length; i++) {
			System.out.println("Loop "+i);
			// 삽입 위치 찾기
			int idx = i;
			for(int j = 0; j < i; j++) {
				if(dataArr[i] < dataArr[j]) {
					idx = j;
					break;
				}
			}
			System.out.printf("삽입 위치: %d\n", idx);
			
			// 삽입 위치부터 데이터 1칸씩 밀기
			int iTemp = dataArr[i];
			for(int j = i; j > idx; j--) {
				dataArr[j] = dataArr[j-1];
			}
			// 데이터 삽입하기
			dataArr[idx] = iTemp;
			System.out.println(Arrays.toString(dataArr)+"\n");
		}
		
		// 합 배열 구하기
		int[] sumArr = new int[dataArr.length];
		sumArr[0] = dataArr[0];
		for(int i = 1; i < dataArr.length; i++) {
			sumArr[i] = sumArr[i-1] + dataArr[i];
		}
		
		// 총 합
		int total = 0;
		for(int i = 0; i < sumArr.length; i++) {
			total += sumArr[i];
		}
		
		System.out.println("각 사람들이 돈을 인출하는 데 필요한 시간의 합의 최솟값.");
		System.out.printf("=%d", total);
		
	}
	
	public void runSolution(int[] dataArr) {
		// [삽입정렬] 오름차순 정렬
		for(int i = 1; i < dataArr.length; i++) {
			System.out.println("Loop "+i);
			int insert_point = i;
			int insert_value = dataArr[i];
			// 삽입 위치 찾기
			for(int j = i - 1; j >= 0; j--) {
				if(dataArr[j] < dataArr[i]) {
					insert_point = j + 1;
					break;
				}
				if(j == 0) {
					insert_point = 0;
				}
			}
			// 데이터 한 칸씩 밀기
			for(int j = i; j > insert_point; j--) {
				dataArr[j] = dataArr[j-1];
			}
			// 데이터 삽입하기
			dataArr[insert_point] = insert_value;
			
			System.out.println(Arrays.toString(dataArr)+"\n");
		}
		
		// 합 배열 만들기
		int[] sumArr = new int[dataArr.length];
		sumArr[0] = dataArr[0];
		for(int i = 1; i < sumArr.length; i++) {
			sumArr[i] = sumArr[i-1] + dataArr[i];
		}
		
		// 합 배열의 총 합
		int sum = 0;
		for(int i = 0; i < sumArr.length; i++) {
			sum = sum + sumArr[i];
		}
		
		System.out.println("각 사람들이 돈을 인출하는 데 필요한 시간의 합의 최솟값.");
		System.out.printf("=%d", sum);
	}
	
	public static void main(String[] args) {
		P018_CalculateWatingTime p = new P018_CalculateWatingTime();
		p.runPrompt();
	}

}
