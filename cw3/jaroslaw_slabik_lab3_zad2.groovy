def pmap = [ Groovy: [ 'Asia', 'Jan' ],
             Grails: [ 'Asia', 'Jan', 'Stefan', 'Mirek' ],
             Java: [ 'Asia', 'Stefan', 'Mirek' ],
             JEE: [ 'Slawek', 'Stefan', 'Janusz' ]
           ]

//a
pmap.each{ key, value ->
    def val = value.size();
    println "Projekt: $key ilość osób: $val";
}

//b
pmap.each{ key, value ->
    if(value.size() > 2)
    {
        println "Projekt: $key";
    }
}

//c
def emap = [ : ]
pmap.each{ key, value ->
    value.each({it ->
        if(emap.get(it) == null)
        {
            def val = []
            val.add(key)
            emap.put(it, val)
        }
        else
        {
            def val = []
            val = emap.get(it)
            val.add(key)
            emap.put(it, val)
        }
    })
}

println emap
