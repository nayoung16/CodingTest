'''
던전마다 (최소 필요 피로도, 소모 피로도)
최소 필요 피로도 = 해당 던전을 탐험하기 위해 가지고 있어야 하는 최소한의 피로도
소모 피로도 = 던전을 탐험한 후 소모되는 피로도
하루에 한 번씩 탐험할 수 있는 던전 여러개
최대한 많이 탐험
k = 유저 피로도
'''
def solution(k, dungeons):
    answer = 0
    visited = [False for _ in range(len(dungeons))]
    
    def dfs(fatigue, count):
        nonlocal answer
        answer = max(answer, count)
        
        for i in range(len(dungeons)):
            if not visited[i] and fatigue >= dungeons[i][0]:
                visited[i] = True
                dfs(fatigue - dungeons[i][1], count+1)
                visited[i] = False
        
    dfs(k,0)
    return answer