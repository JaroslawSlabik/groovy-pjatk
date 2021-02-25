import groovy.swing.SwingBuilder
import java.awt.*;

def managerMap = ['Flow right': new FlowLayout(FlowLayout.RIGHT), 'Flow left': new FlowLayout(FlowLayout.LEFT), 'Border' : new BorderLayout(), 'Grid': new GridLayout(), 'Box horizontal' : 1, 'Box vertical' : 2 ]
def selectedManager = new FlowLayout(FlowLayout.RIGHT);

new SwingBuilder().edt{
    frame(title: 'Pokaz menedżerów rozkładu', pack: true, visible: true) {
        vbox() {
            panel() {
                comboBox(id: 'cbManagers', border: titledBorder('Wybierz menagera'),items: managerMap.keySet().toList(), actionPerformed: { 
                    def cur = it.source.selectedItem
                    selectedManager = managerMap[cur]
                })
                button('Start', actionPerformed: { e-> 
                    dispose()

                    new SwingBuilder().edt{
                        frame(title: 'Pokaz menedżerów rozkładu', pack: true, visible: true) {
                            if(selectedManager instanceof Integer){
                                if(selectedManager == 1){
                                    hbox(){
                                        '12345'.each { button('Przycisk - ' + it)}
                                    }
                                }else{
                                    vbox(){
                                        '12345'.each { button('Przycisk - ' + it)}
                                    }
                                }
                            }else{
                                panel(layout: selectedManager) {
                                    def dest = [ 'West', 'North', 'East', 'South', 'Center']
                                    '12345'.each { button('Przycisk - ' + it, constraints: dest[it.toInteger() - 1]) }
                                }
                            }
                        }
                     }
                })
            }
        }
    }
}