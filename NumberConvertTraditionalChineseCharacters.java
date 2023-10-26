// 金额转换 NumberConvertTraditionalChineseCharacters.java
// 要求把数字转换成大写汉字，并加上单位，最大单位百万
// 如 1234 → 零佰零拾零万壹仟贰佰叁拾肆元
// 知识点：1、查表法 2、数字各位的获取 3、字符拼接顺序

import java.util.Scanner;
public class NumberConvertTraditionalChineseCharacters {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入数字");
		int inputNumber = sc.nextInt();		
		while(true){
			if(inputNumber >= 0 && inputNumber <= 999999){
				break;
			}else{
				System.out.println("金额输入错误,请重新输入");
			}		
		
		}	
		// 把数字变成大写汉字
		String str = convertCapital(inputNumber);
		
		// 加零
		int count = 7 - str.length();
		String result = "";
		for (int i = 0; i < count ; i++ ) {			
			result +=  "零";			
		}
		result += str;
		System.out.println(result);

		// 加单位
		String[] unitArr = {"佰","拾","万","仟","佰","拾","元"};
		String lastResult = "";
		for (int i = 0; i < result.length() ; i++ ) {
			char chs = result.charAt(i);
			lastResult = lastResult + chs + unitArr[i];
		}
		System.out.println(lastResult);

	}
	public static String convertCapital(int num){
		String[] strArr = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
		String result = "";
		while(num != 0){
			// 获取个位
			int ge = num % 10; // 4 3
			// 重置num
			num = num / 10; // 123 12			
			
			String str = strArr[ge];
			result = str + result;// 字符拼接顺序 "肆" + "" → "肆" → "叁" + "肆" → "叁肆"
		 // result = result + str;// 字符拼接顺序 "" + "肆"  → "肆" → "肆" + "叁" → "肆叁"
		}
		
		return result;
	}
	
	
}