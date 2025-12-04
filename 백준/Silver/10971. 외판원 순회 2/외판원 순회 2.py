n = int(input())
graph = [list(map(int, input().split())) for _ in range(n)]
visited = [False for _ in range(n)]
answer = float('inf')

def dfs(start, now, depth, cost):
    global answer
    if cost >= answer:
        return

    if depth == n:
        if graph[now][start] != 0:
            answer = min(answer, cost + graph[now][start])
        return

    for nxt in range(n):
        if (not visited[nxt]) and graph[now][nxt] != 0:
            visited[nxt] = True
            dfs(start, nxt, depth+1, cost+graph[now][nxt])
            visited[nxt] = False

for start in range(n):
    visited = [False] * n
    visited[start] = True
    dfs(start, start, 1, 0)

print(answer)