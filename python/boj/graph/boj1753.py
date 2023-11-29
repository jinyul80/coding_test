from queue import PriorityQueue

def dijkstra(node_count, start_idx, edge_list: list[list[int, int, int]]):
    
    # 인접 리스트 초기화
    A: list[list[int, int]] = [[] for _ in range(node_count + 1)]
    
    for edge in edge_list:
        s, e, w = edge
        A[s].append([e, w])

    # 방문 배열
    visited:list[int] = [False] * (node_count + 1)

    # 시작 노드 부터의 최단 거리 배열
    dist: list[int] = [float("inf")] * (node_count + 1)
    dist[start_idx] = 0

    # 우선 순위 큐 생성
    queue = PriorityQueue()
    queue.put((0, start_idx))

    while queue.qsize() > 0:
        # 가중치가 가장 작은 노드부터 반복
        cur:list[int, int] = queue.get()
        cur_idx = cur[1]

        # 현재 노드 방문 처리
        visited[cur_idx] = True

        n_info: list[int, int]
        for n_info in A[cur_idx]:
            n_idx = n_info[0]
            n_w = n_info[1]

            # 다음 노드의 거리값 업데이트
            dist[n_idx] = min(dist[cur_idx] + n_w, dist[n_idx])
            
            # 다음 노드가 방분하지 않았다면 큐에 추가
            if not visited[n_idx]:
                queue.put((dist[n_idx], n_idx))

    return dist[1:]


test_case = [
    [5, 1, [[5, 1, 1], [1, 2, 2], [1, 3, 3], [2, 3, 4], [2, 4, 5], [3, 4, 6]], [0, 2, 3, 7, float("inf")]]
]

for t_case in test_case:
    nc, s, e_list, ans = t_case


    result = dijkstra(nc, s, e_list)

    print(f"정답 : {ans}")
    print(f"풀이  : {result}")
