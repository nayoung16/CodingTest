N = int(input())
numbers = list(map(int, input().split()))
B,C = map(int, input().split())

answer = N
for n in numbers:
    if n > B:
        n -= B
        answer += (n + C - 1) // C

print(answer)