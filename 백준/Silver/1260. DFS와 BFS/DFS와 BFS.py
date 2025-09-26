from collections import deque

N,M,V = map(int, input().split())
vertex = [list(map(int, input().split())) for _ in range(M)]
graph = [[] for _ in range(N+1)]
for v in vertex:
    graph[v[0]].append(v[1])
    graph[v[1]].append(v[0])
    
for i in range(1, N+1):
    graph[i].sort()

visited_dfs = [False] * (N+1)
print_dfs = []
def dfs(V):
    visited_dfs[V] = True
    print_dfs.append(V)
    for v in graph[V]:
        if not visited_dfs[v]:
            dfs(v)

dfs(V)

visited = [False] * (N+1)
visited[V] = True
q = deque([V])
print_bfs = []

def bfs():
    while q:
        u = q.popleft()
        print_bfs.append(u)
        for v in graph[u]:
            if not visited[v]:
                visited[v] = True
                q.append(v)

bfs()

print(*print_dfs)
print(*print_bfs)