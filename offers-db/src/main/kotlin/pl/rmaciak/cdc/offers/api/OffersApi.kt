package pl.rmaciak.cdc.offers.api

import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import pl.rmaciak.cdc.offers.repository.Offer
import pl.rmaciak.cdc.offers.repository.OffersRepository
import java.math.BigDecimal

@RestController
class OffersApi(
    private val offersRepository: OffersRepository
) {

    @GetMapping("/offer/{offerId}",
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    @ResponseStatus(HttpStatus.OK)
    fun createPerson(@PathVariable offerId: String): OfferResponse =
        offersRepository.getById(offerId).toResponse()
}

private fun Offer.toResponse(): OfferResponse =
    OfferResponse(
        id,
        name,
        description,
        quantity,
        price,
        categoryId)


data class OfferResponse(
    val id: String,
    val name: String,
    val description: String,
    val quantity: Int,
    val price: BigDecimal,
    val categoryId: String
)