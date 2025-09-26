def are_anagrams(s1, s2):
    if len(s1) != len(s2):
        return False
    return sorted(s1) == sorted(s2)

t = int(input())
for _ in range(t):
    s1 = input().strip()
    s2 = input().strip()
    if are_anagrams(s1, s2):
        print("true")
    else:
        print("false")
