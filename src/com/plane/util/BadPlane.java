package com.plane.util;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class BadPlane {
	//飞机图片
		private BufferedImage image;
		
		//出生的x和y的位置坐标
		private int x;
		private int y;
		
		//飞机的宽度和高度
		private int width;
		private int height;
		
		
		Random random = new Random();
		
		public BadPlane() {
			try {
				int i = random.nextInt(700);
				//判断
				if (i < 50) {
					i = i + 50;
				}
				this.x = i;
				this.y = 50;
				
				image = ImageIO.read(Plane.class.getResource("/41.png"));
				
				this.width = 88;
				this.height = 72;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//子弹移动的方法
		public void move() {
			this.y = y+5;
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
		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}
}
