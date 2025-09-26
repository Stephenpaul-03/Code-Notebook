from collections import deque

class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

class Height:

    def max_depth(self, node):
        if node is None:
            return 0
        left_depth = self.max_depth(node.left)
        right_depth = self.max_depth(node.right)
        return max(left_depth, right_depth) + 1

    def build_tree(self):
        root_value = int(input("Enter the root node value: "))
        if root_value == -1:
            return None

        root = Node(root_value)
        queue = deque([root])

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

        return root

def main():
    tree = Height()
    root = tree.build_tree()
    print("Maximum depth of the tree:", tree.max_depth(root))

if __name__ == "__main__":
    main()
