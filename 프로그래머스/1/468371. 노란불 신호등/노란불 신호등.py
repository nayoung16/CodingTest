import math

def solution(signals):
    answer = 0
    cycles = []
    for sig in signals:
        cycles.append(sum(sig))
    
    # 최소공배수 
    lcm = 1
    for num in cycles:
        lcm = math.lcm(lcm, num)
        
    # 최소공배수까지 검색
    for t in range(1, lcm+1):
        all_yellow = True
        
        for g,y,r in signals:
            # 현재 시간에서 위치 구하기
            cycle = g+y+r
            pos = (t - 1)% cycle + 1
            if pos <= g or (g+y) < pos:
                all_yellow = False
                break
                
        if all_yellow:
            return t
    
    return -1