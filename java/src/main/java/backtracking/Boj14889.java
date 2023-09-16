package backtracking;

import java.util.ArrayList;

public class Boj14889 {
    /*
    스타트와 링크
     */

    int N;
    int[][] scoreTabele;
    ArrayList<Integer> teamA;
    ArrayList<Integer> teamB;
    int scoreDiff = Integer.MAX_VALUE;

    public int solution(int n, int[][] score) {
        // 인원수
        N = n;
        // 시너지 테이블 초기화
        scoreTabele = score.clone();

        // 팀 리스트 초기화
        teamA = new ArrayList<>();
        teamB = new ArrayList<>();

        // 한 팀당 인원수
        int teamNumber = N / 2;

        // 재귀함수 호출
        recursive(0, teamNumber);

        return scoreDiff;
    }

    private void recursive(int order, int teamNumber) {

        // 팀 인원이 충족되면 스코어 비교, 재귀함수 종료
        if (teamNumber == 0) {
            // Team B 설정
            for (int i = 0; i < N; i++) {
                if (!teamA.contains(i)) {
                    teamB.add(i);
                }
            }
            // 스코어 비교
            checkScore();
            // Team B 초기화
            teamB.clear();
            return;
        }

        for (int i = order; i < N; i++) {
            // 현재 인덱스를 Team A에 추가
            teamA.add(i);

            //  필요 인원수 -1 적용하고, 다음 인덱스로 재귀함수 호출
            recursive(i + 1, teamNumber - 1);

            // 현재 인덱스를 Team A에서 제거
            teamA.remove(teamA.size() - 1);
        }
    }

    private void checkScore() {
        int teamAScore = 0;
        int teamBScore = 0;
        
        // 각 팀 멤버수는 전체의 절반
        for (int i = 0; i < N / 2 - 1; i++) {
            for (int j = i + 1; j < N /2; j++) {
                // Team A의 멤버별 시너지 조회
                int first = teamA.get(i);
                int second = teamA.get(j);
                teamAScore += scoreTabele[first][second];
                teamAScore += scoreTabele[second][first];

                // Team B의 멤버별 시너지 조회
                first = teamB.get(i);
                second = teamB.get(j);
                teamBScore += scoreTabele[first][second];
                teamBScore += scoreTabele[second][first];
            }
        }
        // 팀별 시너지 스코어 차이가 작은 값을 저장
        scoreDiff = Math.min(scoreDiff, Math.abs(teamAScore - teamBScore));
    }
}
