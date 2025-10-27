def is_finish(winner):
    key = winner * 3
    if key in [''.join(row) for row in graph]: # 행 검사
        return True
    if key in [''.join([row[i] for row in graph]) for i in range(3)]: # 열 검사
        return True
    if key in [''.join([graph[i][i] for i in range(3)]), ''.join([graph[j][abs(j - 2)] for j in range(3)])]: # 대각선 검사
        return True
    return False

def is_valid(x,o):
    if (x>5) or (o>4):
        print('invalid')
        return
    valid = False
    of, xf = is_finish('O'), is_finish('X')
    if x == o:
        if of and (not xf):
            valid = True
    elif x == o+1:
        if xf and (not of):
            valid = True
        elif (not of) and (not xf):
            if not any('.' in row for row in graph):
                valid = True
    if valid:
        print('valid')
    else:
        print('invalid')


while True:
    graph = list(input().rstrip())
    if graph[0] == 'e':
        break
    x,o = graph.count('X'), graph.count('O')
    graph = [list(graph[i:i+3]) for i in range(0,7,3)]
    is_valid(x,o)