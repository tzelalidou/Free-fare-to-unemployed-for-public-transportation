package gr.hua.ds.springboot1.service;
import gr.hua.ds.springboot1.entity.Application;
import gr.hua.ds.springboot1.repository.ApplicationRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private   ArrayList<Application> temp=new ArrayList<>();
    @Autowired
    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    // get all the applications
    public List<Application> getApplications() {

        return applicationRepository.findAll();
    }
    public List<Application> getApplicationsforOAED() {
        List<Application> allapl=getApplications();
        ArrayList<Application> oaed=new ArrayList<>();
        for(int i=0;i<allapl.size();i++){
            if(allapl.get(i).getApplicationstatus()==0) {
                oaed.add(allapl.get(i));
            }
        }
        return oaed;
    }
    public Application getApplicationforOAED(int id) {
        List<Application> allapl=getApplicationsforOAED();
        for(int i=0;i<allapl.size();i++){
            if(allapl.get(i).getAid()==id) {
                return allapl.get(i);
            }
        }
        return null;
    }

    public ArrayList<Application> getTemp() {
        return temp;
    }
    public ArrayList<?> AddAppTemp(Application app) {
        getTemp().add(app);
        return temp;
    }
    public void dltAppTemp(Application app) {
        getTemp().remove(app);
    }

/*
    // get all applications that need to be validated by OAED
    public List<Application> getApplicationsOAED() {
        return applicationRepository.findAllById(Collections.singleton(0));
    }

    // get all applications that need to be confirmed by OASA
    public List<Application> getApplicationsOASA() {
        return applicationRepository.findAllById(Collections.singleton(1));
    }
    */

    // get an application by id
    public Application getApplication(int id) {
        return  applicationRepository.getById(id);
    }

    // save an application
    public void saveApplication(Application application) {
        applicationRepository.saveAndFlush(application);
    }

    // remove an application
    public void removeApplication(Application application) {
        applicationRepository.delete(application);
    }

    // remove application by id
    public void removeApplicationById(int id) {
        applicationRepository.deleteById(id);
    }
}