package poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PokerModel {
	/** 現在のチップ数 初期値は500 */
	int chips;
	/** 数字毎に手札を集計した配列(countNumber()内で初期化する) */
	 int count[];
	/** 山札 */
	List<Integer> deckcards;
	/** 手札 */
	List<Integer> handcards;
	/** 送信ボタンに表示する文字列("交換","次のゲーム"のどちらか */
	String buttonLabel;
	/** プレイヤーへのメッセージ */
	String message;

	/** ゲーム回数 */
	int games;
	/** コンストラクタ */
	public PokerModel() {
		deckcards = new ArrayList<>();
		handcards = new ArrayList<>();
	}

	/** 一連のゲームを開始する */
	public void reset() {
		chips = 500;
		games = 0;
	}

	/** 次のゲームのためにカードを配りなおす */
	public void nextgame() {
		// 52枚の山札を作る
		deckcards.clear();
		for (int i=1; i<=52; i++) {
			deckcards.add(i);
			Collections.shuffle(deckcards);
		}

		// 山札の先頭から5枚抜いて手札にする
		handcards.clear();
		for (int i=0; i<5; i++) {
			int n = deckcards.remove(0);
			handcards.add(n);
		}

		// 残りの場札の枚数とカード番号をコンソールに表示する
		System.out.printf("%d: ", deckcards.size());
		for (int n: deckcards) {
			System.out.printf("%d ", n);
		}
		System.out.println();

		message = "交換するカードをチェックしてください";
		buttonLabel = "交換";
		games++;
	}

	/** indexで指定された位置のカードを、山札から補充したカードを置き換える */
	public void change(List<String> index) {
		System.out.println("index="+index);
		for (int i=0; i<index.size(); i++) {
			int hand = Integer.parseInt(index.get(i));
			int c = deckcards.remove(i); // 山札の先頭を取り除き、
			handcards.set(hand,c ); // 手札の指定場所に入れる
		}
		evaluate();
		buttonLabel = "次のゲーム";
	}
	/** 役の判別を行い、チップを増減させる */
	public void evaluate() {
		countNumber();
		int pair = countPair();
		int three = countThree();
		int fullhouse = countFullhouse(pair,three);
		int four = countFour();
		int red = countRed();
		int seven = countSeven();
		int point = 0;
		if (four == 1) {
			message = "フォーカード";
			point= 1000;
		}else if (fullhouse == 1) {
			message = "フルハウス";
			point= 100;
		}else if (three == 1) {
			message = "スリーカード";
			point= 50;
		}else if (pair == 2) {
			message = "ツーペア";
			point= 40;
		}else if (pair == 1) {
			message = "ワンペア";
			point= 30;
		}else if (red == 5) {
			message = "レッド";
			point= 20;
		} else if (seven > 0) {
			message = "セブン";
			point = seven * 10;
		}else {
			message = "ハイカード";
			point = -100;
		}
		chips += point;
		if(chips > 0) {
			message += ": " + chips;
		}
		else {
			message +="<br>ゲームオーバー";
		}
	}

	/** 7 の枚数を返す */
	int countSeven() {
		int count7=0;
		for(int i=0;i<5;i++) {
			int hand = handcards.get(i)%13;
			if(hand %13==7) {
				count7++;
			}
		}
		return count7;
	}

	/** 赤の枚数を返す */
	int countRed() {
		int countred=0;
		for(int i=0;i<5;i++) {
			if(14<=handcards.get(i) && handcards.get(i)<=39) {
				countred++;
			}
		}
		return countred;
	}
	
	/** 数字毎に手札の枚数を数える */
	void countNumber() {
		count = new int[13];
		for(int g=1;g<13;g++) {
			for(int i=0;i<5;i++) {
				if(handcards.get(i)%13==g) {
					count[g-1]++;
				}
			}
		}
		for(int i=0;i<5;i++) {
			if(handcards.get(i)%13==0) {
				count[12]++;
			}
		}
		
		for (int n: count) {
			System.out.printf("%d ", n);
		}
		System.out.println();
	}
	
	int countPair() {
		int countpair = 0;
		for(int i=0;i<13;i++) {
			if(count[i] == 2) {
				countpair++;
			}
		}
		return countpair;
	}

	int countThree() {
		int countthree = 0;
		for(int i=0;i<13;i++) {
			if(count[i] == 3) {
				countthree++;
			}
		}
		return countthree;
	}
	
	int countFullhouse(int pair,int three) {
		int countfullhouse = 0;
		if(pair == 1 && three == 1) {
			countfullhouse++;
		}
		return countfullhouse;
	}
	
	int countFour() {
		int countfour = 0;
		for(int i=0;i<13;i++) {
			if(count[i] == 4) {
				countfour++;
			}
		}
		return countfour;
	}
	 /** 手札をセットする（テスト用） */
	public void setHandcards(int a, int b, int c, int d, int e) {
		handcards.set(0, a);
		handcards.set(1, b);
		handcards.set(2, c);
		handcards.set(3, d);
		handcards.set(4, e);
	}
	
	/** 現在のチップ数を返す */
	public int getChips() {
		return chips;
	}

	/** 5枚の手札のうち，i番目のカード番号を返す (i=0～4) */
	public int getHandcardAt(int i) {
		return handcards.get(i);
	}

	/** 送信ボタンのラベルを返す */
	public String getButtonLabel() {
		return buttonLabel;
	}
	/** プレイヤーへのメッセージを返す */
	public String getMessage() {
		return message;
	}

	public int getGames() {
		return games;
	}

}