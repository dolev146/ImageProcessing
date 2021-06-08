
public class GrayImage implements Frame, Comparable<Frame> {

	private int[][] frame;

	public GrayImage(int[][] frame) {
		this.frame = frame;
	}

	public GrayImage(GrayImage gI) {
		this.frame = gI.frame;
	}

	public void rotate90() {
		int[][] rotatedArray = new int[this.frame[0].length][this.frame.length];
		for (int i = 0; i < rotatedArray.length; i++) {
			for (int j = 0; j < rotatedArray[0].length; j++) {
				rotatedArray[i][j] = this.frame[j][i];
			}
		}
		this.frame = rotatedArray;
	};

	public void smooth(int n) {
		for (int i = 0; i < frame.length; i++) {
			for (int j = 0; j < frame[0].length; j++) {
				int avg = avgOfNeighbors(this.frame, i, j, n);
				this.frame[i][j] = avg;
			}
		}
	};

	public static int avgOfNeighbors(int[][] pic, int x, int y, int n) {
		int sum = 0;
		int k = (n - 1) / 2;
		for (int i = x - k; i <= x + k; i++) {
			for (int j = y - k; j <= y + k; j++) {
				if (i < 0 || j < 0) {
					continue;
				}
				if (i >= pic.length || j >= pic[0].length) {
					continue;
				} else {
					sum = sum + pic[i][j];
				}
			}
		}
		int avg = sum / (n * n);
		return avg;
	}

	public int[] getPixel(int x, int y) {
		int pixel = 0;
		pixel = this.frame[x][y];
		int[] pixelArray = new int[1];
		pixelArray[0] = pixel;
		return pixelArray;
	};

	public void crop(int x, int y) {
		int[][] croppedMatrix = new int[x][y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				croppedMatrix[i][j] = this.frame[i][j];
			}
		}
		this.frame = croppedMatrix;
	};

	public void addFrom(Frame f) {
		// first try
		/********************************* */

		// checking if the image is Gray of RGBA Color By The length of a pixel that
		// return
		// int[] pixelArray = f.getPixel(0, 0);
		// if (pixelArray.length != 3) {
		// return;
		// }

		// Loading array of the object that calling the method
		// MyImageIO.writeImageToFile(f, "catE.jpg");
		// int arr[][][] = MyImageIO.readImageFromFile("catE.jpg");

		// Now what we are doing is adding one Pixel at a time to the Cell of the matrix
		// // frame
		// if (arr[0].length == this.frame.length && arr[0][0].length ==
		// this.frame[0].length) {
		// for (int x = 0; x < this.frame.length; x++) {
		// for (int y = 0; y < this.frame[0].length; y++) {
		// pixelArray = f.getPixel(x, y);
		// this.frame[x][y] = this.frame[x][y] + pixelArray[0];
		// }

		// }

		// }

		/***************************************** */
		// second try

		int ArrayOfFrame[][];
		int pixelArray[] = new int[3];
		if (f instanceof GrayImage) {
			ArrayOfFrame = ((GrayImage) f).getFrame();
		} else {
			return;
		}

		if (ArrayOfFrame.length == this.frame.length && ArrayOfFrame[0].length == this.frame[0].length) {
			for (int x = 0; x < this.frame.length; x++) {
				for (int y = 0; y < this.frame[0].length; y++) {
					pixelArray = f.getPixel(x, y);
					if ((this.frame[x][y] + pixelArray[0]) > 255 * 255) {
						this.frame[x][y] = 255 * 255;
					} else {
						this.frame[x][y] = this.frame[x][y] + pixelArray[0];
					}
				}
			}
		}
		return;
	}

	@Override
	public int compareTo(Frame f) {
		int ArrayOfFrame[][];
		if (f instanceof GrayImage) {
			ArrayOfFrame = ((GrayImage) f).getFrame();

			int areaOfFrame = ArrayOfFrame[0].length * ArrayOfFrame.length;

			int areaOfThis = this.frame.length * this.frame[0].length;

			if (areaOfThis == areaOfFrame) {
				return 0;
			}
			if (areaOfThis > areaOfFrame) {
				return 1;
			}
			if (areaOfThis < areaOfFrame) {
				return -1;
			}
		}

		return 99;
	};

	public int[][] getFrame() {

		return frame;
	}

}
