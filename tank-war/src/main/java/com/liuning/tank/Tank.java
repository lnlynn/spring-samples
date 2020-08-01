package com.liuning.tank;

//import TankFinal.Bullet;
//import TankFinal.Tank;

//坦克类
public class Tank{
    public Tank(int x,int y){
        this.x=x;
        this.y=y;
    }

    public boolean isLive=true;

    public int x=0;	//坦克横坐标
    public int y=0;	//坦克纵坐标
    public int 	getX() 		{	return x; 	}
    public void setX(int x) {	this.x = x;	}
    public int 	getY() 		{	return y; 	}
    public void setY(int y) {	this.y = y;	}

    int color;	//坦克的颜色
    public int 	getColor() 			{	return color;		}
    public void setColor(int color) {	this.color = color;	}

    int speed=10;//坦克的速度
    public int 	getSpeed() 			{	return speed;		}
    public void setSpeed(int speed) {	this.speed = speed;	}

    //坦克方向
    //0 表示上    1表示下  2表示左  3表示右
    public int direct=0;
    public int 	getDirect() 			{	return direct;			}
    public void setDirect(int direct) 	{	this.direct = direct;	}
}


