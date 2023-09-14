package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14888 {
    /*
    연산자 끼워 넣기
    입력 : 6
           1 2 3 4 5 6
           2 1 1 1
     출력 : 54
            -24
     */

    static int N;
    static int num[];
    static int operator[] = new int[4];
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        N = Integer.parseInt(br.readLine());
        num = new int[N];

        // 숫자의 종류 초기화
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        // 사용 가능한 연산자의 개수 초기화(+, -, *, /)
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        Backtracking(num[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);

    }

    private static void Backtracking(int now, int index) {
        // 숫자를 모두 사용했으면 백트래킹 종료
        if (index == N) {
            MAX = Math.max(MAX, now);
            MIN = Math.min(MIN, now);
            return;
        }

        // 연산자를 사용할 수 있는 경우 재귀 함수로 계속해서 들어가기
        int i = 0;
        // + 선택
        if (operator[i] > 0) {
            operator[i]--;  // 연산자를 사용한 것으로 차감
            Backtracking(now + num[index], index+1);
            operator[i]++;  // 연산자 개수 복귀
        }
        // - 선택
        i = 1;
        if (operator[i] > 0) {
            operator[i]--;
            Backtracking(now - num[index], index+1);
            operator[i]++;
        }
        // 곱하기 선택
        i = 2;
        if (operator[i] > 0) {
            operator[i]--;
            Backtracking(now * num[index], index+1);
            operator[i]++;
        }
        // 나누기 선택
        i = 3;
        if (operator[i] > 0) {
            operator[i]--;
            Backtracking(now / num[index], index+1);
            operator[i]++;
        }
    }
}
