class UrlMappings {

	static mappings = {

        "/search/$id"(controller : "VIN"){ action = [GET:"search"]}

 		"/$controller/$action?/$id?"{
			constraints {

			}
		}
        "/" {
            controller = "VIN"
            action = "index"
        }

		"500"(view:'/error')
	}
}
