package com.plane.util;

import javax.swing.JFrame;

import com.utils.FrameUtils;
/**
 * 
* @ClassName:  PlaneGame 
* @version:（版本，具体版本信息自己来定） 
* @Description: （启动类） 
* @author: yewenbo （作者） 
* @date: 2019年7月4日上午10:08:00（日期）
 */
public class PlaneGame {
	public static void main(String[] args) {
		//创建窗口对象
		JFrame frame = new JFrame("打飞机游戏");
		FrameUtils.init(frame, 800, 900);
		
		//创建新的对象，面板对象
		PlanePanel panel = new PlanePanel(frame);
		
		frame.add(panel);
		//先画英雄机，封装了一个类
		Plane plane = new Plane();
		panel.drawPlane(plane);
		
		//生成很多子弹，把子弹画在面板上
		panel.biubiu();
		//产生敌机
		panel.badPlanes();
		
		//启动线程，让子弹产生动画效果，启动线程
		new Thread(panel).start();
		
		//绑定鼠标事件
		panel.addMouseMotionListener(panel);
		frame.setVisible(true);
	}
}
