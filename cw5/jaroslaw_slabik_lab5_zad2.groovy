def treeSet = new TreeSet({a, b -> def diff = a.size() - b.size(); if(diff == 0){a <=>b}else{diff} })

new File('data.txt').splitEachLine(' ') { treeSet.addAll(it)}

println treeSet

