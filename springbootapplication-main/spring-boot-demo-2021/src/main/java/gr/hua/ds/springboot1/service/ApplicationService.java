package gr.hua.ds.springboot1.service;
import gr.hua.ds.springboot1.entity.Application;
import gr.hua.ds.springboot1.repository.ApplicationRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import java.util.List;

@Service
public class ApplicationService {

    private ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public List<Application> getApplications() {
        return applicationRepository.findAll();
    }
}