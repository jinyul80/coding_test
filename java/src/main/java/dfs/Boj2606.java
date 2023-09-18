package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj2606 {
    /*
    바이러스 : 1번 노드와 연결된 노드의 개수 찾기
    입력
    7
    6
    1 2
    2 3
    1 5
    5 2
    5 6
    4 7

    출력
    4
     */


    static int N;
    static int M;
    static ArrayList<Integer>[] A;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        // 노드의 개수
        N = Integer.parseInt(br.readLine());
        // Edge의 개수
        M = Integer.parseInt(br.readLine());

        // 방문 배열 초기화
        visited = new boolean[N + 1];

        // 인접리스트 배열 초기화
        A = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        // Edge 정보 입력 받아 입력리스트에 저장
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            A[s].add(e);
            A[e].add(s);
        }

        // 1번 노드부터 DFS 실행
        int count = dfs(1, 0);

        // 1번 노드는 개수에서 제외
        count--;

        // 1번 노드와 연결된 노드의 개수 출력
        System.out.println(count);
    }

    private static int dfs(int idx, int count) {
        // 현재 인덱스 방문으로 저장
        visited[idx] = true;
        // 노드의 개수 증가
        count++;

        // 현재 인덱스에서 연결된 노드를 반복
        for (int next : A[idx]) {
            // 연결된 노드가 방문하지 않았을 경우만 DFS 실행
            if (!visited[next]) {
                count = dfs(next, count);
            }
        }

        // 노드의 개수 리턴
        return count;
    }
}
