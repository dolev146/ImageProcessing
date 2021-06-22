import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FrameContainerTest {
    @Test
    void FirstTest() {

        
//          // sort !!!
//          int[][] arr = {
            
//             { 1, 1, 1, 1 },
//              { 1, 1, 1, 1 },
//               { 1, 1, 1, 1 },
//                { 1, 1, 1, 1 }, 
    
//         };
//     Frame Gray = new GrayImage(arr);

//     int[][] arr2 = {
//          { 1, 1, 1, 1 },
//          { 1, 1, 1, 1 },
//          { 1, 1, 1, 1 } ,     
//         };
//     Frame Gray2 = new GrayImage(arr2);

//     int[][] arr3 = { 
//         { 1, 1, 1, 1 },
//         { 1, 1, 1, 1 },       
//  };
//     Frame Gray3 = new GrayImage(arr3);

//     int[][] arr5 = { 
//         { 1 },
//         { 1 },
//         { 1 },
//         { 1 },         
//     };
//     Frame Gray5 = new GrayImage(arr5);

//     Frame[] ArrayOfFrame = { Gray2, Gray, Gray5, Gray3 };

//     FrameContainer frameContainer = new FrameContainer();
//     for (int i = 0; i < ArrayOfFrame.length; i++) {
//         frameContainer.add(ArrayOfFrame[i]);
//     }
//     frameContainer.sort();

// //        int[][][] ArrayOfmatrix = new int[5][][];
// //        for (int i = 0; i < ArrayOfFrame.length; i++) {
// //            ArrayOfmatrix[i] = ((GrayImage) ArrayOfFrame[i]).getFrame();
// //        }

//     int arr9[][] = ((GrayImage) frameContainer.get(0)).getFrame(); 
//     int[][][][] arr10 = { 
//         // {{ { 1 }, { 1 } },
//         // { { 1 }, { 1 } },
//         // { { 1 }, { 1 } },},

        
// {{ { 1 }, { 1 }, { 1 }, { 1 }, },
// { { 1 }, { 1 }, { 1 }, { 1 }, },
// { { 1 }, { 1 }, { 1 }, { 1 }, },
// },


//         {{ { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, },             
//         { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, },             
//         { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, },             },


//             {{ { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, },
//             { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, },
//             { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, },},


//             {{ { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, },
//             { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, },
//             { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, },}
             

//     };
    



    
		  // sort !!!
		  int[][] arr9 = { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, };
		  Frame gray9 = new GrayImage(arr9);
  
		  int[][] arr2 = { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 } };
		  Frame gray2 = new GrayImage(arr2);
  
		  int[][] arr3 = { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, };
		  Frame gray3 = new GrayImage(arr3);
  
		  int[][] arr5 = { { 1 }, { 1 }, { 1 }, { 1 }, };
		  Frame gray5 = new GrayImage(arr5);
  
		  int[][] arr4 = { { 1 }, { 1 } };
		  Frame gray4 = new GrayImage(arr4);
  
		  Frame[] ArrayOfFrame = {  gray9, gray5, gray3, gray4 };
  
		  FrameContainer frameContainer = new FrameContainer();
		  for (int i = 0; i < ArrayOfFrame.length; i++) {
			  frameContainer.add(ArrayOfFrame[i]);
		  }

		  frameContainer.sort();
  
		//   int[][] ArrayOfmatrix = new int[6][];
		//   for (int i = 0; i < ArrayOfFrame.length; i++) {
		// 	  ArrayOfmatrix[i] = ((GrayImage) frameContainer.get(i)).getFrame();
		//   }

            
           int[][] arr10 = ((GrayImage)  frameContainer.get(0)).getFrame();

           Assertions.assertArrayEquals(arr4, arr10);


    }

    @Test
    void secondTest() {
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
    void thirdTest() {
        // 
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
        
        frameContainer.rotateAll();
        int[][][] ArrayOfmatrix = { ((GrayImage) frameContainer.get(0)).getFrame(), ((GrayImage) frameContainer.get(1)).getFrame(),
                ((GrayImage) frameContainer.get(2)).getFrame(), ((GrayImage) frameContainer.get(3)).getFrame(), ((GrayImage) frameContainer.get(4)).getFrame(), };

        int[][][] arr10 = { { { 1, 1, 1, 1 }, { 2, 2, 2, 2 }, { 3, 3, 3, 3 }, { 4, 4, 4, 4 }, },

                { { 1, 1, 1 }, { 2, 2, 2 }, { 3, 3, 3 }, { 4, 4, 4 }, },

                { { 1, 1 }, { 2, 2 }, { 3, 3 }, { 4, 4 }, },

                { { 1, 1, 1, 1 }, { 2, 2, 2, 2 } },

                { { 1, 1, 1, 1 } }

        };

        Assertions.assertArrayEquals(arr10, ArrayOfmatrix);

    }

    @Test
    void ForthTest() {
        //TODO add 

        int[][] arr = { 
            { 1, 2, 3,  },
             { 1, 2, 3,  },
              { 1, 2, 3, },
             };
        Frame gray = new GrayImage(arr);

        int[][] arr2 = { 
            { 1, 2, 3, 4 },
             { 1, 2, 3, 4 },
              { 1, 2, 3, 4 }, };
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
        frameContainer.smoothAll(3);
        int[][][] ArrayOfmatrix = { ((GrayImage) gray).getFrame(), ((GrayImage) gray2).getFrame(),
                ((GrayImage) gray3).getFrame(), ((GrayImage) gray4).getFrame(), ((GrayImage) gray5).getFrame(), };

        int[][][] arr10 = {     
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

       

        Assertions.assertArrayEquals(arr10, ArrayOfmatrix);

    }

}
