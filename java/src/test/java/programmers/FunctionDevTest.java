package programmers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FunctionDevTest {

    FunctionDev functionDev = new FunctionDev();

    @Test
    void test1() {
        int[] progresses = {93, 30, 55};
        int[] speedes = {1, 30, 5};

        int[] result = functionDev.solution(progresses, speedes);
        int[] actual = {2, 1};

        assertArrayEquals(result, actual);
    }

    @Test
    void test2() {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speedes = {1, 1, 1, 1, 1, 1};

        int[] result = functionDev.solution(progresses, speedes);
        int[] actual = {1, 3, 2};

        assertArrayEquals(result, actual);
    }

}