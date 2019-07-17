package com.utils;

import javax.swing.JFrame;

public class FrameUtils {
	public static void init(JFrame frame,int width,int height) {
		//数字窗口的大小
		frame.setSize(width, height);
		//设置窗口居中
		frame.setLocationRelativeTo(null);
		//点击叉叉退出程序
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
