import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FrameContainerTest {
    @Test
    void test1() {
        //TODO sort
        int[][] arr = {          
                { 1, 1, 1, 1 },
                 { 1, 1, 1, 1 },
                  { 1, 1, 1, 1 },
                   { 1, 1, 1, 1 },         
            };            
        Frame gray = new GrayImage(arr);
        int[][] arr2 = {
             { 1, 1, 1, 1 },
              { 1, 1, 1, 1 },
               { 1, 1, 1, 1 } ,         
            };
        Frame gray2 = new GrayImage(arr2);
        int[][] arr3 = { 
            { 1, 1, 1, 1 },
             { 1, 1, 1, 1 }, 
     };
        Frame gray3 = new GrayImage(arr3);
        int[][] arr5 = { 
            { 1 },
             { 1 },
              { 1 },
               { 1 },     
        };
        Frame gray5 = new GrayImage(arr5);

        // int[][][] arr4 = { 
        // {    { 1 }, { 1 } },
        // {    { 1 }, { 1 } },
        // {    { 1 }, { 1 } },
        // };
        // Frame gray4 = new RGBImage(arr4);

        Frame[] ArrayOfFrame = { gray2, gray, gray5, gray3 };

        FrameContainer frameContainer = new FrameContainer();
        for (int i = 0; i < ArrayOfFrame.length; i++) {
            frameContainer.add(ArrayOfFrame[i]);
        }
        frameContainer.sort(frameContainer.FrameArray);

        // int[][][] ArrayOfmatrix = new int[4][][];
        // for (int i = 0; i < ArrayOfFrame.length; i++) {
        //     ArrayOfmatrix[i] = ((GrayImage) ArrayOfFrame[i]).getFrame();
        // }
 

        int[][][][] arr10 = { 
            // {{ { 1 }, { 1 } },
            // { { 1 }, { 1 } },
            // { { 1 }, { 1 } },},

            
    {{ { 1 }, { 1 }, { 1 }, { 1 }, },
    { { 1 }, { 1 }, { 1 }, { 1 }, },
    { { 1 }, { 1 }, { 1 }, { 1 }, },
    },


            {{ { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, },             
            { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, },             
            { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, },             },


                {{ { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, },
                { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, },
                { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, },},


                {{ { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, },
                { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, },
                { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, },}
                 

        };

        int arr9[][] = ((GrayImage) frameContainer.get(0)).getFrame();

        Assertions.assertArrayEquals(arr9, arr5);

    }

    @Test
    void test2() {
        int[][] arr = { { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, };
        Frame gray = new GrayImage(arr);

        int[][] arr2 = { { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, };
        Frame gray2 = new GrayImage(arr2);

        int[][] arr3 = { { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, };
        Frame gray3 = new GrayImage(arr3);

        int[][] arr4 = { { 1, 2 }, { 1, 2 }, { 1, 2 }, { 1, 2 }, };

        Frame gray4 = new GrayImage(arr4);

        int[][] arr5 = { { 1 }, { 1 }, { 1 }, { 1 }, };
        Frame gray5 = new GrayImage(arr5);

        Frame[] ArrayOfFrame = { gray, gray2, gray3, gray4, gray5, };

        FrameContainer frameContainer = new FrameContainer();
        for (int i = 0; i < ArrayOfFrame.length; i++) {
            frameContainer.add(ArrayOfFrame[i]);
        }

        frameContainer.remove(gray3);

        Assertions.assertEquals(gray, frameContainer.get(0));
        Assertions.assertEquals(gray2, frameContainer.get(1));
        Assertions.assertEquals(gray4, frameContainer.get(2));
        Assertions.assertEquals(gray5, frameContainer.get(3));

        // int[][][] ArrayOfmatrix = new int[3][][];
        // for(int i = 0 ; i < frameContainer.FrameArray.length ; i++){
        // ArrayOfmatrix[i] = ((GrayImage) frameContainer.FrameArray[i]).getFrame();
        // }

        // {
        // ((GrayImage) gray).getFrame() ,
        // ((GrayImage) gray2).getFrame() ,
        // ((GrayImage) gray3).getFrame() ,
        // ((GrayImage) gray4).getFrame() ,
        // ((GrayImage) gray5).getFrame() ,
        // };

        // int[][][] arr10 = {
        // {{1,1,1,1},
        // {2,2,2,2},
        // {3,3,3,3},
        // {4,4,4,4},} ,

        // {{1,1,1},
        // {2,2,2},
        // {3,3,3},
        // {4,4,4},} ,

        // {{1,1},
        // {2,2},
        // {3,3},
        // {4,4},} ,

        // { {1,1,1,1},
        // {2,2,2,2}},

        // { {1,1,1,1}}

        // };

        // Assertions.assertArrayEquals(arr10, ArrayOfmatrix);

    }

    @Test
    void test3() {
        int[][] arr = { { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, };
        Frame gray = new GrayImage(arr);

        int[][] arr2 = { { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, };
        Frame gray2 = new GrayImage(arr2);

        int[][] arr3 = { { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, };
        Frame gray3 = new GrayImage(arr3);

        int[][] arr4 = { { 1, 2 }, { 1, 2 }, { 1, 2 }, { 1, 2 }, };

        Frame gray4 = new GrayImage(arr4);

        int[][] arr5 = { { 1 }, { 1 }, { 1 }, { 1 }, };
        Frame gray5 = new GrayImage(arr5);

        Frame[] ArrayOfFrame = { gray, gray2, gray3, gray4, gray5, };

        FrameContainer frameContainer = new FrameContainer();
        frameContainer.rotateAll(ArrayOfFrame);
        int[][][] ArrayOfmatrix = { ((GrayImage) gray).getFrame(), ((GrayImage) gray2).getFrame(),
                ((GrayImage) gray3).getFrame(), ((GrayImage) gray4).getFrame(), ((GrayImage) gray5).getFrame(), };

        int[][][] arr10 = { { { 1, 1, 1, 1 }, { 2, 2, 2, 2 }, { 3, 3, 3, 3 }, { 4, 4, 4, 4 }, },

                { { 1, 1, 1 }, { 2, 2, 2 }, { 3, 3, 3 }, { 4, 4, 4 }, },

                { { 1, 1 }, { 2, 2 }, { 3, 3 }, { 4, 4 }, },

                { { 1, 1, 1, 1 }, { 2, 2, 2, 2 } },

                { { 1, 1, 1, 1 } }

        };

        Assertions.assertArrayEquals(arr10, ArrayOfmatrix);

    }

    @Test
    void test4() {
        //TODO add 

        int[][] arr = { { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, };
        Frame gray = new GrayImage(arr);

        int[][] arr2 = { { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, };
        Frame gray2 = new GrayImage(arr2);

        int[][] arr3 = { { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, };
        Frame gray3 = new GrayImage(arr3);

        int[][] arr4 = { { 1, 2 }, { 1, 2 }, { 1, 2 }, { 1, 2 }, };

        Frame gray4 = new GrayImage(arr4);

        int[][] arr5 = { { 1 }, { 1 }, { 1 }, { 1 }, };
        Frame gray5 = new GrayImage(arr5);

        Frame[] ArrayOfFrame = { gray, gray2, gray3, gray4, gray5, };

        FrameContainer frameContainer = new FrameContainer();
        frameContainer.rotateAll(ArrayOfFrame);
        int[][][] ArrayOfmatrix = { ((GrayImage) gray).getFrame(), ((GrayImage) gray2).getFrame(),
                ((GrayImage) gray3).getFrame(), ((GrayImage) gray4).getFrame(), ((GrayImage) gray5).getFrame(), };

        int[][][] arr10 = { { { 1, 1, 1, 1 }, { 2, 2, 2, 2 }, { 3, 3, 3, 3 }, { 4, 4, 4, 4 }, },

                { { 1, 1, 1 }, { 2, 2, 2 }, { 3, 3, 3 }, { 4, 4, 4 }, },

                { { 1, 1 }, { 2, 2 }, { 3, 3 }, { 4, 4 }, },

                { { 1, 1, 1, 1 }, { 2, 2, 2, 2 } },

                { { 1, 1, 1, 1 } }

        };

        Assertions.assertArrayEquals(arr10, ArrayOfmatrix);

    }

}
