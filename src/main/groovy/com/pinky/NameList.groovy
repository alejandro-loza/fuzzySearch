package com.pinky
import groovy.json.JsonSlurper
import groovy.json.JsonOutput
import com.pinky.Name

class NameList{
    static List<Name>  nameList = findAll('fuzzy-search.txt')

    public static void main(String[] args) {
        println JsonOutput.toJson(this.nameList)
    }

    static List<Name> findAll(String filename){
        List<Name> names = []
        new File(filename).eachLine { line ->
             names << new Name(name:line)
        }
        return names.toSorted()
    }

}

