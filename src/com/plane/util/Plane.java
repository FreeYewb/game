package com.plane.util;
/**
 * 
* @ClassName:  Plane 
* @version:���汾������汾��Ϣ�Լ������� 
* @Description: ���ɻ��ࣩ 
* @author: yewenbo �����ߣ� 
* @date: 2019��7��4������11:14:12�����ڣ�
 */

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Plane {
	//�ɻ�ͼƬ
	private BufferedImage image;
	
	//������x��y��λ������
	private int x;
	private int y;
	
	//�ɻ��Ŀ�Ⱥ͸߶�
	private int width;
	private int height;
	
	public Plane() {
		try {
			image = ImageIO.read(Plane.class.getResource("/1.png"));
			x = 350;
			y = 720;
			this.width = 100;
			this.height = 100;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public BufferedImage getImage() {
		return image;
	}
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
	
}
