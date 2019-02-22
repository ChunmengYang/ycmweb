package ycmweb.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.RandomStringUtils;;

public class RandomImageGenerator {

	public static String random() {
		String str = "";
		str = "2345689ABCDEFGHJKLMNPQRSUVWXYZabcdefhikmnrstuvwxz";
		return RandomStringUtils.random(4, str);
	}

	public static String random(int length) {
		String str = "2345689ABCDEFGHJKLMNPQRSUVWXYZabcdefhikmnrstuvwxz";
		return RandomStringUtils.random(length, str);
	}

	public static String shortRandom() {
		String str = "";
		str = "2345689ABCDEFGHJKLMNPQRSUVWXYZabcdefhikmnrstuvwxz";
		return RandomStringUtils.random(4, str);
	}

	public static void render(String num, OutputStream out) throws IOException {
		if (num.getBytes().length > 4) {
			throw new IllegalArgumentException("The length of param num cannot exceed 4.");
		}
		int width = 90;

		int height = 30;
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = (Graphics2D) bi.getGraphics();
		java.util.Random random = new java.util.Random();
		g.setColor(Color.white);
		g.fillRect(0, 0, width, height);
		Font mFont = new Font("Arial", Font.PLAIN, 20);
		g.setFont(mFont);
		g.setColor(Color.BLACK);
		String str1[] = new String[4];
		for (int i = 0; i < str1.length; i++) {
			str1[i] = num.substring(i, i + 1);

			Color color1 = new Color(random.nextInt(60), random.nextInt(60), random.nextInt(60));
			g.setColor(color1);
			g.drawString(str1[i], 20 * i + 10, 21);
		}

		for (int i = 0; i < 100; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			Color color1 = new Color(random.nextInt(55) + 200, random.nextInt(55) + 200, random.nextInt(55) + 200);
			g.setColor(color1);
			g.drawOval(x, y, 0, 0);
		}
		for (int i = 0; i < 5; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int x1 = random.nextInt(width);
			int y1 = random.nextInt(height);
			Color color1 = new Color(random.nextInt(55) + 200, random.nextInt(55) + 200, random.nextInt(55) + 200);

			g.setColor(color1);
			g.drawLine(x, y, x1, y1);
		}
		g.dispose();
		ImageIO.write(bi, "jpg", out);
	}

	public static void shortRender(String num, OutputStream out) throws IOException {
		if (num.getBytes().length > 4) {
			throw new IllegalArgumentException("The length of param num cannot exceed 4.");
		}
		int width = 64;

		int height = 22;
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = (Graphics2D) bi.getGraphics();
		java.util.Random random = new java.util.Random();
		g.setColor(Color.white);
		g.fillRect(0, 0, width, height);
		Font mFont = new Font("Arial", Font.PLAIN, 20);
		g.setFont(mFont);
		g.setColor(Color.BLACK);
		String str1[] = new String[4];
		for (int i = 0; i < str1.length; i++) {
			str1[i] = num.substring(i, i + 1);
			int w = 0;
			int x = (i + 1) % 3;

			if (x == random.nextInt(3)) {
				w = 14 - random.nextInt(2);
			} else {
				w = 14 + random.nextInt(2);
			}

			Color color1 = new Color(random.nextInt(60), random.nextInt(60), random.nextInt(60));
			g.setColor(color1);
			g.drawString(str1[i], 16 * i + 4, w);
		}

		for (int i = 0; i < 100; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			Color color1 = new Color(random.nextInt(55) + 200, random.nextInt(55) + 200, random.nextInt(55) + 200);
			g.setColor(color1);
			g.drawOval(x, y, 0, 0);
		}
		for (int i = 0; i < 5; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int x1 = random.nextInt(width);
			int y1 = random.nextInt(height);
			Color color1 = new Color(random.nextInt(55) + 200, random.nextInt(55) + 200, random.nextInt(55) + 200);

			g.setColor(color1);
			g.drawLine(x, y, x1, y1);
		}
		g.dispose();
		ImageIO.write(bi, "jpg", out);
	}

}
