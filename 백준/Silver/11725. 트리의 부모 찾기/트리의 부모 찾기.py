import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

n = int(input().strip())

graph = [[] for _ in range(n+1)]
parents = [0] * (n+1)
visited = [False] * (n+1)
for _ in range(n-1):
    a,b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

def check(start):
    visited[start] = True
    for node in graph[start]:
        if not visited[node]:
            parents[node] = start
            check(node)

check(1)

for i in range(2,n+1):
    print(parents[i])