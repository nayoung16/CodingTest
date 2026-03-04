import sys
input = sys.stdin.readline
n,m = map(int, input().split())

titles = []
powers = []

for _ in range(n):
    string, strength = input().split()
    titles.append(string)
    powers.append(int(strength))

from bisect import bisect_left
# 값이 들어갈 가장 왼쪽 위치의 인덱스 리턴

for _ in range(m):
    cur_strength = int(input())
    idx = bisect_left(powers,cur_strength)
    print(titles[idx])