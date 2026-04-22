def solution(tickets):
    answer = []
    path = ['ICN']
    visited = [False] * (len(tickets))
    tickets.sort()
    def dfs():
        nonlocal answer
        if len(path) == len(tickets) + 1:
            answer = path[:]
            return True
        for i in range(len(tickets)):
            if not visited[i] and path[-1] == tickets[i][0]:
                visited[i] = True
                path.append(tickets[i][1])
                if dfs():
                    return True
                path.pop()
                visited[i] = False
        return False
    dfs()
    return answer