def wave_form(arr):
    for i in range(0, len(arr), 2):
        if i > 0 and arr[i] < arr[i - 1]:
            arr[i], arr[i - 1] = arr[i - 1], arr[i]
        if i < len(arr) - 1 and arr[i] < arr[i + 1]:
            arr[i], arr[i + 1] = arr[i + 1], arr[i]
    return arr

t = int(input())
for _ in range(t):
    arr = list(map(int, input().split()))
    transformed = wave_form(arr)
    print(" ".join(map(str, transformed)))
