package de.dreamnetworx.fxmvp.sample.app.service;

import de.dreamnetworx.fxmvp.sample.app.ui.model.PersonViewModel;

import java.util.List;

public interface PersonService {

    PersonViewModel getDetail(Long id);

    List<PersonViewModel> getPersons();
}
