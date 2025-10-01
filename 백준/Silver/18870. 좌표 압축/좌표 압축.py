N = int(input())
inputList = list(map(int, input().split()))
sortedList = sorted(list(set(inputList)))
dictList = dict(zip(sortedList, list(range(len(sortedList)))))
for x in inputList:
    print(dictList[x])