import java.io.*;


public class FrameContainer implements ContainerFunctions {
     private int mySize;
    final int INIT_SIZE = 5;
    final int RESIZE = 5;
    private Frame[] framearr;

    public FrameContainer() {
        this.framearr = new Frame[this.INIT_SIZE];
        mySize = 0;
    }

    
    @Override
    public void rotateAll() {
        for (int i = 0; i < this.size() ; i++) {
            this.framearr[i].rotate90();
        }
    }

   

    public FrameContainer(String filename, boolean gray) {
        this.framearr = new Frame[INIT_SIZE];
        this.mySize = 0;
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader bf = new BufferedReader(fr);
            String str;
            str = bf.readLine();
            while (str != null) {
                if (str != null) {
                    Frame f = MyImageIO.readImageFromFile(str, gray);

                    Frame newFrame = ((RGBImage) f);
                    add(newFrame);

                    str = bf.readLine();
                }
            }
            bf.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void smoothAll(int n) {
        for (int i = 0; i <this.size(); i++) {
            this.framearr[i].smooth(n);
        }
    }

    @Override
    public Frame get(int i) {
        return this.framearr[i];
    }

    @Override
    public int size() {
        return mySize;
    }

    @Override
    public void add(Frame f) {
        if(f == null)return;
        if (mySize == framearr.length) {
            resize();
        }
        framearr[mySize] = f;
        mySize++;
    }

    public void resize() {

        //We learned in the lesson required to make a deep copy here
        Frame[] temp = new Frame[framearr.length + RESIZE];

        for (int i = 0; i < this.size(); i++) {
            temp[i] = this.framearr[i];
        }
        framearr = temp;
    }

    @Override
    public void remove(Frame f) {

// We learned in class that in order to perform the deletion process, iterations must be performed
//
        for (int i = 0; i < mySize; i++) {
            if (framearr[i] == f) {
                framearr[i] = null;
                for (int j = i + 1; j < mySize; j++) {
                    framearr[j - 1] = framearr[j];
                }
                mySize--;
                break;
            }
        }

    }

  
        public void sort() {


            // By the lesson we learned about sorting functions,
            // I used what we learned in the lesson to compare the sizes

            boolean issorted = true;
            for (int j = 0; j < this.framearr.length && issorted; j++) {
                issorted = false;
                for (int i = 0; i < this.framearr.length - 1 && this.framearr[i + 1] != null; i++) {
                    
                    if (this.framearr[i] instanceof RGBImage) {
                        if (((RGBImage) this.framearr[i]).compareTo(this.framearr[i + 1]) == -1) {
                            Frame temp = this.framearr[i];
                            this.framearr[i] = this.framearr[i + 1];
                            this.framearr[i + 1] = temp;
                            issorted = true;
                        }
                    }
                    if (this.framearr[i] instanceof GrayImage) {
                        if (((GrayImage) this.framearr[i]).compareTo(this.framearr[i + 1]) == -1) {
                            Frame temp = this.framearr[i];
                            this.framearr[i] = this.framearr[i + 1];
                            this.framearr[i + 1] = temp;
                            issorted = true;
                        }
                    }
    
                }
    
            }
        }
    


   
}
