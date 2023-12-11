"""
파티에 참석하기 가장 좋은 시간
시작시간, 끝나는 시간의 리스트에서
가장 많은 사람이 있는 시간대를 찾기
"""


def best_time_to_party(schedule: list[tuple[int]]):
    times = []

    for c in schedule:
        times.append((c[0], "start"))
        times.append((c[1], "end"))

    times = sorted(times, key=lambda x: x[0])

    max_count, time = choose_time(times)

    print("Best time to attend the party is at", time, "o'clock", ":", max_count)


def choose_time(times):
    rcount = 0
    max_count = time = 0

    for t in times:
        if t[1] == "start":
            rcount += 1
        elif t[1] == "end":
            rcount -= 1

        if rcount > max_count:
            max_count = rcount
            time = t[0]

    return max_count, time


sched = [
    (6.0, 8.0),
    (6.5, 12.0),
    (6.5, 7.0),
    (7.0, 8.0),
    (7.5, 10.0),
    (8.0, 9.0),
    (8.0, 10.0),
    (9.0, 12.0),
    (9.5, 10.0),
    (10.0, 11.0),
    (10.0, 12.0),
    (11.0, 12.0),
]

best_time_to_party(sched)
