package com.codingtest.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author : crtEvent
 * @date   : 2022. 11. 18.
 */
public class P003_SumOfInterval {
	
	// 시간복잡도: O(n) *구간 합을 구하는 부분만 계산
	public void runSlowWay() throws IOException {
		System.out.println("'총 데이터 개수'와 '반복 횟수'를 입력해 주세요. 예) 5 3");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int numOfData = Integer.parseInt(st.nextToken()); // 총 데이터 개수
		int numOfRepeat = Integer.parseInt(st.nextToken()); // 반복 개수
		long[] dataArr = new long[numOfData]; // 데이터 배열

		System.out.println("데이터를 입력해 주세요. 예) 1 2 3 4 5");
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < numOfData; i++) {
			dataArr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 구간의 합 출력하기
		for (int q = 0; q < numOfRepeat; q++) {
			System.out.println("i번째 수에서 j번쨰 수까지의 합. i j를 입력 해 주세요. 예) 2 4");
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			long sum = 0;
			
			// 구간의 합 출력하기
			for(int x = i-1; x < j; x++) {
				sum += dataArr[x];
			}
			System.out.println(sum);
		}

	}
	
	// 시간복잡도: O(1) *구간 합을 구하는 부분만 계산
	public void runFastWay() throws IOException {
		System.out.println("'총 데이터 개수'와 '반복 횟수'를 입력해 주세요. 예) 5 3");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int numOfData = Integer.parseInt(st.nextToken()); // 총 데이터 개수
		int numOfRepeat = Integer.parseInt(st.nextToken()); // 반복 개수
		long[] sumArr = new long[numOfData + 1]; // 합 배열

		System.out.println("데이터를 입력해 주세요. 예) 1 2 3 4 5");
		st = new StringTokenizer(br.readLine());

		// 합 배열 생성하기
		for (int i = 1; i <= numOfData; i++) {
			sumArr[i] = sumArr[i - 1] + Integer.parseInt(st.nextToken());
		}

		// 구간의 합 출력하기
		for (int q = 0; q < numOfRepeat; q++) {
			System.out.println("i번째 수에서 j번쨰 수까지의 합. i j를 입력 해 주세요. 예) 2 4");
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			System.out.println(sumArr[j] - sumArr[i - 1]);
			System.out.println();
		}
	}

	public static void main(String[] args) throws IOException {

		P003_SumOfInterval p = new P003_SumOfInterval();
		p.runSlowWay();

	}

}
