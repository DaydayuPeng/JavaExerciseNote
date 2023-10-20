// 双色球抽奖系统6个红色号码 1-33，要求红色号码不能相同，1个蓝色号码 1-16 TwoColorBallLottery.java
import java.util.Random;
import java.util.Scanner;
public class TwoColorBallLottery{
	 public static void main(String[] args) {
	 	
	 	//1.随机获取中奖号码
	 	int[] winningNumber = getNumber();

	 	//2.用户输入号码
	 	int[] userNumber = inputNumber();

	 	// 对比号码,打印中奖结果 	

	 	compareAndPrintResult(winningNumber,userNumber);	 	

	}
	// 随机获取中奖号码
	public static int[] getNumber(){
		// 随机生成一组中奖号码放在数组里
	 	Random r = new Random();
	 	int[] arr = new int[7];	 	
	 	for(int i = 0; i < arr.length - 1; ){
	 		int indexRandom = r.nextInt(33) + 1;
	 		boolean flag = existOrNot(arr,indexRandom);
	 		if (flag) {
	 			arr[i] = indexRandom;
	 			i++;
	 		}
	 		
	 	}
	 	arr[arr.length - 1] = r.nextInt(16) + 1;
	 	System.out.println("本期中奖号码是");
	 	System.out.println("红色球" + "\t\t\t" + "蓝色球");
	 	for(int i = 0; i < arr.length - 1; i++){
	 		System.out.print(arr[i] + " ");
	 	}
	 	System.out.println("\t" + arr[arr.length - 1]);
	 	return arr;
	}
	
	//判断红色球是否重复
	public static boolean existOrNot(int[] arr,int num){
		for(int i = 0;i < arr.length - 1; i++){
			if (arr[i] == num) {
				return false;//下面别写break了，无法访问，因为return已经结束方法了
			}
		}
		return true;
	}

	// 用户输入号码
	public static int[] inputNumber(){
		// 用户输入自己买的号码，6个红色号码 1-33，1个蓝色号码 1-16arr = new int[7];
	 	Scanner sc = new Scanner(System.in);
	 	int[] arr = new int[7];
	 	for(int i = 0; i < arr.length - 1; ){
	 		System.out.println("请输入红球第" + (i + 1) + "个号码：");
	 		int input = sc.nextInt();
	 		if(input  >= 1 && input  <= 33){//过滤掉输入错误的红色球号码
	 			arr[i] = input;
	 			i++;
	 		}else{
	 			System.out.println("输入错误，请输入1~33之间的数字：");
	 		}
	 	}
	 	System.out.println("请输入蓝球号码：");	 		 		 	
	 	while(true){//过滤掉输入错误的蓝色球号码
	 		arr[arr.length - 1]= sc.nextInt();
	 		if (arr[arr.length - 1]  >= 1 && arr[arr.length - 1]  <= 16) {
	 			break;
	 		}else{
	 			System.out.println("输入错误，请输入1~16之间的数字：");
	 		}
	 	}
	 	System.out.println("您购买的号码是");
	 	System.out.println("红色球" + "\t\t\t" + "蓝色球");
	 	for(int i = 0; i < arr.length - 1; i++){
	 		System.out.print(arr[i] + " ");
	 	}
	 	System.out.println("\t" + arr[arr.length - 1]);
	 	return arr;
	}

	// 对比号码的方法
	public static void compareAndPrintResult(int[] winningNumber,int[] userNumber){

	 	//用户输入的号码和随机生成的号码对比，根据对比结果打印中奖情况
	 	// userNumber[i] 和winningNumber[i] 对比 
	 	int count = 0;
	 	for(int i = 0; i < userNumber.length - 1; i++){
	 		for(int j = 0; j < winningNumber.length - 1; j++){
	 			if(winningNumber[j] == userNumber[i]){
	 				count++;
	 			}
	 		}
	 	}

	 	int flag = 0;
	 	if(winningNumber[winningNumber.length - 1] == userNumber[userNumber.length - 1]){
	 		flag = 1;
	 	}
	 	
	 	// 打印中奖结果
	 	if((count == 0 && flag == 1)||(count == 1 && flag == 1) ||(count == 2 && flag == 1)){
	 		System.out.println("恭喜您中了六等奖，奖金是 5 元");
	 	}else if((count == 4 && flag == 0)||(count == 3 && flag == 1)){
	 		System.out.println("恭喜您中了五等奖，奖金是 10 元");
	 	}else if((count == 4 && flag == 1)||(count == 5 && flag == 0)){
	 		System.out.println("恭喜您中了四等奖，奖金是 200 元");
	 	}else if((count == 5 && flag == 1)){
	 		System.out.println("恭喜您中了三等奖，奖金是 3000 元");
	 	}else if((count == 6 && flag == 0)){
	 		System.out.println("恭喜您中了二等奖，奖金是 500 万元");
	 	}else if((count == 6 && flag == 1)){
	 		System.out.println("恭喜您中了一等奖，奖金是 1000 万元");
	 	}else{
	 		System.out.println("很遗憾，您此次没有中奖，梦想还是要有的，下次努力！");
	 	}

	}
}
