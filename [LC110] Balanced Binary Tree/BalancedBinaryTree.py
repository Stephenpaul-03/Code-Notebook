from collections import deque

class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

class BalancedTree:

    def height(self, node):
        if node is None:
            return 0
        return 1 + max(self.height(node.left), self.height(node.right))

    def balanced(self, node):
        if node is None:
            return True
        left = self.height(node.left)
        right = self.height(node.right)
        return abs(left - right) <= 1 and self.balanced(node.left) and self.balanced(node.right)

    def tree_build(self):
        root_val = int(input("Enter the root node value: "))
        if root_val == -1:
            return None

        local_root = Node(root_val)
        queue = deque([local_root])

        while queue:
            current = queue.popleft()

            left_val = int(input(f"Enter left child of {current.data} (or -1 if no left child): "))
            if left_val != -1:
                current.left = Node(left_val)
                queue.append(current.left)

            right_val = int(input(f"Enter right child of {current.data} (or -1 if no right child): "))
            if right_val != -1:
                current.right = Node(right_val)
                queue.append(current.right)

        return local_root

def main():
    tree = BalancedTree()
    tree.root = tree.tree_build()

    if tree.balanced(tree.root):
        print("Tree is balanced")
    else:
        print("Tree is not balanced")

if __name__ == "__main__":
    main()
