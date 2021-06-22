import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FrameContainerTest {
    @Test
    void FirstTest() {

		  int[][] FirstArray = {
               { 2, 2, 2, 2 },
                { 9, 9, 9, 9 },
                 { 5, 5, 5, 5 },
                  { 5, 5, 5, 5 }, };
		  Frame firstGray = new GrayImage(FirstArray);

		  int[][] thirdArray = { { 5, 5, 5, 5 }, { 5, 5, 5, 5 }, };
		  Frame thirdGray = new GrayImage(thirdArray);
  
		  int[][] fithArray = { { 5 }, { 5 }, { 5 }, { 5 }, };
		  Frame fithgray = new GrayImage(fithArray);
  
		  int[][] forthArray = { { 5 }, { 5 } };
		  Frame forthGray = new GrayImage(forthArray);
  
		  Frame[] ArrayOfFrame = {  firstGray, fithgray, thirdGray, forthGray };
  
		  FrameContainer frameContainer = new FrameContainer();
		  for (int i = 0; i < ArrayOfFrame.length; i++) {
			  frameContainer.add(ArrayOfFrame[i]);
		  }

		  frameContainer.sort();
           
           int[][] TheFirst = ((GrayImage)  frameContainer.get(0)).getFrame();

           Assertions.assertArrayEquals(forthArray, TheFirst);


    }

    @Test
    void secondTest() {
        int[][] FirstArray = { { 5, 9, 3, 4 }, { 5, 9, 3, 4 }, { 5, 9, 3, 4 }, { 5, 9, 3, 4 }, };
        Frame gray = new GrayImage(FirstArray);

        int[][] secondArray = { { 5, 9, 3, 4 }, { 5, 9, 3, 4 }, { 5, 9, 3, 4 }, };
        Frame secondGray = new GrayImage(secondArray);

        int[][] thirdArray = { { 5, 9, 3, 4 }, { 5, 9, 3, 4 }, };
        Frame thirdGray = new GrayImage(thirdArray);

        int[][] forthArray = { { 5, 9 }, { 5, 9 }, { 5, 9 }, { 5, 9 }, };

        Frame forthGray = new GrayImage(forthArray);

        int[][] fithArray = { { 5 }, { 5 }, { 5 }, { 5 }, };
        Frame FifthGray = new GrayImage(fithArray);

        Frame[] ArrayOfFrame = { gray, secondGray, thirdGray, forthGray, FifthGray, };

        FrameContainer frameContainer = new FrameContainer();
        for (int i = 0; i < ArrayOfFrame.length; i++) {
            frameContainer.add(ArrayOfFrame[i]);
        }

        frameContainer.remove(thirdGray);
        // we want to test every array
        Assertions.assertEquals(gray, frameContainer.get(0));
        // so we check every array
        Assertions.assertEquals(secondGray, frameContainer.get(1));
        // every array
        Assertions.assertEquals(forthGray, frameContainer.get(2));
        Assertions.assertEquals(FifthGray, frameContainer.get(3));

    
    }

    @Test
    void thirdTest() {
        // 
        int[][] arr = { { 9, 2, 3, 4 }, { 9, 2, 3, 4 }, { 9, 2, 3, 4 }, { 9, 2, 3, 4 }, };
        Frame gray = new GrayImage(arr);

        int[][] secondArray = { { 9, 2, 3, 4 }, { 9, 2, 3, 4 }, { 9, 2, 3, 4 }, };
        Frame secondGray = new GrayImage(secondArray);

        int[][] thirdArray = { { 9, 2, 3, 4 }, { 9, 2, 3, 4 }, };
        Frame thirdGray = new GrayImage(thirdArray);

        int[][] forthArray = { { 9, 2 }, { 9, 2 }, { 9, 2 }, { 9, 2 }, };

        Frame forthGray = new GrayImage(forthArray);

        int[][] fithArray = { { 9 }, { 9 }, { 9 }, { 9 }, };
        Frame FifthGray = new GrayImage(fithArray);

        Frame[] ArrayOfFrame = { gray, secondGray, thirdGray, forthGray, FifthGray, };

        FrameContainer frameContainer = new FrameContainer();
        for (int i = 0; i < ArrayOfFrame.length; i++) {
            frameContainer.add(ArrayOfFrame[i]);    
        }
        
        frameContainer.rotateAll();
        int[][][] ArrayOfmatrix = { ((GrayImage) frameContainer.get(0)).getFrame(), ((GrayImage) frameContainer.get(1)).getFrame(),
                ((GrayImage) frameContainer.get(2)).getFrame(), ((GrayImage) frameContainer.get(3)).getFrame(), ((GrayImage) frameContainer.get(4)).getFrame(), };

        int[][][] arr10 = { { 
            { 9, 9, 9, 9 }, { 2, 2, 2, 2 }, { 3, 3, 3, 3 }, { 4, 4, 4, 4 }, 
        },

                { {9,9,9 }, { 2, 2, 2 }, { 3, 3, 3 }, { 4, 4, 4 }, },

                { { 9, 9 }, { 2, 2 }, { 3, 3 }, { 4, 4 }, },

                { { 9, 9, 9, 9 }, { 2, 2, 2, 2 } },

                { { 9, 9, 9, 9 } }

        };

        Assertions.assertArrayEquals(arr10, ArrayOfmatrix);

    }

    @Test
    void ForthTest() {

        int[][] FirstArr = { 
            { 1, 2, 3,  },
             { 1, 2, 3,  },
              { 1, 2, 3, },
             };
        Frame FirstGray = new GrayImage(FirstArr);

        int[][] secondArray = { 
            { 1, 2, 3, 4 },
             { 1, 2, 3, 4 },
              { 1, 2, 3, 4 }, };
        Frame secondGray = new GrayImage(secondArray);

        int[][] thirdArray = { { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, };
        Frame thirdGray = new GrayImage(thirdArray);

        int[][] forthArray = { { 1, 2 }, { 1, 2 }, { 1, 2 }, { 1, 2 }, };

        Frame forthGray = new GrayImage(forthArray);

        int[][] fithArray = { { 1 }, { 1 }, { 1 }, { 1 }, };
        Frame FifthGray = new GrayImage(fithArray);

        Frame[] ArrayOfFrame = { FirstGray, secondGray, thirdGray, forthGray, FifthGray, };

        FrameContainer frameContainer = new FrameContainer();
        for (int i = 0; i < ArrayOfFrame.length; i++) {
            frameContainer.add(ArrayOfFrame[i]);    
        }
        frameContainer.smoothAll(3);
        int[][][] ArrayOfmatrix = { ((GrayImage) FirstGray).getFrame(), ((GrayImage) secondGray).getFrame(),
                ((GrayImage) thirdGray).getFrame(), ((GrayImage) forthGray).getFrame(), ((GrayImage) FifthGray).getFrame(), };

        int[][][] Last = {     
            {
                  { 1, 2, 2  },
                  { 1, 2, 2 },
                  { 1, 2, 2 },
            },

             {
                  { 1, 2, 3,3 },
                 { 1, 2, 3,3 },
                  { 1, 2, 3,3 },
                   
              },

                { 
                    { 1, 2 ,3,3},
                    { 1, 2 ,3,3},
                     
                      
                       
                     },

                { 
                    { 1, 1,},
                    { 1, 1 },
                    { 1, 1 },
                    { 1, 1 },

                    },

                { 
                    { 1}, {1}, {1}, {1},
                 },
                 };

       

        Assertions.assertArrayEquals(Last, ArrayOfmatrix);

    }

}
