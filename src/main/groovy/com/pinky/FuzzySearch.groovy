package com.pinky
import groovy.json.JsonSlurper
import groovy.json.JsonOutput

class FuzzySearch{
    public static void main(String[] args) {
        println JsonOutput.toJson( search(args[0]) )
    }
   
    static def search(String nameIn){
        if (nameIn){
            def nl = new NameList()
            Levenshtein lv = new Levenshtein()
            def storedNames =  nl.getNameList()
            int count = 0;
            def found = ''
            def candidates = []

            storedNames.any { element ->
                if (lv.distance(nameIn, element.name) == 0){
                    found = element 
                    return true
                }
                else{
                    candidates << ([name:element.name, distance: lv.distance(nameIn, element.name)])
                    return
                }

            }
            if(found != ''){
                return found
            }
            else{
               return candidates.sort({m1, m2 -> m1.distance <=> m2.distance}).unique().take(3)
             
            }

        }

        else println "WARNING: ---- Un programa nececita un nombre"
    }
} 
