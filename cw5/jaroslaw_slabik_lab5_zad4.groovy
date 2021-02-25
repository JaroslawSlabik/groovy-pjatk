import java.text.Collator
import javax.swing.*

//Załadowanie mapy słów
def mapAnagrams = [:]
def words = new URL("https://www.fuw.edu.pl/~werner/files/englishWords.txt").text.tokenize(" \t\n.,:?!-")
words.each({word -> 
    def anagram = word.toList().sort().join()
    
    def anagramSet = mapAnagrams.get(anagram);
    if(anagramSet == null)
    {
        def newAnagramSet = new TreeSet(Collator.getInstance(new Locale('en')))
        newAnagramSet << word
        mapAnagrams.put(anagram, newAnagramSet);
    }
    else
    {
        anagramSet << word
        mapAnagrams.put(anagram, anagramSet);
    } 
})

//Zad A (wypisać je dla wszystkich słów w porządku liczby  anagramów danego słowa (tylko te, które mają powyżej sześciu anagramów))
println "Zad A:"
mapAnagrams.sort({it -> it.value.size()}).each({key, value ->
    if(value.size() > 6)
    {
        println "anagram $key slowa: $value"
    }
})

// Zad B (dla słowa podanego w dialogu wypisać anagramy w porządku alfabetycznym.)
def AA = JOptionPane.showInputDialog(null, "Proszę podać słowo", "");
def AAanagram = AA.toList().sort().join()

println "Zad B:"
println mapAnagrams.get(AAanagram)





