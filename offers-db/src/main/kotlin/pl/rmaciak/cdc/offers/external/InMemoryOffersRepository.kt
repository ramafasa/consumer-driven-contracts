package pl.rmaciak.cdc.offers.external

import org.springframework.stereotype.Repository
import pl.rmaciak.cdc.offers.repository.Offer
import pl.rmaciak.cdc.offers.repository.OffersRepository
import java.math.BigDecimal

@Repository
class InMemoryOffersRepository : OffersRepository {

    override fun getById(id: String): Offer =
        Offer(
            id,
            "AirPods PRO",
            "Innowacyjne słuchawki Apple AirPods Pro zapewnią Ci ponadprzeciętne doznania muzyczne w każdej sytuacji.",
            40,
            BigDecimal.valueOf(919.40),
            "124"
        )
}