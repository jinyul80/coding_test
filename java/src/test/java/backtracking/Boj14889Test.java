package backtracking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Boj14889Test {

    Boj14889 obj = new Boj14889();

    @Test
    void test1() {

        int n = 4;
        int[][] score = {
            {0, 1, 2, 3},
            {4, 0, 5, 6},
            {7, 1, 0, 2},
            {3, 4, 5, 0}
        };

        int result = obj.solution(n, score);

        assertEquals(result, 0);
    }

    @Test
    void test2() {

        int n = 6;
        int[][] score = {
            {0, 1, 2, 3, 4, 5},
            {1, 0, 2, 3, 4, 5},
            {1, 2, 0, 3, 4, 5},
            {1, 2, 3, 0, 4, 5},
            {1, 2, 3, 4, 0, 5},
            {1, 2, 3, 4, 5, 0},
        };

        int result = obj.solution(n, score);

        assertEquals(result, 2);
    }
}