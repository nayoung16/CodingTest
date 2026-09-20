def solution(info, n, m):
    answer = 0
    # DP
    # B 흔적이 j일때 A의 최소 흔적 i
    INF = float('inf')
    dp = [INF] * m
    dp[0] = 0
    for a,b in info:
        next_dp = [INF] * m
        
        for j in range(m):
            if dp[j] == INF:
                continue
            
            # A가 훔치는 경우
            if dp[j] + a < n:
                next_dp[j] = min(next_dp[j], dp[j] + a)
                
            if j + b < m:
                next_dp[j+b] = min(next_dp[j+b], dp[j])
                
        dp = next_dp
    answer = min(dp)
    
    if answer == INF:
        return -1
    
    return answer