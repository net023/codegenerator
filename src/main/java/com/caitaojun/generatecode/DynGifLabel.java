package com.caitaojun.generatecode;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JLabel;

public class DynGifLabel extends JLabel implements Runnable {
	private static final long serialVersionUID = 45345345355L;

	// 用以存储Gif动态图片
	public Image image;

	// 用以刷新paint函数
	Thread refreshThread;

	/** */
	/**
	 * 
	 * @param image:
	 *            Sample:new ImageIcon(DynGifLabel.class
	 *            .getResource("/picture.gif")).getImage()
	 */
	public DynGifLabel(Image image) {
		this.image = image;
		refreshThread = new Thread(this);
		refreshThread.start();
	}

	/** */
	/**
	 * 重载paint函数
	 */
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D graph = (Graphics2D) g;
		if (image != null) {
			// 全屏描绘图片
			graph.drawImage(image, 0, 0, getWidth(), getHeight(), 0, 0, image.getWidth(null), image.getHeight(null),
					null);
		}
	}

	/** */
	/**
	 * 隔100毫秒刷新一次
	 */
	public void run() {
		while (true) {
			this.repaint();// 这里调用了Paint
			try {
				Thread.sleep(100);// 休眠100毫秒
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
