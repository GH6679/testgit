package CH99;
	/*
	 * 캐릭터가 무기상인에게 전용무기를 구매한다. 
	
	구매자(Buyer)
	-보유금액
	-전용무기 개수(한정)
	+구매하기기능
	+무기 정보확인 기능
	
	판매자(Seller)
	-보유금액
	-전용무기 개수
	+전용 무기 1개당 가격
	+돈을 받아 전용무기를 전달하는 기능
	+전용무기 정보확인기능
	 */
	/*
	 * protected 메서드 활용: 부모 클래스에 protected 접근 제어자를 가진 메서드를 정의하고, 
	 * 해당 메서드 내부에서 private 멤버를 활용합니다.
	 *  자식 클래스는 부모 클래스의 protected 메서드를 상속받아 확장한 후, 
	 *  해당 메서드를 호출하여 간접적으로 private 멤버를 사용할 수 있습니다.
	 */
class Savekeeper{
	protected int Mymoney;
	protected int ExclusiveWeapon;
	public int Price;
	protected int Weaponcnt;
	
	//생성자
	public Savekeeper(int Mymoney,int Weaponcnt, int Price)
	{
		this.Mymoney = Mymoney;
        this.Price = Price;
        this.Weaponcnt = Weaponcnt; // 무기 개수 초기화
	}

}

class Shopkeeper extends Savekeeper{
	public Shopkeeper(int Mymoney,int ExclusiveWeapon, int Price)
	{
		   super(Mymoney, 0, Price); // 수정된 부분
	       this.Weaponcnt = ExclusiveWeapon; // 무기 개수 초기화
	}
	public int Receive(int money)
	{	
		Mymoney+=money;
		int revcnt = money/Price;
		Weaponcnt= revcnt;
		return revcnt;
	}
	public void Showinfo()
	{
		System.out.println("----------------------판매자 정보----------");
		System.out.println("보유 금액:" +Mymoney);
		System.out.println("무기 개수:" +Weaponcnt);
		System.out.println("개당 가격:" +Weaponcnt);
	}

}
class Buyer extends Savekeeper{
		
	//생성자
	public Buyer(int Mymoney,int Weaponcnt)
	{	
		super(Mymoney,0,0);
		this.Mymoney=Mymoney;
		this.Weaponcnt=Weaponcnt;
	}
	public void Payment(Shopkeeper shopkeeper,int money)
	{
		Mymoney-=money;  //2000
		int cnt=shopkeeper.Receive(money);
	}
	public void Showinfo()
	{
		System.out.println("----------------------구매자 정보----------------");
		System.out.println("보유 금액 : "+Mymoney);
		System.out.println("무기 개수 : "+Weaponcnt);
	}
}
	

	
	
	
	
	
	
	
	
	public class C02Nam {
		public static void main(String[] args) {
			Shopkeeper keeper1 = new Shopkeeper(50000, 5, 30000);//보유돈,무기개수 , 무기가격
	        Buyer Buy1 = new Buyer(300000, 1);
	        Buy1.Payment(keeper1, 30000);

	        keeper1.Showinfo();
	        Buy1.Showinfo();
	        System.out.println();
	        System.out.println();
//	        Buyer Buy2 = new Buyer(300000, 1);
//	        Buy1.Payment(keeper1, 60000);
//	        
//	        keeper1.Showinfo();
//	        Buy1.Showinfo();
	        

			
		}
	
	}
