from collections import deque

n,k = map(int, input().split())
MAX = 100000
dist = [-1] * (MAX + 1)
parent = [-1] * (MAX + 1)

def bfs(start):
    q = deque([start])
    dist[start] = 0
    parent[start] = -1

    while q:
        cur = q.popleft()

        if cur == k:
            return

        for nxt in (cur - 1, cur + 1, cur * 2):
            if 0 <= nxt <= MAX and dist[nxt] == -1:
                dist[nxt] = dist[cur] + 1
                parent[nxt] = cur
                q.append(nxt)

bfs(n)
print(dist[k])

path = []
cur = k
while cur != -1:
    path.append(cur)
    cur = parent[cur]

path.reverse()
print(*path)