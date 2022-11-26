package com.codingtest.sort.merge;

/**
 * 출처: 안경잡이개발자, https://m.blog.naver.com/PostView.naver?blogId=ndb796&logNo=221227934987&navType=by
 * @author : crtEvent
 * @date   : 2022. 11. 25.
 */
public class MergeSort_03 {
	
	private static int[] temp = new int[8];
	
	public static void mergeSort(int[] dataArr, int start, int end) {
		if(start < end) {
			int middle = (start + end) / 2;
			mergeSort(dataArr, start, middle);
			mergeSort(dataArr, middle + 1, end);
			merge(dataArr, start, middle, end);
		}
	}
	
	public static void merge(int[] dataArr, int start, int middle, int end) {
		int i = start;
		int j = middle + 1;
		int k = start;
		
		// 작은 순서대로 temp 배열에 삽입
		while(i <= middle && j <= end) {
			if(dataArr[i] <= dataArr[j]) {
				temp[k] = dataArr[i];
				i++;
			} else {
				temp[k] = dataArr[j];
				j++; 
			}
			k++;
		}
		
		// 남은 데이터도 삽입
		if(i > middle) {
			for(int t = j; t <= end; t++) {
				temp[k] = dataArr[t];
				k++;
			}
		} else {
			for(int t = i; t <= middle; t++) {
				temp[k] = dataArr[t];
				k++;
			}
		}
		
		// 정렬된 배열을 삽입
		for(int t = start; t <= end; t++) {
			dataArr[t] = temp[t];
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {7, 6, 5, 8, 2, 3, 9, 1};
		int size = arr.length;
		
		mergeSort(arr, 0, size - 1);
		
		// 출력
		for(int i = 0; i < size; i++) {
			System.out.printf("%d ", arr[i]);
		}

	}

}
