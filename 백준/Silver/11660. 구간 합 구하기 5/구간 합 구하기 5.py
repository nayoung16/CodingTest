n,m = map(int, input().split())
dp = [[0] * (n + 1) for _ in range(n + 1)]
for i in range(1, n + 1):
    row = list(map(int, input().split()))
    s = 0
    for j in range(1, n + 1):
        s += row[j - 1]
        dp[i][j] = dp[i - 1][j] + s

for _ in range(m):
    x1, y1, x2, y2 = map(int, input().split())
    print(dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1])