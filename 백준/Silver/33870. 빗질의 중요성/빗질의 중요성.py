import sys

n,m = map(int, sys.stdin.readline().split())
puppy = list(map(int, sys.stdin.readline().split()))
schedule = list(map(int, sys.stdin.readline().split()))

puppy_days = [0] * n
messed = []
day = 1
while day < len(schedule) + 1:
    s = schedule[day-1]
    if (day - puppy_days[s-1]) > puppy[s-1] and (s-1) not in messed:
        messed.append(s-1)
    if (s-1) in messed:
        if day < len(schedule) and schedule[day] == s:
            messed.remove(s-1)
            day += 2
            puppy_days[s-1] = day
        else:
            day += 1
    else:
        puppy_days[s-1] = day
        day += 1

for i in range(n):
    if i not in messed:
        if (day - puppy_days[i]) > puppy[i]:
            messed.append(i)

print(len(messed))