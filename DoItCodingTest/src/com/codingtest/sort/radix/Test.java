package com.codingtest.sort.radix;

import java.util.Arrays;

/**
 *
 * @author : crtEvent
 * @date   : 2022. 11. 27.
 */
public class Test {

	public static void testIncrementOPs() {
		int[] a = { 5, 10, 15, 20, 25 };

		for (int i = 0; i < a.length; i++) {
			a[i]++;
		}

		System.out.println(Arrays.toString(a));
	}

	public static void testRadixSort() {
		int[] dataArr = {123, 44, 543, 77, 22};
		int maxSize = 3;
		int[] output = new int[dataArr.length]; // 임시 정렬을 위한 배열
		int digitNum = 1; // 자릿수
		int count = 0;
		System.out.println(Arrays.toString(dataArr));
		
		while(count != maxSize) { // 최대 자릿수만큼 반복
			System.out.println("loop: "+count);
			// bucket: 현재 자리수들의 분포를 합 배열의 형태로 알려줄 배열
			int[] bucket = new int[10];
			
			// 현재 자리수에 해당하는 수들의 분포 저장
			// (예. 0:0개, 1:1개, 2:3개 ... 9:0개)
			for(int i = 0; i < dataArr.length; i++) {
				bucket[(dataArr[i] / digitNum) % 10]++;
			}
			printArray(bucket, "bucket_1");
			
			// 합 배열을 이용해 index 계산하기
			for(int i = 1; i < 10; i++) {
				bucket[i] += bucket[i - 1];
			}
			printArray(bucket, "bucket_2");
			
			// 현재 자리수 기준으로 정렬하기
			for(int i = dataArr.length - 1; i >= 0; i--) {
				printArray(output, "  output_1");
				printArray(bucket, "  bucket_3");
				System.out.println("   dataArr["+i+"] : "+dataArr[i]);
				System.out.println("   dataArr["+i+"] / digitNum) % 10 : "+(dataArr[i] / digitNum) % 10);
				System.out.println("   bucket["+(dataArr[i] / digitNum) % 10+"] - 1 : "+((bucket[(dataArr[i] / digitNum) % 10]) - 1));
				System.out.println("   output["+((bucket[(dataArr[i] / digitNum) % 10]) - 1)+"] <-"+dataArr[i]);
				output[bucket[(dataArr[i] / digitNum) % 10] - 1] = dataArr[i];
				bucket[(dataArr[i] / digitNum) % 10]--;
			}
			printArray(output, "output_1");
			printArray(bucket, "bucket_3");
			
			// 다음 자릿수를 이동하기 위해 현재 자릿수 기준 정렬 데이터 저장하기
			for(int i = 0; i < dataArr.length; i++) {
				dataArr[i] = output[i];
			}
			printArray(dataArr, "dataArr");
			
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
		System.out.println(" " + description + " > " + Arrays.toString(dataArr));
	}

	public static void main(String[] args) {
		testRadixSort();
	}

}
