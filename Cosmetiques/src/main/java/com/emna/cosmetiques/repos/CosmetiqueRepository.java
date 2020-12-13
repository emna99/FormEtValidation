package com.emna.cosmetiques.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.emna.cosmetiques.entities.Cosmetique;
import com.emna.cosmetiques.entities.Marque;

@RepositoryRestResource(path = "rest")
public interface CosmetiqueRepository extends JpaRepository<Cosmetique, Long> {

	List<Cosmetique> findByNomCosmetique(String nom);

	/*@Query("select p from Cosmetique p where p.nomCosmetique like %?1 and p.prixCosmetique > ?2")
	List<Cosmetique> findByNomPrix (String nom, Double prix);*/
	
	@Query("select p from Cosmetique p where p.nomCosmetique like %:nom and p.prixCosmetique > :prix")
	List<Cosmetique> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);
	
	@Query("select p from Cosmetique p where p.marque = ?1")
	List<Cosmetique> findByMarque (Marque marque);
	
	List<Cosmetique> findByMarqueIdM(Long id);
	
	List<Cosmetique> findByOrderByNomCosmetiqueAsc();
	
	@Query("select p from Cosmetique p order by p.nomCosmetique ASC, p.prixCosmetique DESC")
	List<Cosmetique> trierCosmetiquesNomsPrix ();
}
