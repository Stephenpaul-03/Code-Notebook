from collections import defaultdict

def groupAnagrams(strs):
    anagrams = defaultdict(list)
    for str in strs:
        sorted_str = ''.join(sorted(str))
        anagrams[sorted_str].append(str)
    return list(anagrams.values())

t = int(input())
for _ in range(t):
    strs = input().split()
    result = groupAnagrams(strs)
    print(result)
