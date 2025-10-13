from itertools import combinations

arr = [int(input()) for _ in range(9)]
target_sum = 100
result = []
for c in combinations(arr,7):
    if sum(c) == target_sum:
        result = c
        break
for w in result:
    print(w)