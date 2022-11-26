package com.codingtest.sort.merge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Merge sort
 * - 하나의 리스트를 두 개의 균등한 크기로 분할하고 분할된 부분 리스트를 정렬
 * - 두 개의 정렬된 부분 리스트를 합하여 전체가 정렬된 리스트가 되게 하는 방법
 * 출처: Do it 알고리즘
 * @author : crtEvent
 * @date   : 2022. 11. 24.
 */
public class MergeSort_02 {
	
	public static int[] dataArr, temp;
	
	private static void doMergeSort(int start, int end) {
		if(end - start < 1) {
			return;
		}
		
		int middle = start + (end - start) / 2;
		doMergeSort(start, middle);
		doMergeSort(middle + 1, end);
		
		for(int i = start; i <= end; i++) {
			temp[i] = dataArr[i];
		}
		
		int k = start;
		int index1 = start;
		int index2 = middle + 1;
		while(index1 <= middle && index2 <= end) { // 병합 로직
			if(temp[index1] > temp[index2]) {
				dataArr[k] = temp[index2];
				k++;
				index2++;
			} else {
				dataArr[k] = temp[index1];
				k++;
				index1++;
			}
		}
		
		while(index1 <= middle) {
			dataArr[k] = temp[index1];
			k++;
			index1++;
		}
		
		while(index2 <= end) {
			dataArr[k] = temp[index2];
			k++;
			index2++;
		}
	}
	
	private static void runPrompt() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		System.out.println("입력할 수의 개수를 입력해 주세요.");
		int dataSize = Integer.parseInt(br.readLine());
		dataArr = new int[dataSize + 1];
		temp = new int[dataSize + 1];
		
		System.out.println("데이터를 입력해 주세요.");
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= dataSize; i++) {
			dataArr[i] = Integer.parseInt(st.nextToken());;
		}
		
		doMergeSort(1, dataSize);

		for(int i = 1; i <= dataSize; i++) {
			bw.write(dataArr[i]+" ");
		}
		bw.flush();
		bw.close();
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		runPrompt();
	}

}
