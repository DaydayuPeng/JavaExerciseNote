/*需求:
一个大V直播抽奖,奖品是现金红包，分别有{2, 588 , 888, 1000, 10000}五个奖金。请使用代码模拟抽奖,
打印出每个奖项，奖项的出现顺序要随机且不重复。打印效果如下: (随机顺序, 不一定是下面的顺序)
888元的奖金被抽出
588元的奖金被抽出
10000元的奖金被抽出
1000元的奖金被抽出
2元的奖金被抽出
LuckyMoney.java
*/
import java.util.Random;
public class LuckyMoney{
	 public static void main(String[] args) {

	 	int[] arr = {2, 588 , 888, 1000, 10000};
	 	//方法一： 核心思想是把随机抽取的元素放在新的数组里面，下一次抽取的时候，判断抽取的元素是否在新的数组里，如果不在就是有效抽取
		// 新建一个数组来放置抽取的元素
	 	/*int[] newArr = new int[arr.length];
	 	Random r = new Random();
	 	
	 	for(int i = 0; i < newArr.length; ){	 			 
		 	int indexRandom = r.nextInt(arr.length);			 	
		 	boolean flag = existOrNot(newArr,arr[indexRandom]);
		 	if(flag){
		 		 	newArr[i] = arr[indexRandom];
		 		 	System.out.println(newArr[i] + "奖金被抽出");	
		 			i++;
		 	} 	
	 	}*/

	 	//方法二：对于此题来说，这种方法更高效一点
	 	// 方法二的核心思想是随机抽取arr的下标，然后arr内元素和取到下标的元素按顺序交互值,注意是交换，不是替换
	 	Random r = new Random();
	 	// 打乱数组元素，所谓打乱就是随机选取两个元素进行值的交换，所以元素是不变的只是位置变了，所以元素也不会重复
	 	for (int i = 0; i < arr.length; i++ ) {
	 		int indexRandom = r.nextInt(arr.length);	
	 		int temp = arr[i];
	 		arr[i] = arr[indexRandom];
	 		arr[indexRandom] = temp;	 		
	 	}
	 	//打印打乱顺序后的数组
	 	for (int i = 0; i < arr.length; i++ ) {
	 		System.out.println(arr[i] + "奖金被抽出");	 		
	 	}


	}
	
	//方法一的方法：把新的数组和随机抽取的元素传入到下列方法，方法判断是否是有效抽取
	/*public static boolean existOrNot(int[] arr,int num){
		for(int i = 0;i < arr.length; i++){
			if (arr[i] == num) {
				return false;//下面别写break了，无法访问，因为return已经结束循环了
			}
		}
		return true;

	}*/
}
