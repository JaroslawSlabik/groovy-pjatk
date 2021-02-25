String toMatch = "aa 2017-12-31 aa 22220-05-18 a 2378-94-64 a 1600-02-29 (przystępny poprawny) a 1600-02-31 (przystępny niepoprawny) a 1700-02-29 (nieprzystepny niepoprawny) 1800-02-28 (nieprzystepny poprawny) a 0000-00-00 a 0000-01-00 a 2112-22-22 a 3333-44-44 a"

if((match = toMatch =~ /(\d{4}-\d{2}-\d{2})/))
{
    def dni = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
    match.each({it ->
        match2 = it =~ /(\d{4})-(\d{2})-(\d{2})/
        def rok = match2[0][1].toInteger();
        def miesiac = match2[0][2].toInteger();
        def dzien = match2[0][3].toInteger();
        if(miesiac == 0 || miesiac > 12 || dzien == 0 || dzien > 31)
            return true;

        def rokPrzestepny = (rok % 4 == 0 && rok % 100 == 0) || rok % 400 == 0;

        def dniWMiesiacu = dni[miesiac - 1] + ((true == rokPrzestepny && miesiac == 2)? 1 : 0);
        if(dniWMiesiacu < dzien)
            return true;
        
        println it[0]; 
    })
}
