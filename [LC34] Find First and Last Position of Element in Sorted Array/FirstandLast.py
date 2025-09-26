def occurance(arr, x):
    first = -1
    last = -1
    for i in range(len(arr)):
        if arr[i] == x:
            if first == -1:
                first = i
            last = i

    if first != -1:
        print("First Occurrence:", first)
        print("Last Occurrence:", last)
    else:
        print("Not Found")

t = int(input())
for _ in range(t):
    arr = list(map(int, input().split()))
    n = int(input())
    occurance(arr, n)
