package com.pcagrade.retriever.card.pokemon.feature.translation;

import com.pcagrade.mason.localization.ILocalized;
import com.pcagrade.mason.localization.Localization;
import io.swagger.v3.oas.annotations.media.Schema;

public class FeatureTranslationDTO implements ILocalized {
	@Schema(requiredMode = Schema.RequiredMode.REQUIRED)
	private Localization localization;
	@Schema(requiredMode = Schema.RequiredMode.REQUIRED)
	private String name;
	@Schema(requiredMode = Schema.RequiredMode.REQUIRED)
	private String zebraName;
	private String verificationPattern;
	private String labelVerificationPattern;

	@Override
	public Localization getLocalization() {
		return localization;
	}

	@Override
	public void setLocalization(Localization localization) {
		this.localization = localization;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getZebraName() {
		return zebraName;
	}

	public void setZebraName(String zebraName) {
		this.zebraName = zebraName;
	}

	public String getVerificationPattern() {
		return verificationPattern;
	}

	public void setVerificationPattern(String verificationPattern) {
		this.verificationPattern = verificationPattern;
	}

	public String getLabelVerificationPattern() {
		return labelVerificationPattern;
	}

	public void setLabelVerificationPattern(String labelVerificationPattern) {
		this.labelVerificationPattern = labelVerificationPattern;
	}
}
