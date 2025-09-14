from collections import deque

n = int(input()) # 보드 크기
k = int(input()) # 사과 개수
apples = [list(map(int, input().rstrip().split())) for _ in range(k)]
l = int(input()) # 뱀의 방향 변환 횟수
directions = [list(input().rstrip().split()) for _ in range(l)]

dx = [0,1,0,-1]
dy = [1,0,-1,0]
dir = 0 # 처음에 오른쪽을 향함

# 게임 시작 전 뱀이 있는 위치
snake = deque()
snake.append((1,1))

# 뱀의 머리 위치
x,y = 1,1
time = 0

def check(nx,ny):
    if (nx,ny) in snake:
        return False
    if nx < 1 or nx >= n+1 or ny < 1 or ny >= n+1:
        return False
    if [nx,ny] in apples:
        apples.pop(apples.index([nx,ny]))
        snake.append((nx,ny))
        return True
    snake.popleft()
    snake.append((nx,ny))
    return True

def changeDir(direction):
    global dir
    if direction == 'L':
        dir = (dir - 1) % 4
    if direction == 'D':
        dir = (dir + 1) % 4

while True:
    time += 1
    # 이동
    nx = x + dx[dir]
    ny = y + dy[dir]

    result = check(nx,ny)
    if not result:
        print(time)
        break
    else:
        x,y = nx,ny

    if directions != [] and time == int(directions[0][0]):
        changeDir(directions[0][1])
        directions.pop(0)


