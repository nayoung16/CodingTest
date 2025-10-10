from collections import defaultdict

def solution(commands):
    answer = []
    graph = [[None] * 50 for _ in range(50)]
    
    N = 50
    SIZE = N * N
    parent = list(range(SIZE))
    value = [None] * SIZE
    
    def idx(r, c):
        return (int(r) - 1) * N + (int(c) - 1)

    def find(x):
        while parent[x] != x:
            parent[x] = parent[parent[x]]
            x = parent[x]
        return x

    def union(a, b):
        ra, rb = find(a), find(b)
        if ra == rb:
            return ra
        parent[ra] = rb
        return rb

    for c in commands:
        order = c.split()

        if order[0] == 'UPDATE':
            if len(order) == 4:
                r, c, v = order[1], order[2], order[3]
                root = find(idx(r, c))
                value[root] = v
                graph[int(r)-1][int(c)-1] = v

            else:
                v1, v2 = order[1], order[2]
                for i in range(SIZE):
                    if parent[i] == i and value[i] == v1:
                        value[i] = v2

        elif order[0] == 'MERGE':
            r1, c1, r2, c2 = order[1], order[2], order[3], order[4]
            a, b = idx(r1, c1), idx(r2, c2)
            ra, rb = find(a), find(b)
            if ra == rb:
                continue

            keep = value[ra] if value[ra] is not None else value[rb]

            new_root = union(ra, rb)
            value[new_root] = keep
            other = ra if new_root == rb else rb
            value[other] = None

            graph[int(r2)-1][int(c2)-1] = graph[int(r1)-1][int(c1)-1]

        elif order[0] == 'UNMERGE':
            r, c = order[1], order[2]
            target = idx(r, c)
            root = find(target)
            keep_val = value[root]

            members = []
            for i in range(SIZE):
                if find(i) == root:
                    members.append(i)

            for m in members:
                parent[m] = m
                value[m] = None
                mr, mc = divmod(m, N)
                graph[mr][mc] = None
                
            value[target] = keep_val
            tr, tc = int(r) - 1, int(c) - 1
            graph[tr][tc] = keep_val

        elif order[0] == 'PRINT':
            r, c = order[1], order[2]
            v = value[find(idx(r, c))]
            answer.append(v if v is not None else "EMPTY")
    return answer