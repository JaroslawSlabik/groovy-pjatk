
void eachTuple(Iterable l, Closure c)
{
    for(int i = 0; i < l.size(); i += c.maximumNumberOfParameters)
    {
        if(i + c.maximumNumberOfParameters <= l.size())
        {
            def list = l.subList(i, i + c.maximumNumberOfParameters)
            c(*list)
        }
    }
}

def list = (1..40)

eachTuple(list, {e1, e2, e3, e4 ->
    println "$e1 $e2 $e3 $e4"
})

def s = 'asia ma kota i psa'

def out = new StringBuffer()
eachTuple(s.toList(), {a, b ->
  out << b << a
})
println out

