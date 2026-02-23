package co.edu.eci.blueprints.services;

import org.springframework.stereotype.Service;

import co.edu.eci.blueprints.filter.BlueprintsFilter;
import co.edu.eci.blueprints.model.Blueprint;
import co.edu.eci.blueprints.persistance.BlueprintNotFoundException;
import co.edu.eci.blueprints.persistance.BlueprintPersistence;
import co.edu.eci.blueprints.persistance.BlueprintPersistenceException;

import java.util.Set;

@Service
public class BlueprintsServices {

    private final BlueprintPersistence persistence;
    private final BlueprintsFilter filter;

    public BlueprintsServices(BlueprintPersistence persistence, BlueprintsFilter filter) {
        this.persistence = persistence;
        this.filter = filter;
    }

    public void addNewBlueprint(Blueprint bp) throws BlueprintPersistenceException {
        persistence.saveBlueprint(bp);
    }

    public Set<Blueprint> getAllBlueprints() {
        return persistence.getAllBlueprints();
    }

    public Set<Blueprint> getBlueprintsByAuthor(String author) throws BlueprintNotFoundException {
        return persistence.getBlueprintsByAuthor(author);
    }

    public Blueprint getBlueprint(String author, String name) throws BlueprintNotFoundException {
        return filter.apply(persistence.getBlueprint(author, name));
    }

    public void addPoint(String author, String name, int x, int y) throws BlueprintNotFoundException {
        persistence.addPoint(author, name, x, y);
    }
}