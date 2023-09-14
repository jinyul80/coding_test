package programmers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExpiryDateTest {

    ExpiryDate expiryDate = new ExpiryDate();

    @Test
    void solution() {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        int[] result = expiryDate.solution(today, terms, privacies);

        assertArrayEquals(result, new int[]{1, 3});
    }
}