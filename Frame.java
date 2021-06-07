
public interface Frame {
	
	
	 void rotate90();
	
	 void smooth(int n);
	 
	 int[] getPixel(int x, int y);
	 
	 void crop(int x, int y );
	 
	 void addFrom(Frame f);
	 
	 
	 
	 

}
