package com.pinky
import groovy.json.JsonSlurper
import groovy.json.JsonOutput
import com.pinky.Name

class NameList{

    public static void main(String[] args) {
        println JsonOutput.toJson(findAll())
    }

    static def findAll(){
        List<Name> names = []
        new File('fuzzy-search.txt').eachLine { line ->
             names << new Name(name:line)
        }
        return names.toSorted()
    }

}

