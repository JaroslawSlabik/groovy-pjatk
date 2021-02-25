import groovy.swing.SwingBuilder
import java.awt.*;

def colorList = [Color.BLACK, Color.WHITE, Color.RED, Color.BLUE, Color.GREEN]
def index = 0;

new SwingBuilder().edt{
    frame(title: 'Przycisk', pack: true, visible: true) {
        button('Click me!',  actionPerformed: { e-> 
            if(index % colorList.size == 0){
                index = 0;
            }
            
            e.source.background = colorList[index]
            index++
        })
    }
}
