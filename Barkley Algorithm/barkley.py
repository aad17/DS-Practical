def avg_clock_time(servers):
    suma = sum(servers)
    return (suma//len(servers))

def main():
    n = int(input('Enter the number of servers\n'))
    servers = []
    for i in range(n):
        servers.append(int(input(f'Enter the server time for server {i+1}\n')))
    avg_clock = avg_clock_time(servers)

    for i in range(n):
        time_diff = avg_clock - servers[i]
        servers[i] += time_diff
        print(f'Server {i} clock time adjusted by {time_diff} seconds')
    
    print('Final clock times of servers are: \n')
    print(servers)

if __name__ == '__main__':
    main()