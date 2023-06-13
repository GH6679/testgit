package CH99;

import java.util.Scanner;

class TriangleSpawner{
	void triangleSpawner(int h){
		for (int i=0;i<h;i++) {

			for (int k=0;k<=(h-2)-i;k++) {
				System.out.print(" ");
			}
			for (int j=0;j<=i*2;j++) {
				System.out.print("*");
			}

			System.out.println();
		}
	}
}

public class test2 {
	public static void main(String[] args) {
		TriangleSpawner Spawner = new TriangleSpawner();
		Scanner sc = new Scanner(System.in);
		System.out.print("높이 입력 : ");
		Spawner.triangleSpawner(sc.nextInt());
		
	}
}