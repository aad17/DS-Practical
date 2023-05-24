from mpi4py import MPI

ARRAY_SIZE = int(input('Enter the size of the array\n'))

comm = MPI.COMM_WORLD
rank = comm.Get_rank()
size = comm.Get_size()

array = []
for i in range(ARRAY_SIZE):
    array.append(int(input(f'Enter the process ')))

partial_sum = 0

# Calculate the partial sum for each process
for i in range(rank, ARRAY_SIZE, size):
    partial_sum += array[i]

# Reduce the partial sums to obtain the final sum
sum = comm.reduce(partial_sum, op=MPI.SUM, root=0)

if rank == 0:
    print("Sum of elements:", sum)

MPI.Finalize()