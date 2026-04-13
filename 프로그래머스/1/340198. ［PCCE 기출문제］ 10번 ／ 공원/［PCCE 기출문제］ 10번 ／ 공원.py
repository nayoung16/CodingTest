def solution(mats, park):
    n = len(park)
    m = len(park[0])
    for size in sorted(mats, reverse=True):
        for row in range(n-size+1):
            for col in range(m-size+1):
                place = True
                for x in range(row,row+size):
                    for y in range(col,col+size):
                        if park[x][y]!='-1':
                            place=False
                            break
                    if not place:
                        break
                if place:
                    return size
            
    return -1