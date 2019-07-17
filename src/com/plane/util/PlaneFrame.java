package com.plane.util;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
* @ClassName:  PlaneFrame 
* @version:���汾������汾��Ϣ�Լ������� 
* @Description: ����Ϸ�������ڣ� 
* @author: yewenbo �����ߣ� 
* @date: 2019��7��3������8:20:46�����ڣ�
 */
public class PlaneFrame extends JFrame{
	
	
	
	//�ҵ���Ϸ����ԴĿ¼
	public static String path = System.getProperty("user.dir")+"\\Resouce\\resources";
	
	//�洢ͼƬ�ļ�
	public static HashMap<String, BufferedImage> mps= new HashMap<>();
	//����һ����Դ���ȼ��ؾ�̬�������ȼ���
	static {
		
		File[] files = new File(path).listFiles();
		for (int i = 0; i < files.length; i++) {
			try {
				mps.put(files[i].getName(), ImageIO.read(files[i]));
			} catch (IOException e) { 
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	PlanePlane jp;
	
	public PlaneFrame() {
		//���ֱ���
		this.setTitle("�����зɻ�");
		//���ִ��ڵĴ�С
		this.setSize(1400, 800);
		//���ô��ھ���
		this.setLocationRelativeTo(null);
		//�������˳�����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���ô��ڲ����϶�
		this.setResizable(false);
		//���ô��ڿɼ�
		this.setVisible(true);
		
		//����һ��С���
		PlanePlane jp = new PlanePlane();
		this.setContentPane(jp);
		
	}
	
	
	public static void main(String[] args) {
		System.out.println(path);
		PlaneFrame planeFrame = new PlaneFrame();
	}
}
/*
 * �ɻ�����
 */
class PlanePlane extends JPanel{
	public void paint(Graphics g) {
		//�ص�
		super.paint(g);
		//����һ����������
		BufferedImage image = new BufferedImage(1400, 800, BufferedImage.TYPE_INT_RGB);
		//��������
		Graphics gs = image.createGraphics();
		
		//���Ʊ���
		gs.drawImage(PlaneFrame.mps.get("bj.png"), 0, 0, null);
//		gs.drawImage(PlaneFrame.mps.get("20190310203343399.png"), 200, 200, null);
//		gs.drawImage(image , 0, 0, this);
	}
}