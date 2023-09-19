package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj1450 {
    /*
    냅색 문제
    DFS만 적용할 경우 시간 초과 발생. 최대 2^30 경우의 수
    DFS + Binary search 방식으로 시간 복잡도를 최소화
     */

    static int N;
    static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // 물건의 무개를 2개 리스트로 나누어서 받기
        ArrayList<Integer> weight1 = new ArrayList<>();
        ArrayList<Integer> weight2 = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            if (i < N / 2) {
                weight1.add(Integer.parseInt(st.nextToken()));
            } else {
                weight2.add(Integer.parseInt(st.nextToken()));
            }
        }

        // DFS로 sum1 sum2 만들기
        ArrayList<Integer> sum1 = new ArrayList<>();
        ArrayList<Integer> sum2 = new ArrayList<>();

        dfs(0, 0, weight1, sum1);
        dfs(0, 0, weight2, sum2);

        // Sort 및 Binary search
        Collections.sort(sum2);
        int answer = 0;
        for (int i = 0; i < sum1.size(); i++) {
            // sum1 리스트에서 값 하나 가져와서
            // 무게 C에서 빼고 남은 값을 찾을 값으로 설정
            // sum2 리스트에서 찾을 값 이하를 값으로 가지는
            // 인덱스는 가능한 경우의 수로 판단
            int searchValue = C - sum1.get(i);
            answer += binarySearch(sum2, searchValue) + 1;
        }

        System.out.println(answer);

    }

    private static int binarySearch(ArrayList<Integer> sum, int target) {
        // 인덱스 초기화
        int left = 0;
        int right = sum.size() - 1;
        int mid = 0;
        int answer = -1;

        // 이진 탐색 시작
        while (left <= right) {
            // 중간 인덱스
            mid = (left + right) / 2;
            
            // 중앙 인덱스 값이 타겟 이하인 경우 오른쪽 리스트에서 찾기 반복
            if(sum.get(mid) <= target) {
                answer = mid;
                left = mid+1;
            } else {
                // 타겟 초과하는 경우 왼쪽 리스트에서 반복
                right = mid - 1;
            }
        }

        // 타겟의 마지막 인덱스
        return answer;
    }

    private static void dfs(int idx, int sum, ArrayList<Integer> weight,
        ArrayList<Integer> answer) {
        // 탈출 조건
        if (sum > C) {
            return;
        }
        if (idx == weight.size()) {
            // 모든 Item에 대해 케이스 설정하고 무게합이 C보다 작은 경우는 가능한 경우 추가
            answer.add(sum);
            return;
        }

        // 물건을 넣은 경우
        dfs(idx + 1, sum + weight.get(idx), weight, answer);

        // 물건을 안 넣은 경우
        dfs(idx + 1, sum, weight, answer);
    }

}
