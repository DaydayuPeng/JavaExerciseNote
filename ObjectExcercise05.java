// 对象数组练习 ObjectExcercise05.java
/*定义一个长度为3的数组，数组存储1~3名学生对象作为初始数据，学生对象的学号,姓名各不相同。
学生的属性:学号,姓名，年龄。
要求1:再次添加一个学生对象，并在添加的时候进行学号的唯一性判断。
要求2:添加完毕之后，遍历所有学生信息。
要求3:通过id删除学生信息，如果存在，则删除，如果不存在，则提示删除失败。
要求4:删除完毕之后，遍历所有学生信息。
要求5:查询数组id为"002" 的学生,如果存在，则将他的年龄+1岁*/

import java.util.Scanner;
public class ObjectExcercise05{
	public static void main(String[] args){
		//创建对象数组
		Student[] stdArr = new Student[3];

		// 创建对象并完成初始化
		Student std1 = new Student(1, "Andy", 19);
		Student std2 = new Student(2, "July", 22);
		Student std3 = new Student(3, "Tina", 23);
		Student std4 = new Student(5, "Sophia",32);

		//把数组元素指向新创建对象的地址
		stdArr[0] = std1;
		stdArr[1] = std2;
		stdArr[2] = std3;	

		// 要求1：新添加学生，如果学生id存在就提示该学生已存在，如果不存在就表示可以添加
	/*	boolean flag = idExist(stdArr,5);		
		
		if (flag) {
			System.out.println("该学生已存在");
		}else{
			// 添加的时候要判断老数组是否已满，满了就加一个长度，如果没满就直接加
			int index = indexFind(stdArr);
			if(index < stdArr.length){
				// 直接添加
				stdArr[index] = std4;
				// printArr(stdArr);// 要求2：打印数组验证是否添加成功
				// System.out.println("*********");
			}else{
				//满了，新建数组
				Student[] newArr = new Student[stdArr.length + 1];
				for (int i = 0; i < stdArr.length ; i++ ) {
					newArr[i] = stdArr[i];
				}
				newArr[index] = std4;
				printArr(newArr);// 要求2：打印数组验证是否添加成功
				System.out.println("*********");
			}
		}*/

	// 要求3:通过id删除学生信息，如果存在，则删除，如果不存在，则提示删除失败。 为了不开新的窗口这里只考虑stdArr，不考虑newArr
		/*
		int i = idIndex(stdArr,2);
		if(i != -1){
			stdArr[i] = null;
		}else{
			System.out.println("学生不存在，删除失败");
		}
		printArr(stdArr);// 要求4：打印数组验证是否添加成功*/

		//要求5：查询数组id为"2" 的学生,如果存在，则将他的年龄+1岁
		
		int i = idIndex(stdArr,5);
		if(i != -1){
			int age = stdArr[i].getAge() + 1;
			stdArr[i].setAge(age);
		}else{
			System.out.println("学生不存在，修改失败");
		}
		printArr(stdArr);

		

	}


	// 找到id对应的索引
	public static int idIndex(Student[] arr,int id){
		for (int i = 0;i < arr.length ;i++ ) {
			Student stu = arr[i];
			if(arr[i] != null){
				if(stu.getId() == id){
					return i;
				}
			}
		}
		return -1;
	}

	// 打印数组的方法	
	public static void printArr(Student[] arr){
		for (int i = 0; i < arr.length; i++ ) {
			Student student = arr[i];
			if( arr[i] != null){
			System.out.println(student.getId() + "," + student.getName() + "," + student.getAge());	
			}		
		}
	}

	// 判断id是否存在的方法
	public static boolean idExist(Student[] arr, int id){
		for (int i = 0; i < arr.length; i++) {
			Student student = arr[i];
			if(arr[i] != null){
				int idarr = student.getId();
				if( idarr == id){
					return true;
				}
			}
			
		}
		return false;
	}
	
	// 判断数组是否是满的方法
	public static int indexFind(Student[] arr){
		int count = 0;
		for (int i = 0; i < arr.length; i++) {			
			if( arr[i] != null){
				count++;
			}
			
		}
		return count;
	}

}
