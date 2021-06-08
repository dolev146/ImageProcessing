import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class MyImageIO {

	public static int[][] RGB_TO_Gray(int[][][] m) {
		int[][] m_new = new int[m[0].length][m[0][0].length];
		for (int i = 0; i < m[0].length; i++) {
			for (int j = 0; j < m[0][0].length; j++) {

				int R = m[0][i][j];
				int G = m[1][i][j];
				int B = m[2][i][j];
				// System.out.println(R +" "+G +" "+B);
				m_new[i][j] = (int) (((0.3 * R) + (0.59 * G) + (0.11 * B)) * 255);
				// m_new[i][j]= (int) ((0.3 * R) + (0.3 * G) + (0.3 * B)) ;
			}
		}

		return m_new;
	}

	public static Frame readImageFromFile(String fileName, boolean gray) {
		if (gray) {
			int[][][] img = readImageFromFile(fileName);
			int[][] im_g = RGB_TO_Gray(img);
			GrayImage gi = new GrayImage(im_g);
			return gi;
		} else {
			int[][][] img = readImageFromFile(fileName);
			RGBImage rgbi = new RGBImage(img);
			return rgbi;
		}
	}

	public static int[][][] readImageFromFile(String fileName) {
		try {
			BufferedImage im = ImageIO.read(new File(fileName));
			int[][][] img = new int[3][im.getHeight()][im.getWidth()];
			for (int i = 0; i < im.getHeight(); i++) {
				for (int j = 0; j < im.getWidth(); j++) {
					Color c = new Color(im.getRGB(j, i));
					img[0][i][j] = c.getRed();
					img[1][i][j] = c.getGreen();
					img[2][i][j] = c.getBlue();
				}
			}
			return img;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void writeImageToFile(String fileName, int[][][] pixels) {
		BufferedImage im = new BufferedImage(pixels[0][0].length, pixels[0].length, BufferedImage.TYPE_INT_RGB);
		Graphics g = im.createGraphics();
		for (int i = 0; i < pixels[0].length; i++) {
			for (int j = 0; j < pixels[0][0].length; j++) {
				g.setColor(new Color(pixels[0][i][j], pixels[1][i][j], pixels[2][i][j]));
				g.fillRect(j, i, 1, 1);
			}
		}
		try {
			fileName = fileName + ".jpg";
			ImageIO.write(im, "jpg", new File(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeImageToFile(String fileName, int[][] pixels) {
		BufferedImage im = new BufferedImage(pixels[0].length, pixels.length, BufferedImage.TYPE_BYTE_GRAY);
		for (int i = 0; i < pixels.length; i++) {
			for (int j = 0; j < pixels[0].length; j++) {
				im.setRGB(j, i, pixels[i][j]);
			}
		}
		try {
			fileName = fileName + ".jpg";
			ImageIO.write(im, "jpg", new File(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeImageToFile(Frame f, String fileName) {
		if (f instanceof RGBImage) {
			writeImageToFile(fileName, ((RGBImage) f).getFrame());
		} else
			writeImageToFile(fileName, ((GrayImage) f).getFrame());
	}

	public static void main(String[] args) throws IOException {
		// for windows: C:\\Users\\dolev\\Desktop\\Tichnot\\catE.jpg
		// for mac : Users/dolev/Desktop/Tichnot/catE.jpg
		// C:\Users\dolev\Desktop\Tichnot\catE.jpg
		// link to code on github
		// https://github.com/dolev146/ImageProcessing/blob/main/FrameContainer.java

		Frame color = readImageFromFile("catE.jpg", false);
		Frame gray = readImageFromFile("catE.jpg", true);
		writeImageToFile(color, "catE.jpg_color");
		writeImageToFile(gray, "catE.jpg_gray");
		Frame colorR = readImageFromFile("catE.jpg", false);
		Frame grayR = readImageFromFile("catE.jpg", true);
		colorR.rotate90();
		grayR.rotate90();
		writeImageToFile(colorR, "catE.jpg_colorRotated");
		writeImageToFile(grayR, "catE.jpg_grayRotated");
		Frame colorSmooth = readImageFromFile("catE.jpg", false);
		Frame graySmooth = readImageFromFile("catE.jpg", true);
		colorSmooth.smooth(15);
		graySmooth.smooth(15);
		writeImageToFile(colorSmooth, "catE.jpg_colorSmooth");
		writeImageToFile(graySmooth, "catE.jpg_graySmooth");

		Frame colorcrop = readImageFromFile("catE.jpg", false);
		Frame graycrop = readImageFromFile("catE.jpg", true);

		colorcrop.crop(100, 100);
		graycrop.crop(100, 100);

		colorcrop.getPixel(10, 10);
		graycrop.getPixel(10, 10);

		writeImageToFile(colorcrop, "catE.jpg_colorcrop");
		writeImageToFile(graycrop, "catE.jpg_graycrop");

		Frame colorAddfrom = readImageFromFile("catE.jpg", false);
		Frame grayAddfrom = readImageFromFile("catE.jpg", true);

		colorAddfrom.addFrom(colorAddfrom);
		grayAddfrom.addFrom(grayAddfrom);

		writeImageToFile(colorAddfrom, "catE.jpg_colorAddFrame");
		writeImageToFile(grayAddfrom, "catE.jpg_grayAddFrame");

		FrameContainer part2 = new FrameContainer("readFrame.txt", true);

		Frame[] arr = new Frame[3];
		arr[0] = colorAddfrom;
		arr[1] = colorcrop;
		arr[2] = graySmooth;
		part2.sort(arr);
		part2.get(1);
		part2.smoothAll(arr, 3);

		
	}

}
