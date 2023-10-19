//数字加密和解密：输入一组大于 0 的数字，每个数字先加五，再对10取余，最后再翻转。然后对加密的数据进行解密 DigitalEncryption.java
import java.util.Scanner;
public class DigitalEncryption{
	 public static void main(String[] args) {

	 	//获取用户输入的数字并组成数组，对数字进行解密，1983为例
	 	int[] arr = getEncryptionArr();

	 	//使用获取的数组进行操作：先把1983每位数字+5 → 6，14，13，8 对10取余 → 6，4，3，8 翻转 → 8，3，4，6
	 	int[] newArr = encryption(arr);//
	 	
	 	//打印验证数组 1983 → 8346
		for(int i = 0; i < newArr.length; i++){
			System.out.print(newArr[i]);
		}
		System.out.println();
		// 对加密过的数字进行解密，8346为例，先把这几个数组成数组
		int[] arr2 = getDecryptionArr();
		// 对获取的数组进行操作，先把 8，3，4，6进行翻转 → 6，4，3，8 → ? 每个数字 - 5 → ？
		// 数组翻转后，无法从余数直接推断下一步，可以通过输入数字的范围 + 5 再对10取余，从而求出第二步数组的范围
		// 即 输入数字的范围0~9 + 5 → 5~14 对10 取余 → 5,6,7,8,9,0,1,2,3,4 即0 ~4先加10,再减5，如果是5~9就直接 -5
		int[] newArr2 = decryption(arr2); 

		//打印验证数组  8346 → 1983
		for(int i = 0; i < newArr2.length; i++){
			System.out.print(newArr2[i]);
		}

	}

	public static int[] decryption(int[] arr2){
		// 数组翻转
		for(int i = 0,j = arr2.length - 1; i < j; i++,j--){
			int temp = arr2[i];
			arr2[i] = arr2[j];
			arr2[j] = temp;
		}
		// 数字是 0 ~4先加10,再减5，如果是5~9就直接 -5
		for(int i = 0; i < arr2.length; i++){

			if(arr2[i] >= 0 && arr2[i] <= 4){
				arr2[i] = arr2[i] + 5;
			}else{
				arr2[i] = arr2[i] - 5;
			}
			
		}
		
		return arr2;

	}

	public static int[] encryption(int[] arr){
		// 先加五，再对10取余
		for(int i = 0; i < arr.length; i++){
			arr[i] = arr[i] + 5;
			arr[i] = arr[i] % 10;
		}
		// 数组翻转
		for(int i = 0,j = arr.length - 1; i < j; i++,j--){
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		return arr;

	}

	public static int[] getEncryptionArr(){
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入要加密的数字，每个数字必须大于 0");
		int input = sc.nextInt();
		int temp = input;//临时记录input的值		
		int index  = 0;	// 统计被除的次数，即需要定义的数组长度
		while(input != 0){
			int ge = input % 10 ;// 每次取最右边的，即个位。
			input = input / 10;//重置input的值			
			index++;
		}
		
		int[] arr1 = new int[index];
		for (int i = index - 1; i >= 0 ; i-- ) {
			arr1[i] = temp % 10;
			temp = temp / 10;
		}
		return arr1;
	}

	public static int[] getDecryptionArr(){
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入要解密的数字，每个数字必须大于 0");
		int input = sc.nextInt();
		int temp = input;//临时记录input的值		
		int index  = 0;	// 统计被除的次数，即需要定义的数组长度
		while(input != 0){
			int ge = input % 10 ;// 每次取最右边的，即个位。
			input = input / 10;//重置input的值			
			index++;
		}
		
		int[] arr1 = new int[index];
		for (int i = index - 1; i >= 0 ; i-- ) {
			arr1[i] = temp % 10;
			temp = temp / 10;
		}
		return arr1;
	}
}
