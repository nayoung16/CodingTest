from collections import defaultdict
import copy

# 방향 배열 (위에서부터 반시계 방향, 0-indexed)
dx_arr = [-1, -1, 0, 1, 1, 1, 0, -1]
dy_arr = [0, -1, -1, -1, 0, 1, 1, 1]

# 입력 받기
fishes = []
for _ in range(4):
    fish = list(map(int, input().split()))
    # ✅ 방향 -1 보정
    result = [[fish[i], fish[i + 1] - 1] for i in range(0, 8, 2)]
    fishes.append(result)

# 물고기 위치 저장
fishes_loc = defaultdict(list)
for i in range(4):
    for j in range(4):
        num, dir = fishes[i][j]
        fishes_loc[num] = [dir, i, j]  # 이미 보정된 방향 사용

# 초기 상어 상태
shark_x, shark_y = 0, 0
num, shark_dir = fishes[0][0]
sum_eat = num
del fishes_loc[num]
fishes[0][0] = [-1, shark_dir]  # fishes 배열도 0-indexed

answer = 0  # 결과 저장

# 물고기 이동
def move_all_fishes(fishes, fishes_loc):
    fish_nums = sorted(fishes_loc.keys())
    for fish_num in fish_nums:
        if fish_num not in fishes_loc:
            continue
        dir, x, y = fishes_loc[fish_num]
        for i in range(8):
            ndir = (dir + i) % 8
            nx = x + dx_arr[ndir]
            ny = y + dy_arr[ndir]
            if 0 <= nx < 4 and 0 <= ny < 4 and fishes[nx][ny][0] != -1:
                target_num, target_dir = fishes[nx][ny]
                # swap fishes
                fishes[x][y], fishes[nx][ny] = fishes[nx][ny], fishes[x][y]
                # update fishes_loc
                fishes_loc[fish_num] = [ndir, nx, ny]
                fishes[nx][ny][1] = ndir  # ✅ 물고기의 방향 업데이트!
                if target_num != 0:
                    fishes_loc[target_num] = [target_dir, x, y]
                    fishes[x][y][1] = target_dir  # ✅ swap 한 물고기의 방향도 업데이트!
                break

# DFS
def dfs(fishes, fishes_loc, shark_x, shark_y, shark_dir, total):
    global answer
    answer = max(answer, total)

    copied_fishes = copy.deepcopy(fishes)
    copied_fishes_loc = copy.deepcopy(fishes_loc)

    move_all_fishes(copied_fishes, copied_fishes_loc)

    for step in range(1, 4):
        nx = shark_x + dx_arr[shark_dir] * step
        ny = shark_y + dy_arr[shark_dir] * step

        if 0 <= nx < 4 and 0 <= ny < 4 and copied_fishes[nx][ny][0] != 0:
            next_fishes = copy.deepcopy(copied_fishes)
            next_fishes_loc = copy.deepcopy(copied_fishes_loc)

            eat_num, next_dir = next_fishes[nx][ny]
            next_fishes[nx][ny] = [-1, next_dir]  # fishes 배열은 0-indexed
            next_fishes[shark_x][shark_y] = [0, 0]

            del next_fishes_loc[eat_num]

            dfs(next_fishes, next_fishes_loc, nx, ny, next_dir, total + eat_num)

# 시작
dfs(fishes, fishes_loc, shark_x, shark_y, shark_dir, sum_eat)

# 결과 출력
print(answer)