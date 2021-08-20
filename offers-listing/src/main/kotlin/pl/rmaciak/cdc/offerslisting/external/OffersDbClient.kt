package pl.rmaciak.cdc.offerslisting.external

import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.RequestEntity
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import pl.rmaciak.cdc.offerslisting.domain.repository.Offer
import pl.rmaciak.cdc.offerslisting.domain.repository.OffersRepository
import java.math.BigDecimal

@Component
class OffersDbClient(
    private val restTemplate: RestTemplate
) : OffersRepository {


    override fun getById(offerId: String): Offer {

        val requestEntity = RequestEntity.get("http://localhost:8090/offer/$offerId")
            .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
            .build()

        return restTemplate.exchange(requestEntity, OfferResponse::class.java).body.toOffer()
    }
}

private fun OfferResponse.toOffer() =
    Offer(
        id,
        name,
        description,
        quantity,
        price,
        categoryId
    )

data class OfferResponse(
    val id: String,
    val name: String,
    val description: String,
    val quantity: Int,
    val price: BigDecimal,
    val categoryId: String
)