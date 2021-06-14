import java.io.*;
import java.util.Arrays;

public class FrameContainer implements ContainerFunctions {
     private int actualSize;
    final int INITIAL_Size = 5;
    final int RESIZE_Size = 5;
    private Frame[] FrameArray;

    public FrameContainer() {
        this.FrameArray = new Frame[this.INITIAL_Size];
        actualSize = 0;
    }

    // copy constructor but not needed for this question
    // public FrameContainer(FrameContainer FC) {
    //     this.FrameArray = new Frame[FC.FrameArray.length];
    //     this.actualSize = FC.size();
    //     // deep copy not deep copy need to fix this
    //     for (int i = 0; i < this.actualSize; i++) {
    //         this.FrameArray[i] = FC.FrameArray[i];
    //     }
    // }

    public FrameContainer(String FileName, boolean gray) {
        this.FrameArray = new Frame[INITIAL_Size];
        this.actualSize = 0;
        try {
            FileReader fr = new FileReader(FileName);
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
    public Frame get(int i) {
        return this.FrameArray[i];
    }

    @Override
    public int size() {
        return actualSize;
    }

    @Override
    public void add(Frame f) {
        if(f == null)return;
        if (actualSize == FrameArray.length) {
            resize();
        }
        FrameArray[actualSize] = f;
        actualSize++;
    }

    public void resize() {
        Frame[] temp = new Frame[FrameArray.length + RESIZE_Size];
        // deep copy
        for (int i = 0; i < this.size(); i++) {
            temp[i] = this.FrameArray[i];
        }
        FrameArray = temp;
    }

    @Override
    public void remove(Frame f) {
        for (int i = 0; i < actualSize; i++) {
            if (FrameArray[i] == f) {
                FrameArray[i] = null;
                for (int j = i + 1; j < actualSize; j++) {
                    FrameArray[j - 1] = FrameArray[j];
                }
                actualSize--;
                break;
            }
        }

    }

    // @Override
    // public void sort(Frame[] f) {
        public void sort() {

            for (int i = 1; i<this.actualSize ; i++) {
                for (int j = 0; j<this.actualSize-1; j++) {    
                    int ans = 0;
                    if (this.FrameArray[j] instanceof GrayImage)     
                         ans = ((GrayImage)this.FrameArray[j]).compareTo(this.FrameArray[j+1]);    
                    else ans = ((RGBImage)this.FrameArray[j]).compareTo(this.FrameArray[j+1]);
    
                    if (ans == 1) {
                        Frame Temp;
                        if (this.FrameArray[j] instanceof GrayImage) {
                            Temp = new GrayImage((GrayImage)this.FrameArray[j]);            
                        }
                        else Temp = new RGBImage((RGBImage)this.FrameArray[j]);        
    
                        this.FrameArray[j] = this.FrameArray[j+1];
                        this.FrameArray[j+1] = Temp;
                    }
                }    
            }
        }
            
// Arrays.sort(this.FrameArray);
          
    
            // int size1;
            // int size2;
    
            // int arr1[][][];
            // int arr2[][];
    
            // for (int i = 0; i<actualSize - 1; i++) {
    
            //     if (f[i] instanceof GrayImage) {
            //         arr2 = ((GrayImage)f[i]).getFrame();
    
            //         size1 = arr2.length * arr2[0].length;
            //     }
    
            //     else {
    
            //         arr1 = ((RGBImage)f[i]).getFrame();
    
            //         size1 = arr1[0].length * arr1[0][0].length;
            //     }
    
            //     for (int j = i+1; j<actualSize; j++) {	
    
            //         if (f[j] instanceof GrayImage) {
            //             arr2 = ((GrayImage)f[j]).getFrame();
    
            //             size2 = arr2.length * arr2[0].length;
            //         }
    
            //         else {
    
            //             arr1 = ((RGBImage)f[j]).getFrame();
    
            //             size2 = arr1[0].length * arr1[0][0].length;
            //         }
    
            //         if (size1 < size2) {
    
            //             Frame hold;
    
            //             if (f[i] instanceof GrayImage) {
            //                 hold = new GrayImage((GrayImage)f[i]);	
            //             }
    
            //             else {
            //                 hold = new RGBImage((RGBImage)f[i]);		
            //             }
    
            //             f[i] = f[j];
            //             f[j] = hold;
            //         }
    
            //     }	
            // }
    
        // }

        // Arrays.sort(this.FrameArray);

        // for (int i = 1; i < actualSize - 1; i++) {
        //     for(int j = 0 ; j < actualSize - 1; j++){

        //         int answer = 0;
        //         if (f[i] instanceof GrayImage) {
        //             answer = ((GrayImage) f[i]).compareTo(f[j]);
        //         }else{
        //             answer = ((RGBImage)f[i]).compareTo(f[j]);
        //         }
        //         if(answer == 1){
        //             Frame hold;
        //             if(f[i] instanceof GrayImage){
        //                 hold = new GrayImage((GrayImage)f[i]);
        //             }
        //             else{
        //                 hold = new RGBImage((RGBImage)f[i]);
        //             }


        //         }


        //     }
            

        // }

        // int size1;
        // int size2;
        // int arr1[][][];
        // int arr2[][];
        // for (int i = 0; i<actualSize ; i++) {
        // if (f[i] instanceof GrayImage) {
        // arr2 = ((GrayImage)f[i]).getFrame();
        // size1 = arr2.length * arr2[0].length;
        // }
        // else {
        // arr1 = ((RGBImage)f[i]).getFrame();
        // size1 = arr1[0].length * arr1[0][0].length;
        // }
        // for (int j = i+1; j<actualSize; j++) {
        // if (f[j] instanceof GrayImage) {
        // arr2 = ((GrayImage)f[j]).getFrame();
        // size2 = arr2.length * arr2[0].length;
        // }
        // else {
        // arr1 = ((RGBImage)f[j]).getFrame();
        // size2 = arr1[0].length * arr1[0][0].length;
        // }
        // if (size1 > size2) {
        // Frame hold;
        // if (f[i] instanceof GrayImage) {
        // hold = new GrayImage((GrayImage)f[i]);
        // }
        // else {
        // hold = new RGBImage((RGBImage)f[i]);
        // }
        // f[i] = f[j];
        // f[j] = hold;
        // }

        // }
        // }

        // Arrays.sort(f);

        // int TheLengthOfFirst = 0;
        // ///
        // int TheLengthOfSecound = 0;
        // //
        // int firstArray[][][];
        // //
        // int secondArray[][];

        // for (int i = 0; i < actualSize - 1; i++) {

        // if (f[i] instanceof GrayImage) {
        // secondArray = ((GrayImage) f[i]).getFrame();

        // TheLengthOfFirst = secondArray.length * secondArray[0].length;
        // }

        // else if (f[i] instanceof RGBImage) {

        // firstArray = ((RGBImage) f[i]).getFrame();

        // TheLengthOfFirst = firstArray[0].length * firstArray[0][0].length;
        // }

        // for (int j = i + 1; j < actualSize; j++) {

        // if (f[j] instanceof GrayImage) {
        // secondArray = ((GrayImage) f[j]).getFrame();

        // TheLengthOfSecound = secondArray.length * secondArray[0].length;
        // }

        // else if(f[j] instanceof RGBImage ) {

        // firstArray = ((RGBImage) f[j]).getFrame();

        // TheLengthOfSecound = firstArray[0].length * firstArray[0][0].length;
        // }

        // if (TheLengthOfFirst < TheLengthOfSecound) {

        // Frame hold;

        // if (f[i] instanceof GrayImage) {
        // hold = new GrayImage((GrayImage) f[i]);
        // }

        // else {
        // hold = new RGBImage((RGBImage) f[i]);
        // }

        // f[i] = f[j];
        // f[j] = hold;
        // }

        // }
        // }

    

    // @Override
    // public void sort() {
    // // bubble sort
    // // https://www.youtube.com/watch?v=xli_FI7CuzA

    // // sort with implemented comparable interface
    // //
    // https://stackoverflow.com/questions/18895915/how-to-sort-an-array-of-objects-in-java
    // // Arrays.sort(this.FrameArray);

    // // for (int i = 1; i < f.length && f[i] != null; i++) {
    // // for (int j = 0; j < f.length - 1 && f[j] != null; j++) {
    // // int areaOfFirst = 0;
    // // int areaOfSecond = 0;
    // // if (f[j] instanceof GrayImage) {
    // // areaOfFirst = areaOfGrayImage((GrayImage) f[j]);
    // // } else if (f[i] instanceof RGBImage) {
    // // areaOfFirst = areaOfRGBImage((RGBImage) f[j]);
    // // } else {
    // // return;
    // // }
    // // if (f[j + 1] instanceof GrayImage) {
    // // areaOfSecond = areaOfGrayImage((GrayImage) f[j + 1]);
    // // } else if (f[j + 1] instanceof RGBImage) {
    // // areaOfSecond = areaOfRGBImage((RGBImage) f[j + 1]);
    // // } else {
    // // return;
    // // }
    // // if (areaOfFirst > areaOfSecond) {
    // // swap(f[j], f[j + 1]);
    // // }
    // // }
    // // }

    // for (int i = 1; i < this.actualSize; i++) {
    // for (int j = 0; j < this.actualSize; j++) {
    // int areaOfFirst = 0;
    // int areaOfSecond = 0;
    // if (this.FrameArray[j] instanceof GrayImage) {
    // areaOfFirst = areaOfGrayImage((GrayImage) this.FrameArray[j]);
    // } else if (this.FrameArray[i] instanceof RGBImage) {
    // areaOfFirst = areaOfRGBImage((RGBImage) this.FrameArray[j]);
    // } else {
    // return;
    // }
    // if (this.FrameArray[j + 1] instanceof GrayImage) {
    // areaOfSecond = areaOfGrayImage((GrayImage) this.FrameArray[j + 1]);
    // } else if (this.FrameArray[j + 1] instanceof RGBImage) {
    // areaOfSecond = areaOfRGBImage((RGBImage) this.FrameArray[j + 1]);
    // } else {
    // return;
    // }
    // if (areaOfFirst > areaOfSecond) {
    // swap(this.FrameArray[j], this.FrameArray[j + 1]);
    // }
    // }
    // }
    // }

    // public int areaOfGrayImage(GrayImage gi) {
    // int ArrayOffirstFrame[][] = gi.getFrame();
    // int areaOfFrame = ArrayOffirstFrame[0].length * ArrayOffirstFrame.length;
    // return areaOfFrame;
    // }

    // public int areaOfRGBImage(RGBImage color) {
    // int ArrayOffirstFrame[][][] = color.getFrame();
    // int areaOfFrame = ArrayOffirstFrame[0][0].length *
    // ArrayOffirstFrame[0].length;
    // return areaOfFrame;
    // }

    // public void swap(Frame first, Frame second) {

    // if (first instanceof GrayImage) {
    // int[][] a = ((GrayImage) first).getFrame();
    // }

    // Frame temp = first;
    // first = second;
    // second = temp;
    // }

    @Override
    public void rotateAll() {
        for (int i = 0; i < this.size() ; i++) {
            this.FrameArray[i].rotate90();
        }
    }

    @Override
    public void smoothAll(int n) {
        for (int i = 0; i <this.size(); i++) {
            this.FrameArray[i].smooth(n);
        }
    }
}
