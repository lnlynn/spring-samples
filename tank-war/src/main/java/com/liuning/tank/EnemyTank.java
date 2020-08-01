package com.liuning.tank;

import java.util.Vector;

//import TankFinal.Bullet;
//import TankFinal.EnemyTank;
//import TankFinal.Tank;

//敌人的坦克
public class EnemyTank extends Tank implements Runnable
{
    int speed=2;
    int times=0;

    //定义一个向量，可以访问MyPanel上所有敌人的坦克
    Vector<EnemyTank> ets=new Vector<EnemyTank>();

    //boolean isLive=true;
    //定义一个向量，可以存放敌人的子弹
    public Vector<Bullet> bb=new Vector<Bullet>();
    //敌人添加子弹，应当在刚刚创建坦克和敌人的坦克刚刚死亡后

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    //得到MyPanel上的敌人坦克向量
    public void setEts(Vector<EnemyTank> vv)
    {
        this.ets=vv;
    }

    //判断是否碰到了别的敌人坦克
    public boolean isTouchOtherEnemy()
    {
        boolean b=false;

        switch(this.direct)
        {
            case 0:
                //坦克向上
                //取出所有的敌人坦克
                for(int i=0;i<ets.size();i++)
                {
                    //取出第一个坦克
                    EnemyTank et=ets.get(i);
                    //如果不是自己
                    if(et!=this)
                    {
                        //如果敌人的坦克是向上或者向下
                        if(et.direct==0||et.direct==1)
                        {
                            //左点
                            if(this.x>=et.x&&this.x<=et.x+20
                                    &&this.y>=et.y&&this.y<=et.y+30)
                            {
                                return true;
                            }
                            if(this.x+20>=et.x&&this.x<et.x+20
                                    &&this.y>=et.y&&this.y<=et.y+30)
                            {
                                return true;
                            }
                        }
                        if(et.direct==2||et.direct==3)
                        {
                            if(this.x>=et.x&&this.x<=et.x+30
                                    &&this.y>=et.y&&this.y<=et.y+20)
                            {
                                return true;
                            }
                            if(this.x+20>=et.x&&this.x<et.x+30
                                    &&this.y>=et.y&&this.y<=et.y+20)
                            {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 1:
                //坦克向下
                //取出所有的敌人坦克
                for(int i=0;i<ets.size();i++)
                {
                    //取出第一个坦克
                    EnemyTank et=ets.get(i);
                    //如果不是自己
                    if(et!=this)
                    {
                        //如果敌人的坦克是向上或者向下
                        if(et.direct==0||et.direct==1)
                        {
                            //我的左一点
                            if(this.x>=et.x&&this.x<=et.x+20
                                    &&this.y+30>=et.y&&this.y+30<=et.y+30)
                            {
                                return true;
                            }
                            //yo
                            if(this.x+20>=et.x&&this.x+20<et.x+20
                                    &&this.y+30>=et.y&&this.y+30<=et.y+30)
                            {
                                return true;
                            }
                        }
                        if(et.direct==2||et.direct==3)
                        {
                            if(this.x>=et.x&&this.x<=et.x+30
                                    &&this.y+30>=et.y&&this.y+30<=et.y+20)
                            {
                                return true;
                            }
                            if(this.x+20>=et.x&&this.x+20<et.x+30
                                    &&this.y+30>=et.y&&this.y+30<=et.y+20)
                            {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 2:
                //坦克向左
                //取出所有的敌人坦克
                for(int i=0;i<ets.size();i++)
                {
                    //取出第一个坦克
                    EnemyTank et=ets.get(i);
                    //如果不是自己
                    if(et!=this)
                    {
                        //如果敌人的坦克是向上或者向下
                        if(et.direct==0||et.direct==1)
                        {
                            //我的上一点
                            if(this.x>=et.x&&this.x<=et.x+20
                                    &&this.y>=et.y&&this.y<=et.y+30)
                            {
                                return true;
                            }
                            //下一点
                            if(this.x>=et.x&&this.x<et.x+20
                                    &&this.y+20>=et.y&&this.y+20<=et.y+30)
                            {
                                return true;
                            }
                        }
                        if(et.direct==2||et.direct==3)
                        {
                            //上一点
                            if(this.x>=et.x&&this.x<=et.x+30
                                    &&this.y>=et.y&&this.y<=et.y+20)
                            {
                                return true;
                            }
                            if(this.x>=et.x&&this.x<et.x+30
                                    &&this.y+20>=et.y&&this.y+20<=et.y+20)
                            {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 3:
                //坦克向右
                //取出所有的敌人坦克
                for(int i=0;i<ets.size();i++)
                {
                    //取出第一个坦克
                    EnemyTank et=ets.get(i);
                    //如果不是自己
                    if(et!=this)
                    {
                        //如果敌人的坦克是向上或者向下
                        if(et.direct==0||et.direct==1)
                        {
                            //上面一点
                            if(this.x+30>=et.x&&this.x+30<=et.x+20
                                    &&this.y>=et.y&&this.y<=et.y+30)
                            {
                                return true;
                            }
                            if(this.x+30>=et.x&&this.x+30<et.x+30
                                    &&this.y+20>=et.y&&this.y+20<=et.y+30)
                            {
                                return true;
                            }
                        }
                        if(et.direct==2||et.direct==3)
                        {
                            if(this.x+30>=et.x&&this.x+30<=et.x+30
                                    &&this.y>=et.y&&this.y<=et.y+20)
                            {
                                return true;
                            }
                            if(this.x+30>=et.x&&this.x+30<et.x+30
                                    &&this.y+20>=et.y&&this.y+20<=et.y+20)
                            {
                                return true;
                            }
                        }
                    }
                }
                break;
        }


        return b;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while(true)
        {

            switch(this.direct)
            {
                case 0:
                    //说明坦克正在向上移动
                    for(int i=0;i<30;i++)
                    {
                        //保证坦克不出边界
                        if(y>0&&!this.isTouchOtherEnemy())
                        {
                            y-=speed;
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1:
                    for(int i=0;i<30;i++)
                    {
                        if(y<300&&!this.isTouchOtherEnemy())
                        {
                            y+=speed;
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    for(int i=0;i<30;i++)
                    {
                        if(x>0&&!this.isTouchOtherEnemy())
                        {
                            x-=speed;
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    for(int i=0;i<30;i++)
                    {
                        if(x<400&&!this.isTouchOtherEnemy())
                        {
                            x+=speed;
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    break;
            }



            //判断是否要给坦克加入新的子弹
            this.times++;

            if(times%2==0)
            {
                if(isLive)
                {
                    if(bb.size()<5)
                    {
                        Bullet b=null;
                        switch(direct)
                        {
                            case 0:	b=new Bullet(x+10,y,0);		bb.add(b); 	break;
                            case 1:	b=new Bullet(x+10,y+30,1);	bb.add(b);	break;
                            case 2:	b=new Bullet(x,y+10,2);		bb.add(b);	break;
                            case 3:	b=new Bullet(x+30,y+10,3);	bb.add(b);	break;
                        }
                        Thread t=new Thread(b);
                        t.start();
                    }
                }
            }
            //让坦克随机产生一个新的方向
            this.direct=(int)(Math.random()*4);
            //判断敌人坦克是否死亡
            if(this.isLive==false)
            {
                //让坦克死亡后，退出线程
                break;
            }


        }
    }
}
