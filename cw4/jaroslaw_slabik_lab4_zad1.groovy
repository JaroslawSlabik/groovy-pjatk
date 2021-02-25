def projekty_txt_file = new File("Projekty.txt").newInputStream()
def projekty_duze_txt_file = new File("ProjektyDuze.txt")
projekty_duze_txt_file.text = ''

def map_people_project = [:]
projekty_txt_file.eachLine {
    String[] str = it.split("\t")
    if(str.length - 1 > 3)
        projekty_duze_txt_file.append(str[0] + "\n")

    for(int i = 1; i < str.length; i++) {
         if(map_people_project.containsKey(str[i]))
         {
            def old = map_people_project.get(str[i])
            old = old + str[0] + "\t"
            map_people_project.put(str[i], old)
         }
         else
         {
            map_people_project.put(str[i], str[0] + "\t")
         }
    }
}
projekty_txt_file.close()


def programisci_txt_file = new File("Programisci.txt")
programisci_txt_file.text = ''
for(def val in map_people_project.keySet()){
    programisci_txt_file.append(val + "\t" + map_people_project.get(val) + "\n")
}

