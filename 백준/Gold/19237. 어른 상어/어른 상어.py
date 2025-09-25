N,M,K = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(N)]
d = list(map(int, input().split()))
rank = []
for i in range(M):
    r = []
    for j in range(4):
        r.append(list(map(int, input().split())))
    rank.append(r)

# 위 아래 왼 오
dx=[-1,1,0,0]
dy=[0,0,-1,1]

shark = [[] for _ in range(M)] # x,y,방향

for i in range(N):
    for j in range(N):
        if graph[i][j] != 0:
            shark[graph[i][j] - 1] = [i,j,d[graph[i][j] - 1]-1]
        graph[i][j] = [0,0]

def smell(graph, shark):
    for i in range(len(shark)):
        if shark[i]:
            x,y,d=shark[i]
            graph[x][y]=[K, i]
    return graph

def next(graph):
    for i in range(N):
        for j in range(N):
            if graph[i][j][0]>0:
                graph[i][j][0] -= 1
    return graph

def move(shark):
    # 임시배열 - 겹치는 상어 제거
    temp=[[[] for j in range(N)] for _ in range(N)]
    for i in range(len(shark)):
        if shark[i]:
            x,y,d = shark[i]
            candidate = [] # 빈자리
            my_candidate = [] # 내 냄새가 있는 곳
            for k in range(4):
                nx,ny=x+dx[k],y+dy[k]
                if 0<=nx<N and 0<=ny<N:
                    if graph[nx][ny][0]==0:
                        candidate.append((nx,ny,k))
                    elif graph[nx][ny][1]==i:
                        my_candidate.append((nx,ny,k))
            new_d=d
            if not candidate:
                candidate=my_candidate
            if len(candidate) >= 2:
                shark_rank=rank[i][d]
                for r in shark_rank:
                    flag=False
                    for a,b,c in candidate:
                        if r-1==c:
                            new_d=r-1
                            flag=True
                            break
                    if flag:
                        break
            else:
                new_d=candidate[0][2]
            shark[i]=[x+dx[new_d], y+dy[new_d], new_d]
            temp[x+dx[new_d]][y+dy[new_d]].append(i)

        for i in range(N):
            for j in range(N):
                if len(temp[i][j])>1:
                    temp[i][j].sort()
                    for k in temp[i][j][1:]:
                        shark[k]=[]

        cnt=0
        for i in range(M):
            if shark[i]!=[]:
                cnt += 1
    return shark,cnt

for i in range(1000):
    graph=smell(graph,shark)
    shark, live = move(shark)
    graph=next(graph)
    if live==1:
        print(i+1)
        break
else:
    print(-1)

