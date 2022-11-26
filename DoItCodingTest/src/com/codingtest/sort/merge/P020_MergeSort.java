package com.codingtest.sort.merge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 * @author : crtEvent
 * @date   : 2022. 11. 26.
 */
public class P020_MergeSort {
	
	public static int[] dataArr, temp;

	private static void runPrompt() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		System.out.println("입력할 수의 개수를 입력해 주세요.");
		int dataSize = Integer.parseInt(br.readLine());
		dataArr = new int[dataSize];
		temp = new int[dataSize];
		
		System.out.println("데이터를 입력해 주세요.");
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < dataSize; i++) {
			dataArr[i] = Integer.parseInt(st.nextToken());
		}
		
		doMergeSort(0, dataSize - 1);
		printArray(dataArr);
	}
	
	private static void doMergeSort(int start, int end) {
		if(start < end) {
			int middle = (start + end) / 2;
			doMergeSort(start, middle);
			doMergeSort(middle + 1, end);
			merge(start, middle, end);
		}
	}
	
	private static void merge(int start, int middle, int end) {
		for(int i = start; i <= end; i++) {
			temp[i] = dataArr[i];
		}
		
		// 작은 순서대로 dataArr 배열에 삽입
		int part1 = start;
		int part2 = middle + 1;
		int index = start; // 결과를 저장할 배열의 인덱스
		while(part1 <= middle && part2 <= end) {
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
		for(int i = 0; i <= middle - part1; i++) {
			dataArr[index + i] = temp[part1 + i];
		}
	}
	
	private static void printArray(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		runPrompt();
	}

}
