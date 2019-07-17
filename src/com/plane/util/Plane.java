package com.plane.util;
/**
 * 
* @ClassName:  Plane 
* @version:（版本，具体版本信息自己来定） 
* @Description: （飞机类） 
* @author: yewenbo （作者） 
* @date: 2019年7月4日上午11:14:12（日期）
 */

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Plane {
	//飞机图片
	private BufferedImage image;
	
	//出生的x和y的位置坐标
	private int x;
	private int y;
	
	//飞机的宽度和高度
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
