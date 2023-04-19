package remember;

public class ArraySample {
	int prime[] = {2,3,5,7,11,13,17,19,23,29};
	int data[];
	
	public static void main(String args[]) {
		ArraySample sample = new ArraySample();
		
		sample.initData();
		sample.printData();
		sample.printData2();
		
		sample.swap(0,4);
		sample.printData();
		
		sample.primesum();
		
		int r = (int)(Math.random() * 5);
		System.out.println(r);
		
		sample.shuffle();
	}
	
	
	void initData() {
		data=new int[prime.length];
		for (int i=0;i<prime.length;i++) {
			data[i]=prime[i];
		}
	}
	
	void printData() {
		for(int i=0;i<data.length; i++) {
			System.out.print(data[i] + " ");
			}
		System.out.println();
	}

	void printData2() {
		for(int d:data) {
			System.out.print(d + " ");
		}
		System.out.println();
	}
	
	void swap(int x,int y) {
		int temp = data[x] ;
			data[x]=data[y];
			data[y]=temp;
	}
	
	void primesum() {
		int ps[] = new int[prime.length-1];
		for(int i=0;i<ps.length;i++) {
			ps[i]=prime[i]+prime[i+1];
			System.out.print(ps[i]+" ");
		}
		System.out.println();
	}
	
	void shuffle() {
		for(int i=0;i<10;i++) {
			int r=(int)(Math.random() * 10);
			swap(i, r);
			System.out.print(data[i]+" ");
		}
		System.out.println();
	}

}
