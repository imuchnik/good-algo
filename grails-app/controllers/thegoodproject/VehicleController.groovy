package thegoodproject

import grails.converters.JSON
import org.codehaus.groovy.grails.web.json.JSONObject

import static groovy.json.JsonOutput.toJson

class VehicleController {

    VehicleService vehicleService

    def index() {

    }

    def search() {
        def searchVSN = params.id;

        def match = vehicleService.findCars(searchVSN);

        render toJson(match)
    }

}