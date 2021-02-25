def number = System.console().readLine 'Podaj liczbę: '

def map = [0: "zero", 1: "jeden", 2: "dwa", 3: "trzy", 4: "cztery", 5: "pięć", 6: "sześć", 7: "siedem", 8: "osiem", 9: "dziewięć"]

def strOut = ""

try 
{
    for(item in number)
    {
        strOut += map[item.toInteger()] + " - "
    }
}
catch(Exception e)
{
    println "Podaj liczbę nieujemną, tzn ciąg znaków składajacych się z <0,9> "
    System.exit(0)
}

if(strOut.length() == 0)
{
    println "pusto"
    System.exit(0)
}

println strOut[0..-3]

