package com.pcagrade.retriever.cart.item;

import com.pcagrade.retriever.card.Card;
import com.pcagrade.mason.ulid.jpa.AbstractUlidEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart_item")
public class CartItem extends AbstractUlidEntity {

	@ManyToOne
	@JoinColumn(name = "card_id")
	private Card card;

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}
}
