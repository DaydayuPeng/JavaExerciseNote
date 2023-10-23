// 文字格斗有效 TextGame.java
public class TextGame{
	public static void main(String[] args){
		Role r1 = new Role("乔峰", 100, '男');
		Role r2 = new Role("小龙女", 100, '女');		

		r1.printRoleInfo();
		r2.printRoleInfo();

		//回合制游戏
		while(true){
			// r1攻击r2
			r1.attact(r2);
			//被攻击方r2血量为0时，循环中断
			if (r2.getBlood() == 0) {
				System.out.println(r1.getName() + "KO了" + r2.getName());
				break;
			}

			// r2攻击r1
			r2.attact(r1);
			// 被攻击方r1血量为0时，循环中断
			if (r1.getBlood() == 0) {
				System.out.println(r2.getName() + "KO了" + r1.getName());
				break;
			}

		}


	}
}