from queue import PriorityQueue


def solution(e, paths, gates, summits):
    graph = [[] for _ in range(e + 1)]
    for s, e, w in paths:
        graph[s].append((e, w))
        graph[e].append((s, w))

    visited = [False] * (n + 1)

    dist: list[int] = [float("inf")] * (n + 1)

    queue = PriorityQueue()

    for v in gates:
        dist[v] = 0
        queue.put((0, v))

    while queue.qsize() > 0:
        cur = queue.get()
        cur_idx = cur[1]

        visited[cur_idx] = True

        for ni, nw in graph[cur_idx]:
            dist[ni] = min(dist[cur_idx] + nw, dist[ni])

            if not visited[ni] and ni not in summits:
                queue.put((dist[ni], ni))

    print(dist)


test_case = [
    [
        6,
        [
            [1, 2, 3],
            [2, 3, 5],
            [2, 4, 2],
            [2, 5, 4],
            [3, 4, 4],
            [4, 5, 3],
            [4, 6, 1],
            [5, 6, 1],
        ],
        [1, 3],
        [5],
        [5, 3],
    ]
]

for n, paths, gates, summits, ans in test_case:
    solution(n, paths, gates, summits)
