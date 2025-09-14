import sys
n = int(input())
schedule = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

# 부분 문제 풀이를 기록
# i번째 일까지 일했을 때 얻을 수 있는 최대 수익
dp = [0 for _ in range(n+1)]

for i in range(n):
    for j in range(i+schedule[i][0], n+1):
        if dp[j] < dp[i] + schedule[i][1]:
            dp[j] = dp[i] + schedule[i][1]

print(dp[-1])
