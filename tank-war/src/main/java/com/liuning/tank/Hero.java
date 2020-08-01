package com.liuning.tank;

import java.util.Vector;

public class Hero extends Tank{
	
	//子弹
	//Bullet b=null;
	public Vector<Bullet> bb=new Vector<Bullet>();
	Bullet b=null;
	public Hero(int x,int y){
		super(x,y);
	}
	
	public void shotEnEemy()
	{	
		switch(this.direct)
		{
			case 0:	b=new Bullet(x+10,y,0);		bb.add(b); 	break;
			case 1:	b=new Bullet(x+10,y+30,1);	bb.add(b);	break;
			case 2:	b=new Bullet(x,y+10,2);		bb.add(b);	break;
			case 3:	b=new Bullet(x+30,y+10,3);	bb.add(b);	break;
		}
		Thread t=new Thread(b);
		t.start();
	}
	
	public void moveUp()		{	y-=speed;	}
	public void moveRight()	{	x+=speed;	}
	public void moveDown()	{	y+=speed;	}
	public void moveLeft()	{	x-=speed;	}	
}