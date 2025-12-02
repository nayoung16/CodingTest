from itertools import combinations

n,m = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]
houses = list()
chickens = list()
for i in range(n):
    for j in range(n):
        if graph[i][j] == 1:
            houses.append((i,j))
        elif graph[i][j] == 2:
            chickens.append((i,j))

def man_dist(chickens_list):
    dist = 0
    for house in houses:
        min_dist = float('inf')
        for chicken in chickens_list:
            cur_dist = abs(house[0] - chicken[0]) + abs(house[1] - chicken[1])
            min_dist = min(min_dist, cur_dist)
        dist += min_dist
    return dist


candidates = combinations(chickens,m)
result = float('inf')
for can in candidates:
    cur_result = man_dist(can)
    result = min(result, cur_result)
print(result)