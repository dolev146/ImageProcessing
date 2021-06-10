
public class GrayImage implements Frame, Comparable<Frame> {

	private int[][] frame;

	public GrayImage(int[][] frame) {
		this.frame = frame;
		// deep copy
		// for (int i = 0; i < frame.length; i++) {
		// for (int j = 0; j < frame[i].length; j++) {
		// this.frame[i][j] = frame[i][j];
		// }
		// }
	}

	public GrayImage(GrayImage gI) {
		this.frame = gI.frame;
	}

	public void rotate90() {
		int[][] rotatedArray = new int[this.frame[0].length][this.frame.length];
		for (int x = 0; x < rotatedArray[0].length; x++) {
			for (int y = 0; y < rotatedArray.length; y++) {
				rotatedArray[y][x] = this.frame[this.frame.length - x - 1][y];
			}
		}

		this.frame = rotatedArray;
	};

	public void smooth(int n) {
		// https://www.youtube.com/watch?v=C_zFhWdM4ic
		// https://www.youtube.com/watch?v=ZoaEDbivmOE
		// https://www.youtube.com/watch?v=9JFjYMvLCX0

		if (n < 2) {
			return;
		}

		if (n % 2 == 0) {
			n = n - 1;
		}

		for (int i = 0; i < frame.length; i++) {
			for (int j = 0; j < frame[0].length; j++) {
				int avg = avgOfNeighbors(this.frame, i, j, n);
				this.frame[i][j] = avg;
			}
		}
	};

	public static int avgOfNeighbors(int[][] pic, int x, int y, int n) {

		int counter = 0;
		int sum = 0;
		int numberOfNeighbersToCount = (n - 1) / 2;
		for (int i = x - numberOfNeighbersToCount; i <= x + numberOfNeighbersToCount; i++) {
			for (int j = y - numberOfNeighbersToCount; j <= y + numberOfNeighbersToCount; j++) {
				if (i < 0 || j < 0) {
					continue;
				}
				if (i >= pic.length || j >= pic[0].length) {
					continue;
				} else {
					counter++;
					sum = sum + pic[i][j];
				}
			}
		}
		int avg = sum / counter;
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
		// video about casting and insance of
		// https://www.w3schools.com/java/ref_keyword_instanceof.asp
		// https://www.w3schools.com/java/java_type_casting.asp
		// https://www.youtube.com/watch?v=H0LNjF9PSeM

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
		
		if (f == null) {
			return -1;
		}

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

		return -1;
	};

	public int[][] getFrame() {
		return this.frame;
	}

	public int[][] getFrame(Frame f) {
		return this.frame;
	}
	public void setFrame(int[][] f) {
		
	}

}
