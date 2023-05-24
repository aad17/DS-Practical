from mpi4py import MPI
import numpy as np

n = 10
a = np.array([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], dtype=np.int32)
a2 = np.empty(1000, dtype=np.int32)

comm = MPI.COMM_WORLD
rank = comm.Get_rank()
size = comm.Get_size()

if rank == 0:
    elements_per_process = n // size

    if size > 1:
        for i in range(1, size - 1):
            index = i * elements_per_process

            comm.send(elements_per_process, dest=i, tag=0)
            comm.Send(a[index:index+elements_per_process], dest=i, tag=0)

        index = (size - 1) * elements_per_process
        elements_left = n - index

        comm.send(elements_left, dest=size - 1, tag=0)
        comm.Send(a[index:index+elements_left], dest=size - 1, tag=0)

    local_sum = np.sum(a[:elements_per_process])
    partial_sums = np.empty(size - 1, dtype=np.int32)

    for i in range(1, size):
        partial_sums[i - 1] = comm.recv(source=MPI.ANY_SOURCE, tag=0)
        local_sum += partial_sums[i - 1]

    print("Sum of array is:", local_sum)

else:
    n_elements_received = comm.recv(source=0, tag=0)
    comm.Recv(a2, source=0, tag=0)

    partial_sum = np.sum(a2[:n_elements_received])
    comm.send(partial_sum, dest=0, tag=0)