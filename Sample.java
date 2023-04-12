package remember;

public class Sample {
	
	public  static void main(String args[]) {
		Sample sample = new Sample();
		sample.hello();
		sample.morning("サトシ");
		sample.printAllCode();
		sample.printOddCode();
		sample.printSpadeCode();
		sample.printDiamondCode();
		sample.printNot3Code1();
		sample.printNot3Codes2();
		sample.printNot23Codes1();
		sample.printNot23Codes2();
		System.out.println(sample.code2num(26));
		System.out.println(sample.code2suit(26));
	}

	void hello() {
		System.out.println("Hello,world");
	}
	
	void morning(String name) {
		System.out.println("おはよう"+name);
	}
	
	void printAllCode() {
		for(int i=1; i<52; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	void printOddCode() {
		for (int i=1; i<52; i++) {
			if(i % 2 == 1) {
				System.out.print(i +" ");
			}
		}
		System.out.println();
	}
	
	void printSpadeCode() {
		for(int i=1; i<52; i++) {
			if(i<=13) {
				System.out.print(i+" ");
			}
		}
		System.out.println(" ");
	}
	
	void printDiamondCode() {
		for(int i=1; i<52; i++) {
			if(i>=27) {
				if(i<=39) {
					System.out.print(i+" ");
				}
			}
		}
		System.out.println(" ");
	}
	
	void printNot3Code1() {
		for(int i=1; i<52; i++) {
			if (i % 3 != 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println(" ");
	}
	
	void printNot3Codes2() {
		for (int i=1; i<=52; i++) {
			if (!(i % 3 == 0)) {
				System.out.print(i + " ");
			}
		}
		System.out.println(" ");
	}
	
	void printNot23Codes1() {
		for (int i=1; i<=52; i++) {
			if (i % 2 != 0) {
				if (i % 3 != 0) {
					System.out.print(i + " ");
				}
			}
		}
		System.out.println(" ");
	}
	
	void printNot23Codes2() {
		for (int i=1; i<=52; i++) {
			if (!(i % 2 == 0)) {
				if (!(i % 3 == 0)) {
					System.out.print(i + " ");
				}
			}
		}
		System.out.println(" ");
	}
	
	int code2num(int code) {
		int ancer = code%13;
		if(ancer==0) {
			ancer=13;
		}
		return ancer;
	}
	
	String code2suit(int code) {
		String ancer = "";
		if(code>=1) {
			if(code<=13) {
				ancer="スぺド";
			}
		}
		if(code>=14) {
			if(code<=26) {
				ancer="ハート";
			}
		}
		if(code>=27) {
			if(code<=39) {
				ancer="ダイヤ";
			}
		}
		if(code>=40) {
			if(code<=52) {
				ancer="クラブ";
			}
		}
		return ancer;
	}

}


