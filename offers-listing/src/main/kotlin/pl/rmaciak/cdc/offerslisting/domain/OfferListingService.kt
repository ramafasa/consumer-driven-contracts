package pl.rmaciak.cdc.offerslisting.domain

import org.springframework.stereotype.Service
import pl.rmaciak.cdc.offerslisting.domain.repository.OffersRepository

@Service
class OfferListingService(
    private val offersRepository: OffersRepository
) {

    fun showOffer(offerId: String) =
        offersRepository.getById(offerId)
}