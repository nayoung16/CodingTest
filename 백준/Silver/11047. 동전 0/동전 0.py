N, K = map(int, input().split())
coins = [int(input()) for _ in range(N)]

count = 0
for coin in reversed(coins):  # 큰 동전부터 확인
    if K >= coin:
        count += K // coin   # 해당 동전 개수 더하기
        K %= coin            # 남은 금액 갱신

print(count)