from collections import deque as dq

class Node:
    def __init__(self, w, l):
        self.word = w
        self.len = l

def ADJ(a, b):
    count = 0
    for i in range(len(a)):
        if a[i] != b[i]:
            count += 1
    return count == 1

def ladder(beginWord, endWord, wordList):
    q1 = dq()
    q2 = dq()
    vis1 = dict()
    v2 = dict()

    start = Node(beginWord, 1)
    end = Node(endWord, 1)

    vis1[beginWord] = 1
    q1.append(start)
    v2[endWord] = 1
    q2.append(end)

    while q1 and q2:
        curr1 = q1.popleft()
        curr2 = q2.popleft()

        for it in wordList:
            if ADJ(curr1.word, it) and it not in vis1:
                temp = Node(it, curr1.len + 1)
                q1.append(temp)
                vis1[it] = curr1.len + 1
                if temp.word == endWord:
                    return temp.len
                if temp.word in v2:
                    return temp.len + v2[temp.word] - 1

        for it in wordList:
            if ADJ(curr2.word, it) and it not in v2:
                temp = Node(it, curr2.len + 1)
                q2.append(temp)
                v2[it] = curr2.len + 1
                if temp.word == beginWord:
                    return temp.len
                if temp.word in vis1:
                    return temp.len + vis1[temp.word] - 1

    return 0

t = int(input())
for _ in range(t):
    wordList = input().split()
    start = input().strip()
    end = input().strip()
    print(ladder(start, end, wordList))
