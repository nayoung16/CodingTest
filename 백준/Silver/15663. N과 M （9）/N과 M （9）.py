from itertools import permutations

n, m = map(int, input().split())
numbers = sorted(map(int, input().split()))

seen = set()

for p in permutations(numbers, m):
    if p not in seen:
        seen.add(p)
        print(*p)