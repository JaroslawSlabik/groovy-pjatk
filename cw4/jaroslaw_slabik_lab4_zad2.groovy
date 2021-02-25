def currency = 1.00;
try
{
    def ReqResult = new InputStreamReader(
        (new URL("https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml")).newInputStream()
    ).getText();
    if((match2 = ReqResult =~ /Cube currency=\'PLN\' rate=\'([+-]?\d+([\.,][0-9]+)?)\'/))
    {
        currency = match2.group(1).toDouble()
    }
}
catch(Exception ex)
{
    println "Błąd podczas pobierania aktualnego kursu EURO"
    return;
}

def menupl_txt_file = new File("MenuPl.txt").newInputStream()
def menueur_txt_file = new File("MenuEur.txt")
menueur_txt_file.text=''
menupl_txt_file.eachLine {
    if((match = it =~ /( [+-]?\d+(\.[0-9]+)?)/))
    {
        def d = match.group(1).toDouble()
        it = it.replaceAll(d.toString(), (d / currency).trunc(2).toString())
    }

    menueur_txt_file.append(it + "\n")
}
menupl_txt_file.close()
