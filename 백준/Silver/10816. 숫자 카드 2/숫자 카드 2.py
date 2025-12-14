n = int(input())
cards = list(map(int, input().split()))
card_set = dict()
for card in cards:
    if card in card_set.keys():
        card_set[card] += 1
    else:
        card_set[card] = 1
m = int(input())
numbers = list(map(int, input().split()))

for number in numbers:
    if number in card_set.keys():
        print(card_set[number], end=' ')
    else:
        print(0, end=' ')