from collections import deque
N = int(input())
q = deque()
out = []
for _ in range(N):
    op = input().split()
    if op[0] == "push":
        q.append(int(op[1]))
    elif op[0] == "pop":
        if q:
            out.append(q[0])
            q.popleft()
        else:
            out.append(-1)
    elif op[0] == "size":
        out.append(len(q))
    elif op[0] == "empty":
        if q:
            out.append(0)
        else:
            out.append(1)
    elif op[0] == "front":
        if q:
            out.append(q[0])
        else:
            out.append(-1)
    elif op[0] == "back":
        if q:
            out.append(q[-1])
        else:
            out.append(-1)
print("\n".join(map(str, out)))