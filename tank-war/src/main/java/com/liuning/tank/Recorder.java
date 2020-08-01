package com.liuning.tank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Vector;

//纪录类
public class Recorder
{
	//从文件中恢复记录点
	static Vector<Node> nodes=new Vector<Node>();
	//完成读取文件
	
	public Vector<Node> getNodesAndEnNums()
	{
		try {
			fr=new FileReader("D:\\Java\\workspace"
					+ "\\TankFinal\\src\\myRecording.txt");
			br=new BufferedReader(fr);
			String n="";
			//先读取第一行
			n=br.readLine();
			allEnNum=Integer.parseInt(n);
			while((n=br.readLine())!=null)
			{
				String []xyz=n.split("");
				
				Node node=new Node(Integer.parseInt(xyz[0]),Integer.parseInt(xyz[1]),Integer.parseInt(xyz[2]));
				nodes.add(node);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				br.close();
				fr.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return nodes;
	}
	
	//记录每关有多少敌人
	private static int enNum=20;
	public static int getEnNum() {
		return enNum;
	}
	public static void setEnNum(int enNum) {
		Recorder.enNum = enNum;
	}
	
	//设置我有多少可以用的人
	private static int myLife=3;
	public static int getMyLife() {
		return myLife;
	}
	public static void setMyLife(int myLife) {
		Recorder.myLife = myLife;
	}
	
	//记录总共消灭了多少敌人
	private static int allEnNum;
	
	public static int getAllEnNum() {
		return allEnNum;
	}
	public static void setAllEnNum(int allEnNum) {
		Recorder.allEnNum = allEnNum;
	}
	
	//消灭敌人
	public static void addEnNumRec()
	{
		allEnNum++;
	}
	
	//减少敌人数
	public static void reduceEnNum()
	{
		enNum--;
	}
	
	private  Vector<EnemyTank> ets=new Vector<EnemyTank>();
	public  Vector<EnemyTank> getEts() {
		return ets;
	}
	public  void setEts(Vector<EnemyTank> ets1) {
		this.ets = ets1;
	}
	//保存击毁敌人的数量和敌人坦克坐标，方向
	public void keepRecordAndEnemyTank()
	{
		try {
			//创建
			fw=new FileWriter("D:\\Java\\workspace"
					+ "\\TankFinal\\src\\myRecording.txt");
			bw=new BufferedWriter(fw);
			
			bw.write(allEnNum+"\r\n");
			
			//保存当前活着的敌人坦克的坐标和方向
			for(int i=0;i<ets.size();i++)
			{
				EnemyTank et=ets.get(i);
				if(et.isLive)
				{
					//活着就保存
					String recode=et.x+" "+et.y+""+et.direct;
					
					//写入
					bw.write(recode+"\r\n");
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try {
				//后开先关闭
				bw.close();
				fw.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	
	private static FileWriter fw=null;
	private static BufferedWriter bw=null;
	private static FileReader fr=null;
	private static BufferedReader br=null;
	
	//从文件中读取，记录
	public static void getRecording()
	{
		try {
			fr=new FileReader("D:\\Java\\workspace"
					+ "\\TankFinal\\src\\myRecording.txt");
			br=new BufferedReader(fr);
			String n=br.readLine();
			allEnNum=Integer.parseInt(n);
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try {
				br.close();
				fr.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	//把玩家击毁敌人数量保存到文件中
	public static void keepRecording()
	{
		try {
			//创建
			fw=new FileWriter("D:\\Java\\workspace"
					+ "\\TankFinal\\src\\myRecording.txt");
			bw=new BufferedWriter(fw);
			
			bw.write(allEnNum+"\r\n");
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try {
				//后开先关闭
				bw.close();
				fw.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}