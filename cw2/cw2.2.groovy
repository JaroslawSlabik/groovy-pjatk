import javax.swing.*

List getInts()
{
    List listToRet = [];
    String listInvalidValues = "";

    while(true)
    {
        String listOfnumbersStr = JOptionPane.showInputDialog(null, "Podaj szereg liczb całkowitych oddzielnoych białbym znakiem", listInvalidValues);
        listInvalidValues = "";
        for(String numberStr : listOfnumbersStr.split(" "))
        {
            try
            {
                listToRet.add(numberStr.toInteger());
            }
            catch (Exception ex)
            {
                listInvalidValues += numberStr;
            }
        }

        if(listInvalidValues.isEmpty())
        {
            break;
        }
    }

    return listToRet;
}



println getInts();
