String toMatch = "Dużo kasy 100.12 PLN mało kasy 0.76 PLN bankrut -1023.54 PLN przecinek nie obsługuję 34,00 PLN"
println toMatch
if((match = toMatch =~ /( [+-]?\d+(\.[0-9]+)? PLN)/))
{
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

    match.each({it ->
        def valInPLN = (it[0][0..-5]).toDouble()
        def valInEUR = valInPLN / currency

        valInEUR = valInEUR.trunc(2)

        toMatch = toMatch.replaceAll(it[0], " " + valInEUR.toString() + " EUR")
    })
}

println toMatch

