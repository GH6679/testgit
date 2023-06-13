package CH99;


class C01Seller{
	private int MyMoney;
	private int AppleCnt;
	int Price;
	public C01Seller(int myMoney,int appleCnt,int price) {
		this.MyMoney = myMoney;
		this.AppleCnt = appleCnt;
		this.Price = price;
	}
	public int Receuve(int money) {
		MyMoney = MyMoney+money;
		AppleCnt = AppleCnt-(money/Price);
		return (money/Price);
	}
	public void Showinfo(){
		System.out.println("보유금액 : "+MyMoney);
		System.out.println("사과개수 : "+AppleCnt);
		System.out.println("개당가격 : "+Price);
	}
	
}

class C01Buyer{
	private int MyMoney;
	private int AppleCnt;
	public C01Buyer(int myMoney,int appleCnt) {
		this.MyMoney = myMoney;
		this.AppleCnt = appleCnt;
	}
	public void Pay(C01Seller seller01,int money) {
		MyMoney = MyMoney-money;
		int buy = seller01.Receuve(money);
		AppleCnt = AppleCnt + buy;
		}
	
	public void Showinfo(){
		System.out.println("보유금액 : "+MyMoney);
		System.out.println("사과개수 : "+AppleCnt);
	}
}


public class test {
	public static void main(String[] args) {
		C01Seller seller = new C01Seller(1000000,100,1000);
		C01Buyer buyer01 = new C01Buyer(10000,0);
		C01Buyer buyer02 = new C01Buyer(20000,0);
		C01Buyer buyer03 = new C01Buyer(30000,0);
		buyer01.Pay(seller, 2000);
		buyer02.Pay(seller, 5000);
		buyer03.Pay(seller, 3000);
		System.out.println("---판매자 정보---");
		seller.Showinfo();
		System.out.println("---구매자 정보---");
		System.out.println("-beyer01-");
		buyer01.Showinfo();
		System.out.println("-beyer02-");
		buyer02.Showinfo();
		System.out.println("-beyer03-");
		buyer03.Showinfo();
		
	}
}

