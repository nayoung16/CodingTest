from collections import deque

n,m = map(int, input().split())
friends = [[] for _ in range(n+1)]
for _ in range(m):
    a,b = map(int, input().split())
    friends[a].append(b)
    friends[b].append(a)

kevin_num = float('inf')
answer = 0
def bfs(start):
    dist = [-1] * (n+1)
    dist[start] = 0
    q = deque([start])
    while q:
        cur = q.popleft()
        for nxt in friends[cur]:
            if dist[nxt] == -1:
                dist[nxt] = dist[cur] + 1
                q.append(nxt)
    if -1 in dist[1:]:
        return float('inf')
    return sum(dist[1:])

for i in range(1,n+1):
    value = bfs(i)
    if value < kevin_num:
        kevin_num = value
        answer = i

print(answer)