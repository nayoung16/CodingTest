import heapq

n,m = map(int, input().split())
graph = [[] for _ in range(n+1)]
for _ in range(m):
    a,b,c = map(int, input().split())
    graph[a].append((b,c))
    graph[b].append((a,c))

# 1부터 n까지 최소비용으로 연결
def dijkstra():
    dist = [float('inf')] * (n+1)
    dist[1] = 0
    queue = []
    heapq.heappush(queue, (0,1)) # (누적 비용, 노드)

    while queue:
        cost, now = heapq.heappop(queue)
        if dist[now] < cost:
            continue

        for nxt, weight in graph[now]:
            new_cost = weight + cost
            if new_cost < dist[nxt]:
                dist[nxt] = new_cost
                heapq.heappush(queue, (new_cost, nxt))
    return dist[n]

print(dijkstra())