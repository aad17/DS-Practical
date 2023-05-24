n = int(input('Enter the number of nodes\n'))
node_ids = []

for i in range(n):
    node_ids.append(int(input(f'Enter ID of node {i+1}: ')))

maxi = -1
for i in range(n):
    successor = (i + 1) % n
    print(f'Node {node_ids[i]} sends election message to node {node_ids[successor]}')
    maxi = max(maxi, node_ids[i])

coordinator = -1

# Message passing to let know all the nodes who is the coordinaator
while coordinator == -1:
    for i in range(n):
        predecessor = (i - 1 + n) % n
        successor = (i + 1) % n

        if node_ids[predecessor] == maxi:
            coordinator = node_ids[predecessor]
        print(f'Node {node_ids[i]} forwards message from {node_ids[predecessor]} to {node_ids[successor]}')

print(f'Coordinator is {coordinator}')