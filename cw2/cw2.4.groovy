
import groovy.transform.PackageScope
import javax.swing.*

//@PackageScope 
public <T> List<T> getData(Class<T> cl, Closure c = {x -> return true})
{
    List<T> listToRet = [];
    String listInvalidValues = "";

    while(true)
    {
        String listOfnumbersStr = JOptionPane.showInputDialog(null, "Podaj ciągi znaków oddzielnoych białbym znakiem", listInvalidValues);
        if(listOfnumbersStr == null)
            return null;

        listInvalidValues = "";
        for(String numberStr : listOfnumbersStr.split(" "))
        {
            try
            {
                T val = (numberStr as T);
                if(false == c(val))
                {
                    listInvalidValues += numberStr + " ";
                    continue;
                }

                listToRet.add(val);
            }
            catch (Exception ex)
            {
                println ex;
                listInvalidValues += numberStr + " ";
            }
        }

        if(listInvalidValues.isEmpty())
        {
            break;
        }

        listInvalidValues = listInvalidValues.substring(0, listInvalidValues.length() - 1);
    }

    return listToRet;
}

List<String> getData(Closure c = {x -> return true})
{
    return getData(String, c)
}

println getData({x -> x.size() > 3})
println getData(String, {x -> x.size() > 3})
println getData(Integer, {x -> (x as Integer) > 3;})
