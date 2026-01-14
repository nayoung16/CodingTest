n = int(input())
people = []
for i in range(n):
    new_arr = list(input().split()) + [i]
    people.append(new_arr)
people.sort(key = lambda x : (int(x[0]) , x[2]))

for i in range(n):
    print(people[i][0], people[i][1])