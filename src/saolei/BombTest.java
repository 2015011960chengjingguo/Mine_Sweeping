package saolei;

import static org.junit.Assert.*;

import org.junit.Test;

public class BombTest {

	@Test
	public void test() {
		int bx=1;//方块所在位置
		int by=2;
//		int BombRoundCount=4;//周围雷数
//		int Bombflag=2;//探雷标记
//		boolean isBomb=true;//是否是雷
//		boolean isClicked=true;//是否点击左键
//		boolean isRight=true;//是否点击右键
//	    int blockopennum = 0;//打开方格数
	    Bomb b=new Bomb(bx,by);
	    System.out.println(b.isBomb);
	}

}
