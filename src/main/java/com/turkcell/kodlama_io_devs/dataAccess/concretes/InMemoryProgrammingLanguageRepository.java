package com.turkcell.kodlama_io_devs.dataAccess.concretes;

import com.turkcell.kodlama_io_devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import com.turkcell.kodlama_io_devs.entities.ProgrammingLanguage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository {
    List<ProgrammingLanguage> programmingLanguages;
    InMemoryProgrammingLanguageRepository(){
        programmingLanguages = new ArrayList<ProgrammingLanguage>();
        programmingLanguages.add(new ProgrammingLanguage(1,"Java"));
        programmingLanguages.add(new ProgrammingLanguage(2,"C#"));
    }
    @Override
    public void add(ProgrammingLanguage programmingLanguage) {
        programmingLanguages.add(programmingLanguage);
    }

    @Override
    public void delete(int id) {
        programmingLanguages.remove(getById(id));
    }

    @Override
    public void update(ProgrammingLanguage programmingLanguage) {
        ProgrammingLanguage oldProgrammingLanguage = getById(programmingLanguage.getId());
        oldProgrammingLanguage.setName(programmingLanguage.getName());
    }

    @Override
    public List<ProgrammingLanguage> getAll() {
        return programmingLanguages;
    }

    @Override
    public ProgrammingLanguage getById(int id) {
        for(ProgrammingLanguage programmingLanguage: programmingLanguages){
            if(programmingLanguage.getId() == id){
                return programmingLanguage;
            }
        }
        return null;
    }
}
