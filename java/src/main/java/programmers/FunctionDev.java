package programmers;

import java.util.ArrayList;
import java.util.List;

public class FunctionDev {

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            // 현재 인덱스의 기능을 개발하는데 필요한 날짜 계산
            double day = (double) (100 - progresses[i]) / speeds[i];
            int dayUp = (int) Math.ceil(day);

            // 함께 배포 가능한 인덱스 찾기
            int j = i + 1;
            for (; j < progresses.length; j++) {
                // j 인덱스의 완료율 + (i 인덱스의 필요 날짜 * j 인덱스의 speed)가
                // 100 미만이면 함께 배포 못함
                if (progresses[j] + dayUp * speeds[j] < 100) {
                    break;
                }
            }
            // 함께 배포 가능한 인덱스 개수 추가
            answer.add(j - i);
            i = j - 1;
        }

        return answer
            .stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }

}
