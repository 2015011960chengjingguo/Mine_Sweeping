package saolei;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * ������
 */
public class HHH{
	public static void main(String args[])
	{
		MyFrame app = new MyFrame();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}
}

/**
 * �������
 */
class MyFrame extends JFrame{
	
	private final static int PRIMARY_ROW = 10;//��������
	private final static int PRIMARY_COL = 10;//��������
	private final static int PRIMARY_BOMB = 10;//��������
	
	private final static int MEDIUM_ROW = 15;//�м�����
	private final static int MEDIUM_COL = 20;//�м�����
	private final static int MEDIUM_BOMB = 40;//�м�����
	
	private final static int SENIOR_ROW = 20;//�߼�����
	private final static int SENIOR_COL = 35;//�߼�����
	private final static int SENIOR_BOMB = 120;//�߼�����
	
	private final static int SUPER_ROW = 30;//��������
	private final static int SUPER_COL = 50;//��������
	private final static int SUPER_BOMB = 350;//��������
	
	private static int row = PRIMARY_ROW;//����
	private static int col = PRIMARY_COL;//����
	private static int bombnum = PRIMARY_BOMB;//����
	private static int blocknum = row * col;//����������
	private static int leftblocknum = blocknum - bombnum;//ʣ�෽����
	private static int weight = row * 20 + 70;//�߶�
	private static int width = col * 20;//���
	 public static int time=0; //60�뵹��ʱ 
     public static boolean running=true;//�Ƿ�һֱ���� 
	JMenuBar mBar;//�˵���
	JMenu gameMenu,gradeMenu;
	JMenuItem startItem,exitItem;
	JMenuItem primary,medium,senior,ssuper;//�ĸ�����
	
	JPanel MenuPanel;//״̬���
	JLabel noflagbombnum;//δ���������ǩ
	private static int leftbombnum = bombnum;//δ�������
	 JLabel label=new JLabel();
	public static JLabel labe2=new JLabel();
	JPanel BombPanel;//�������
	Bomb [][]bomb;//������������
	
	ImageIcon iconbomb = new ImageIcon("Image/bomb.jpg");
	ImageIcon iconbomb0 = new ImageIcon("Image/bomb0.jpg");
	ImageIcon iconflag = new ImageIcon("Image/flag.jpg");
	ImageIcon iconflag2 = new ImageIcon("Image/flag2.jpg");
	ImageIcon icon1 = new ImageIcon("Image/1.jpg");
	ImageIcon icon2 = new ImageIcon("Image/2.jpg");
	ImageIcon icon3 = new ImageIcon("Image/3.jpg");
	ImageIcon icon4 = new ImageIcon("Image/4.jpg");
	ImageIcon icon5 = new ImageIcon("Image/5.jpg");
	ImageIcon icon6 = new ImageIcon("Image/6.jpg");
	ImageIcon icon7 = new ImageIcon("Image/7.jpg");
	ImageIcon icon8 = new ImageIcon("Image/8.jpg");
	ImageIcon icon0 = new ImageIcon("Image/0.jpg");
	ImageIcon icons = new ImageIcon("Image/s.jpg");
	public  void setLeftblocknum(int leftblocknum) {
		this.leftblocknum=leftblocknum;
	}
	public  int getLeftblocknum() {
		return leftblocknum;
	}
	public MyFrame()//���췽��
	{
		super("ɨ��");
		
		//��Ӳ˵�
		mBar = new JMenuBar(); 
        gameMenu = new JMenu("��Ϸ");
        startItem = new JMenuItem("����Ϸ");
        gradeMenu = new JMenu("����");
        exitItem = new JMenuItem("�˳�");
        primary = new JMenuItem("����");
        medium = new JMenuItem("�м�");
        senior = new JMenuItem("�߼�");
        ssuper = new JMenuItem("����");
        mBar.add(gameMenu); 
        gameMenu.add(startItem);
        gameMenu.add(gradeMenu);
        gameMenu.add(exitItem);
        gradeMenu.add(primary);
        gradeMenu.add(medium);
        gradeMenu.add(senior);
        gradeMenu.add(ssuper);
        setJMenuBar(mBar);
       
       
     
        //��Ӳ˵���������
        startItem.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		setBomb();
        	}
        });
        primary.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		row = PRIMARY_ROW;
        		col = PRIMARY_COL;
        		bombnum = PRIMARY_BOMB;
        		setBomb();
        	}
        });
        medium.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		row = MEDIUM_ROW;
        		col = MEDIUM_COL;
        		bombnum = MEDIUM_BOMB;
        		setBomb();
        	}
        });
        senior.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		row = SENIOR_ROW;
        		col = SENIOR_COL;
        		bombnum = SENIOR_BOMB;
        		setBomb();
        	}
        });
        ssuper.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		row = SUPER_ROW;
        		col = SUPER_COL;
        		bombnum = SUPER_BOMB;
        		setBomb();
        	}
        });
        exitItem.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		System.exit(0);
        	}
        });
        
        Container c = getContentPane();
		//���״̬���
		MenuPanel = new JPanel();
		noflagbombnum = new JLabel();
		MenuPanel.add(noflagbombnum);
		 labe2=new JLabel();//��ʾʱ��ı�ǩ
	        startTimer();
	       MenuPanel.add(labe2);
		c.add(MenuPanel,BorderLayout.NORTH);
				
		//����������
		BombPanel = new JPanel();
		c.add(BombPanel,BorderLayout.CENTER);
		
		setBomb();
		
	}
	
	public void setBomb()//������׷���
	{
		//��ʼ������
		BombPanel.removeAll();//�Ƴ������������
		bomb = new Bomb[row][col];
		BombPanel.setLayout(new GridLayout(row,col));
		for(int i=0;i<row;i++)
			for(int j=0;j<col;j++)
			{
				bomb[i][j] = new Bomb(i,j);
				bomb[i][j].addMouseListener(new MouseAdapter()
				{
					public void mouseClicked(MouseEvent e)
					{
						Bomb ebomb = (Bomb)e.getSource();
						if(e.getButton() == MouseEvent.BUTTON1)
						{
							if(!ebomb.isClicked&&!ebomb.isRight)
							{
								if(!ebomb.isBomb)
								{
									open(ebomb);//�򿪷���
									isWin();//�ж��Ƿ����
								}
								else
								{
									for(int i=0;i<row;i++)
										for(int j=0;j<col;j++)
											if(bomb[i][j].isBomb)
												bomb[i][j].setIcon(iconbomb);
									ebomb.setIcon(icons);
									ebomb.setIcon(iconbomb0);
									isLose();
									setBomb();
								}
							}
						}
						else if(e.getButton() == MouseEvent.BUTTON3)
						{
							if (!ebomb.isClicked) 
						    {
						    	ebomb.Bombflag = (ebomb.Bombflag + 1) % 3;
						    	if (ebomb.Bombflag == 1) 
						    	{
						    		if (leftbombnum > 0) 
						    		{
						    			ebomb.setIcon(iconflag);
						    			ebomb.isRight = true;
						    			leftbombnum--;
						    		}
						    		else 
						    			ebomb.Bombflag = 0;
						    	}
						    	else if (ebomb.Bombflag == 2)
						    	{
						    		leftbombnum++;
						    		ebomb.setIcon(iconflag2);
						    		ebomb.isRight = false;
						    	}
						    	else 
						    		ebomb.setIcon(icons);
						    	noflagbombnum.setText("δ������� ��"+leftbombnum);
						    	isWin();
						    }
						}
					}
				});
				BombPanel.add(bomb[i][j]);
			}
		blocknum = row * col;//������
		leftbombnum = bombnum;//δ��ǵ�����
		leftblocknum = blocknum - bombnum;//δ�򿪷�����
		noflagbombnum.setText("δ������� ��"+leftbombnum);
		weight = row * 20 + 70;//���ڸ߶�
		width = col * 20;//���ڿ��
		setSize(width,weight);//�趨���ڴ�С
		setResizable(false);//�趨���ɸı䴰�ڴ�С
		//��ʼ������
		for(int i=0;i<row;i++)
			for(int j=0;j<col;j++)
			{
				bomb[i][j].BombRoundCount = 9;
				bomb[i][j].Bombflag = 0;
				bomb[i][j].isBomb = false;
				bomb[i][j].isClicked = false;
				bomb[i][j].isRight = false;
				bomb[i][j].setIcon(icons);
			}

		//��ʼ�������
		Random rand = new Random();
		for(int i=0;i<bombnum;)
		{
			int x = rand.nextInt(row);
			int y = rand.nextInt(col);
			if(!bomb[x][y].isBomb)
			{
				bomb[x][y].isBomb = true;
				i++;
			}
		}
		calculateRoundBomb();
	}
	
	public void calculateRoundBomb()//������Χ��������
	{
		for(int i=0;i<row;i++)
			for(int j=0;j<col;j++)
			{
				int count = 0;
				if(!bomb[i][j].isBomb)
					for(int x=i-1;x<=i+1;x++)
						for(int y=j-1;y<=j+1;y++)
							if(x>=0&&y>=0&&x<row&&y<col&&bomb[x][y].isBomb)
								count++;
				bomb[i][j].BombRoundCount = count;
			}
	}
	
	public void isWin()//�ж��Ƿ�������������
	{
		if(leftblocknum == 0)
		{
			JOptionPane.showMessageDialog(this,"��ϲ��ȡ��ʤ��!","ʤ��!",JOptionPane.INFORMATION_MESSAGE);
			setBomb();
		}
	}
	
	public void isLose()
	{
		noflagbombnum.setText("δ������� ��"+0);
		JOptionPane.showMessageDialog(this,"������ˣ����㣬��ȷ�����¿�ʼ!","ʧ��!",2);
	}
	
	public void isNull(Bomb clickbomb)//�������Ϊ�գ�������Χ����
	{
		int x = clickbomb.bx;
		int y = clickbomb.by;
		for(int i=x-1;i<=x+1;i++)
			for(int j=y-1;j<=y+1;j++)
				if(i>=0&&j>=0&&i<row&&j<col)
					if(!bomb[i][j].isBomb&&!bomb[i][j].isClicked&&!bomb[i][j].isRight)
						open(bomb[i][j]);
	}
	
	public void open(Bomb clickbomb)//����򿪷���
	{
		clickbomb.isClicked = true;
		leftblocknum--;
		if(clickbomb.BombRoundCount > 0)
		{
			if(clickbomb.BombRoundCount == 1)
				clickbomb.setIcon(icon1);
			else if(clickbomb.BombRoundCount == 2)
				clickbomb.setIcon(icon2);
			else if(clickbomb.BombRoundCount == 3)
				clickbomb.setIcon(icon3);
			else if(clickbomb.BombRoundCount == 4)
				clickbomb.setIcon(icon4);
			else if(clickbomb.BombRoundCount == 5)
				clickbomb.setIcon(icon5);
			else if(clickbomb.BombRoundCount == 6)
				clickbomb.setIcon(icon6);
			else if(clickbomb.BombRoundCount == 7)
				clickbomb.setIcon(icon7);
			else if(clickbomb.BombRoundCount == 8)
				clickbomb.setIcon(icon8);
		}
		else
		{
			clickbomb.setIcon(icon0);
			isNull(clickbomb);
		}
	}

//  public int time=1000* 60; //60�뵹��ʱ 
//   public boolean running=true;//�Ƿ�һֱ���� 
//  JLabel labe2=new JLabel();//��ʾʱ��ı�ǩ 
//������ʱ 
public static void startTimer(){ 
new java.lang.Thread(new Runnable(){ 
public void run(){ 
while(running){ 
try{ 
Thread.sleep(1000);//˯һ�� 
}catch(Exception e){} 
time++; 
labe2.setText(String.valueOf(time)); 
//new MyFrame().update(g);
//this.update();// ����Ľ���ˢ��һ��
if(time<0){//����ʱ���㣬�������� 
//your code�� ��Ϸʧ�ܣ����㴦�� 
running=false;//�ǵ��ó�false�����˳� 
} 
} 
} 
}).start(); 
} 
}
/**
 * ����������
 */
final class Bomb extends JButton{
	
	int bx,by;//��������λ��
	int BombRoundCount;//��Χ����
	int Bombflag;//̽�ױ��
	boolean isBomb;//�Ƿ�����
	boolean isClicked;//�Ƿ������
	boolean isRight;//�Ƿ����Ҽ�
	public static int blockopennum = 0;//�򿪷�����
	
	public Bomb(int x,int y)//���췽��
	{
		bx = x;
		by = y;
		BombRoundCount = 9;
		Bombflag = 0;
		isBomb = false;
		isClicked = false;
		isRight = false;
	}
}
