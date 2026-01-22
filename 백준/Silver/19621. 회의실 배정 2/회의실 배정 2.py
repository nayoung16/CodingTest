n = int(input())
meetings = [list(map(int, input().split())) for _ in range(n)]
# 시작시간, 끝시간, 회의 인원

# 끝시간 오름차순으로 정렬
meetings.sort(key=lambda x : x[1])

# 내 기준으로 가장 늦게 끝나는 회의이면서 안겹치는 회의
p = [-1] * n
for i in range(0,n):
    for j in range(i-1,-1,-1):
        if meetings[i][0] >= meetings[j][1]:
            p[i] = j
            break


dp = [0] * n
dp[0] = meetings[0][2]
for i in range(1,n):
    # i번째 회의를 고르는 경우
    take = meetings[i][2]
    if p[i] != -1:
        take += dp[p[i]]
    # i번째 회의를 안 고르는 경우
    skip = dp[i-1]
    dp[i] = max(skip, take)
print(dp[-1])