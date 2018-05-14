package com.pinky
import groovy.json.JsonSlurper
import groovy.json.JsonOutput

class Agenda{
    
    public static void main(String[] args) {
        add(args[0], 'fuzzy-search.txt')
    }
   
    static def add(String nameIn, String filename){
        if (nameIn){
            def file = createFile(filename)
            file << nameIn + '\n' 
            JsonOutput.toJson([name: nameIn])
        }
        else  errorMessage()
    }

    static def errorMessage(){
        "WARNING: ---- Un programa nececita un nombre" 
    }

    static def createFile(String filename){
        return new File(filename)
    }
}
