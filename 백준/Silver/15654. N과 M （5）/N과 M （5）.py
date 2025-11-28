from itertools import permutations
n,m = map(int, input().split())
numbers = list(map(int, input().split()))
numbers.sort()
results = permutations(numbers,m)
for result in results:
    print(*result)