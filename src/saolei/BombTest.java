package saolei;

import static org.junit.Assert.*;

import org.junit.Test;

public class BombTest {

	@Test
	public void test() {
		int bx=1;//��������λ��
		int by=2;
//		int BombRoundCount=4;//��Χ����
//		int Bombflag=2;//̽�ױ��
//		boolean isBomb=true;//�Ƿ�����
//		boolean isClicked=true;//�Ƿ������
//		boolean isRight=true;//�Ƿ����Ҽ�
//	    int blockopennum = 0;//�򿪷�����
	    Bomb b=new Bomb(bx,by);
	    System.out.println(b.isBomb);
	}

}
