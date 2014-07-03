package thegoodproject

class VehicleService {
   Vehicle vehicle
    HashMap cars
    WildCardTrie wildCardTrie
    def parsedFile

    def init(){

        def csvc = new File( 'grails-app/conf/vsn_data.csv' ).getText()
        def slurper = new CsvSlurper()
        parsedFile = slurper.parseText(csvc,true)
        println parsedFile
    }

    def initialize() {
        File vsnData = new File("grails-app/conf/vsn_data_noheader.csv")
        wildCardTrie = new WildCardTrie();
        cars = new HashMap();
        vsnData.splitEachLine(",") { fields ->
            wildCardTrie.insert(fields[0])
            cars[fields[0]] = fields;
        }
    }

    def addToTrie(String id) {
        wildCardTrie.insert(id)
    }

    def findInTrie(vsn) {
        wildCardTrie.search(vsn)
    }

    def findCars(vsn) {
        def vehicleInfo=cars[findInTrie(vsn)]

    vehicle = new Vehicle(id: vehicleInfo[0],make: vehicleInfo[1], model:vehicleInfo[2] ,trim:vehicleInfo[3] ,trimName:vehicleInfo[4] )
        vehicle
    }

}