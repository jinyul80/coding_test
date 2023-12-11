"""
모두 똑같이 만들기
최소한의 명령으로 같은 값으로 만들기
구간의 개수가 작은쪽을 찾아서 뒤집으라고 표시
"""


def please_conform(caps: list[str]):
    caps = caps + [caps[0]]

    start = end = -1

    for i in range(1, len(caps)):
        if caps[i] != caps[i - 1]:
            if caps[i] != caps[0]:
                start = i
            else:
                end = i - 1
                if start == end:
                    print("Person at positions", start, "flip your cap!")
                else:
                    print(
                        "People in positions", start, " through", end, "flip your caps!"
                    )


caps = ["F", "F", "B", "B", "B", "F", "B", "B", "B", "F", "F", "B", "F"]
please_conform(caps)
