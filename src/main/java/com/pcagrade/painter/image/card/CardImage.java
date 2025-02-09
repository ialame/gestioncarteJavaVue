package com.pcagrade.painter.image.card;

import com.github.f4b6a3.ulid.Ulid;
import com.pcagrade.mason.localization.ILocalized;
import com.pcagrade.mason.localization.Localization;
import com.pcagrade.mason.localization.jpa.LocalizationColumnDefinitions;
import com.pcagrade.mason.ulid.jpa.AbstractUlidEntity;
import com.pcagrade.mason.ulid.jpa.UlidColumnDefinitions;
import com.pcagrade.mason.ulid.jpa.UlidType;
import com.pcagrade.painter.image.Image;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import org.hibernate.annotations.Type;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

@Entity
@Table(name = "card_image", indexes = {
        @Index(name = "card_image_card_id_idx", columnList = "card_id")
}, uniqueConstraints = {
        @UniqueConstraint(name = "card_image_card_id_localization_uq", columnNames = {"card_id", "localization"})
})
@Audited
public class CardImage extends AbstractUlidEntity implements ILocalized {

    @Column(name = "card_id", nullable = false, columnDefinition = UlidColumnDefinitions.DEFINITION)
    @Type(UlidType.class)
    private Ulid cardId;

    @Column(nullable = false, columnDefinition = LocalizationColumnDefinitions.DEFINITION)
    private Localization localization;

    @ManyToOne
    @JoinColumn(name = "image_id")
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Image image;

    public Ulid getCardId() {
        return cardId;
    }

    public void setCardId(Ulid cardId) {
        this.cardId = cardId;
    }

    @Override
    public Localization getLocalization() {
        return localization;
    }

    @Override
    public void setLocalization(Localization localization) {
        this.localization = localization;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
