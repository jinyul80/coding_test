package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Boj2667 {
    /*
    단지 번호 붙이기
    입력
    7
    0110100
    0110101
    1110101
    0000111
    0100000
    0111110
    0111000
    출력
    3
    7
    8
    9
     */

    static int N;
    static boolean[][] graph;
    static boolean[][] visited;
    static int[] dirY = {1, -1, 0, 0};
    static int[] dirX = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        // 지도의 크기
        N = Integer.parseInt(br.readLine());

        // 4방향 탐색을 위해 지도 크기 +2로 지도 생성
        graph = new boolean[N + 2][N + 2];
        visited = new boolean[N + 2][N + 2];

        // 지도 초기화
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                graph[i + 1][j + 1] = s.charAt(j) == '1';
            }
        }

        // 단지의 개수 결과 리스트
        ArrayList<Integer> countList = new ArrayList<>();

        // 지도 탐색
        // 모든 인덱스에 대해서 반복
        for (int y = 1; y < N + 1; y++) {
            for (int x = 1; x < N + 1; x++) {
                // 해당 인덱스 값이 "true" 이고 방문하지 않은 경우만 DFS 탐색
                if (graph[y][x] && !visited[y][x]) {
                    int count = dfs(y, x, 1);
                    countList.add(count);
                }
            }
        }

        // 결과 출력
        System.out.println(countList.size());

        // 오름차순 정렬
        Collections.sort(countList);
        for (int i = 0; i < countList.size(); i++) {
            System.out.println(countList.get(i));
        }
    }

    private static int dfs(int y, int x, int count) {
        // 현재 위치 방문으로 저장
        visited[y][x] = true;

        // 4방면 탐색
        for (int i = 0; i < dirY.length; i++) {
            int newY = y + dirY[i];
            int newX = x + dirX[i];

            // 다음 위치 값이 "true" 이고 방문하지 않은 경우 DFS 탐색
            if (graph[newY][newX] && !visited[newY][newX]) {
                count = dfs(newY, newX, count + 1);
            }
        }

        // 연결된 true의 개수 리턴
        return count;
    }
}
