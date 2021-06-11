
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GrayImageTest {
    @Test
    void test1() {
        int[][] arr = { { 4, 5, 9, 1, 3, 6 }, { 4, 5, 9, 1, 3, 6 }, { 4, 5, 9, 1, 3, 6 }, { 4, 5, 9, 1, 3, 6 } };
        Frame gray = new GrayImage(arr);
        gray.rotate90();
        int[][] ArrayOfFrame = ((GrayImage) gray).getFrame();

        int[][] arr2 = { { 4, 4, 4, 4 }, { 5, 5, 5, 5 }, { 9, 9, 9, 9 }, { 1, 1, 1, 1 }, { 3, 3, 3, 3 },
                { 6, 6, 6, 6 } };

        Assertions.assertArrayEquals(arr2, ArrayOfFrame);
    }

    @Test
    void test2() {
        int[][] arr = {
             { 1, 2, 3 },
              { 4, 5, 6 },
               { 7, 8, 9 }
             };
        Frame gray = new GrayImage(arr);
        gray.smooth(3);
        int[][] ArrayOfFrame = ((GrayImage) gray).getFrame();

        int[][] arr2 = {
             { 3, 3, 4 },
              { 4, 5, 5 },
               { 6, 6, 7 },
            
            };
        Assertions.assertArrayEquals(arr2, ArrayOfFrame);
    }

    @Test
    void test3() {
        int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        Frame gray = new GrayImage(arr);
        gray.crop(2, 2);

        int[][] ArrayOfFrame = ((GrayImage) gray).getFrame();

        int[][] arr2 = { { 1, 2 }, { 4, 5 } };

        Assertions.assertArrayEquals(arr2, ArrayOfFrame);
    }

    @Test
    void test4() {
        int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        Frame gray = new GrayImage(arr);

        gray.addFrom(gray);

        int[][] ArrayOfFrame = ((GrayImage) gray).getFrame();

        int[][] arr2 = { { 2, 4, 6 }, { 8, 10, 12 }, { 14, 16, 18 } };
        Assertions.assertArrayEquals(arr2, ArrayOfFrame);
    }

    @Test
    void test5() {

        int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        Frame gray = new GrayImage(arr);

        int[] a = gray.getPixel(1, 1);

        int[] arr2 = { 5 };

        Assertions.assertArrayEquals(arr2, a);
    }

}
