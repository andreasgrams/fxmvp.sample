package de.dreamnetworx.fxmvp.sample.app.service;

import de.dreamnetworx.fxmvp.sample.app.ui.model.PersonViewModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonServiceImpl implements PersonService {

    private static final Logger LOG = LoggerFactory.getLogger(PersonServiceImpl.class);

    private List<PersonViewModel> list = new ArrayList<>();

    public PersonServiceImpl() {
        list.add(new PersonViewModel(1L,"Firstname", "Surname", "avatar/one.png"));
        list.add(new PersonViewModel(2L,"Firstname 2", "Surname", "avatar/two.png"));
        list.add(new PersonViewModel(3L,"Firstname 3", "Surname", "avatar/three.png"));
        list.add(new PersonViewModel(4L,"Firstname 4", "Surname", ""));

    }

    @Override
    public PersonViewModel getDetail(Long id) {
        final int index = list.indexOf(new PersonViewModel(id));
        final PersonViewModel detail = list.get(index);
        return detail;
    }

    @Override
    public List<PersonViewModel> getPersons() {
        LOG.info("load data from persistence storage....");
        return list;
    }

}
