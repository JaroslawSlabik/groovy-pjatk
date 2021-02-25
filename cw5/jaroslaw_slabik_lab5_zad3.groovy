import java.text.Collator 
def treeMap = [:] as TreeMap

new File('data.txt').eachLine{
    it.tokenize(" ,-!?.:").each({it2 -> 
        def oldValue = treeMap.get(it2);
        if(oldValue == null)
            treeMap.put(it2, 1);
        else
            treeMap.put(it2, oldValue + 1);
    })
}
println treeMap.sort(Collator.getInstance(new Locale('pl')))
