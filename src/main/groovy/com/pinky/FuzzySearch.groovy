package com.pinky
import groovy.json.JsonSlurper
import groovy.json.JsonOutput

class FuzzySearch{
    public static void main(String[] args) {
        search(args[0])
    }
   
    static def search(String nameIn){
        if (nameIn){
           println nameIn
        }

        else println "WARNING: ---- Un programa nececita un nombre"
    }
} 
