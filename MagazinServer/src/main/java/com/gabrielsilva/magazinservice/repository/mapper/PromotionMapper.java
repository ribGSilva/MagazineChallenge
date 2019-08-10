package com.gabrielsilva.magazinservice.repository.mapper;

import java.util.HashSet;
import java.util.Set;

import com.gabrielsilva.magazinservice.enums.PromotionNames;
import com.gabrielsilva.magazinservice.repository.entity.Promotion;

public class PromotionMapper {

	public Set<Promotion> mapPromotions() {
		Set<Promotion> promotions = new HashSet<>();
		
		Promotion light = new Promotion();
		
		light.setName(PromotionNames.LIGHT);
		light.setDescription("Se o lanche tem alface e não tem bacon, ganha 10% de desconto.");

		promotions.add(light);
		
		
		Promotion muitaCarne = new Promotion();
		
		muitaCarne.setName(PromotionNames.MUITA_CARNE);
		muitaCarne.setDescription("A cada 3 porções de carne o cliente só paga 2. Se o lanche tiver 6 porções, ocliente pagará 4. Assim por diante...");

		promotions.add(muitaCarne);
		
		
		Promotion muitoQueijo = new Promotion();
		
		muitoQueijo.setName(PromotionNames.MUITO_QUEIJO);
		muitoQueijo.setDescription("A cada 3 porções de queijo o cliente só paga 2. Se o lanche tiver 6 porções, ocliente pagará 4. Assim por diante...");

		promotions.add(muitoQueijo);
		
		
		return promotions;
	}

}
