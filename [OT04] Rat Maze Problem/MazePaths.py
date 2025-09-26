direction = "DLRU"
DR = [1, 0, 0, -1]
DC = [0, -1, 1, 0]

def check_validity(row, col, n, maze):
    return 0 <= row < n and 0 <= col < n and maze[row][col] == 1

def path_finder(row, col, maze, n, ans, current_path):
    if row == n - 1 and col == n - 1:
        ans.append("".join(current_path))
        return

    maze[row][col] = 0

    for i in range(4):
        next_row = row + DR[i]
        next_col = col + DC[i]

        if check_validity(next_row, next_col, n, maze):
            current_path.append(direction[i])
            path_finder(next_row, next_col, maze, n, ans, current_path)
            current_path.pop()

    maze[row][col] = 1

t = int(input("Enter number of test cases: "))
for test_case in range(t):
    n = int(input("Enter the size of the maze (n): "))
    maze = [list(map(int, input("Enter the maze rows: ").split())) for _ in range(n)]

    res = []
    current_path = []

    if maze[0][0] != 0 and maze[n-1][n-1] != 0:
        path_finder(0, 0, maze, n, res, current_path)

    if not res:
        print(-1)
    else:
        print(f"Paths for test case {test_case + 1}: ", end="")
        print(" ".join(res))
