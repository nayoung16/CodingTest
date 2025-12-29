n,m = map(int, input().split())
truth_people = list(map(int, input().split()))
truth_num = truth_people[0]
truth_people = set(truth_people[1:])

parent = list(range(n+1))
rank = [0] * (n+1)

parties = []

def find(x):
    while parent[x] != x:
        parent[x] = parent[parent[x]]
        x = parent[x]
    return x
def union(a,b):
    ra, rb = find(a), find(b)
    if ra == rb:
        return
    if rank[ra] < rank[rb]:
        parent[ra] = rb
    elif rank[ra] > rank[rb]:
        parent[rb] = ra
    else:
        parent[rb] = ra
        rank[ra] += 1


for _ in range(m):
    arr = list(map(int, input().split()))
    k = arr[0]
    people = arr[1:]
    parties.append(people)
    if k >= 2:
        first = people[0]
        for p in people[1:]:
            union(first, p)

truth_roots = set(find(p) for p in truth_people)

answer = 0
for people in parties:
    can_lie = True
    for p in people:
        if find(p) in truth_roots:
            can_lie = False
            break
    if can_lie:
        answer += 1
print(answer)