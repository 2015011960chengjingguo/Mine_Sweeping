package saolei;

import static org.junit.Assert.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.junit.Test;

public class HHHTest {

	
	
	@Test
	public void testisWin()//�ж��Ƿ�������������
	{ 
		int leftblocknum=0;
//		assertTrue()
//		
//		{
//			
//	
//		}
		MyFrame h=new MyFrame();
		h.setLeftblocknum(leftblocknum);
		if(h.getLeftblocknum()== 0)
		{
			JFrame f=new JFrame();
			
			JOptionPane.showMessageDialog(f,"��ϲ��ȡ��ʤ��!","ʤ��!",JOptionPane.INFORMATION_MESSAGE);
			
		}
		
	}
}
