import heapq

n = int(input())
m = int(input())

graph = [[] for _ in range(n + 1)]

for _ in range(m):
    s, e, cost = map(int, input().split())
    graph[s].append((e, cost))
# 출발 도시 번호, 도착 도시 번호, 버스 비용
start, end = map(int, input().split())

INF = 10**15
dist = [INF] * (n+1)
dist[start] = 0

pq = []
heapq.heappush(pq, (0, start))
while pq:
    cur_cost, u = heapq.heappop(pq)
    if cur_cost > dist[u]:
        continue
        
    for v,w in graph[u]:
        new_cost = cur_cost + w
        if new_cost < dist[v]:
            dist[v] = new_cost
            heapq.heappush(pq, (new_cost, v))

print(dist[end])