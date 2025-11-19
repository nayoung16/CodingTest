import sys
input = sys.stdin.readline

n = int(input())
people = [int(input()) for _ in range(n)]
people.sort()

answer = 0
for i in range(1, n + 1):
    answer += abs(i - people[i - 1])

print(answer)