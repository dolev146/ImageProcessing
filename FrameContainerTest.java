import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FrameContainerTest {
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

}
