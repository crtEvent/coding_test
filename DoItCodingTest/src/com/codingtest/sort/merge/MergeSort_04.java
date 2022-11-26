package com.codingtest.sort.merge;

/**
 * 출처: 자바로 배우는 쉬운 자료구조
 * @author : crtEvent
 * @date   : 2022. 11. 24.
 */
public class MergeSort_04 {
	
	private static int temp[] = new int[30];
	
	public static void mergeSort(int dataArr[], int start, int end) {
		int middle;
		if(start < end) {
			middle = (start + end) / 2;
			mergeSort(dataArr, start, middle);
			mergeSort(dataArr, middle + 1, end);
			merge(dataArr, start, middle, end);
		}
	}
	
	public static void merge(int dataArr[], int start, int middle, int end) {
		int size = dataArr.length;
		int i, j, k;
		i = start;
		j = middle + 1;
		k = start;
		
		// 작은 순서대로 temp 배열에 삽입
		while(i <= middle && j <= end) {
			if(dataArr[i] <= dataArr[j]) {
				temp[k] = dataArr[i++];
			} else {
				temp[k] = dataArr[j++];
			}
			k++;
		}
		
		// 남은 데이터도 삽입
		if(i > middle) {
			for(int t = j; t <= end; t++, k++) {
				temp[k] = dataArr[t];
			}
		} else {
			for(int t = i; t <= middle; t++, k++) {
				temp[k] = dataArr[t];
			}
		}
		
		// 정렬된 배열을 삽입
		for(int t = start; t <= end; t++) {
			dataArr[t] = temp[t];
		}
		
		// 출력
		System.out.printf("\n 병합 정렬 >>");
		for(int t = 0; t < size; t++) {
			System.out.printf("%3d ", dataArr[t]);
		}
	}

	public static void main(String[] args) {
		int a[] = {69, 10, 30, 2, 16, 8, 31, 22};
		int size = a.length;
		
		System.out.printf("\n정렬할 원소: ");
		for(int i = 0; i < a.length; i++) {
			System.out.printf(" %d", a[i]);
		}
		System.out.println();
		
		mergeSort(a, 0, size - 1);
	}

}
