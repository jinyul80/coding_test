from collections import deque


def solution(cacheSize, cities):
    answer = 0
    chche = []
    q = deque(chche, maxlen=cacheSize)

    for city in cities:
        city = city.lower()
        if city in q:
            q.remove(city)
            q.append(city)
            answer += 1

        else:
            q.append(city)
            answer += 5

    return answer


test_case = [
    [
        3,
        [
            "Jeju",
            "Pangyo",
            "Seoul",
            "NewYork",
            "LA",
            "Jeju",
            "Pangyo",
            "Seoul",
            "NewYork",
            "LA",
        ],
    ],
    [
        3,
        [
            "Jeju",
            "Pangyo",
            "Seoul",
            "Jeju",
            "Pangyo",
            "Seoul",
            "Jeju",
            "Pangyo",
            "Seoul",
        ],
    ],
    [
        5,
        [
            "Jeju",
            "Pangyo",
            "Seoul",
            "NewYork",
            "LA",
            "SanFrancisco",
            "Seoul",
            "Rome",
            "Paris",
            "Jeju",
            "NewYork",
            "Rome",
        ],
    ],
]

for case in test_case:
    print(solution(case[0], case[1]))
