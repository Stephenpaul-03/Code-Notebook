t = int(input())
for _ in range(t):
    arr = list(map(int, input().split()))
    m = int(input())

    if m > len(arr):
        print(-1)
    else:
        arr.sort()
        min_diff = float('inf')

        for i in range(len(arr) - m + 1):
            diff = arr[i + m - 1] - arr[i]
            min_diff = min(min_diff, diff)

        print(min_diff)
