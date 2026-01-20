import sys
from collections import deque
input = sys.stdin.readline

n,m,k,x = map(int, input().split())

graph = [[] for _ in range(n + 1)]

for _ in range(m):
    s, e = map(int, input().split())
    graph[s].append(e)

dist = [-1] * (n + 1)
dist[x] = 0
q = deque([x])

while q:
    u = q.popleft()
    if dist[u] == k:
        continue
    for v in graph[u]:
        if dist[v] == -1:
            dist[v] = dist[u] + 1
            q.append(v)
out = [str(i) for i in range(1, n + 1) if dist[i] == k]
sys.stdout.write("\n".join(out) if out else "-1")