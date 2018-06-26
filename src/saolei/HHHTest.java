package saolei;

import static org.junit.Assert.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.junit.Test;

public class HHHTest {

	
	
	@Test
	public void testisWin()//判断是否挖完了所有雷
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
			
			JOptionPane.showMessageDialog(f,"恭喜你取得胜利!","胜利!",JOptionPane.INFORMATION_MESSAGE);
			
		}
		
	}
}
