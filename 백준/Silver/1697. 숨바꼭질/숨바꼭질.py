from collections import deque

n,k = map(int, input().split())
MAX = 100000
dist = [-1] * (MAX + 1)

def bfs(start: int) -> int:
    q = deque([start])
    dist[start] = 0

    while q:
        cur = q.popleft()
        if cur == k:
            return dist[cur]

        for nxt in (cur - 1, cur + 1, cur * 2):
            if 0 <= nxt <= MAX and dist[nxt] == -1:
                dist[nxt] = dist[cur] + 1
                q.append(nxt)

    return dist[k]

print(bfs(n))