package com.codingdojoassignments.axsos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojoassignments.axsos.models.Language;
import com.codingdojoassignments.axsos.repositories.LanguageRepositories;

@Service
public class LanguageServices {
    private final LanguageRepositories repository;

    public LanguageServices(LanguageRepositories repository){
        this.repository=repository;
    }
    public List<Language> allLanguauges(){
        return repository.findAll();
    }
    public Language findlanguage(Long id){
       Optional<Language> lang=repository.findById(id);
       if (lang.isPresent()){
           return lang.get();
       }
       return null;
    }
    public Language createLanguage(Language lang)
    {

   	 System.out.println("createLanguage");
	 System.out.println(lang.getCurrentVersion());
        return repository.save(lang);
    }
    public void deleteLanguage(Long id){
        Optional<Language> optionalang = repository.findById(id);
        if(optionalang.isPresent()) {
        	repository.deleteById(id);
        }


    }
    public Language updateLanguage(Language lang) {
        Optional<Language> optionalLang = repository.findById(lang.getId());
        if(optionalLang.isPresent()) {
            Language language= optionalLang.get();
            language.setName(lang.getName());
            language.setCreator(lang.getCreator());
            language.setCurrentVersion(lang.getCurrentVersion());
            repository.save(language);
            return language;
        } else {
            return null;
        }

    }
	public LanguageRepositories getRepository() {
		return repository;
	}

}
