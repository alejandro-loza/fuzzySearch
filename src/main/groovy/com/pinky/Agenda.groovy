package com.pinky
import groovy.json.JsonSlurper
import groovy.json.JsonOutput

class Agenda{
    
    public static void main(String[] args) {
        add(args[0])
    }
   
    static def add(String nameIn){
        if (nameIn){
            def file = new File('fuzzy-search.txt')
            file << nameIn + '\n' 
            def json = JsonOutput.toJson([name: nameIn])
            println json
        }
        else println "WARNING: ---- Un programa nececita un nombre"
    }
}
