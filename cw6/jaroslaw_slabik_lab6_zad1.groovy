import groovy.swing.SwingBuilder
import java.awt.*;
import java.awt.Font
import static javax.swing.WindowConstants.*
import static javax.swing.SwingConstants.*

Font font;
def fontList = ['Arial', 'Serif']
def fontStyleMap = ['Plain': Font.PLAIN, 'Bold': Font.BOLD, 'Italic': Font.ITALIC ]
def fontColorMap = ['Red': Color.RED, 'Blue': Color.BLUE, 'Green': Color.GREEN ]
def backgroundColorMap = ['Red': Color.RED, 'Blue': Color.BLUE, 'Green': Color.GREEN ]
def selectedFont = 'Arial';
def selectedFontStyle = Font.PLAIN;
def selectedFontSize = 6;
def selectedFontColor = Color.BLACK;
def selectedBackgroundColor = Color.WHITE;

new SwingBuilder().edt{
    frame(title: 'Prosty edytor - ustawienia', pack: true, visible: true) {
        vbox(){
            panel(layout: new GridLayout()) {
            comboBox(id: 'cbFontName', border: titledBorder('Wybierz nazwę czcionki'),items: fontList, actionPerformed: { 
                selectedFont = it.source.selectedItem
            })
            comboBox(id: 'cbFontStyle', border: titledBorder('Wybierz styl czcionki'),items: fontStyleMap.keySet().toList(), actionPerformed: { 
                def cur = it.source.selectedItem
                selectedFontStyle = fontStyleMap[cur]
            })
            }
            panel(layout: new GridLayout()) {
            comboBox(id: 'cbFontSize', border: titledBorder('Wybierz wielkość czcionki'),items: 6..40, actionPerformed: { 
                selectedFontSize = it.source.selectedItem
            })
            comboBox(id: 'cbFontColor', border: titledBorder('Wybierz kolor czcionki'),items: fontColorMap.keySet().toList(), actionPerformed: { 
                def cur = it.source.selectedItem
                selectedFontColor = fontColorMap[cur]
            })
            }
            panel(layout: new GridLayout()) {
            comboBox(id: 'cbBackgroundColor', border: titledBorder('Wybierz kolor tła'),items: backgroundColorMap.keySet().toList(), actionPerformed: { 
                def cur = it.source.selectedItem
                selectedBackgroundColor = backgroundColorMap[cur]
            })
            //Ustawienia rodzaju i rozmiaru pisma kolorów tła i pisma

            }
            panel(layout: new FlowLayout(FlowLayout.RIGHT)) {
                button('Start', constraints:'East',  actionPerformed: { e-> 
                      font = new Font(selectedFont, selectedFontStyle, selectedFontSize)

                      dispose()
                       new SwingBuilder().edt{
                            frame(title: 'Prosty edytor', pack: true, visible: true) {
                                vbox(){
                                    panel() {
                                        scrollPane() {
                                            textArea(rows: 15, columns: 40, background:selectedBackgroundColor, foreground:selectedFontColor ).setFont(font)
                                        }
                                    }
                                }
                            }
                        }
                    }
                )
                button('Wyjście', constraints:'West',  actionPerformed: { e-> 
                        dispose()
                    }
                )
            }    
        } 
    }
}

