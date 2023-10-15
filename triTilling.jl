permList = fill(0, 15)
permList[1] = 3;
permList[2] = 11;
function perms(n)
    next = 3*permList[n-1]
    for i = 1:(n-2)
        next += 2*permList[i]
    end
    permList[n] = next
end

for i = 3:15
    perms(i)
end

for i = 1:30
    if i%2 == 1
        println(i + ": " + 0)
    else
        println(i + ": " + permList[i/2])
    end
end

#=
input = readlines()
for i ∈ input
    c = convert(Int, i)
    if c%2 == 1 
        println(0)
    else
        println(permList[c/2])
end
=#
