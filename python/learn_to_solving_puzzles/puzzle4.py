# 체스판 크기
max_size = 4


def queen_position(depth):
    # 현재 깊이가 체스판보다 크면 전체 출력
    if depth == max_size:
        for row in boards:
            print(row)
        print()
        return

    for col in range(max_size):
        find_queen = False
        # 현재 깊이 보다 위에 있는 행에서 퀸의 위치를 탐색
        # 같은 열 또는 대각선에 퀸이 존재하는지 체크
        for row in range(depth):
            if boards[row][col] == 1:
                find_queen = True
            else:
                diff = depth - row
                if (col - diff) >= 0 and boards[row][col - diff] == 1:
                    find_queen = True
                elif (col + diff) < max_size and boards[row][col + diff] == 1:
                    find_queen = True

        # 같은 열 또는 대각선에 퀸이 존재한다면 탐색 종료
        if find_queen:
            continue

        # 현재 위치에 퀸을 배치 시키고 다음 깊이에서 추가 탐색
        boards[depth][col] = 1
        queen_position(depth + 1)
        boards[depth][col] = 0


# 체스판 생성
boards = [[0 for _ in range(max_size)] for _ in range(max_size)]

# 퀸 위치 탐색
queen_position(0)
