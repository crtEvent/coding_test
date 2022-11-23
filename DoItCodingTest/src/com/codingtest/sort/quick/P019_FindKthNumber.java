package com.codingtest.sort.quick;

import java.util.Scanner;

/**
 * Quick Sort
 * - 기준갑(pivot)을 선정해 해당 값보다 작은 데이터와 큰 데이터로 분류하는 것을 반복하여 정렬
 * - 기준값을 어떻게 선정하는지가 시간 복잡도에 많은 영향을 미친다.
 * - 평균 시간 복잡도: O(nlogn)
 * @author : crtEvent
 * @date   : 2022. 11. 22.
 */
public class P019_FindKthNumber {
	
	public void runPrompt() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("입력할 수의 개수와 k번째 수를 입력해 주세요.");
		int dataSize = sc.nextInt();
		int k = sc.nextInt();
		
		System.out.println("데이터를 입력해 주세요.");
		int[] dataArr = new int[dataSize];
		for(int i = 0; i < dataSize; i++) {
			dataArr[i] = sc.nextInt();
		}
		
		doQuickSort(dataArr, 0, dataSize-1, k-1);
		System.out.println(dataArr[k-1]);
		sc.close();
	}
	
	public void doQuickSort(int[] dataArr, int start, int end, int k) {
		if(start < end) {
			// pivot 찾기
			int pivot = separatePartition(dataArr, start, end);
			
			if(pivot == k) { // k == pivot : k번쨰 수를 찾은 것이므로 알고리즘 종료
				return;
			}
			if(pivot > k) { // pivot > k : pivot의 왼쪽에 k가 있으므로 왼쪽만 정렬 수행
				doQuickSort(dataArr, start, pivot-1, k);
			}
			if(pivot < k) { // pivot < k : pivot의 오른쪽에 k가 있으므로 오른쪽만 정렬 수행
				doQuickSort(dataArr, pivot+1, end, k);
			}
		}
	}
	
	public int separatePartition(int[] dataArr, int start, int end) {
		if(start + 1 == end) {
			if(dataArr[start] > dataArr[end]) {
				swap(dataArr, start, end);
			}
			return end;
		}
		
		// 중간 위치를 pivot으로 설정하고 맨 앞의 값과 swap
		//  - i, j 이동을 편하게 하기 위한 것
		int middle = (start + end) / 2;
		swap(dataArr, start, middle);
		
		int pivot = dataArr[start];
		int i = start + 1, j = end;
		while(i <= j) {
			while(pivot < dataArr[j] && j > 0) {
				j--; // pivot보다 작은 수가 나올 때까지 j--
			}
			while(pivot > dataArr[i] && i < dataArr.length-1) {
				i++; // pivot보다 큰 수가 나올 때까지 i++
			}
			if(i <= j) {
				swap(dataArr, i++, j--);
			}
		}
		
		// 중앙에서 맨 앞으로 이동한 pivot을 다시 원래 자리로 이동
		//  - i == j일때 pivot의 값을 양쪽으로 분리한 가운데에 오도록 설정하기
		dataArr[start] = dataArr[j];
		dataArr[j] = pivot;
		return j;
	}
	
	public void swap(int[] dataArr, int i, int j) {
		int temp = dataArr[i];
		dataArr[i] = dataArr[j];
		dataArr[j] = temp;
	}

	public static void main(String[] args) {
		P019_FindKthNumber p = new P019_FindKthNumber();
		p.runPrompt();
	}

}
