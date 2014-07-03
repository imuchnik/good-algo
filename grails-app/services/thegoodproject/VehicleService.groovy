package thegoodproject

class VehicleService {
   Vehicle vehicle
    HashMap cars
    WildCardTrie wildCardTrie
    def parsedFile

    def init(){


    }

    def initialize() {
        wildCardTrie = new WildCardTrie();
        cars = new HashMap();
        def csvc = new File( 'grails-app/conf/vsn_data.csv' ).getText()
        def slurper = new CsvSlurper()
        parsedFile = slurper.parseText(csvc,true)
        //Serial Number Pattern,Vehicle Trim Id,Year,Make,Model,Trim Name
        parsedFile.each { fields ->
            wildCardTrie.insert(fields['Serial Number Pattern'])
            cars[fields['Serial Number Pattern']] = fields;
        }
    }

    def addToTrie(String id) {
        wildCardTrie.insert(id)
    }

    def findInTrie(vsn) {
        wildCardTrie.search(vsn)
    }

    def findCars(vsn) {
      cars[findInTrie(vsn)]

    }

}