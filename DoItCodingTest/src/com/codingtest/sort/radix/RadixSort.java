package com.codingtest.sort.radix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Radix sort(기수 정렬)
 * - 데이터의 자릿수를 바교해 데이터를 정렬하는 방식
 * - 시간 복잡도: O(kn) * k는 테이터의 자리수
 * @author : crtEvent
 * @date   : 2022. 11. 27.
 */
public class RadixSort {
	
	private static int[] dataArr;
	
	public static void runPrompt() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		System.out.println("입력할 수의 개수를 입력해 주세요.");
		int dataSize = Integer.parseInt(br.readLine());
		dataArr = new int[dataSize];
		
		System.out.println("입력할 데이터의 최대 자릿수를 입력해 주세요.");
		int maxSize = Integer.parseInt(br.readLine());
		
		System.out.println("데이터를 입력해 주세요. 예) 11 555 344 27 99");
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < dataSize; i++) {
			dataArr[i] = Integer.parseInt(st.nextToken());
		}
		
		doRadixSort(dataArr, maxSize);
		
		br.close();
	}
	
	public static void doRadixSort(int[] dataArr, int maxSize) {
		int[] output = new int[dataArr.length]; // 임시 정렬을 위한 배열
		int digitNum = 1; // 자릿수
		int count = 0;
		
		while(count != maxSize) { // 최대 자릿수만큼 반복
			System.out.println("loop: "+count);
			// bucket: 현재 자리수들의 분포를 합 배열의 형태로 알려줄 배열
			int[] bucket = new int[10];
			
			// 현재 자리수에 해당하는 수들의 분포 저장
			// (예. 0:0개, 1:1개, 2:3개 ... 9:0개)
			for(int i = 0; i < dataArr.length; i++) {
				bucket[(dataArr[i] / digitNum) % 10]++;
			}
			
			// 합 배열을 이용해 index 계산하기
			for(int i = 1; i < 10; i++) {
				bucket[i] += bucket[i - 1];
			}
			
			// 현재 자리수 기준으로 정렬하기
			for(int i = dataArr.length - 1; i >= 0; i--) {
				output[bucket[(dataArr[i] / digitNum) % 10] - 1] = dataArr[i];
				bucket[(dataArr[i] / digitNum) % 10]--;
			}
			
			// 다음 자릿수를 이동하기 위해 현재 자릿수 기준 정렬 데이터 저장하기
			for(int i = 0; i < dataArr.length; i++) {
				dataArr[i] = output[i];
			}
			
			digitNum = digitNum * 10; // 자릿수 증가
			count++;
			System.out.println();
		}
		
		// 출력
		printArray(dataArr, "결과");
	}
	
	public static void printArray(int[] dataArr) {
		System.out.println(Arrays.toString(dataArr));
	}
	
	public static void printArray(int[] dataArr, String description) {
		System.out.println(" "+description+" > "+Arrays.toString(dataArr));
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		runPrompt();
	}

}
