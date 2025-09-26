def nge(arr):
    stack = []
    result = [-1] * len(arr)

    for i in range(len(arr) - 1, -1, -1):
        while stack and stack[-1] <= arr[i]:
            stack.pop()
        if stack:
            result[i] = stack[-1]
        stack.append(arr[i])

    for i in range(len(arr)):
        print(f"{arr[i]} -> {result[i]}")

t = int(input())
for _ in range(t):
    arr = list(map(int, input().split()))
    nge(arr)
