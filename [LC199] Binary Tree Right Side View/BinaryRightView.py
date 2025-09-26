from collections import deque

class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

class BinaryRightView:

    def right_view(self, root):
        if not root:
            return

        queue = deque([root])
        while queue:
            level_size = len(queue)
            for i in range(level_size):
                node = queue.popleft()
                if i == level_size - 1:
                    print(node.data, end=" ")

                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
        print()

    def build_tree(self):
        root_value = int(input("Enter the root node value: "))
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
    tree = BinaryRightView()
    root = tree.build_tree()
    print("Right view of the binary tree:")
    tree.right_view(root)

if __name__ == "__main__":
    main()
