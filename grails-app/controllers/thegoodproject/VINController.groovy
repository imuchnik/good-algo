package thegoodproject

import grails.converters.JSON
import org.codehaus.groovy.grails.web.json.JSONObject

class VINController {

    VehicleService vehicleService

    def index() {

    }

    def search() {
        def searchVSN = params.id;

        def match = vehicleService.findCars(searchVSN);

        render JSONObject(match)
    }
    def test(){
        render vehicleService.init()
    }
}