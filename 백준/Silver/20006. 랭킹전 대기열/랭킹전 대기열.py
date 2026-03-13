import sys
input = sys.stdin.readline

p,m = map(int, input().split())
rooms = []
for _ in range(p):
    l,n = input().split()
    l = int(l)
    if not rooms:
        rooms.append([(l, n)])
        continue

    for i in range(len(rooms)):
        room = rooms[i]

        if room[0][0] - 10 <= l <= room[0][0] + 10 and len(room) < m:
            rooms[i].append((l, n))
            break
    else:
        rooms.append([(l, n)])

for room in rooms:
    room.sort(key=lambda x: x[1])

    if len(room) == m:
        print("Started!")
    else:
        print("Waiting!")

    for l, n in room:
        print(l, n)