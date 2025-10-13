n = int(input())
def is_doom(cur):
    text = str(cur)
    series_6 = 0

    for i in range(len(text)):
        if text[i] == '6':
            series_6 += 1
        else:
            series_6 = 0
        if series_6 == 3:
            return True
    return False
cur = 1
n_doom = 0
while True:
    if is_doom(cur) == True:
        n_doom += 1
    if n_doom == n:
        print(cur)
        break
    cur += 1