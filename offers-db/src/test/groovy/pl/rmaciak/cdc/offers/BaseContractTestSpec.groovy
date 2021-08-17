package pl.rmaciak.cdc.offers

import io.restassured.module.mockmvc.RestAssuredMockMvc
import pl.rmaciak.cdc.offers.api.OffersApi
import pl.rmaciak.cdc.offers.repository.Offer
import pl.rmaciak.cdc.offers.repository.OffersRepository
import spock.lang.Specification

abstract class BaseContractTestSpec extends Specification {

    OffersRepository offersRepository = Stub(OffersRepository.class)

    def setup() {

        offersRepository.getById(_ as String) >>
            new Offer(
                "4455",
                "Test offer name",
                "This is test offer description",
                10,
                BigDecimal.valueOf(199.99)
            )

        RestAssuredMockMvc.standaloneSetup(new OffersApi(offersRepository))
    }
}
