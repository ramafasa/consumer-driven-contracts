package contracts.offersListing

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    name("should return offer")
    request {
        method 'GET'
        url $(c(regex("/offer/[0-9]*")), p("/offer/4455"))
        headers {
            accept('application/json')
        }
    }
    response {
        status OK()
        body([
            id         : "4455",
            name       : "Test offer name",
            description: "This is test offer description",
            quantity   : 10,
            price      : 199.99,
            categoryId : "190"
        ])
        headers {
            contentType('application/json')
        }
    }
}