n = int(input())
m = int(input())
board = [list(map(int, input().split())) for _ in range(n)]
trip = list(map(int, input().split()))

parent = list(range(n + 1))
rank = [0] * (n + 1)

def find(x):
    while parent[x] != x:
        parent[x] = parent[parent[x]]
        x = parent[x]
    return x

def union(a,b):
    ra = find(a)
    rb = find(b)
    if ra == rb:
        return
    if rank[ra] < rank[rb]:
        parent[ra] = rb
    elif rank[ra] > rank[rb]:
        parent[rb] = ra
    else:
        parent[rb] = ra
        rank[ra] += 1

for i in range(n):
    for j in range(n):
        if board[i][j] == 1:
            union(i + 1, j + 1)

root = find(trip[0])
for t in trip[1:]:
    if find(t) != root:
        print("NO")
        break
else:
    print("YES")
