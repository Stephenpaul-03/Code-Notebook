def modify(mat):
    n = len(mat)
    m = len(mat[0])
    row_flag = False
    col_flag = False

    for i in range(n):
        for j in range(m):
            if i == 0 and mat[i][j] == 1:
                row_flag = True
            if j == 0 and mat[i][j] == 1:
                col_flag = True
            if mat[i][j] == 1:
                mat[0][j] = 1
                mat[i][0] = 1

    for i in range(1, n):
        for j in range(1, m):
            if mat[0][j] == 1 or mat[i][0] == 1:
                mat[i][j] = 1

    if row_flag:
        for j in range(m):
            mat[0][j] = 1

    if col_flag:
        for i in range(n):
            mat[i][0] = 1


def print_matrix(mat):
    for row in mat:
        print(' '.join(map(str, row)))


t = int(input())
for _ in range(t):
    matrix_input = []
    while True:
        try:
            line = input().strip()
            if not line:
                break
            matrix_input.append(list(map(int, line.split())))
        except EOFError:
            break

    modify(matrix_input)
    print_matrix(matrix_input)
