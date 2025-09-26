class Node:
    def __init__(self, value):
        self.data = value
        self.left = None
        self.right = None


def maxValue(node):
    if node is None:
        return float('-inf')
    return max(node.data, maxValue(node.left), maxValue(node.right))


def minValue(node):
    if node is None:
        return float('inf')
    return min(node.data, minValue(node.left), minValue(node.right))


def checker(node):
    if node is None:
        return True

    if node.left and maxValue(node.left) >= node.data:
        return False

    if node.right and minValue(node.right) <= node.data:
        return False

    return checker(node.left) and checker(node.right)


def build(values):
    if not values or values[0] == 'N':
        return None

    root = Node(int(values[0]))
    queue = [root]
    index = 1

    while index < len(values):
        current = queue.pop(0)

        if values[index] != 'N':
            current.left = Node(int(values[index]))
            queue.append(current.left)
        index += 1

        if index >= len(values):
            break

        if values[index] != 'N':
            current.right = Node(int(values[index]))
            queue.append(current.right)
        index += 1

    return root


t = int(input("Enter number of test cases: ").strip())
for _ in range(t):
    print(f"\nTest case {_ + 1}:")
    level_order = input("Enter level-order traversal (use 'N' for null nodes): ").strip().split()
    tree_root = build(level_order)

    if checker(tree_root):
        print("This tree satisfies the Binary Search Tree (BST) property.")
    else:
        print("This tree does NOT satisfy the BST property.")
