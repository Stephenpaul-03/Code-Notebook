def substr(s):
    n = len(s)    
    res = 0
    last_index = [-1] * 256
    start = 0
    for end in range(n):
        start = max(start, last_index[ord(s[end])] + 1)
        res = max(res, end - start + 1)
        last_index[ord(s[end])] = end

    return res

t = int(input())
for _ in range(t):
    s = str(input())
    print(substr(s))
    