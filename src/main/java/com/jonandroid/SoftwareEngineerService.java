package com.jonandroid;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEngineerService {

    private final SoftwareEngineerRepository repository;
    private final AIService aiService;

    public SoftwareEngineerService(SoftwareEngineerRepository repository
    , AIService aiService) {
        this.repository = repository;
        this.aiService = aiService;
    }

    public List<SoftwareEngineer> getSoftwareEngineers()
    {
        return repository.findAll();
    }

    public SoftwareEngineer getSoftwareEngineerbyId(Integer id)
    {
        return repository.findById(id).orElseThrow(()-> new IllegalStateException(id+"not found"));
    }

    public void deleteSoftwareEngineerbyId(Integer id)
    {
        repository.deleteById(id);
    }

    public void addSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        String prompt = """
                Based on techstack %s of %s provide learning path for person, limit response to 50 tokens, summarize
                """.formatted(softwareEngineer.getTechStack(), softwareEngineer.getName());
        String response = aiService.chat(prompt);
        softwareEngineer.setLearningPath(response);
        repository.save(softwareEngineer);
    }

    public void modifySoftwareEngineerbyId(Integer id, SoftwareEngineer engineer) {
        engineer.setId(id);
        repository.save(engineer);

    }
}
