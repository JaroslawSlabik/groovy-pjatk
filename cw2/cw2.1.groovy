def maximum(Object listOfObject) // -> Tuple2
{
    if(listOfObject.size() == 0)
        return Tuple2();

    Object maxVal = listOfObject[0];
    def listOfIndexs = [0];

    listOfObject.eachWithIndex{it, index ->
        if(index == 0)
            return;

        if(maxVal == it)
        {
            listOfIndexs.add(index);
        }
        else if(maxVal < it)
        {
            listOfIndexs.clear();
            listOfIndexs.add(index);
            maxVal = it;
        }
    }
    
    new Tuple2(maxVal, listOfIndexs);
}


(maxVal, indList) = maximum( [5, 3, 5, 5, 1, 5] )
println "Maximum: $maxVal"
println "Indexes: $indList"

(maxVal, indList) = maximum(['a', 'c', 'c', 'c', 'b'])
println "Maximum: $maxVal"
println "Indexes: $indList"

