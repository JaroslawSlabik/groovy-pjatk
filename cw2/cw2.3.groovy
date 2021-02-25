

List apply(List l, Closure c)
{
    List listToReturn = [];
    l.each({e -> listToReturn.add(c(e))});
    return listToReturn;
}

assert apply([1,2,3], {x -> x++; return x;}) == [2,3,4]
assert apply([1,2,3], {x -> x*=2; return x;}) == [2,4,6]
assert apply([1,2,3], {x -> x*=2; return x;}) == [2,4,6]

assert apply([-1,-2,-3], {x -> x^=3; return x;}) == [-4,-3,-2]


