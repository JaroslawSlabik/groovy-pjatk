import javax.swing.*

def root_dir = JOptionPane.showInputDialog(null, "Proszę podać początkowy katalog do wylistowania rekursywnie ścieżek bezwzględnych do plików HTML", "");

def listDirectory(path)
{
    def file = new File(path)
    file.eachFileRecurse() { f ->
        if(f.isFile() && f.absolutePath.length() > 4 && f.absolutePath.reverse().take(4).reverse().toUpperCase() == "HTML")
        {
            println f.absolutePath
        }
    }
}

listDirectory(root_dir)

