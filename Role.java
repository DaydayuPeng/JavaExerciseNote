//文字格斗游戏的标准javabean类 Role.java
import java.util.Random;
class Role{

	//成员属性
	private String name;
	private int blood;
	private char gender;
	private String appearance;


	String[] boyAppearance= {"风流俊雅","气宇轩昂","相貌英俊","五官端正","相貌平平","一塌糊涂","面目狰狞"};
	String[] girlAppearance ={"美奂绝伦","沉鱼落雁" ,"婷婷玉立" ,"身材娇好","相貌平平","相貌简陋","惨不忍睹"};

	String[] attacks_desc={
	"%s使出了一招[背心钉]，转到对方的身后，一掌向%s背心的灵台穴拍去。",
	"%s使出了一招[游空探爪]，飞起身形自半空中变掌为抓锁向%s。",
	"%s大喝一声，身形下伏，一招[劈雷坠地]，捶向%s双腿。",
	"%s运气于掌，-瞬间掌心变得血红，一式[掌心雷]，推向%S。",
	"%s阴手翻起阳手跟进，-招|没遮拦]，结结实实的捶向%s。",
	"%s上步抢身，招中套招，-招[ 劈挂连环]，连环攻向%S。"
	};

	String[] injureds_desc={
	"结果%s退了半步，亳发无损",
	"结果给%s造成一处瘀伤",
	"结果一击命中，%s痛得弯下腰",
	"结果%s痛苦地闷哼了一声，显然受了点内伤",
	"结果%s摇摇晃晃，一跤摔倒在地",
	"结果%s脸色一下变得惨白，连退了好几步",
	"结果「轰」的一声，%s口中鲜血狂啧而出",
	"结果%s一声惨叫，像滩软泥般塌了下去"
	};



	//空参和全参构造器
	public Role(){}
	public Role(String name,int blood,char gender){
		this.name = name;
		this.blood = blood;
		this.gender = gender;
		setAppearance(gender);
	}
	//设置成员变量和获取成员变量的方法
	public void setGender(char gender){
		this.gender = gender;
	}
	public void setAppearance(char gender){
		if (getGender() == '男') {
			Random r = new Random();
			int index = r.nextInt(boyAppearance.length);
			this.appearance = boyAppearance[index];
		}else if(getGender() == '女'){
			Random r = new Random();
			int index = r.nextInt(girlAppearance.length);
			this.appearance = girlAppearance[index];

		}else{
			this.appearance = "面目狰狞";
		}
		
	}

	public char getGender(){
		return gender;
	}
	public String getAppearance(){
		return appearance;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setBlood(int blood){
		this.blood = blood;
	}

	public String getName(){
		return name;
	}
	public int getBlood(){
		return blood;
	}

	//攻击方法
	public void attact(Role role){
		Random r = new Random();
		int index = r.nextInt(attacks_desc.length);
		// String KungFu = attacks_desc[index];
		System.out.printf(attacks_desc[index],this.getName(),role.getName());
		System.out.println();		
		//设置每次掉血 1-20之间
		// Random r = new Random();
		int hurt = r.nextInt(20) + 1;

		//计算被攻击人的剩余血量
		int remainBlood = role.getBlood() - hurt;	

		//当被攻击人的剩余血量小于0，系统设定剩余血量是0，而不是负数
		remainBlood = remainBlood < 0? 0:remainBlood;

		//把计算出的被攻击人剩余血量赋值给被攻击人的成员属性，这点很重要，因为需要在main方法中使用这个数值去控制程序
		role.setBlood(remainBlood);	
		// System.out.println(this.getName() + "举起拳头，打了" + role.getName() + "一下，" + role.getName() + "掉了" + hurt + "的血量,还剩余" + remainBlood + "的血量");

		if (role.getBlood()> 90) {
			System.out.printf(injureds_desc[0],role.getName());
		}else if(role.getBlood() > 80){
			System.out.printf(injureds_desc[1],role.getName());			
		}else if(role.getBlood() > 70){
			System.out.printf(injureds_desc[2],role.getName());			
		}else if(role.getBlood()> 60){
			System.out.printf(injureds_desc[3],role.getName());			
		}else if(role.getBlood() > 50){
			System.out.printf(injureds_desc[4],role.getName());			
		}else if(role.getBlood() > 30){
			System.out.printf(injureds_desc[5],role.getName());			
		}else if(role.getBlood() > 10){
			System.out.printf(injureds_desc[6],role.getName());			
		}else {
			System.out.printf(injureds_desc[7],role.getName());			
		}				
		
		System.out.println();
		
	
	}

	//打印游戏角色信息
	public void printRoleInfo(){
		System.out.println("角色姓名 " + this.getName());
		System.out.println("角色血量 " + this.getBlood());
		System.out.println("角色性别 " + this.getGender());
		System.out.println("角色长相 " + this.getAppearance());
		System.out.println("*************");

	}

}