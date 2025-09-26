def dfs(grid, i, j, n, m):
    if i < 0 or j < 0 or i >= n or j >= m or grid[i][j] == 0:
        return
    grid[i][j] = 0  
    dfs(grid, i + 1, j, n, m)  # D
    dfs(grid, i - 1, j, n, m)  # U
    dfs(grid, i, j + 1, n, m)  # R
    dfs(grid, i, j - 1, n, m)  # L
    dfs(grid, i + 1, j + 1, n, m)  # BR
    dfs(grid, i - 1, j - 1, n, m)  # TL
    dfs(grid, i + 1, j - 1, n, m)  # BL
    dfs(grid, i - 1, j + 1, n, m)  # TR

def count_islands(grid):
    n, m = len(grid), len(grid[0])
    count = 0

    for i in range(n):
        for j in range(m):
            if grid[i][j] == 1:
                count += 1
                dfs(grid, i, j, n, m)  
    return count

def main():
    t = int(input("Enter number of test cases: "))
    for _ in range(t):
        n, m = map(int, input("Enter dimensions of the grid (rows and columns): ").split())
        print("Enter the grid (0s and 1s):")
        grid = [list(map(int, input().split())) for _ in range(n)]

        print("Number of islands:", count_islands(grid))

if __name__ == "__main__":
    main()
