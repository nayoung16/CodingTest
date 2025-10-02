N,M = map(int, input().split())
price6 = []
price1 = []
for _ in range(M):
    a,b = map(int, input().split())
    price6.append(a)
    price1.append(b)

price6.sort()
price1.sort()

min6 = min(price6)
min1 = min(price1)

# 세 가지 경우 비교
answer = min(
    min6 * ((N // 6) + 1),                # 패키지로만 (넘치게 사기)
    min6 * (N // 6) + min1 * (N % 6),     # 패키지 + 낱개
    min1 * N                              # 낱개만
)

print(answer)