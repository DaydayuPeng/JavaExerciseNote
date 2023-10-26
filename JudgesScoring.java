// 评委打分：6个评委打分，去掉最高分和最低分，求最后的平均分 JudgesScoring.java

import java.util.Scanner;
public class JudgesScoring{
	 public static void main(String[] args) {
	 	int[] newArr = getArr();
	 	for(int i = 0; i < newArr.length; i++){
			System.out.print(newArr[i] + " ");
		}
		int max = getMax(newArr);
		int min = getMin(newArr);
		int sum = getSum(newArr);
		int average = (sum - max - min) / (newArr.length - 2);
		System.out.println("去掉最高分" + max + "去掉最低分" + min + "平均分是" + average);

	}

	public static int[] getArr(){
		int[] arr = new int[6];
		for(int i = 0; i < arr.length; ){
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入评分");
			int score = sc.nextInt();
			if(score >= 0 && score <= 100){
				arr[i] = score;
				i++;
			}else{
				System.out.println("输入错误，请输入 0 - 100之间的数字！");
			}
			
		}
		return arr;
	}

	public static int getMax(int[] arr){
		int max = arr[0];
		for (int i = 1;i < arr.length; i++ ) {
			if(arr[i] > max){
				max = arr[i]; 
			}
		}
		return max;
	}
	
	public static int getMin(int[] arr){
		int min = arr[0];
		for (int i = 1;i < arr.length; i++ ) {
			if(arr[i] < min){
				min = arr[i]; 
			}
		}
		return min;
	}

	public static int getSum(int[] arr){
		int sum = 0;
		for (int i = 1;i < arr.length; i++ ) {
			sum += arr[i];
		}
		return sum;
	}
}