//对象数组 赋值，打印 ObjectArrayCopyAndPrint.java
public class ObjectArrayCopyAndPrint{
	public static void main(String[] args){
		// 创建一个新的对象数组，长度为三
		Goods[] arr = new Goods[3];

		// 创建三个对象，并完成对对象的初始化
		Goods g1 = new Goods("问界M7",34.6,"华为",34);
		Goods g2 = new Goods("理想L9",50.0,"理想",27);
		Goods g3 = new Goods("特斯拉MoldeY",32.0,"特斯拉",66);

		// 把三个对象赋值给数组元素
		arr[0] = g1;
		arr[1] = g2;
		arr[2] = g3;

		// 打印对象数组
		for (int i = 0; i < arr.length; i++ ){
			Goods goods = arr[i];
			System.out.println(goods.getName() + "," + goods.getPrice() + "," + goods.getBrand() + "," + goods.getStock());
		}

	}
}