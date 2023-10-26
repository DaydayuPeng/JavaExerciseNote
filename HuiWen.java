// 回文数HuiWen.java
public class HuiWen{
	 public static void main(String[] args) {
	 	//怎么把数倒过来？
	 	/*int x = 121;
	 	//获取个位
	 	int ge = x % 10;	 	
	 	//把获取到的数字拿出来依次排到最右边
	 	int num = num * 10 + ge;
	 	// 利用int 取整的特点，每次获取各位后，x除以10后取整，这样就去掉了个位数上的数字
	 	x = x / 10;*/
	 	//不知道循环次数，只知道循环条件，用while循环
	 	
	 	int x = 12321;//要求是不是回文数的值
	 	int temp = x;//记录x的值
	 	int num = 0;//最终得到的数初始值
	 	while(x != 0){//只要x不等于0 就可以一直循环	 		
	 		int ge = x % 10;	 				
	 		num = 10 * num + ge;
	 		x = x / 10;	 
	 	}
	 	System.out.println("num的值" + num);
	 	System.out.println("temp的值" + temp);
	 	System.out.println("x的值" + x);
	 	System.out.println(num == temp);
	 	if(num == temp){
	 		System.out.println(temp +"是回文数");
	 	}else{
	 		System.out.println(temp +"不是回文数");
	 	}

	}
}