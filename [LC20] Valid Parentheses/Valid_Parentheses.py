def is_balanced(par):
    stack = []

    for ch in par:
        if ch == '(':
            stack.append(ch)
        elif ch == ')':
            if not stack:
                return False
            stack.pop()

    return len(stack) == 0


def main():
    t = int(input("Enter Test Case Count: "))

    for _ in range(t):
        par = input("Enter Parentheses: ")

        if is_balanced(par):
            print("Balanced")
        else:
            print("Not Balanced")


if __name__ == "__main__":
    main()
