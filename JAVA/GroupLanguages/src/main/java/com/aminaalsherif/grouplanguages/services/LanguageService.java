package com.aminaalsherif.grouplanguages.services;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aminaalsherif.grouplangauges.models.Language;

@Service
public class LanguageService {
	private List<Language> languages = new ArrayList<Language>();
	
	public List<Language> getLanguages() {
		return languages;
	}
	
	public void addLanguage(Language lang) {
		languages.add(lang);
	}
	
	public Language getLanguage(int id) {
		return languages.get(id);
	}
	
	public void updateLanguage(int id, Language lang) {
		languages.set(id, lang);
	}
	
	public void deleteLanguage(int id) {
		languages.remove(id);
	}	
}
