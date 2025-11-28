from itertools import combinations_with_replacement
n,m = map(int, input().split())
numbers = [i for i in range(1,n+1)]
results = combinations_with_replacement(numbers,m)
for result in results:
    print(*result)