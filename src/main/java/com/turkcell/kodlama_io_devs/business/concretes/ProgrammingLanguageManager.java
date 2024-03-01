package com.turkcell.kodlama_io_devs.business.concretes;

import com.turkcell.kodlama_io_devs.business.abstracts.ProgrammingLanguageService;
import com.turkcell.kodlama_io_devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import com.turkcell.kodlama_io_devs.entities.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {
    private ProgrammingLanguageRepository programmingLanguageRepository;
    @Autowired
    public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository){
        this.programmingLanguageRepository = programmingLanguageRepository;
    }
    @Override
    public void add(ProgrammingLanguage programmingLanguage) throws Exception {
        if(isIdExist(programmingLanguage.getId())){
            throw new Exception("This programming language is already exist.");
        }
        if (isNameExist(programmingLanguage)) {
            throw new Exception("Names cannot be repeated and programming language cannot be left blank.");
        }

        programmingLanguageRepository.add(programmingLanguage);
    }

    @Override
    public void delete(int id) throws Exception {
        if (!isIdExist(id)) {
            throw new Exception("There is no such a programming language");
        }
        programmingLanguageRepository.delete(id);
    }

    @Override
    public void update(ProgrammingLanguage programmingLanguage) throws Exception {
        if (!isIdExist(programmingLanguage.getId())) {
            throw new Exception("There is no such an id");
        }
        if (isNameExist(programmingLanguage)) {
            throw new Exception("Names cannot be repeated and programming language cannot be left blank.");
        }
        programmingLanguageRepository.update(programmingLanguage);
    }

    @Override
    public List<ProgrammingLanguage> getAll() {
        return programmingLanguageRepository.getAll();
    }

    @Override
    public ProgrammingLanguage getById(int id) throws Exception {
        if (!isIdExist(id)) {
            throw new Exception("There is no such a programming language");
        }
        return programmingLanguageRepository.getById(id);
    }
    public boolean isNameExist(ProgrammingLanguage programmingLanguage) {
        for (ProgrammingLanguage programmingLanguage1 : getAll()) {
            if (programmingLanguage1.getName().equals(programmingLanguage.getName()) || programmingLanguage.getName().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public boolean isIdExist(int id) {
        for (ProgrammingLanguage programmingLanguage : getAll()) {
            if (programmingLanguage.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
