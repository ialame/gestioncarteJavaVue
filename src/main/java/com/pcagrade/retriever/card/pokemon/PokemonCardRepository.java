package com.pcagrade.retriever.card.pokemon;

import com.github.f4b6a3.ulid.Ulid;
import com.pcagrade.mason.jpa.repository.MasonRevisionRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface PokemonCardRepository extends MasonRevisionRepository<PokemonCard, Ulid> {

	@Query("select pc from PokemonCard pc join fetch pc.cardSets cs where cs.id = :setId")
	List<PokemonCard> findInSet(Ulid setId);

	@Query("select pc.type from PokemonCard pc group by pc.type")
	List<String> findAllTypes();

	List<PokemonCard> findAllByParentId(Ulid parentId);

	@Query("select c from PokemonCard c join fetch c.promoCards pc where pc.id = :promoId")
	Optional<PokemonCard> findByPromoId(Ulid promoId);
}
