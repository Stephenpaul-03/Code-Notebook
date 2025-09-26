def validity_checker(expression):
    stack = []

    for ch in expression:
        if ch in "({[":
            stack.append(ch)
        elif ch in ")}]":
            if not stack:
                return False
            top = stack.pop()
            if (top == '(' and ch != ')') or \
               (top == '{' and ch != '}') or \
               (top == '[' and ch != ']'):
                return False

    return len(stack) == 0

t = int(input())
for _ in range(t):
    expression = input()
    print(validity_checker(expression))
