package pl.rmaciak.cdc.offerslisting.domain.repository

import java.math.BigDecimal

interface OffersRepository {
    fun getById(offerId: String): Offer
}

data class Offer(
    val id: String,
    val name: String,
    val description: String,
    val quantity: Int,
    val price: BigDecimal,
    val categoryId: String
)