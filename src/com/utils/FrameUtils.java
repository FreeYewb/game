package com.utils;

import javax.swing.JFrame;

public class FrameUtils {
	public static void init(JFrame frame,int width,int height) {
		//���ִ��ڵĴ�С
		frame.setSize(width, height);
		//���ô��ھ���
		frame.setLocationRelativeTo(null);
		//�������˳�����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
