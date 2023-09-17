package programmers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class KakaoEmoticonTest {

    KakaoEmoticon kakaoEmoticon = new KakaoEmoticon();

    @Test
    void test1() {
        int[][] users = {
            {40, 10000},
            {25, 10000}
        };

        int[] emoticons = {7000, 9000};

        int[] result = kakaoEmoticon.solution(users, emoticons);
        int[] actual = {1, 5400};

        assertArrayEquals(result, actual);
    }

    @Test
    void test2() {
        int[][] users = {
            {40, 2900},
            {23, 10000},
            {11, 5200},
            {5, 5900},
            {40, 3100},
            {27, 9200},
            {32, 6900}
        };

        int[] emoticons = {1300, 1500, 1600, 4900};

        int[] result = kakaoEmoticon.solution(users, emoticons);
        int[] actual = {4, 13860};

        assertArrayEquals(result, actual);
    }
}