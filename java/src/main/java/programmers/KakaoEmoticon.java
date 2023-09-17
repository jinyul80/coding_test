package programmers;

public class KakaoEmoticon {

    // 할인율 종류
    int[] discounts = {10, 20, 30, 40};
    // 각 케이스별 이모티콘의 할인율 배열
    int[] emoticon_dis;
    int subscribe = 0;
    int sumPrice = 0;

    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];

        // 케이스별 이모티콘 할인율 배열 초기화
        emoticon_dis = new int[emoticons.length];

        // 재귀함수 호출
        recursive(users, emoticons, 0, 0);

        // 결과 저장
        answer[0] = subscribe;
        answer[1] = sumPrice;

        return answer;
    }

    private void recursive(int[][] users, int[] emoticons, int idx, int count) {
        // 모든 이모티콘에 대해서 할인율을 정한 경우 유저별 체크 실행
        if (count == emoticons.length) {
            checkUsers(users, emoticons);
            return;
        }

        // 할인율 종류별로 모두 반복
        for (int dis : discounts) {
            emoticon_dis[idx] = dis;
            recursive(users, emoticons, idx + 1, count + 1);
            emoticon_dis[idx] = 0;
        }
    }

    private void checkUsers(int[][] users, int[] emoticons) {
        // 현재 할인율 케이스에 대한 구독수, 구매 합계 초기화
        int tempSubscribe = 0;
        int tempSumPrice = 0;

        // 유저별 반복
        for (int[] user : users) {
            // 유저별 구매 금액 합계
            int userSumPrice = 0;

            // 모든 이모티콘에 대해서 반복
            for (int idx =0; idx< emoticons.length; idx++) {
                int dis = emoticon_dis[idx];

                // 유저의 할인율 기준보다 더 할인한다면 구매
                if (user[0] <= dis) {
                    userSumPrice += emoticons[idx] * (100 - dis) / 100;
                }
            }

            // 유저의 최대 금액 이상이면 구독수에 더하기
            if (userSumPrice >= user[1]) {
                tempSubscribe++;
            } else {
                // 현재 할인율 케이스에 유저의 구매 합계금액 더하기
                tempSumPrice += userSumPrice;
            }
        }

        // 이전에 계산된 구독수보다 현재 케이스의 구독수가 크다면 값 갱신
        if (subscribe < tempSubscribe) {
            subscribe = tempSubscribe;
            sumPrice = tempSumPrice;
        } else if (subscribe == tempSubscribe && sumPrice < tempSumPrice) {
            sumPrice = tempSumPrice;
        }
    }
}
