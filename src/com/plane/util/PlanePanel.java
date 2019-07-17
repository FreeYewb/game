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
* @version:���汾������汾��Ϣ�Լ������� 
* @Description: ����壩 
* @author: yewenbo �����ߣ� 
* @date: 2019��7��4������11:35:01�����ڣ�
 */
public class PlanePanel extends JPanel implements Runnable,MouseMotionListener{
	//���ڶ���
	private JFrame frame;
	//Ӣ�ۻ�
	private Plane plane;
	//�����洢�ӵ�
	private List<Bullet> bulletlist = new ArrayList<>();
	
	//���˷ɻ�����
	private List<BadPlane> badPlanes = new ArrayList<>();
	
	private BadPlane badPlane;
	
	int sum =0;
	//������壬��ű���ͼƬ
	public PlanePanel(JFrame frame) {
		this.frame = frame;
		//��������
		JLabel label = new JLabel(new ImageIcon(PlanePanel.class.getResource("/bj.png")));
		
		this.add(label);
		//������
		frame.add(this);
	}
	
	//��Ӣ�ۻ����������
	public void drawPlane(Plane plane) {
		this.plane = plane;
		//��
		this.repaint();
	}
	
	
	//�����ݵķ���
	public void paint(Graphics g) {
		//�ص�
		super.paint(g);
		if (plane != null) {
			//�Ȼ�Ӣ�ۻ�
			g.drawImage(plane.getImage(),plane.getX(), plane.getY(), null);
		}
		
		//�л�
		for (int i = 0; i < badPlanes.size(); i++) {
			badPlane = badPlanes.get(i);
			badPlane.move();
			g.drawImage(badPlane.getImage(),badPlane.getX(), badPlane.getY(), null);
		}
		//�ӵ�
		for (int i = 0; i < bulletlist.size(); i++) {
			Bullet bullet = bulletlist.get(i);
			bullet.move();
			g.drawImage(bullet.getImage(), bullet.getX(), bullet.getY(), null);
		}
			
	}
	//����ӵ�
	public void biubiu() {
		TimerTask timerTask = new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//�����ӵ�����
				Bullet bullet = new Bullet(plane.getX()-8,plane.getY()+5);
				//�ӵ��ƶ��ķ���
				bullet.move();
				//���ӵ����뵽list���� 
				bulletlist.add(bullet);
			}
		};
		Timer timer = new Timer();
		//2���ʼ�л�
		long delay = 0;
		//ÿ��2��ִ��һ��
		long intevalPeriod = 500;
		//������ʱ���񣬶�ʱ��
		timer.schedule(timerTask, delay, intevalPeriod);
	}
	
	//�����̣߳���ʼЧ��
	//�����ӵ�
	public void run() {
		//�����ӵ�
		while (true) {
			//��ʱ����� 
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
				//�����л�
				BadPlane badPlane = new BadPlane();
				badPlane.move();
				badPlanes.add(badPlane);
				
			}
		};
		Timer timer = new Timer();
		//2���ʼ�л�
		long delay =0;
		//ÿ��2��ִ��һ��
		long intevalPeriod = 500;
		//������ʱ���񣬶�ʱ��
		timer.schedule(task, delay, intevalPeriod);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		//��ȡ���ƶ�������
		int x = e.getX();
		//������xλ��
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
