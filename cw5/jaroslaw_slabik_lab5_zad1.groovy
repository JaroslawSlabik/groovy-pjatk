def listA = [0,1,2,3,4,5,6,7,8,9]
compA = { l, r -> r - l } as Comparator

println "Zad A"
listA.sort(compA)
println listA

def listB = [0,1,2,3,4,5,6,7,8,9]
println "Zad B"
listB.sort(Comparator.reverseOrder())
//listB.reverse(true)
println listB


