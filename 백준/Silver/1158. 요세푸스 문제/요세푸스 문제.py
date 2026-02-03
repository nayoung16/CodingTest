import sys
from collections import deque

N, K = map(int, sys.stdin.readline().split())

queue = deque([i for i in range(1, N + 1)])
res = []
cnt = 0

while len(queue) > 0:
    temp = queue.popleft()

    queue.append(temp)
    cnt += 1
    if cnt == K:
        res.append(temp)
        queue.pop()
        cnt = 0
        
print("<", end='')
for i in range(0, len(res)):
    print(res[i], end = '')
    if i != len(res) - 1:
        print(", ", end='')
print(">", end='')