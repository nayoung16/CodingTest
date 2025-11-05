code = input()
str = input()
without_dup = []
abc = ['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R',
'S','T','U','V','W','X','Y','Z']

final_code = abc.copy()
for c in code:
    if c not in without_dup:
        without_dup.append(c)
        final_code.remove(c)

final_code = without_dup + final_code

result = ""
for s in str:
    i = abc.index(s)
    result += final_code[i]

print(result)