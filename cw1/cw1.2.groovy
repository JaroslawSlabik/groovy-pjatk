

def mapOfProducts = [:];
println "Podaj produkty, w celu wyjścia napisz koniec[ENTER]"
while(true) 
{
    def val = System.console().readLine 'Podaj produkt i wartość (w formie pozycja = koszt): '
    if(val == "koniec")
    {
        break;
    }

    String[] pairProductValue = val.split("=");
    if(pairProductValue.size() != 2)
    {
        println "Źle podana wartość"
        continue;
    }

    try 
    {
        def product = pairProductValue[0].replaceAll(" ","");
        def value = pairProductValue[1].replaceAll(" ","").toInteger();
        mapOfProducts.put(product, value);
    }
    catch(Exception ex)
    {
        println "Źle podana wartość"
        continue;
    }
}

def mapOfSumProducts = [:];
def listOfProductsStr = System.console().readLine 'Podaj listę produktów do sumowania oddzielając je przecinkami (pr1, pr2, ...): '
String[] listOfProducts = listOfProductsStr.split(",");
for(String product : listOfProducts)
{
    product = product.replaceAll(" ","");

    def defValue = mapOfProducts.get(product);
    if(defValue == null)
    {
        println "Nie znam podanego ($product) produktu, omijam w sumowaniu"
        continue
    }

    def oldValue = mapOfSumProducts.get(product);
    if(oldValue == null)
        mapOfSumProducts.put(product, defValue);
    else
        mapOfSumProducts.put(product, oldValue + defValue);
}

println "Lista sumowanych produktów:"
for(def p : mapOfSumProducts)
{
    println "$p.key - $p.value"
}




