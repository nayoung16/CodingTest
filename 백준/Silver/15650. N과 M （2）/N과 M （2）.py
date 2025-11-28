from itertools import combinations
n,m = map(int, input().split())
numbers = [i for i in range(1,n+1)]
results = combinations(numbers,m)
for result in results:
    print(*result)