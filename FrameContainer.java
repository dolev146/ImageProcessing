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

    public FrameContainer(String FileName, boolean isGray) {
        this.FrameArray = new Frame[INITIAL_Size];
        this.actualSize = 0;
        try {
            FileReader fr = new FileReader(FileName);
            BufferedReader bf = new BufferedReader(fr);
            String str;
            str = bf.readLine();

            while (str != null) {

                if (str != null) {
                    Frame f = MyImageIO.readImageFromFile(str, isGray);
                    if (isGray) {
                        Frame newFrame = ((GrayImage) f);
                        add(newFrame);
                    } else {
                        Frame newFrame = ((RGBImage) f);
                        add(newFrame);
                    }
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
        // TODO Auto-generated method stub

        return null;
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
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f.length; j++) {
                int areaOfFirst = 0;
                int areaOfSecond = 0;
                if (f[i] instanceof GrayImage) {
                    areaOfFirst = areaOfGrayImage((GrayImage) f[i]);
                } else if (f[i] instanceof RGBImage) {
                    areaOfFirst = areaOfRGBImage((RGBImage) f[i]);
                } else{
                    return;
                }
                if (f[j] instanceof GrayImage) {
                    areaOfSecond = areaOfGrayImage((GrayImage) f[j]);
                } else if (f[j] instanceof RGBImage) {
                    areaOfSecond = areaOfRGBImage((RGBImage) f[j]);
                } else{
                    return;
                }
                if (areaOfFirst > areaOfSecond) {
                        swap(f[i], f[j]); 
                }
            }
        }

    }

    public int areaOfGrayImage(GrayImage gi) {
        int ArrayOffirstFrame[][] = gi.getFrame();
        int areaOfFrame = ArrayOffirstFrame[0].length * ArrayOffirstFrame.length;
        return areaOfFrame;
    }

    public int areaOfRGBImage(RGBImage color) {
        int ArrayOffirstFrame[][][] = color.getFrame();
        int areaOfFrame = ArrayOffirstFrame[0][0].length * ArrayOffirstFrame[0].length;
        return areaOfFrame;
    }

    public void swap(Frame first, Frame second) {
        Frame temp = first;
        first = second;
        second = temp;
    }

    @Override
    public void rotateAll(Frame[] f) {
        // TODO Auto-generated method stub

    }

    @Override
    public void smoothAll(Frame[] f, int n) {
        // TODO Auto-generated method stub

    }

}
