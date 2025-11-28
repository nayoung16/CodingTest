n = int(input())
graph = [[0 for _ in range(n)] for _ in range(n)]
position = dict()
like = dict()

# 인접 - 상 하 좌 우
dy = [-1,1,0,0]
dx = [0,0,-1,1]

def getPosition1(friends):
    candidates = [[0 for _ in range(n)] for _ in range(n)]
    for friend in friends:
        for i in range(4):
            ny = friend[0]+dy[i]
            nx = friend[1]+dx[i]
            if 0 <= ny < n and 0 <= nx < n and graph[ny][nx] == 0:
                candidates[ny][nx] += 1
    max_val = max(max(row) for row in candidates)
    positions = []
    for i in range(n):
        for j in range(n):
            if candidates[i][j] == max_val and graph[i][j] == 0:
                positions.append((i,j))
    return positions

def getPosition2(positions):
    l = len(positions)
    count = [0] * l
    for j in range(l):
        position = positions[j]
        for i in range(4):
            ny = position[0] + dy[i]
            nx = position[1] + dx[i]
            if 0 <= ny < n and 0 <= nx < n and graph[ny][nx] == 0:
                count[j] += 1
    max_count = max(count)
    new_positions = []
    for i in range(l):
        if count[i] == max_count:
            new_positions.append(positions[i])
    return new_positions


for i in range(1,n*n+1):
    line = list(map(int, input().split()))
    student = line[0]
    like[student] = line[1:]
    if i == 1:
        position[student] = [1,1]
        graph[1][1] = student
        continue
    friends_pos = []
    for j in range(1,5):
        friend = line[j]
        if friend in position.keys():
            friends_pos.append(position[friend])

    positions = getPosition1(friends_pos)
    if len(positions) == 1:
        y,x = positions[0][0], positions[0][1]
        graph[y][x] = student
        position[student] = [y,x]
    else:
        new_positions = getPosition2(positions)
        new_positions.sort()
        y, x = new_positions[0][0], new_positions[0][1]
        graph[y][x] = student
        position[student] = [y, x]

# 만족도 계산
answer = 0
for y in range(n):
    for x in range(n):
        student = graph[y][x]
        cnt = 0
        for d in range(4):
            ny = y + dy[d]
            nx = x + dx[d]
            if 0 <= ny < n and 0 <= nx < n:
                if graph[ny][nx] in like[student]:
                    cnt += 1

        if cnt == 1:
            answer += 1
        elif cnt == 2:
            answer += 10
        elif cnt == 3:
            answer += 100
        elif cnt == 4:
            answer += 1000

print(answer)