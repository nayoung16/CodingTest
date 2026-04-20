t = int(input())
for _ in range(t):
    w = list(input().rstrip())
    k = int(input())
    word_dict = dict()
    for i in range(len(w)):
        if w[i] not in word_dict:
            word_dict[w[i]] = []
        word_dict[w[i]].append(i)

    game3_result = float('inf')
    game4_result = 0
    for key in word_dict:
        positions = word_dict[key]
        if len(positions) < k:
            continue
        for i in range(len(positions) - k + 1):
            length = positions[i+k-1] - positions[i] + 1

            game3_result = min(game3_result, length)
            game4_result = max(game4_result, length)

    if game3_result == float('inf'):
        print(-1)
    else:
        print(game3_result, game4_result)