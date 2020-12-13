package com.emna.cosmetiques.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.emna.cosmetiques.entities.Cosmetique;
import com.emna.cosmetiques.entities.Marque;

public interface CosmetiqueService {
	Cosmetique saveCosmetique(Cosmetique c);
	Cosmetique updateCosmetique(Cosmetique c);
	void deleteCosmetique(Cosmetique c);
	void deleteCosmetiqueById(Long id);
	Cosmetique getCosmetique(Long id);
	List<Cosmetique> getAllCosmetiques();
	List<Cosmetique> findByNomCosmetique(String nom);
	
	List<Cosmetique> findByNomPrix (String nom, Double prix);
	List<Cosmetique> findByMarque (Marque marque);
	List<Cosmetique> findByMarqueIdM(Long id);
	List<Cosmetique> findByOrderByNomCosmetiqueAsc();
	List<Cosmetique> trierCosmetiquesNomsPrix();
	
	Page<Cosmetique> getAllCosmetiquesParPage(int page, int size);
}
