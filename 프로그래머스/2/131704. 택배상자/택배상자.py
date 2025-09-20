def solution(order):
    stack = []
    answer = 0
    n = len(order)
    idx = 0  # order에서 현재 실어야 할 상자 인덱스

    for box in range(1, n+1):  # 1부터 n까지 컨베이어 벨트에서 상자 도착
        stack.append(box)  # 일단 보조 컨테이너에 넣음

        # 보조 컨테이너의 top이 현재 order와 같으면 꺼내서 트럭에 싣기
        while stack and stack[-1] == order[idx]:
            stack.pop()
            answer += 1
            idx += 1
    return answer