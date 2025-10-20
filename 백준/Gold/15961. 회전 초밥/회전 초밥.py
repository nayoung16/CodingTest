from collections import defaultdict

n,d,k,c = map(int, input().split())
chobab = [int(input()) for _ in range(n)]
chobab += chobab[:k-1]
start, end = 0, k

cnt = [0] * (d + 1)
unique = 0
for i in range(k):
    s = chobab[i]
    if cnt[s] == 0:
        unique += 1
    cnt[s] += 1

max_d = unique + (1 if cnt[c] == 0 else 0)

target = min(d, k + 1)

while end < len(chobab):
    left = chobab[start]
    cnt[left] -= 1
    if cnt[left] == 0:
        unique -= 1

    right = chobab[end]
    if cnt[right] == 0:
        unique += 1
    cnt[right] += 1

    cur = unique + (1 if cnt[c] == 0 else 0)
    if cur > max_d:
        max_d = cur
        if max_d == target:
            break

    start += 1
    end += 1

print(max_d)