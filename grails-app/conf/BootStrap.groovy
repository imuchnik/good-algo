import thegoodproject.VehicleService

class BootStrap {
    VehicleService vehicleService

    def init = { servletContext ->
        vehicleService.initialize()
    }
    def destroy = {
    }
}
