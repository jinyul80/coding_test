package programmers;

public class DeliveryPickup {
    /*
    택배 배달과 수거하기
     */

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        // 배달 및 수거 가능 값
        int d_cap = 0;
        int p_cap = 0;

        for (int i = n - 1; i >= 0; i--) {
            // 현재 위치에 배달 및 수거 값을 더하기
            d_cap += deliveries[i];
            p_cap += pickups[i];

            // 배달 및 수거 해야 할 값이 있으면 현재 인덱스(거리)를 결과에 더하고
            // cap 값 만큼 배달 및 수거해야 할 값에서 빼기
            while (d_cap > 0 || p_cap > 0) {
                d_cap -= cap;
                p_cap -= cap;
                answer += (i + 1) * 2;
            }
        }

        return answer;
    }
}
