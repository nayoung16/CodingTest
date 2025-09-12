from itertools import combinations

N = int(input())
S = [list(map(int, input().split())) for _ in range(N)]

players = list(range(N))
ans = float('inf')

def team_score(team):
    total = 0
    for i, j in combinations(team, 2):
        total += S[i][j] + S[j][i]
    return total

# 플레이어 0을 스타트팀에 고정해 대칭 제거
for start_rest in combinations(players[1:], N // 2 - 1):
    start = (0,) + start_rest
    link = [p for p in players if p not in start]

    diff = abs(team_score(start) - team_score(link))
    if diff < ans:
        ans = diff
        if ans == 0:  # 더 줄일 수 없음
            break

print(ans)
