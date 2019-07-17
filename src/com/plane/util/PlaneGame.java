package com.plane.util;

import javax.swing.JFrame;

import com.utils.FrameUtils;
/**
 * 
* @ClassName:  PlaneGame 
* @version:���汾������汾��Ϣ�Լ������� 
* @Description: �������ࣩ 
* @author: yewenbo �����ߣ� 
* @date: 2019��7��4������10:08:00�����ڣ�
 */
public class PlaneGame {
	public static void main(String[] args) {
		//�������ڶ���
		JFrame frame = new JFrame("��ɻ���Ϸ");
		FrameUtils.init(frame, 800, 900);
		
		//�����µĶ���������
		PlanePanel panel = new PlanePanel(frame);
		
		frame.add(panel);
		//�Ȼ�Ӣ�ۻ�����װ��һ����
		Plane plane = new Plane();
		panel.drawPlane(plane);
		
		//���ɺܶ��ӵ������ӵ����������
		panel.biubiu();
		//�����л�
		panel.badPlanes();
		
		//�����̣߳����ӵ���������Ч���������߳�
		new Thread(panel).start();
		
		//������¼�
		panel.addMouseMotionListener(panel);
		frame.setVisible(true);
	}
}
