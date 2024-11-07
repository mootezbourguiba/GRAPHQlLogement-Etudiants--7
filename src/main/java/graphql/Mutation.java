package graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import entite.RendezVous;
import entite.Logement;
import repository.RendezVousRepository;
import repository.LogementRepository;

public class Mutation implements GraphQLMutationResolver {
    private final RendezVousRepository rendezVousRepository;
    private final LogementRepository logementRepository;

    public Mutation(RendezVousRepository rendezVousRepository, LogementRepository logementRepository) {
        this.rendezVousRepository = rendezVousRepository;
        this.logementRepository = logementRepository;
    }

    public RendezVous createRendezVous(int id, String date, String heure, int refLog, String numTel) {
        Logement logement = logementRepository.getLogementsByReference(refLog);
        if (logement != null) {
            RendezVous rendezVous = new RendezVous(id, date, heure, logement, numTel);
            if (rendezVousRepository.addRendezVous(rendezVous)) {
                return rendezVous;
            }
        }
        return null;
    }

    // Ajoutez d'autres mutations selon vos besoins
}

