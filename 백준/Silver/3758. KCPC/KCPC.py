import sys

input = sys.stdin.readline

T = int(input())
for _ in range(T):
    n, k, t, m = map(int, input().split())

    best = [[0]*k for _ in range(n)]
    cnt = [0]*n
    last = [0]*n

    for idx in range(m):
        team, prob, score = map(int, input().split())
        team -= 1
        prob -= 1
        if score > best[team][prob]:
            best[team][prob] = score
        cnt[team] += 1
        last[team] = idx

    rank = []
    for team in range(n):
        total = sum(best[team])
        rank.append((-total, cnt[team], last[team], team+1))

    rank.sort()

    for i, item in enumerate(rank, 1):
        if item[3] == t:
            print(i)
            break