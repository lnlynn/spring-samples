package com.liuning.view;

import com.liuning.tank.Recorder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyTankGame extends JFrame implements ActionListener{
	
	MyPanel mp=null;
	
	MyStartPanel msp=null;

	JMenuBar jmb=null;
	JMenu jm1=null;
	JMenuItem jmi1=null;
	JMenuItem jmi2=null;
	JMenuItem jmi3=null;
	JMenuItem jmi4=null;
	
	public static void main(String[] args) {
		
		MyTankGame mytank=new MyTankGame();
	
	}
	
	public MyTankGame(){
		
		jmb=new JMenuBar();
		jm1=new JMenu("游戏(G)");
		//设置快捷方式
		jm1.setMnemonic('G');
		jmi1=new JMenuItem("开始新游戏");
		jmi2=new JMenuItem("退出游戏(E)");
		jmi3=new JMenuItem("存盘退出游戏(C)");
		jmi4=new JMenuItem("继续上局游戏(C)");
		
		jmi2.setMnemonic('E');
		jmi2.addActionListener(this);
		jmi2.setActionCommand("exit");
		
		jmi3.addActionListener(this);
		jmi3.setActionCommand("saveExit");
		//对jmi1响应
		jmi1.addActionListener(this);
		jmi1.setActionCommand("new game");
		
		jmi4.addActionListener(this);
		jmi4.setActionCommand("continue last game");
		
		jm1.add(jmi1);
		jm1.add(jmi2);
		jm1.add(jmi3);
		jm1.add(jmi4);
		jmb.add(jm1);
		
		msp=new MyStartPanel();
		Thread t=new Thread(msp);
		t.start();
		
		this.setJMenuBar(jmb);
		
		this.add(msp);
		this.setSize(800,600);
		this.setLocationRelativeTo(null);//在屏幕中心显示
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("new game"))
		{
			mp=new MyPanel("newGame");
			Thread t=new Thread(mp);
			t.start();
			
			//先删除旧的面板
			this.remove(msp);
			this.add(mp);
			this.addKeyListener(mp);
			this.setTitle("坦克大战");//JFrame标题
			this.setLocationRelativeTo(null);//在屏幕中心显示
			this.setVisible(true);
		}else if(e.getActionCommand().equals("exit"))
		{
			Recorder.keepRecording();
			System.exit(0);
		}else if(e.getActionCommand().equals("saveExit"))
		{
			//保存击毁敌人的数量和敌人的坐标
			Recorder rd=new Recorder();
			rd.setEts(mp.ets);
			rd.keepRecordAndEnemyTank();
			System.exit(0);
		}else if(e.getActionCommand().equals("continue last game"))
		{
			mp=new MyPanel("con");
			Thread t=new Thread(mp);
			t.start();
			
			//先删除旧的面板
			this.remove(msp);
			this.add(mp);
			this.addKeyListener(mp);
			this.setTitle("坦克大战");//JFrame标题
			this.setLocationRelativeTo(null);//在屏幕中心显示
			this.setVisible(true);
		}	
	}
}
