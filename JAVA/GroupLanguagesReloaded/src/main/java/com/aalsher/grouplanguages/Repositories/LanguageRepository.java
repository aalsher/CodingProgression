package com.aalsher.grouplanguages.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aalsher.grouplanguages.Models.Language;

	@Repository
	public interface LanguageRepository extends CrudRepository<Language, Long>{
		Language findById(Long id);
		
	}
