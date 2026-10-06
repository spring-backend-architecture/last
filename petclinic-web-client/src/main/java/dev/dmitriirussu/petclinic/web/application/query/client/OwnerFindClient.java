package dev.dmitriirussu.petclinic.web.application.query.client;

import dev.dmitriirussu.petclinic.web.application.query.view.OwnerDetailsView;

public interface OwnerFindClient {
    OwnerDetailsView findById(String id);
}
