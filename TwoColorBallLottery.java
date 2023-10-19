// 双色球抽奖系统 TwoColorBallLottery.java
import java.util.Random;
import java.util.Scanner;
public class TwoColorBallLottery{
	 public static void main(String[] args) {
	 	// 随机生成一组中奖号码放在数组里
	 	Random r = new Random();
	 	int[] winningNumber = new int[6];
	 	for(int i = 0; i < winningNumber.length; i++){
	 		winningNumber[i] = r.nextInt(33) + 1;
	 	}
	 	int blueBall = r.nextInt(16) + 1;
	 	System.out.println("本期中奖号码是");
	 	System.out.println("红色球" + "\t\t\t" + "蓝色球");
	 	for(int i = 0; i < winningNumber.length; i++){
	 		System.out.print(winningNumber[i] + " ");
	 	}
	 	System.out.println("\t" + blueBall);

	 	// 用户输入自己买的号码，6个红色号码 1-33，1个蓝色号码 1-16
	 	int[] userNumber = new int[6];
	 	Scanner sc = new Scanner(System.in);
	 	for(int i = 0; i < userNumber.length; ){
	 		System.out.println("请输入红球第" + (i + 1) + "个号码：");
	 		int input = sc.nextInt();
	 		if(input  >= 1 && input  <= 33){
	 			userNumber[i] = input;
	 			i++;
	 		}else{
	 			System.out.println("输入错误，请输入1~33之间的数字：");
	 		}
	 	}
	 	System.out.println("请输入蓝球号码：");
	 	int userBlueBall = 0;
	 	//过滤掉输入错误的蓝色球号码	 	
	 	while(true){
	 		userBlueBall = sc.nextInt();
	 		if (userBlueBall  >= 1 && userBlueBall  <= 16) {
	 			break;
	 		}else{
	 			System.out.println("输入错误，请输入1~16之间的数字：");
	 		}
	 	}
	 	
	 	System.out.println("您购买的号码是");
	 	System.out.println("红色球" + "\t\t\t" + "蓝色球");
	 	for(int i = 0; i < userNumber.length; i++){
	 		System.out.print(userNumber[i] + " ");
	 	}
	 	System.out.println("\t" + userBlueBall);


	 	//用户输入的号码和随机生成的号码对比，根据对比结果打印中奖情况
	 	// userNumber[i] 和winningNumber[i] 对比 blueBall 和 userBlueBall 对比
	 	int count = 0;
	 	for(int i = 0; i < userNumber.length; i++){
	 		for(int j = 0; j < winningNumber.length; j++){
	 			if(winningNumber[j] == userNumber[i]){
	 				count++;
	 			}
	 		}
	 	}

	 	int flag = 0;
	 	if(blueBall == userBlueBall){
	 		flag = 1;
	 	}
	 	
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
