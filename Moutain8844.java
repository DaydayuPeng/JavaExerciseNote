/*需求:世界最高山峰是珠穆朗玛峰(8844.43米=8844430毫米),假如我
有一张足够大的纸，它的厚度是0.1毫米。
请问，我折叠多少次，可以折成珠穆朗玛峰的高度?Moutain8844.java*/

public class Moutain8844{
	 public static void main(String[] args) {
	 	int i = 0;
	 	double height = 0.1;
	 	while(height < 8844430.0 ){
	 		height =  height * 2;
	 		i++;
	 	}
	 	System.out.println("折叠" + i + "次，可以折成珠穆朗玛峰的高度");	 	
	}
}