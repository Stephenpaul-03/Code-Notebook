class Node:
    def __init__(self, new_data):
        self.data = new_data
        self.next = None


def delete(head, key):
    curr = head
    prev = None
    while curr is not None:
        if curr.data == key:
            if prev is None:
                head = curr.next 
            else:
                prev.next = curr.next
            curr = curr.next  
        else:
            prev = curr
            curr = curr.next
    return head


def build(values):
    if not values:
        return None

    head = Node(values[0])
    current = head
    for value in values[1:]:
        current.next = Node(value)
        current = current.next
    return head


def print(head):
    result = []
    current = head
    while current is not None:
        result.append(current.data)
        current = current.next
    print(" -> ".join(map(str, result)) if result else "List is empty.")


if __name__ == "__main__":
    t = int(input("Enter number of test cases: ").strip())
    for _ in range(t):
        print(f"\nTest case {_ + 1}:")
        list = list(map(int, input("Enter the elements of the linked list: ").strip().split()))
        head = build(list)
        key = int(input("Enter the value to delete from the linked list: ").strip())
        head = delete(head, key)
        print(head)
