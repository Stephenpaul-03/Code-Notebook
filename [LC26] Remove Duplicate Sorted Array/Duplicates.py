def remover(arr):
    n = len(arr)
    if n <= 1:
        return n
    idx = 1
    for i in range(1, n):
        if arr[i] != arr[i - 1]:
            arr[idx] = arr[i]
            idx += 1
    return idx

t = int(input())
for _ in range(t):
    arr = list(map(int, input().split()))
    new_length = remover(arr)
    for i in range(new_length):
        print(arr[i], end=' ')
    print()
