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
* @version:（版本，具体版本信息自己来定） 
* @Description: （游戏的主窗口） 
* @author: yewenbo （作者） 
* @date: 2019年7月3日下午8:20:46（日期）
 */
public class PlaneFrame extends JFrame{
	
	
	
	//找到游戏的资源目录
	public static String path = System.getProperty("user.dir")+"\\Resouce\\resources";
	
	//存储图片文件
	public static HashMap<String, BufferedImage> mps= new HashMap<>();
	//加载一下资源最先加载静态语句块最先加载
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
		//数字标题
		this.setTitle("看，有飞机");
		//数字窗口的大小
		this.setSize(1400, 800);
		//设置窗口居中
		this.setLocationRelativeTo(null);
		//点击叉叉退出程序
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置窗口不能拖动
		this.setResizable(false);
		//设置窗口可见
		this.setVisible(true);
		
		//创建一个小面板
		PlanePlane jp = new PlanePlane();
		this.setContentPane(jp);
		
	}
	
	
	public static void main(String[] args) {
		System.out.println(path);
		PlaneFrame planeFrame = new PlaneFrame();
	}
}
/*
 * 飞机容器
 */
class PlanePlane extends JPanel{
	public void paint(Graphics g) {
		//重叠
		super.paint(g);
		//创建一个绘制容器
		BufferedImage image = new BufferedImage(1400, 800, BufferedImage.TYPE_INT_RGB);
		//创建画笔
		Graphics gs = image.createGraphics();
		
		//绘制背景
		gs.drawImage(PlaneFrame.mps.get("bj.png"), 0, 0, null);
//		gs.drawImage(PlaneFrame.mps.get("20190310203343399.png"), 200, 200, null);
//		gs.drawImage(image , 0, 0, this);
	}
}