from collections import deque


def solution(queue1: list[int], queue2: list[int]):
    """
    두 큐의 합 같게 만들기 위한 최소 이동 횟수 구하기
    :param queue1:
    :param queue2:
    :return:
    """
    queue1 = deque(queue1)
    queue2 = deque(queue2)

    max_move_count = len(queue1) * 4

    max_num = max(max(queue1), max(queue2))
    sum1 = sum(queue1)
    sum2 = sum(queue2)

    answer = 0

    # 절대 해를 구할 수 없는 경우를 판단
    if (sum1 + sum2) % 2 != 0:
        return -1

    if max_num > (sum1 + sum2) / 2:
        return -1

    # Q1, Q2 합이 같을 때까지 반복
    while sum1 != sum2:
        # Q1, Q2 합이 큰쪽에서 작은쪽으로 요소를 이동
        if sum1 < sum2:
            temp_num = queue2.popleft()
            queue1.append(temp_num)
            sum1 += temp_num
            sum2 -= temp_num
            answer += 1

        elif sum1 > sum2:
            temp_num = queue1.popleft()
            queue2.append(temp_num)
            sum1 -= temp_num
            sum2 += temp_num
            answer += 1

        else:
            break

        # 최대 이동 횟수를 이상이면 해를 구할 수 없다고 판단
        if answer == max_move_count:
            answer = -1
            break

    return answer


test_case = [
    [[3, 2, 7, 2], [4, 6, 5, 1], 2],
    [[1, 2, 1, 2], [1, 10, 1, 2], 7],
    [[1, 1], [1, 5], -1],
]

for q1, q2, ans in test_case:
    result = solution(q1, q2)

    if result == ans:
        print("OK")
    else:
        print("FAIL")
