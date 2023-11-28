def solution(alp, cop, problems):
    # DP 테이블 최대 값 계산
    max_alp = max_cop = 0
    for alp_req, cop_req, _, _, _ in problems:
        max_alp = max(max_alp, alp_req)
        max_cop = max(max_cop, cop_req)

    # DP 테이블 초기화
    times = [[float("inf") for _ in range(max_cop + 1)] for _ in range(max_alp + 1)]

    # 시작 위치 설정
    alp = min(alp, max_alp)
    cop = min(cop, max_cop)

    # 시작 위치 값 초기화
    times[alp][cop] = 0

    # Bottom up 동적 계획법
    for a in range(alp, max_alp + 1):
        for c in range(cop, max_cop + 1):
            # 공부에 의한 알고력, 코딩력 향상
            if a + 1 <= max_alp:
                times[a + 1][c] = min(times[a + 1][c], times[a][c] + 1)
            if c + 1 <= max_cop:
                times[a][c + 1] = min(times[a][c + 1], times[a][c] + 1)

            # 문제 해결에 의한 보상
            for alp_req, cop_req, alp_rwd, cop_rwd, cost in problems:
                if a >= alp_req and c >= cop_req:
                    na = min(a + alp_rwd, max_alp)
                    nc = min(c + cop_rwd, max_cop)
                    times[na][nc] = min(times[na][nc], times[a][c] + cost)

    return times[-1][-1]


test_case = [
    [10, 10, [[10, 15, 2, 1, 2], [20, 20, 3, 3, 4]], 15],
    [0, 0, [[0, 0, 2, 1, 2], [4, 5, 3, 1, 2], [4, 11, 4, 0, 2], [10, 4, 0, 4, 2]], 13],
]

for alp, cop, problems, ans in test_case:
    result = solution(alp, cop, problems)
    break

    if result == ans:
        print("OK")
    else:
        print("FAIL")
