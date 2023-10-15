using Pkg
Pkg.add("DataStructures")
using DataStructures

board = reshape(0:8, (3, 3))
board_goal_tuples = [(3, 3), (1, 1), (1, 2), (1, 3), (2, 1), (2, 2), (2, 3), (3, 1), (3, 2)]
Indicies = CartesianIndices((1:3, 1:3, 1:3))
print(board)
heap = MutableBinaryMinHeap{Int}()

function heuristic(board::Array{Int8,2})
    distance = 0
    for i in Indicies
        Tuple(i)
    end
end