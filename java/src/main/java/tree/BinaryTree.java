package tree;

public class BinaryTree {
    /*
    표현 가능한 이진트리(프로그래머스)
     */

    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            // 이진수로 변경
            String now = Long.toBinaryString(numbers[i]);

            // 트리 높이 계산
            int treeHeight = 0;
            while (Math.pow(2, treeHeight) - 1 < now.length()) {
                treeHeight++;
            }

            // 완전 포화 이진트리 노드 수 만큼 왼쪽에 '0' 추가
            int treeSize = (int) (Math.pow(2, treeHeight) - 1);
            while (treeSize > now.length()) {
                now = "0" + now;
            }

            // 이진탐색으로 트리로 표현 가능한지 체크
            answer[i] = checkBinaryTree(now);
        }

        return answer;
    }

    private int checkBinaryTree(String now) {
        // 중간 인덱스 계산
        int mid = now.length() / 2;
        // 중간 위치 값(부모 노드)
        char parents = now.charAt(mid);

        // 왼쪽 트리와 오른쪽 트리로 분리
        String leftChild = now.substring(0, mid);              // 처음부터 중간 바로 전까지
        String rightChild = now.substring(mid + 1); // 중간 다음부터 끝까지

        // 부모 노드가 '0' 이고 자식 노드가 '1'이 있으면 트리로 표현 불가능
        if (parents == '0' &&
            (leftChild.charAt(mid / 2) == '1' || rightChild.charAt(mid / 2) == '1')) {
            return 0;
        }

        // 분리된 트리가 3개 이상인 경우만 하위 트리가 있는 것으로 판단
        if (leftChild.length() >= 3) {
            // 왼쪽 트리로 재귀함수 호출
            if (checkBinaryTree(leftChild) == 0) {
                return 0;
            }
        }

        if (rightChild.length() >= 3) {
            if (checkBinaryTree(rightChild) == 0) {
                return 0;
            }
        }

        // 모두 트리로 표현 가능한 경우
        return 1;
    }
}
