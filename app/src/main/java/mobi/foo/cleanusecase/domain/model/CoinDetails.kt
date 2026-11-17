package mobi.foo.cleanusecase.domain.model

import mobi.foo.cleanusecase.data.remote.dto.TeamMember

class CoinDetails(
    val id: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>
)