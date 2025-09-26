def max_one(arr):
    row = len(arr)
    col = len(arr[0]) if row > 0 else 0
    max_row = -1
    current_row = 0
    current_col = col - 1

    if row == 0 or col == 0:
        return -1

    while current_row < row and current_col >= 0:
        if arr[current_row][current_col] == 0:
            current_row += 1
        else:
            max_row = current_row
            current_col -= 1

    return max_row

t = int(input())
for _ in range(t):
    n, m = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(n)]
    print(max_one(arr))
