
public class RGBImage implements Frame, Comparable<Frame> {

	int frame[][][];

	public RGBImage(int frame[][][]) {
		this.frame = frame;
	}

	public RGBImage(RGBImage rgbImage) {
		this.frame = rgbImage.frame;
	}

	public void rotate90() {
		int[][][] rotate = new int[3][this.frame[0][0].length][this.frame[0].length];

		for (int x = 0; x < 3; x++) {
			for (int i = 0; i < rotate[x].length; i++) {
				for (int j = 0; j < rotate[x][0].length; j++) {
					rotate[x][i][j] = this.frame[x][j][i];
				}
			}

		}

		this.frame = rotate;

	};

	public void smooth(int n) {
		for (int externalLoopOfColors = 0; externalLoopOfColors < 3; externalLoopOfColors++) {
			for (int i = 0; i < frame[externalLoopOfColors].length; i++) {
				for (int j = 0; j < frame[externalLoopOfColors][0].length; j++) {
					int avg = avrageOfTheNeighbors(this.frame, i, j, externalLoopOfColors, n);
					this.frame[externalLoopOfColors][i][j] = avg;
				}
			}
		}
	};

	public static int avrageOfTheNeighbors(int[][][] MatrixArray, int x, int y, int LoopOfColors, int n) {
		int sum = 0;
		int neighborsCounter = (n - 1) / 2;
		for (int i = x - neighborsCounter; i <= x + neighborsCounter; i++) {
			for (int j = y - neighborsCounter; j <= y + neighborsCounter; j++) {
				if (i < 0 || j < 0) {
					continue;
				}
				if (i >= MatrixArray[LoopOfColors].length || j >= MatrixArray[LoopOfColors][0].length) {
					continue;
				} else {
					sum = sum + MatrixArray[LoopOfColors][i][j];
				}
			}
		}
		int avg = sum / (n * n);
		return avg;
	}

	public int[] getPixel(int x, int y) {
		int RedPixel = 0;
		int GreenPixel = 0;
		int BluePixel = 0;
		RedPixel = this.frame[0][x][y];
		GreenPixel = this.frame[1][x][y];
		BluePixel = this.frame[2][x][y];

		int[] pixelArray = { RedPixel, GreenPixel, BluePixel };

		return pixelArray;
	};

	public void crop(int x, int y) {
		int[][][] croppedMatrix = new int[3][x][y];
		for (int externalLoop = 0; externalLoop < 3; externalLoop++) {
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					croppedMatrix[externalLoop][i][j] = this.frame[externalLoop][i][j];
				}
			}
		}
		this.frame = croppedMatrix;
	};

	public void addFrom(Frame f) {

		/*****  */
		// first try

		// // checking if the image is Gray of RGBA Color By The length of a pixel that
		// return
		// int[] pixelArray = f.getPixel(0, 0);
		// if (pixelArray.length != 1) {
		// return;
		// }

		// // Loading array of the object that calling the method
		// MyImageIO.writeImageToFile(f, "catE.jpg");
		// int arr[][][] = MyImageIO.readImageFromFile("catE.jpg");

		// // Now what we are doing is adding one Pixel at a time to the Cell of the
		// matrix
		// // frame , but we have to remember that in rgb the max value is 255
		// if (arr[0].length == this.frame[0].length && arr[0][0].length ==
		// this.frame[0][0].length) {
		// for (int x = 0; x < this.frame.length; x++) {
		// for (int y = 0; y < this.frame[0].length; y++) {
		// pixelArray = f.getPixel(x, y);
		// if( (this.frame[0][x][y] + pixelArray[0]) >= 255){
		// this.frame[0][x][y] = 255;
		// }
		// if( (this.frame[1][x][y] + pixelArray[0]) >= 255){
		// this.frame[1][x][y] = 255;
		// }
		// if( (this.frame[2][x][y] + pixelArray[0]) >= 255){
		// this.frame[2][x][y] = 255;
		// }
		// }

		// }

		// }

		// ********************** */

		// secound solution that is better because it doesnt require the file name

		int ArrayOfFrame[][][];
		int pixelArray[] = new int[3];
		if (f instanceof RGBImage) {
			ArrayOfFrame = ((RGBImage) f).getFrame();
		} else {
			return;
		}

		// // Now what we are doing is adding one Pixel at a time to the Cell of the
		// matrix
		// // frame , but we have to remember that in rgb the max value is 255
		if (ArrayOfFrame[0].length == this.frame[0].length && ArrayOfFrame[0][0].length == this.frame[0][0].length) {
			for (int x = 0; x < this.frame[0].length; x++) {
				for (int y = 0; y < this.frame[0][0].length; y++) {
					pixelArray = f.getPixel(x, y);

					if ((this.frame[0][x][y] + pixelArray[0]) >= 255) {
						this.frame[0][x][y] = 255;
					} else {
						this.frame[0][x][y] = this.frame[0][x][y] + pixelArray[0];
					}
					if ((this.frame[1][x][y] + pixelArray[1]) >= 255) {
						this.frame[1][x][y] = 255;
					}else {
						this.frame[1][x][y] = this.frame[1][x][y] + pixelArray[1];
					}
					if ((this.frame[2][x][y] + pixelArray[2]) >= 255) {
						this.frame[2][x][y] = 255;
					}else {
						this.frame[2][x][y] = this.frame[2][x][y] + pixelArray[2];
					}

				}
			}
		}
		return;

	};

	@Override
	public int compareTo(Frame f) {
		// if(this.frame.length ==){

		// }
		return 0;
	};

	public int[][][] getFrame() {
		return frame;
	}

}