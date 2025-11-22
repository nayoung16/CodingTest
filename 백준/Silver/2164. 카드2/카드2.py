from collections import deque
n = int(input())
q = deque([i for i in range(1,n+1)])
while len(q) > 1:
    q.popleft()
    cur = q.popleft()
    q.append(cur)

print(q[0])