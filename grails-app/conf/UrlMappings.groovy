class UrlMappings {

	static mappings = {

        "/search/$id"(controller : "vehicle"){ action = [GET:"search"]}

 		"/$controller/$action?/$id?"{
			constraints {

			}
		}
        "/" {
            controller = "vehicle"
            action = "index"
        }

		"500"(view:'/error')
	}
}
