def idx_of_initiating_process(processes, initiating_process_id):
    for i in range(len(processes)):
        if processes[i] == initiating_process_id:
            return i
    return None

def initiate_election(processes, initiating_process_id, initiating_process_idx):
    coordinator = initiating_process_id
    for i in range(initiating_process_idx+1, len(processes)):
        print(f'{coordinator} sends message to {processes[i]} with index {i}')
        if processes[i] > coordinator:
            print(f'{processes[i]} reponded to {coordinator}')
            coordinator = processes[i]
    
    for i in range(initiating_process_idx):
        print(f'{coordinator} sends message to {processes[i]} with index {i}')
        if processes[i] > coordinator:
            print(f'{processes[i]} reponded to {coordinator}')
            coordinator = processes[i]
    
    return coordinator

def main():
    n = int(input('Enter the number of processes\n'))
    processes = []

    for i in range(n):
        processes.append(int(input(f'Enter the Process ID for process {i+1}\n')))
    
    initiating_process_id = int(input('Enter the Process ID for initiating the election\n'))
    idx_initiating_process = idx_of_initiating_process(processes, initiating_process_id)
    if idx_initiating_process is not None:
        coordinator = initiate_election(processes, initiating_process_id, idx_initiating_process)
    else:
        print('Invalid input')
        exit()

    print(f'Coordinator is {coordinator}')

if __name__ == '__main__':
    main()