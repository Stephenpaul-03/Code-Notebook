from collections import deque

def ladder(start, target, D):
    if start == target:
        return 0
    if target not in D:
        return 0

    level, wordlength = 0, len(start)
    Q = deque()
    Q.append(start)

    while len(Q) > 0:
        level += 1
        sizeofQ = len(Q)

        for i in range(sizeofQ):
            word = [j for j in Q.popleft()]

            for pos in range(wordlength):
                orig_char = word[pos]

                for c in range(ord('a'), ord('z') + 1):
                    word[pos] = chr(c)

                    if "".join(word) == target:
                        return level + 1

                    if "".join(word) not in D:
                        continue
                        
                    D.remove("".join(word))  
                    Q.append("".join(word))

                word[pos] = orig_char

    return 0

t = int(input())
for _ in range(t):
    strings = set(input().split())
    start = input()
    end = input()
    print(ladder(start, end, strings))
