package graphql;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import entite.Logement;
import entite.RendezVous;
import repository.LogementRepository;
import repository.RendezVousRepository;

public class Query implements GraphQLRootResolver {
    
    private final LogementRepository logementRepository;
    private final RendezVousRepository rdvRepository;
    
    public Query(LogementRepository logementRepository,RendezVousRepository rdvRepository) {
        this.logementRepository = logementRepository;
		this.rdvRepository = rdvRepository;
    }
    
    public List<Logement> allLogements() {
        return logementRepository.getAllLogements();
    }
    
    public Logement getLogementByRef(int reference) {
        return logementRepository.getLogementsByReference(reference);
    }
    public List<RendezVous> getRdvsByLog(int reference) {
        return rdvRepository.getListeRendezVousByLogementRef(reference);
    }

    public RendezVous getRdvsById(int id){
        return rdvRepository.getRendezVousById(id);
    }
    public List<RendezVous> allRendezVous() {
        return rdvRepository.getListeRendezVous();
    }
    public List<Logement> getLogementByType (Logement.TypeL type){
        return logementRepository.getLogementsByType(type);
    }
}
