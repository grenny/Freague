class UrlMappings {

	static mappings = {
        "/team/$id?"(resource:"team")

		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}
        
		"/"(view:"/index")
		"500"(view:'/error')
	}
}
