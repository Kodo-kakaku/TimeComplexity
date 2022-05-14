import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class TimeComplexityTest {
    @Test
    @DisplayName("Checking correctness of classic algorithm")
    public void bubbleSortTest() {
        ArrayGlist<Integer> notSort = new ArrayGlist<>(Arrays.asList(4, 5, 6, 0, 3, 1, 2));
        ArrayGlist<Integer> sort = new ArrayGlist<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6));

        notSort.bubbleSort();
        Assert.assertEquals(notSort, sort);
    }

    @Test
    @DisplayName("Checking correctness of stream algorithm")
    public void streamBubbleSortTest() {
        ArrayGlist<Integer> notSort = new ArrayGlist<>(Arrays.asList(4, 5, 6, 0, 3, 1, 2));
        ArrayGlist<Integer> sort = new ArrayGlist<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6));

        notSort.streamBubbleSort();
        Assert.assertEquals(notSort, sort);
    }

    @Test
    @DisplayName("Speed test: Bubble sort -> bSort, Stream Bubble sort -> sbSort, Fast sort -> fSort")
    public void speedTest() {
        final int MAX_SIZE = 10000;

        ArrayGlist<Integer> bSort = new ArrayGlist<>();
        ArrayGlist<Integer> sbSort = new ArrayGlist<>();
        ArrayGlist<Integer> fSort = new ArrayGlist<>();

        for (int i = 0; i <= MAX_SIZE; i++) {
            bSort.add(new Random().nextInt(MAX_SIZE));
        }
        sbSort.addAll(bSort);
        fSort.addAll(sbSort);

        Assert.assertEquals(bSort, sbSort);
        Assert.assertEquals(sbSort, fSort);

        long startTime = System.currentTimeMillis();
        bSort.bubbleSort();
        System.out.printf("Bubble sort time: %d ms\n", System.currentTimeMillis() - startTime);

        startTime = System.currentTimeMillis();
        sbSort.streamBubbleSort();
        System.out.printf("Stream Bubble sort time: %d ms\n", System.currentTimeMillis() - startTime);

        startTime = System.currentTimeMillis();
        Collections.sort(fSort);
        System.out.printf("Fast sort time: %d ms\n", System.currentTimeMillis() - startTime);

        Assert.assertEquals(bSort, sbSort);
        Assert.assertEquals(sbSort, fSort);
    }
}
