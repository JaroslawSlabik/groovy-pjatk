def list1 = [ 'a', 'b', 'c']
def list2 = [ 1, 8, 23 ]

//a
list1.each({ it ->
    println it
})

list2.each({ it ->
    println it
})

//b
def list1b = []
list1.each({ it ->
    list1b.add(it * 2)
})
println list1b

def list2b = []
list2.each({ it ->
    list2b.add(it * 2)
})
println list2b
