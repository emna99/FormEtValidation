package com.emna.cosmetiques;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.emna.cosmetiques.entities.Cosmetique;
import com.emna.cosmetiques.entities.Marque;
import com.emna.cosmetiques.repos.CosmetiqueRepository;
import com.emna.cosmetiques.service.CosmetiqueService;

@SpringBootTest
class CosmetiquesApplicationTests {

	@Autowired
	private CosmetiqueRepository cosmetiqueRepository;
	
	@Autowired
	private CosmetiqueService cosmetiqueService;
	
	@Test
	public void testCreateCosmetique() {
	Cosmetique cos = new Cosmetique("Mascara MF",50.500,new Date());
	cosmetiqueRepository.save(cos);
	}
	
	@Test
	public void testFindCosmetique()
	{
		Cosmetique c = cosmetiqueRepository.findById(1L).get();
	System.out.println(c);
	}
	
	@Test
	public void testUpdateCosmetique()
	{
	Cosmetique c = cosmetiqueRepository.findById(1L).get();
	c.setPrixCosmetique(20.0);
	cosmetiqueRepository.save(c);
	
	System.out.println(c);
	}
	
	@Test
	public void testDeleteCosmetique()
	{
		cosmetiqueRepository.deleteById(1L);;
		}
	
	@Test
	public void testFindAllCosmetiques()
	{
	List<Cosmetique> coss = cosmetiqueRepository.findAll();
	for (Cosmetique c : coss)
	{
	System.out.println(c);
	}
	}
	
	@Test
	public void testFindByNomCosmetiqueContains()
	{
	Page<Cosmetique> coss = cosmetiqueService.getAllCosmetiquesParPage(0,2);
	System.out.println(coss.getSize());
	System.out.println(coss.getTotalElements());
	System.out.println(coss.getTotalPages());
	coss.getContent().forEach(p -> {System.out.println(p.toString());
	 });
	
	}
	
	@Test
	public void testFindCosmetiqueByNom()
	{
		List<Cosmetique> coss = cosmetiqueRepository.findByNomCosmetique("Rouge a levre MF");
		for (Cosmetique p : coss)
		{
		System.out.println(p);
		}
	}
	
	@Test
	public void testfindByNomPrix()
	{
	List<Cosmetique> coss = cosmetiqueRepository.findByNomPrix("Eyeliner", 39.0);
	for (Cosmetique p : coss)
	{
	System.out.println(p);
	}
	}
	
	@Test
	public void testfindByMarque()
	{
	Marque m = new Marque();
	m.setIdM(1L);
	List<Cosmetique> coss = cosmetiqueRepository.findByMarque(m);
	for (Cosmetique p : coss)
	{
	System.out.println(p);
	}
	
}
	
	@Test
	public void findByMarqueIdM()
	{
	List<Cosmetique> coss = cosmetiqueRepository.findByMarqueIdM(1L);
	for (Cosmetique p : coss)
	{
	System.out.println(p);
	}
	 }
	
	@Test
	public void testfindByOrderByNomCosmetiqueAsc()
	{
	List<Cosmetique> coss =
	cosmetiqueRepository.findByOrderByNomCosmetiqueAsc();
	for (Cosmetique p : coss)
	{
	System.out.println(p);
	}
	}
	
	@Test
	public void testTrierCosmetiquesNomsPrix()
	{
	List<Cosmetique> coss = cosmetiqueRepository.trierCosmetiquesNomsPrix();
	for (Cosmetique p : coss)
	{
	System.out.println(p);
	}
	}
}

