package tree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinaryTreeTest {

    BinaryTree bt = new BinaryTree();

    @Test
    void test1() {
        long[] numbers = {7, 42, 5};

        int[] result = bt.solution(numbers);
        int[] actual = {1, 1, 0};

        assertArrayEquals(result, actual);
    }

    @Test
    void test2() {
        long[] numbers = {63, 111, 95};

        int[] result = bt.solution(numbers);
        int[] actual = {1, 1, 0};

        assertArrayEquals(result, actual);
    }
}