def distance(s1, s2, m, n):
    if m == 0:
        return n
    if n == 0:
        return m
    if s1[m - 1] == s2[n - 1]:
        return distance(s1, s2, m - 1, n - 1)
    return 1 + min(distance(s1, s2, m, n - 1),distance(s1, s2, m - 1, n),distance(s1, s2, m - 1, n - 1))

t = int(input())
for _ in range(t):
    s1 = str(input())
    s2 = str(input())
    m = len(s1)
    n = len(s2)
    print(distance(s1, s2, len(s1), len(s2)))
