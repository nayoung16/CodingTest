n,m = map(int, input().split())
operations = [list(map(int, input().split())) for _ in range(m)]

parent = list(range(n+1))
rank = [0] * (n+1)

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

for op in operations:
    o,a,b = op
    if o == 0:
        union(a,b)
    else:
        if find(a) == find(b):
            print("YES")
        else:
            print("NO")