package co.edu.eci.blueprints.filter;

import co.edu.eci.blueprints.model.Blueprint;

public interface BlueprintsFilter {
    Blueprint apply(Blueprint bp);
}