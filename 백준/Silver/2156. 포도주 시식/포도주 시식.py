n = int(input())
drinks = [int(input()) for _ in range(n)]
dp = [0 for _ in range(n)]
for i in range(n):
    if i == 0:
        dp[i] = drinks[i]
    elif i == 1:
        dp[i] = drinks[i] + drinks[i-1]
    elif i == 2:
        # 가능한 경우: (0,1) / (0,2) / (1,2)
        dp[i] = max(dp[i-1], drinks[i] + drinks[i-1], drinks[i] + drinks[i-2])
    else:
        result1 = dp[i-1]
        result2 = dp[i-2] + drinks[i]
        result3 = dp[i-3] + drinks[i-1] + drinks[i]
        dp[i] = max(result1, result2, result3)

print(max(dp))