package com.liuning.tank;

/*
 * 子弹类作为一个线程
 * 使用Runnable接口
 * 在hero类的ShotEnemy里面被创建
 */
public class Bullet implements Runnable{
    public int x;					//	子弹的x坐标
    public int y;					//  子弹的y坐标
    int direct; 			//	子弹的方向
    int speed=2;			//	子弹的速度
    public boolean IsLive=true;	//	判断子弹是否存活

    public Bullet(int x,int y,int direct)
    {
        this.x=x;
        this.y=y;
        this.direct=direct;
    }

    //重写Runnable接口的run函数
    @Override
    public void run() {
        while(true)
        {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            switch(direct)
            {
                case 0:	y-=speed;	break;
                case 1:	y+=speed;	break;
                case 2:	x-=speed;	break;
                case 3:	x+=speed;	break;
            }
            //System.out.println("子弹坐标="+x+"y="+y);
            //子弹何时死亡？？？
            //判断该子弹是否碰到边缘
            if(x<0||x>400||y<0||y>300)
            {
                this.IsLive=false;
                break;
            }
        }
    }
}