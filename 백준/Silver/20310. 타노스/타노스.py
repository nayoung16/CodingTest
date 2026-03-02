s = input().strip()

remove0 = s.count('0') // 2
remove1 = s.count('1') // 2

mid = []
for ch in s:
    if ch == '1' and remove1 > 0:
        remove1 -= 1
    else:
        mid.append(ch)

ans = []
for ch in reversed(mid):
    if ch == '0' and remove0 > 0:
        remove0 -= 1
    else:
        ans.append(ch)

print(''.join(reversed(ans)))
