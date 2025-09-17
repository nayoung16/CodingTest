T = int(input())

dp = [(1,0), (0,1)]

# 메모이제이션
for i in range(2, 41):
    c0 = dp[i-1][0] + dp[i-2][0]
    c1 = dp[i-1][1] + dp[i-2][1]
    dp.append((c0,c1))

for i in range(T):
    N = int(input())
    print(dp[N][0], dp[N][1])