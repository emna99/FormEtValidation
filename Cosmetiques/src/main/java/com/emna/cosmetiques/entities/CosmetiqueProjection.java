package com.emna.cosmetiques.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomCos", types = { Cosmetique.class })
public interface CosmetiqueProjection {
	public String getNomCosmetique();
}
