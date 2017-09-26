package com.aalsher.grouplanguages.Services;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aalsher.grouplanguages.Models.Language;
import com.aalsher.grouplanguages.Repositories.LanguageRepository;

@Service
public class LanguageService {
	private LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	private List<Language> languages = new ArrayList<Language>();
	
	public List<Language> getLanguages() {
		return (List<Language>) languageRepository.findAll();
	}
	
	public void addLanguage(Language language) {
		languageRepository.save(language);
	}
	
	public Language findLanguageById(Long id) {
		return languageRepository.findById(id);
	}
	
	public void updateLanguage(Language language) {
		languageRepository.save(language);
	}
	
	public void deleteLanguage(Long id) {
		languageRepository.delete(id);
	}	
}
