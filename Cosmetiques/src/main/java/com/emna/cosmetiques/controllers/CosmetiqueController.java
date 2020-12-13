package com.emna.cosmetiques.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.emna.cosmetiques.entities.Cosmetique;
import com.emna.cosmetiques.service.CosmetiqueService;

@Controller
public class CosmetiqueController {
	
	@Autowired
	CosmetiqueService cosmetiqueService;
	
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap)
	{
	modelMap.addAttribute("cosmetique", new Cosmetique());
	modelMap.addAttribute("mode", "new");
	return "formCosmetique";
	}
	
	@RequestMapping("/saveCosmetique")
	public String saveCosmetique(@Valid Cosmetique cosmetique,
			 BindingResult bindingResult)
	{
		if (bindingResult.hasErrors()) return "formCosmetique";
	 cosmetiqueService.saveCosmetique(cosmetique);
	return "formCosmetique";
	}
	
	@RequestMapping("/ListeCosmetiques")
	public String listeCosmetiques(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size)
	{
		Page<Cosmetique> coss = cosmetiqueService.getAllCosmetiquesParPage(page, size);
		modelMap.addAttribute("cosmetiques", coss);
		 modelMap.addAttribute("pages", new int[coss.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeCosmetiques";
	}

	@RequestMapping("/supprimerCosmetique")
	public String supprimerCosmetique(@RequestParam("id") Long id,
	 ModelMap modelMap,
	 @RequestParam (name="page",defaultValue = "0") int page,
	 @RequestParam (name="size", defaultValue = "2") int size)
	{
	cosmetiqueService.deleteCosmetiqueById(id);
	Page<Cosmetique> coss = cosmetiqueService.getAllCosmetiquesParPage(page,
			size);
			modelMap.addAttribute("cosmetiques", coss);
			modelMap.addAttribute("pages", new int[coss.getTotalPages()]);
			modelMap.addAttribute("currentPage", page);
			modelMap.addAttribute("size", size);
	return "listeCosmetiques";
	}
	
	@RequestMapping("/modifierCosmetique")
	public String editerCosmetique(@RequestParam("id") Long id,ModelMap modelMap)
	{
		Cosmetique p= cosmetiqueService.getCosmetique(id);
	modelMap.addAttribute("cosmetique", p);
	modelMap.addAttribute("mode", "edit");
	return "formCosmetique";
	}
	@RequestMapping("/updateCosmetique")
	public String updateCosmetique(@ModelAttribute("cosmetique") Cosmetique cosmetique,
	@RequestParam("date") String date,ModelMap modelMap) throws ParseException
	{
		//conversion de la date
		 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		 Date dateCreation = dateformat.parse(String.valueOf(date));
		 cosmetique.setDateCreation(dateCreation);

		 cosmetiqueService.updateCosmetique(cosmetique);
		 List<Cosmetique> coss = cosmetiqueService.getAllCosmetiques();
		 modelMap.addAttribute("cosmetiques", coss);
		return "listeCosmetiques";
		}


}