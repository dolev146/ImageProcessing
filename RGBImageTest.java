
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RGBImageTest {
    @Test
    void FirstTest() {
        int[][][] FirstArray = { 
            {{ 7, 5, 11, 1, 3, 6 },
            { 7, 5, 11, 1, 3, 6 },
             { 7, 5, 11, 1, 3, 6 },
              { 7, 5, 11, 1, 3, 6 }},

               {{ 7, 5, 11, 1, 3, 6 },
               { 7, 5, 11, 1, 3, 6 },
                { 7, 5, 11, 1, 3, 6 },
                 { 7, 5, 11, 1, 3, 6 }},


               {{ 7, 5, 11, 1, 3, 6 },
               { 7, 5, 11, 1, 3, 6 },
                { 7, 5, 11, 1, 3, 6 },
                 { 7, 5, 11, 1, 3, 6 }}
            
            
            
            };
        Frame color = new RGBImage(FirstArray);







        
        color.rotate90();
        int[][][] Frame = ((RGBImage) color).getFrame();

        int[][][] secondArray = { 
            { { 7, 7, 7, 7 },
            { 5, 5, 5, 5 },
             { 11, 11, 11, 11 },
              { 1, 1, 1, 1 },
               { 3, 3, 3, 3 },
               { 6, 6, 6, 6 }
            },
            { { 7, 7, 7, 7 },
            { 5, 5, 5, 5 },
             { 11, 11, 11, 11 },
              { 1, 1, 1, 1 },
               { 3, 3, 3, 3 },
               { 6, 6, 6, 6 }
            },
            { { 7, 7, 7, 7 },
            { 5, 5, 5, 5 },
             { 11, 11, 11, 11 },
              { 1, 1, 1, 1 },
               { 3, 3, 3, 3 },
               { 6, 6, 6, 6 }
            }
            
            };

        Assertions.assertArrayEquals(secondArray, Frame);
    }

    @Test
    void secondTest() {
        
        int[][][] arr = { 

            {{ 1, 2, 3 },
             { 4, 5, 6 },
              { 7, 8, 9 }},

            {{ 1, 2, 3 },
             { 4, 5, 6 },
              { 7, 8, 9 }},

            {{ 1, 2, 3 },
             { 4, 5, 6 },
              { 7, 8, 9 }},

           };

        Frame color = new RGBImage(arr);
        color.smooth(3);
        int[][][] ArrayOfFrame = ((RGBImage) color).getFrame();

        int[][][] arr2 = { 
            {{ 3, 3, 4 }, { 4, 5, 5 }, { 6, 6, 7 }},
            {{ 3, 3, 4 }, { 4, 5, 5 }, { 6, 6, 7 }},
            {{ 3, 3, 4 }, { 4, 5, 5 }, { 6, 6, 7 }},
         };


        Assertions.assertArrayEquals(arr2, ArrayOfFrame);
    }

    @Test
    void thirdTest() {

        int[][][] arr = { 
            {{ 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }},
            {{ 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }},
            {{ 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }},};

        Frame color = new RGBImage(arr);
        color.crop(1, 1);

        int[][][] ArrayOfFrame = ((RGBImage) color).getFrame();

        int[][][] arr2 = { 
            {{ 1, 2 }, { 4, 5 }},
            {{ 1, 2 }, { 4, 5 }},
            {{ 1, 2 }, { 4, 5 }},
         };

        Assertions.assertArrayEquals(arr2, ArrayOfFrame);
    }

    @Test
    void ForthTest() {
        int[][][] arr = {  {{ 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }},
        {{ 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }},
        {{ 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }}, };
        Frame color = new RGBImage(arr);

        color.addFrom(color);

        int[][][] ArrayOfFrame = ((RGBImage) color).getFrame();

        int[][][] arr2 = { 
            {{ 2, 4, 6 }, { 8, 10, 12 }, { 14, 16, 18 }},
            {{ 2, 4, 6 }, { 8, 10, 12 }, { 14, 16, 18 }},
            {{ 2, 4, 6 }, { 8, 10, 12 }, { 14, 16, 18 }},
         };
        Assertions.assertArrayEquals(arr2, ArrayOfFrame);
    }

    @Test
    void fithTest() {

        int[][][] arr = { 
        {    { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }},
        {    { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }},
        {    { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }},
        
        };

        Frame color = new RGBImage(arr);

        int[] a = color.getPixel(1, 1);

        int[] arr2 = { 5,5,5 };

        Assertions.assertArrayEquals(arr2, a);
    }

    

}
