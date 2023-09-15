package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ExpiryDate {
    /*
    개인정보 수집 유효기간
     */

    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};

        // 오늘 날짜 숫자
        int todayIntValue = dateToInt(today);

        // 종류별 유효기간
        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] termInfo = term.split(" ");
            termMap.put(termInfo[0], Integer.parseInt(termInfo[1]) * 28);
        }

        // 유효기간 만료된 리스트 추출
        ArrayList<Integer> destroyList = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] privacyInfo = privacies[i].split(" ");
            int privacyIntValue = dateToInt(privacyInfo[0]);
            int expiryValue = termMap.get(privacyInfo[1]);
            if (privacyIntValue+expiryValue <= todayIntValue) {
                destroyList.add(i+1);
            }
        }

        // List to Array
        answer = destroyList.stream()
            .mapToInt(Integer::intValue)
            .toArray();

        return answer;
    }

    private int dateToInt(String date) {
        // 인풋 예시) 2023.09.14
        String dateInfo[] = date.split("[.]");
        int year = Integer.parseInt(dateInfo[0].substring(2, 4));
        int month = Integer.parseInt(dateInfo[1]);
        int day = Integer.parseInt(dateInfo[2]);

        return year * 12 * 28 + month * 28 + day;
    }

}
