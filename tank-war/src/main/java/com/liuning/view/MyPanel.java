package com.liuning.view;

import com.liuning.tank.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Vector;

//我的面板
class MyPanel extends JPanel implements Runnable,KeyListener{
	//定义一个坦克
	Hero hero=null;
	
	//判断是继续上局还是新游戏
	//String flag="newGame";
	
	//定义敌人的坦克组
	Vector<EnemyTank> ets=new Vector<EnemyTank>();
	Vector<Node> nodes=new Vector<Node>();
	int emSize=10;//初始化敌人坦克数量
	
	//定义炸弹集合
	Vector<Bomb> bombs=new Vector<Bomb>();
	
	//播放开战声音
	AePlayWave apw=new AePlayWave("/111.wav");
	
	//定义三张图片，三张图片组成一颗炸弹
	Image image1 = null;
	Image image2 = null;
	Image image3 = null;
	
	Image tankDown  = null;
	Image tankLeft  = null;
	Image tankRight = null;
	Image tankUp    = null;
	
	public MyPanel(String flag)
	{
		//恢复记录
		Recorder.getRecording();
		
		hero =new Hero(400,400);
		
		if(flag.equals("newGame"))
		{
			//初始化敌人的坦克
			for(int i=0;i<emSize;i++)
			{
				//创建一辆敌人的坦克对象
				EnemyTank et=new EnemyTank((i+1)*50,0);
				et.setColor(2);
				et.setDirect(1);
				
				//将MyPanel的敌人坦克向量交给该敌人坦克
				et.setEts(ets);
				
				Thread t=new Thread(et);
				t.start();
				//给敌人添加一颗子弹
				Bullet b=new Bullet(et.x+10,et.y+30,1);
				et.bb.add(b);
				Thread t2=new Thread(b);
				t2.start();
				
				ets.add(et);
			}
		}else{
			nodes=new Recorder().getNodesAndEnNums();
			//初始化敌人的坦克
			for (Node node : nodes) {
				//创建一辆敌人的坦克对象
				EnemyTank et = new EnemyTank(node.x, node.y);
				et.setColor(2);
				et.setDirect(node.direct);

				//将MyPanel的敌人坦克向量交给该敌人坦克
				et.setEts(ets);

				Thread t = new Thread(et);
				t.start();
				//给敌人添加一颗子弹
				Bullet b = new Bullet(et.x + 10, et.y + 30, 1);
				et.bb.add(b);
				Thread t2 = new Thread(b);
				t2.start();

				ets.add(et);
			}
		}
		
		try {
			image1=ImageIO.read(new File("/images/bomb1.gif"));
			image2=ImageIO.read(new File("/images/bomb2.gif"));
			image3=ImageIO.read(new File("/images/bomb3.gif"));
			
			tankDown = ImageIO.read(new File("/images/Tank_down.png"));
			tankLeft = ImageIO.read(new File("/images/Tank_left.png"));
			tankRight = ImageIO.read(new File("/images/Tank_right.png"));
			tankUp = ImageIO.read(new File("/images/Tank_up.png"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//画出提示信息
	public void showInfo(Graphics g)
	{
		//画出提示信息坦克（该坦克不参与战斗）
		this.drawTank(80, 330, g, 0, 0);
		g.setColor(Color.BLACK);
		g.drawString(Recorder.getEnNum()+"", 110, 350);
		this.drawTank(140, 330, g, 1, 0);
		g.setColor(Color.BLACK);
		g.drawString(Recorder.getMyLife()+"", 170, 350);
	
		//显示玩家的总成绩
		g.setColor(Color.BLACK);
		Font f=new Font("宋体",Font.BOLD,20);
		g.setFont(f);
		g.drawString("总成绩", 400, 350);
		
		this.drawTank(400, 400, g, 0, 0);
		
		g.setColor(Color.black);
		g.drawString(Recorder.getAllEnNum()+"", 430, 420);
		
	}
	
	//重写paint
	public void paint(Graphics g){
		
		super.paint(g);
		g.fillRect(0, 0, 800, 600);
		
		//画出提示信息
		this.showInfo(g);
		
		//画出自己的坦克
		if(hero.isLive)
		{
			this.drawTank(hero.getX(), hero.getY(), g, 0, this.hero.direct);
		}
			//从bb中取出每一刻子弹并绘制
		for(int i=0;i<this.hero.bb.size();i++)
		{
			Bullet myBullet=hero.bb.get(i);
			//画出一颗子弹
			if(myBullet!=null&&myBullet.IsLive==true)
			{
				g.draw3DRect(myBullet.x, myBullet.y, 1, 1, false);
			}
			if(myBullet.IsLive==false)
			{
				//从bbz中删除该子弹
				hero.bb.remove(myBullet);
			}
		}
		//画出敌人的坦克
		for(int i=0;i<ets.size();i++)
		{
			EnemyTank et=ets.get(i);
			if(et.isLive)
			{
				this.drawTank(et.getX(), et.getY(), g, 1, et.getDirect());
				//画出敌人的子弹
				for(int j=0;j<et.bb.size();j++)
				{
					Bullet enemyBullet=et.bb.get(j);
					if(enemyBullet.IsLive)
					{
						g.draw3DRect(enemyBullet.x, enemyBullet.y, 1, 1, false);
					}else{
						//如果敌人的坦克死亡了，就从Vector中删除
						et.bb.remove(enemyBullet);
					}
				}
			}
		}
		//画出炸弹
		for(int i=0;i<bombs.size();i++)
		{
			Bomb b=bombs.get(i);
			
			if(b.life>6)
			{
				g.drawImage(image1, b.x, b.y, 30,30,this);
			}else if(b.life>4){
				g.drawImage(image2, b.x, b.y, 30,30,this);
			}else{
				g.drawImage(image3, b.x, b.y, 30,30,this);
			}
			//让b的生命值减小
			b.lifeDown();
			if(b.life==0)
			{
				bombs.remove(b);
			}
		}
	}
	
	//我的坦克是否被击中
	public void hitMyTank()
	{
		for(int i=0;i<this.ets.size();i++)
		{
			EnemyTank et=ets.get(i);
			
			//取出每一颗子弹
			for(int j=0;j<et.bb.size();j++)
			{
				Bullet enemyBullet=et.bb.get(j);
				if(hero.isLive){
					this.hitTank(enemyBullet, hero);
					{
//						Recorder.reduceEnNum();
//						Recorder.addEnNumRec();
					}
				}
			}
		}
	}
	
	public void hitEnemyTank()
	{
		//判断是否击中敌人的坦克
		for(int i=0;i<hero.bb.size();i++)
		{
			//取出子弹
			Bullet myBullet=hero.bb.get(i);
			//判断子弹是否有效
			if(myBullet.IsLive)
			{
				//取出每一个坦克，与之判断
				for(int j=0;j<ets.size();j++)
				{
					//取出坦克
					EnemyTank et=ets.get(j);
					if(et.isLive)
					{
						if(this.hitTank(myBullet, et))
						{
							Recorder.reduceEnNum();
							Recorder.addEnNumRec();
						}
					}
				}
			}
		}
	}
	
	//写一个函数专门判断子弹是否击中敌人坦克
	//public void hitTank(Bullet b,EnemyTank et)升级
	public boolean hitTank(Bullet b,Tank et)
	{
		boolean c=false;
		//判断改坦克的方向
		switch(et.direct)
		{
		//如果敌人坦克的方向是上或者是下
		case 0:
		case 1:
			if(b.x>et.x&&b.x<et.x+20&&b.y>et.y&&b.y<et.y+30)
			{
				
				//击中了
				//子弹死亡
				b.IsLive=false;
				//敌人的坦克死亡
				
//				Recorder.reduceEnNum();
//				Recorder.addEnNumRec();
				c=true;
				
				et.isLive=false;
				//创建一颗炸弹，翻入Vector
				Bomb b1=new Bomb(et.x,et.y);
				bombs.add(b1);
			}
			break;	
			
		case 2:
		case 3:
			if(b.x>et.x&&b.x<et.x+30&&b.y>et.y&&b.y<et.y+20)	
			{
				b.IsLive=false;
				et.isLive=false;
//				
//				Recorder.reduceEnNum();
//				Recorder.addEnNumRec();
				c=true;
				
				Bomb b1=new Bomb(et.x,et.y);
				bombs.add(b1);
			}
			break;
		}
		return c;
	}
	//画出坦克的函数（扩展）
	public void drawTank(int x,int y,Graphics g,int type,int direct){
		
		switch(type)
		{
			//这里的setColor与tank类里面的setColor不同
			//这里指设置画笔的颜色
			case 0:	g.setColor(Color.RED);		break;
			case 1:	g.setColor(Color.YELLOW);	break;
			case 2:	g.setColor(Color.CYAN);	break;
		}
		switch(direct)
		{
			case 0:	g.drawImage(tankUp, x, y, 50, 50, this);	break;
			case 1:	g.drawImage(tankDown, x, y, 50, 50, this);	break;
			case 2:	g.drawImage(tankLeft, x, y, 50, 50, this);	break;
			case 3:	g.drawImage(tankRight, x, y, 50,50,this);	break;
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	//键按下处理  a左边  s 下 w 上 d 右
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_W||e.getKeyCode()==KeyEvent.VK_UP){
			//设置我的坦克的方向
			this.hero.setDirect(0);
			this.hero.moveUp();
		}else if(e.getKeyCode()==KeyEvent.VK_D||e.getKeyCode()==KeyEvent.VK_RIGHT){
			this.hero.setDirect(3);
			this.hero.moveRight();
		}else if(e.getKeyCode()==KeyEvent.VK_S||e.getKeyCode()==KeyEvent.VK_DOWN){
			this.hero.setDirect(1);
			this.hero.moveDown();
		}else if(e.getKeyCode()==KeyEvent.VK_A||e.getKeyCode()==KeyEvent.VK_LEFT){
			this.hero.setDirect(2);
			this.hero.moveLeft();
		}
		if(e.getKeyCode()==KeyEvent.VK_F)
		{
			//判断玩家是否按下f
			//开火
			if(this.hero.bb.size()<=5)
			{
				this.hero.shotEnEemy();
			}
			
		}
		//必须重绘窗口
		this.repaint();
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
	@Override
	public void run() {
		//每隔100毫秒重绘
		while(true)
		{
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.hitEnemyTank();
			this.hitMyTank();
			this.repaint();
		}
		
	}
}