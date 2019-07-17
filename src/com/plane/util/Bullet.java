package com.plane.util;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

public class Bullet {
			//�ӵ�ͼƬ
			private BufferedImage image;
			
			//������x��y��λ������
			private int x;
			private int y;
			
			//�ӵ��Ŀ�Ⱥ͸߶�
			private int width;
			private int height;
			
			//�ӵ�
			public Bullet(int x, int y) {
				try {
					this.x = x + 54;
					this.y = y;
					image = ImageIO.read(Plane.class.getResource("/zd.png"));
					this.width = 18;
					this.height = 25;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			//�ӵ��ƶ��ķ���
			public void move() {
				this.y = y-10;
			}
			
			//�����ӵ��ͷɻ���Ч��
			public boolean clear(List<BadPlane> badPlanes) {
				for (int j = 0; j < badPlanes.size(); j++) {
					BadPlane badPlane = badPlanes.get(j);
					int badx = badPlane.getX();
					int bady = badPlane.getY();
					
					int numx = badx - this.x;
					int numy = bady + badPlane.getHeight() - this.y;
					
					if (numx >= -88 && numx<= 0 && numy > -10 && numy <10) {
						badPlanes.remove(badPlane);
						return true;
					}
				}
				return false;
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