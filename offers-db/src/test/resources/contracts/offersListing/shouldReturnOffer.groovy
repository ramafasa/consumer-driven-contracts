package contracts.offersListing

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        url '/offer/4455'
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
            price      : 199.99
        ])
        headers {
            contentType('application/json')
        }
    }
}