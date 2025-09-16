N = int(input())
paper = [list(map(int, input().split())) for _ in range(N)]

def func(li, lj, ri, rj):
    if ri - li == 1:
        if paper[li][lj] == 0:
            return [1,0]
        else:
            return [0,1]
    first_value = paper[li][lj]
    is_consistent = True

    for i in range(li, ri):
        for j in range(lj, rj):
            if first_value != paper[i][j]:
                is_consistent = False
                break
        if not is_consistent:
            break

    if is_consistent:
        if first_value == 0:
            return [1,0]
        else:
            return [0,1]

    mi = (li+ri)//2
    mj = (lj+rj)//2

    res = [0,0]

    rec1 = func(li,lj,mi,mj)
    rec2 = func(li,mj,mi,rj)
    rec3 = func(mi,lj,ri,mj)
    rec4 = func(mi,mj,ri,rj)

    res[0] = rec1[0] + rec2[0] + rec3[0] + rec4[0]
    res[1] = rec1[1] + rec2[1] + rec3[1] + rec4[1]

    return res

res = func(0,0,N,N)
print(*res, sep="\n")
