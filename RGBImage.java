
public class RGBImage implements Frame, Comparable<Frame> {

	int frame[][][];





	public void rotate90() {
		int[][][] rotate = new int[3][this.frame[0][0].length][this.frame[0].length];

		for (int x = 0; x < rotate[0][0].length; x++) {
			for (int y = 0; y < rotate[0].length; y++) {
				rotate[0][y][x] = this.frame[0][this.frame[0].length - x - 1][y];
				rotate[1][y][x] = this.frame[1][this.frame[1].length - x - 1][y];
				rotate[2][y][x] = this.frame[2][this.frame[2].length - x - 1][y];
			}
		}

	

		this.frame = rotate;
	}

	@Override
	public int compareTo(Frame f) {
		if (f == null) {
			return -1;
		}

		if (f instanceof RGBImage) {
			int arr[][][];

			arr = ((RGBImage) f).getFrame();

			int size = this.frame[0].length * this.frame[0][0].length;
			int other = arr[0].length * arr[0][0].length;

			if (size > other)
				return 1;

			if (size < other)
				return -1;

			return 0;
		}

		else {
			int arr[][];

			arr = ((GrayImage) f).getFrame();

			int my_size = this.frame[0].length * this.frame[0][0].length;
			int other = arr.length * arr[0].length;

			if (my_size > other)
				return 1;

			if (my_size < other)
				return -1;

			return 0;
		}
	};

	

	public static int avrageOfTheNeighbors(int[][][] MatrixArray, int x, int y, int LoopOfColors, int n) {
		int sum = 0;
		int counter = 0;
		int neighborsCounter = (n - 1) / 2;
		for (int i = x - neighborsCounter; i <= x + neighborsCounter; i++) {
			for (int j = y - neighborsCounter; j <= y + neighborsCounter; j++) {
				if (i < 0 || j < 0) {
					continue;
				}
				if (i >= MatrixArray[LoopOfColors].length || j >= MatrixArray[LoopOfColors][0].length) {
					continue;
				} else {
					counter++;
					sum = sum + MatrixArray[LoopOfColors][i][j];
				}
			}
		}
		int avg = sum / counter;
		return avg;
	}

	public int[] getPixel(int x, int y) {
		int r = 0;
		int g = 0;
		int b = 0;
		// now will add all of them to array of 3

		r = this.frame[0][x][y];
		g = this.frame[1][x][y];
		b = this.frame[2][x][y];

		// and we will return the array

		int[] p = { r, g, b };

		return p;
	};

	public RGBImage(RGBImage other) {
		this.frame = new int[3][other.frame[0].length][other.frame[0][0].length];
		
		for (int i = 0; i < frame[0].length; i++) {
			for (int j = 0; j < frame[0][0].length; j++) {
				this.frame[0][i][j] = other.frame[0][i][j];
				this.frame[1][i][j] = other.frame[1][i][j];
				this.frame[2][i][j] = other.frame[2][i][j];
			}
		}

	}

	public RGBImage(int frame[][][]) {
		this.frame = new int[3][frame[0].length][frame[0][0].length];
		for (int i = 0; i < frame[0].length; i++) {
			for (int j = 0; j < frame[0][0].length; j++) {
				this.frame[0][i][j] = frame[0][i][j];
				this.frame[1][i][j] = frame[1][i][j];
				this.frame[2][i][j] = frame[2][i][j];
			}
		}
	}

	public void crop(int x, int y) {


		if (x >= this.frame[0].length || y >= this.frame[0][0].length) {
			return;
		}

		int[][][] copycrop = new int[3][x+1][y+1];
		for (int colorloop = 0; colorloop < 3; colorloop++) {
			for (int i = 0; i <= x; i++) {
				for (int j = 0; j <= y; j++) {


					copycrop[colorloop][i][j] = this.frame[colorloop][i][j];



				}
			}
		}
		this.frame = copycrop;
	};

	public void addFrom(Frame f) {
	
	

		int arr[][][];
		int p[] = new int[3];
		if (f instanceof RGBImage) {
			arr = ((RGBImage) f).getFrame();
		} else {
			return;
		}

	
		if (arr[0].length == this.frame[0].length && arr[0][0].length == this.frame[0][0].length) {
			for (int x = 0; x < this.frame[0].length; x++) {
				for (int y = 0; y < this.frame[0][0].length; y++) {
					p = f.getPixel(x, y);

					if ((this.frame[0][x][y] + p[0]) >= 255) {
						this.frame[0][x][y] = 255;
					} else {
						this.frame[0][x][y] = this.frame[0][x][y] + p[0];
					}
					if ((this.frame[1][x][y] + p[1]) >= 255) {
						this.frame[1][x][y] = 255;
					} else {
						this.frame[1][x][y] = this.frame[1][x][y] + p[1];
					}
					if ((this.frame[2][x][y] + p[2]) >= 255) {
						this.frame[2][x][y] = 255;
					} else {
						this.frame[2][x][y] = this.frame[2][x][y] + p[2];
					}

				}
			}
		}
		return;

	};


	public void smooth(int n) {
	

		if (n < 2) {
			return;
		}

		if (n % 2 == 0) {
			n = n - 1;
		}

	// we will deep copy so that it is a diffrent adress
		int[][][] arr = new int[3][this.frame[0].length][this.frame[0][0].length];
		for (int i = 0; i < this.frame[0].length; i++) {
			for (int j = 0; j < this.frame[0][0].length; j++) {
				arr[0][i][j] = this.frame[0][i][j];
				arr[1][i][j] = this.frame[1][i][j];
				arr[2][i][j] = this.frame[2][i][j];
			}
		}

		for (int i = 0; i < frame[0].length; i++) {
			for (int j = 0; j < frame[0][0].length; j++) {

				int avg1 = avrageOfTheNeighbors(arr, i, j, 0, n);
				int avg2 = avrageOfTheNeighbors(arr, i, j, 1, n);
				int avg3 = avrageOfTheNeighbors(arr, i, j, 2, n);

				this.frame[0][i][j] = avg1;
				this.frame[1][i][j] = avg2;
				this.frame[2][i][j] = avg3;
			}
		}

	};



	public int[][][] getFrame() {
		return this.frame;
	}

}
