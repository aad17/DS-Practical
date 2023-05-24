n = int(input('Enter the number of nodes\n'))
m = n-1
ch = 0
token = 0

for i in range(n):
    print(f'{i}', end=' ')
print('0')

while True:
    s = int(input('Enter Sender\n'))
    r = int(input('Enter Receiver\n'))
    a = input('Enter Message\n')
    i, j = token, token

    while((i%n) != s):
        print(f'{j} -> ', end=' ')
        i += 1
        j = (j+1) % n    # to rotate in circular manner

    print(f'{s}')
    print(f'Sender {s} is sending data {a} to receiver {r}')

    i = (s+1) % n
    while i != r:
        print(f'Data {a} is forwarded by {i}')
        i = (i+1)%n

    print(f'Data {a} is received by {r}')

    token = s   # Token is passed to sender

    while True:
        try:
            ch = int(input('Do you want to continue\nEnter 1 for Yes Enter 0 for No\n'))
            if ch != 1 and ch != 0:
                raise ValueError
            break
        except ValueError:
            print('Invalid Input')

    if ch == 0:
        break