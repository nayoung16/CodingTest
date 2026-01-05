king, stone, n = input().split()
n = int(n)
king_move = [input().strip() for _ in range(n)]

def alpha_to_num(ch):
    return ord(ch) - ord('A')

king_y = int(king[1]) - 1
king_x = alpha_to_num(king[0])

stone_y = int(stone[1]) - 1
stone_x = alpha_to_num(stone[0])

# move -> (dx, dy) where x is file(A~H), y is rank(1~8)
dirs = {
    'R':  (1, 0),
    'L':  (-1, 0),
    'B':  (0, -1),
    'T':  (0, 1),
    'RT': (1, 1),
    'LT': (-1, 1),
    'RB': (1, -1),
    'LB': (-1, -1),
}

def in_board(x, y):
    return 0 <= x < 8 and 0 <= y < 8

for move in king_move:
    dx, dy = dirs[move]
    nkx, nky = king_x + dx, king_y + dy

    if not in_board(nkx, nky):
        continue

    if nkx == stone_x and nky == stone_y:
        nsx, nsy = stone_x + dx, stone_y + dy
        if not in_board(nsx, nsy):
            continue
        stone_x, stone_y = nsx, nsy

    king_x, king_y = nkx, nky

def to_pos(x, y):
    return chr(x + ord('A')) + str(y + 1)

print(to_pos(king_x, king_y))
print(to_pos(stone_x, stone_y))