import groovy.swing.SwingBuilder
import java.awt.*;
import javax.swing.*

def listOfImagesPath = []
def index = 0;

def selectedPath = JOptionPane.showInputDialog(null, "Proszę podać ścieżkę bezwzględną do katalogu z zdjęciami", "");

def file = new File(selectedPath)
file.eachFileRecurse() { f ->
    if(f.isFile() && f.absolutePath.length() > 3) {
        def type = f.absolutePath.reverse().take(3).reverse().toUpperCase()
        if(type == "JPG" || type == "PNG"){
            listOfImagesPath.add(f.absolutePath)
        }
    }
}

new SwingBuilder().edt{
    frame(title: 'Pokaz menedżerów rozkładu', pack: true, visible: true) {
        vbox() {
            label(id: 'l1', icon:  imageIcon(listOfImagesPath[index]))
            button( text: 'Next',  actionPerformed: { e-> 
                index++
                if(index % listOfImagesPath.size == 0){
                    index = 0;
                }
                
                l1.setIcon(imageIcon(listOfImagesPath[index]))
            })
        }
    }
}