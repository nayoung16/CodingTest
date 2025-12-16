n = int(input())
cranes = list(map(int, input().split()))
m = int(input())
boxes = list(map(int, input().split()))

cranes.sort(reverse=True)
boxes.sort(reverse=True)

if boxes and cranes[0] < boxes[0]:
    print(-1)
    exit()

visited = [False] * m
pos = [0] * n
moved = 0
time = 0

while moved < m:
    for i in range(n):
        while pos[i] < m:
            if not visited[pos[i]] and cranes[i] >= boxes[pos[i]]:
                visited[pos[i]] = True
                pos[i] += 1
                moved += 1
                break
            pos[i] += 1
    time += 1

print(time)