package com.codingtest.sort.merge;

/**
 * Merge sort 구현
 * 출처: 엔지니어대한민국 https://www.youtube.com/watch?v=QAyl79dCO_k
 * @author : crtEvent
 * @date   : 2022. 11. 24.
 */
public class MergeSort_01 {
	
	private static void mergeSort(int[] dataArr) {
		int[] temp = new int[dataArr.length];
		mergeSort(dataArr, temp, 0, dataArr.length - 1);
	}
	
	private static void mergeSort(int[] dataArr, int[] temp, int start, int end) {
		if(start < end) {
			int mid = (start + end) / 2;
			mergeSort(dataArr, temp, start, mid);
			mergeSort(dataArr, temp, mid+1, end);
			merge(dataArr, temp, start, mid, end);
		}
	}
	
	private static void merge(int[] dataArr, int[] temp, int start, int mid, int end) {
		for(int i = start; i <= end; i++) {
			temp[i] = dataArr[i];
		}
		
		int part1 = start;
		int part2 = mid + 1;
		int index = start; // 결과를 저장할 배열의 인덱스
		while(part1 <= mid && part2 <= end) {
			if(temp[part1] <= temp[part2]) {
				dataArr[index] = temp[part1];
				part1++;
			} else {
				dataArr[index] = temp[part2];
				part2++;
			}
			index++;
		}
		
		// 뒤 쪽 배열은 다 끝나고 앞 쪽 배열에 테이터가 남아 있는 경우
		for(int i = 0; i <= mid - part1; i++) {
			dataArr[index + i] = temp[part1 + i];
		}
	}
	
	private static void printdataArray(int[] dataArr) {
		for(int data : dataArr) {
			System.out.print(data + ", ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] dataArr = {3,9,4,7,5,0,1,6,8,2};
		printdataArray(dataArr);
		mergeSort(dataArr);
		printdataArray(dataArr);
	}

}
