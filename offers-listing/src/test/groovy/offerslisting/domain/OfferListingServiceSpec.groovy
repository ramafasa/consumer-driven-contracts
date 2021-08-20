package offerslisting.domain

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties
import pl.rmaciak.cdc.offerslisting.OffersListingApplication
import pl.rmaciak.cdc.offerslisting.domain.OfferListingService
import spock.lang.Specification
import spock.lang.Subject

@SpringBootTest(classes = [OffersListingApplication])
@AutoConfigureStubRunner(
    ids = ["pl.rmaciak.cdc:offers:+:stubs:8090"], stubsMode = StubRunnerProperties.StubsMode.LOCAL
)
class OfferListingServiceSpec extends Specification {

    @Subject
    @Autowired
    OfferListingService sut


    def "should return offer for given ID"() {
        given:

        when:
        def actual = sut.showOffer("45435")

        then:
        actual.name == "Test offer name"
    }
}
