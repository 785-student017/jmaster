package lecture1.la.algorithm;

import java.util.Scanner;

public class stars {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.print("1～5の数字を入力してください:");
		int i = scan.nextInt();

		if (i < 1 || 5 < i) {
			System.out.println("エラー：1～5の数字を入力してください");
		} else {
			System.out.println(Star(i));
		}

		scan.close();
	}

	public static String Star(int i) {

		String star = "";

		// ★を追加
		for (int j = 0; j < i; j++) {
			star += "★";
		}

		// ☆を追加（5文字にする）
		for (int j = i; j < 5; j++) {
			star += "☆";
		}

		return star;
	}
}