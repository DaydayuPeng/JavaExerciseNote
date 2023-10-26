//学生类
class Student{
	// 成员属性
	private int id;
	private String name;
	private int age;

	// 空参和全参
	public Student(){}
	public Student(int id, String name,int age){
		this.id = id;
		this.name = name;
		this.age = age;
	}

	// get and set
	public void setId(int id){
		this.id = id;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setAge(int age){
		this.age = age;
	}
	public int getId(){
		return id;
	}
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
}