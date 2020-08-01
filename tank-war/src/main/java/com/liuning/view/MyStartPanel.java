package com.liuning.view;

import javax.swing.*;
import java.awt.*;

class MyStartPanel extends JPanel implements Runnable
{
	int times=0;
	public void paint(Graphics g)
	{
		super.paint(g);
		g.fillRect(0, 0, 800, 600);
		//提示信息
		if(times%2==0)
		{
			//开关信息的字体
			g.setColor(Color.yellow);
			Font myFont=new Font("华文新魏",Font.BOLD,30);
			g.setFont(myFont);
			g.drawString("第一关", 150, 150);
		}
		
	}

	@Override
	public void run() {
		while(true)
		{	
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
			times++;
			this.repaint();
		}
	}
}