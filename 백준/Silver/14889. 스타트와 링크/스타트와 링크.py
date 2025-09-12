from itertools import combinations

N = int(input())
graph = [list(map(int, input().split())) for _ in range(N)]
start = [1]
link = []
min_result = float("inf")

def calculate(i,j):
    global graph
    return graph[i-1][j-1] + graph[j-1][i-1]

def calculateTeam():
    comb_start = combinations(start,2)
    comb_link = combinations(link,2)
    ability_start, ability_link = 0,0
    for s in comb_start:
        (i,j) = s
        ability_start += calculate(i,j)
    for l in comb_link:
        (i,j) = l
        ability_link += calculate(i,j)
    return abs(ability_start - ability_link)

numbers = [i for i in range(2,N+1)]
comb = combinations(numbers, N//2-1)
for c in comb:
    start = [1]
    link = []
    for i in c:
        start.append(i)
    for j in range(2,N+1):
        if j not in start:
            link.append(j)
    cur_result = calculateTeam()
    if cur_result < min_result:
        min_result = cur_result

print(min_result)