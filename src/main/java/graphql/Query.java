package graphql;
import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entite.RendezVous;
import repository.RendezVousRepository;

import java.util.List;

public class Query implements GraphQLRootResolver {
    private RendezVousRepository rendezVousRepository;
    public Query (RendezVousRepository repoR){
        this.rendezVousRepository= repoR;

    }
    public List<RendezVous> getallrendezVous(){
        return this.rendezVousRepository.getListeRendezVous();
    }
}
