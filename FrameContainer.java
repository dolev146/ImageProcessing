import java.io.*;


public class FrameContainer implements ContainerFunctions {
    int actualSize;
    final int INITIAL_Size = 5;
    final int RESIZE_Size = 5;
    Frame[] FrameArray;

    public FrameContainer() {
        this.FrameArray = new Frame[this.INITIAL_Size];
        actualSize = 0;
    }

    // copy constructor but not needed for this question
    public FrameContainer(FrameContainer FC) {
        this.FrameArray = new Frame[FC.FrameArray.length];
        this.actualSize = FC.size();
        // deep copy
        for (int i = 0; i < this.actualSize; i++) {
            this.FrameArray[i] = FC.FrameArray[i];
        }
    }

    public FrameContainer(String FileName) {
        this.FrameArray = new Frame[INITIAL_Size];
        this.actualSize = 0;
        try {
            FileReader fr = new FileReader(FileName);
            BufferedReader bf = new BufferedReader(fr);
            String str;
            str = bf.readLine();
            while (str != null) {
                if (str != null) {
                    Frame f = MyImageIO.readImageFromFile(str, false);

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

    @Override
    public void sort(Frame[] f) {


        int size1;
        int size2;

        int arr1[][][];
        int arr2[][];

        for (int i = 0; i<actualSize - 1; i++) {

            if (f[i] instanceof GrayImage) {
                arr2 = ((GrayImage)f[i]).getFrame();

                size1 = arr2.length * arr2[0].length;
            }

            else {

                arr1 = ((RGBImage)f[i]).getFrame();

                size1 = arr1[0].length * arr1[0][0].length;
            }

            for (int j = i+1; j<actualSize; j++) {

                if (f[j] instanceof GrayImage) {
                    arr2 = ((GrayImage)f[j]).getFrame();

                    size2 = arr2.length * arr2[0].length;
                }

                else {

                    arr1 = ((RGBImage)f[j]).getFrame();

                    size2 = arr1[0].length * arr1[0][0].length;
                }

                if (size1 < size2) {

                    Frame hold;

                    if (f[i] instanceof GrayImage) {
                        hold = new GrayImage((GrayImage)f[i]);
                    }

                    else {
                        hold = new RGBImage((RGBImage)f[i]);
                    }

                    f[i] = f[j];
                    f[j] = hold;
                }

            }
        }




        // Arrays.sort(f);


        // int TheLengthOfFirst = 0;
        // ///
        // int TheLengthOfSecound = 0;
        //     //
        // int firstArray[][][];
        //         //
        // int secondArray[][];

        // for (int i = 0; i < actualSize - 1; i++) {

        //     if (f[i] instanceof GrayImage) {
        //         secondArray = ((GrayImage) f[i]).getFrame();

        //         TheLengthOfFirst = secondArray.length * secondArray[0].length;
        //     }

        //     else if (f[i] instanceof RGBImage)  {

        //         firstArray = ((RGBImage) f[i]).getFrame();

        //         TheLengthOfFirst = firstArray[0].length * firstArray[0][0].length;
        //     }

        //     for (int j = i + 1; j < actualSize; j++) {

        //         if (f[j] instanceof GrayImage) {
        //             secondArray = ((GrayImage) f[j]).getFrame();

        //             TheLengthOfSecound = secondArray.length * secondArray[0].length;
        //         }

        //         else if(f[j] instanceof RGBImage ) {

        //             firstArray = ((RGBImage) f[j]).getFrame();

        //             TheLengthOfSecound = firstArray[0].length * firstArray[0][0].length;
        //         }

        //         if (TheLengthOfFirst < TheLengthOfSecound) {

        //             Frame hold;

        //             if (f[i] instanceof GrayImage) {
        //                 hold = new GrayImage((GrayImage) f[i]);
        //             }

        //             else {
        //                 hold = new RGBImage((RGBImage) f[i]);
        //             }

        //             f[i] = f[j];
        //             f[j] = hold;
        //         }

        //     }
        // }

    }

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
    public void rotateAll(Frame[] f) {
        for (int i = 0; i < f.length && f[i] != null; i++) {
            f[i].rotate90();
        }
    }

    @Override
    public void smoothAll(Frame[] f, int n) {
        for (int i = 0; i < f.length; i++) {
            f[i].smooth(n);
        }
    }
}
