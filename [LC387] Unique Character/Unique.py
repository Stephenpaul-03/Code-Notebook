MAX_CHAR = 26

def NRC(s):
    arr = [0] * MAX_CHAR
    for c in s:
        arr[ord(c) - ord('a')] += 1
    for i in range(len(s)):
        if arr[ord(s[i]) - ord('a')] == 1:
            return s[i]
    return 'NONE'

t = int(input())
for _ in range(t):
    s = str(input())
    print(NRC(s))