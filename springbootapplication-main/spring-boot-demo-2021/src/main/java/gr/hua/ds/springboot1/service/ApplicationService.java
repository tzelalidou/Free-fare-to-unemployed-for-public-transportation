package gr.hua.ds.springboot1.service;
import gr.hua.ds.springboot1.entity.Application;
import gr.hua.ds.springboot1.repository.ApplicationRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

    public List<Application> getApplicationsforOASA() {
        List<Application> allapl = getApplications();
        ArrayList<Application> oasa=new ArrayList<>();
        for(int i=0;i<allapl.size();i++){
            if(allapl.get(i).getApplicationstatus()==1) {
                oasa.add(allapl.get(i));
            }
        }
        return oasa;
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

    // get Applications of unemployed users by their username.
    public List<Application> getApplicationsUnemployed(String username) {
        List<Application> allapl = getApplications();
        ArrayList<Application> unemp = new ArrayList<>();
        for(int i=0;i<allapl.size();i++){
            if(allapl.get(i).getUser().getUsername().equals(username)) {
                unemp.add(allapl.get(i));
            }
        }
        return unemp;
    }
    private Connection connect() {
        String username = "root";
        String password = "root";
        // SQLite connection string
        String url = "jdbc:mysql://localhost:3306/userlist?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void delete(int id) {

        //String sql = "DELETE FROM `userlist`.`application` WHERE (`aid` = '?');";
        String sql = "DELETE FROM userlist.application WHERE aid = ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, id);
            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveFileFromApplication( MultipartFile file,Application appl) throws IOException {
        // save image in local file
        Path currentPath = Paths.get("");
        Path absPath = currentPath.toAbsolutePath();
        Path path = Paths.get(absPath + "\\springbootapplication-main\\spring-boot-demo-2021\\src\\main\\resources\\img\\"+appl.getImgname());
        System.out.println(path);
        Files.copy(file.getInputStream(), path);

    }
    public void saveFileFromApplicationInC( MultipartFile file,Application appl) throws IOException {
        // save image in local file
        String UPLOAD_DIR = "C:img";
        Path path = Paths.get(UPLOAD_DIR +appl.getImgname());
        Files.copy(file.getInputStream(), path);
    }
    public void saveByteImgFromApplicationInC( MultipartFile file,Application appl) throws IOException {
        // save image in local file
        String UPLOAD_DIR = "C:img";
        byte [] bytes=appl.getImgname().getBytes();
        Path path = Paths.get(UPLOAD_DIR +appl.getImgname());
        Files.write(path,bytes);
    }
}