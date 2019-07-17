package com.plane.util;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadFactory;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * 
* @ClassName:  PlanePanel 
* @version:（版本，具体版本信息自己来定） 
* @Description: （面板） 
* @author: yewenbo （作者） 
* @date: 2019年7月4日上午11:35:01（日期）
 */
public class PlanePanel extends JPanel implements Runnable,MouseMotionListener{
	//窗口对象
	private JFrame frame;
	//英雄机
	private Plane plane;
	//用来存储子弹
	private List<Bullet> bulletlist = new ArrayList<>();
	
	//敌人飞机集合
	private List<BadPlane> badPlanes = new ArrayList<>();
	
	private BadPlane badPlane;
	
	int sum =0;
	//创建面板，存放背景图片
	public PlanePanel(JFrame frame) {
		this.frame = frame;
		//创建对象
		JLabel label = new JLabel(new ImageIcon(PlanePanel.class.getResource("/bj.png")));
		
		this.add(label);
		//存放面板
		frame.add(this);
	}
	
	//把英雄机画到面板上
	public void drawPlane(Plane plane) {
		this.plane = plane;
		//画
		this.repaint();
	}
	
	
	//画内容的方法
	public void paint(Graphics g) {
		//重叠
		super.paint(g);
		if (plane != null) {
			//先画英雄机
			g.drawImage(plane.getImage(),plane.getX(), plane.getY(), null);
		}
		
		//敌机
		for (int i = 0; i < badPlanes.size(); i++) {
			badPlane = badPlanes.get(i);
			badPlane.move();
			g.drawImage(badPlane.getImage(),badPlane.getX(), badPlane.getY(), null);
		}
		//子弹
		for (int i = 0; i < bulletlist.size(); i++) {
			Bullet bullet = bulletlist.get(i);
			bullet.move();
			g.drawImage(bullet.getImage(), bullet.getX(), bullet.getY(), null);
		}
			
	}
	//射出子弹
	public void biubiu() {
		TimerTask timerTask = new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//创建子弹对象
				Bullet bullet = new Bullet(plane.getX()-8,plane.getY()+5);
				//子弹移动的方法
				bullet.move();
				//把子弹存入到list集合 
				bulletlist.add(bullet);
			}
		};
		Timer timer = new Timer();
		//2秒后开始切换
		long delay = 0;
		//每隔2秒执行一次
		long intevalPeriod = 500;
		//开启定时任务，定时器
		timer.schedule(timerTask, delay, intevalPeriod);
	}
	
	//启动线程，开始效果
	//创建子弹
	public void run() {
		//创建子弹
		while (true) {
			//定时画面板 
			this.repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void badPlanes() {
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//创建敌机
				BadPlane badPlane = new BadPlane();
				badPlane.move();
				badPlanes.add(badPlane);
				
			}
		};
		Timer timer = new Timer();
		//2秒后开始切换
		long delay =0;
		//每隔2秒执行一次
		long intevalPeriod = 500;
		//开启定时任务，定时器
		timer.schedule(task, delay, intevalPeriod);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		//获取到移动的坐标
		int x = e.getX();
		//给设置x位置
		plane.setX(x);
		
		for (int i = 0; i < bulletlist.size(); i++) {
			Bullet bullet = bulletlist.get(i);
			bullet.move();
			boolean clear = bullet.clear(badPlanes);
			if ( clear == true ) {
				bulletlist.remove(bullet);
				sum ++;
			}
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
