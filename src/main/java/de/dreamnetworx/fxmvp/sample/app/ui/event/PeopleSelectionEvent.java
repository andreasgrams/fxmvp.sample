package de.dreamnetworx.fxmvp.sample.app.ui.event;

import de.dreamnetworx.fxmvp.sample.app.ui.model.PersonViewModel;

public class PeopleSelectionEvent {

    private PersonViewModel item;

    public PeopleSelectionEvent(PersonViewModel item) {
        this.item = item;
    }

    public PersonViewModel getItem() {
        return item;
    }
}
