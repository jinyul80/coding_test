def solution(n, arr1, arr2):
    answer = []

    for i, j in zip(arr1, arr2):
        s_map = bin(i | j)[2:].zfill(n).replace("1", "#").replace("0", " ")
        answer.append(s_map)

    return answer


test_case = [
    [5, [9, 20, 28, 18, 11], [30, 1, 21, 17, 28]],
    [6, [46, 33, 33, 22, 31, 50], [27, 56, 19, 14, 14, 10]],
]

for i, j, k in test_case:
    print(solution(i, j, k))
