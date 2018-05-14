package com.pinky
import org.junit.Ignore
import spock.lang.Specification
import groovy.json.JsonSlurper
import groovy.json.JsonOutput


class AgendaSpec extends Specification{
   String filename = "temp.txt"
   def temp = File.createTempFile('temp', '.txt') 

   void "must return a name in json format"(){
        setup:
          Agenda agenda = new Agenda()
          String name = "Edard Stark"
        when:
          def response = agenda.add(name,filename)
          def slurped = new JsonSlurper().parseText(response)

        then:
           assert slurped.name == "Edard Stark"
           assert response.toString() == '{"name":"'+name+'"}'
    }
   void "must a return a error message on missing name"(){
        setup:
          Agenda agenda = new Agenda()
        when:
          def response = agenda.add('', filename)
        then:
           assert response == "WARNING: ---- Un programa nececita un nombre"
    }
    void "must return name list in json format"(){
        setup:
          Agenda agenda = new Agenda()
          String name = "Edard Stark"
          String name1 = "Jhon Snow"
          agenda.add(name, filename)
          agenda.add(name1, filename)
        when:
          NameList response = new NameList()
          def json = JsonOutput.toJson(response.getNameList())
        then:
            assert !response.getNameList().isEmpty() 
            assert  response.getNameList().getClass() == ArrayList
            assert  !json.isEmpty()
    }

    void "must assert levi distance"(){
        setup:
           Levenshtein lv = new Levenshtein()
        when:
            def a = lv.distance( 'Alberto Vera Padrón', 'Alverto' )
            def b = lv.distance( 'Alberto Vera Padrón', 'Eddar Stark' )
        then:
            assert a < b
    }
    void "must assert levi distance eqqual zero on same word"(){
        setup:
           Levenshtein lv = new Levenshtein()
        when:
            def a = lv.distance( 'Eddard Stark', 'Eddard Stark' )
        then:
            assert a == 0
    }


}
