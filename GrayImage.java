
public class GrayImage implements Frame, Comparable<Frame> {

	private int[][] frame;
	
	public void rotate90() {
		int[][] r = new int[this.frame[0].length][this.frame.length];
		for (int x = 0; x < r[0].length; x++) {
			for (int y = 0; y < r.length; y++) {
				r[y][x] = this.frame[this.frame.length - x - 1][y];
			}
		}

		this.frame = r;
	};

	public GrayImage(GrayImage other) {
		// we have to do here deep copy so that the frame is not pointing to the same frame array objet
		this.frame = new int[other.frame.length][other.frame[0].length];
		for (int i = 0; i < frame.length; i++) {
			for (int j = 0; j < frame[i].length; j++) {
				this.frame[i][j] = other.frame[i][j];
			}
		}
	}


	public void smooth(int n) {
		if (n <= 2) {
			return;
		}

		if (n % 2 == 0) {
			n = n - 1;
		}


		int[][] arr = new int[this.frame.length][this.frame[0].length];
		for (int i = 0; i < this.frame.length; i++) {
			for (int j = 0; j < this.frame[0].length; j++) {
				arr[i][j] = this.frame[i][j];
			}
		}

		for (int i = 0; i < frame.length; i++) {
			for (int j = 0; j < frame[0].length; j++) {
				int avg = neighborsAvrage(arr, i, j, n);
				this.frame[i][j] = avg;
			}
		}
	};

	public int[] getPixel(int x, int y) {
		int p = 0;
		p = this.frame[x][y];

		// now we will return the pixel in an array

		int[] parr = new int[1];
		parr[0] = p;
		return parr;
	};

	public GrayImage(int[][] frame) {
		this.frame = new int[frame.length][frame[0].length];	
		for (int i = 0; i < frame.length; i++) {
			for (int j = 0; j < frame[i].length; j++) {
				this.frame[i][j] = frame[i][j];
			}
		}

		// we need to do deep copy so the frame is deep copyied
	}

	public static int neighborsAvrage(int[][] framepicture, int x, int y, int n) {

		int counter = 0;
		int sum = 0;
		int couner2 = (n - 1) / 2;
		for (int i = x - couner2; i <= x + couner2; i++) {
			for (int j = y - couner2; j <= y + couner2; j++) {
				if (i < 0 || j < 0) {
					continue;
				}
				if (i >= framepicture.length || j >= framepicture[0].length) {
					continue;
				} else {
					counter++;
					sum = sum + framepicture[i][j];
				}
			}
		}
		int avg = sum / counter;
		return avg;
	}



	public boolean isInside(int test[][], int x, int y) {

		if (x < 0 || y < 0 || x >= test.length || y >= test[0].length){
			return false;
		}

		return true;
	}

	public void crop(int x, int y) {

		if (x >= this.frame.length || y >= this.frame[0].length) {
			return;
		}


		int[][] cropycrop = new int[x+1][y+1];
		for (int i = 0; i <= x; i++) {
			for (int j = 0; j <= y; j++) {
				if(isInside(this.frame, i,j)) {
					cropycrop[i][j] = this.frame[i][j];
				}
			}
		}
		this.frame = cropycrop;
	};

	public void addFrom(Frame f) {

		int arr[][];
		int pixel[] = new int[3];

		if (f instanceof GrayImage) {
			arr = ((GrayImage) f).getFrame();
		} else {
			return;
		}

		if (arr.length == this.frame.length && arr[0].length == this.frame[0].length) {
			for (int x = 0; x < this.frame.length; x++) {
				for (int y = 0; y < this.frame[0].length; y++) {
					pixel = f.getPixel(x, y);
					if ((this.frame[x][y] + pixel[0]) > 255 * 255) {
						this.frame[x][y] = 255 * 255;
					} else {
						this.frame[x][y] = this.frame[x][y] + pixel[0];
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

		if (f instanceof RGBImage) {
			int arrayofpixel[][][];
			
			arrayofpixel = ((RGBImage)f).getFrame();
			// we have to check the size
			// we have to check the size
			// we have to check the size
			
			int size= this.frame.length * this.frame[0].length;
			int other = arrayofpixel[0].length * arrayofpixel[0][0].length;
			
			if (size> other)
				return 1;
			
			if (size< other)
				return -1;
			
			return 0;
		}
		
		else {
			int arrayofpixel[][];
			
			arrayofpixel = ((GrayImage)f).getFrame();
			
			int size= this.frame.length * this.frame[0].length;

			// we have to check the size
			int other = arrayofpixel.length * arrayofpixel[0].length;
			
			if (size> other)
				return 1;
			
			if (size< other)
				return -1;
			
			return 0;
		}
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
