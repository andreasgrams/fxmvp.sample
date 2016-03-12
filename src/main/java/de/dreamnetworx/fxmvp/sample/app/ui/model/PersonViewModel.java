package de.dreamnetworx.fxmvp.sample.app.ui.model;

public class PersonViewModel {

    private Long id;
    private String firstName;
    private String surname;
    private String avatar;

    public PersonViewModel(final Long id) {
        this(id, null, null, null);
    }

    public PersonViewModel(final Long id, final String firstName, final String surname, final String avatar) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.avatar = avatar;
    }

    @Override
    public boolean equals(final Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        PersonViewModel that = (PersonViewModel) o;

        return !(id != null ? !id.equals(that.id) : that.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "PersonViewModel{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public void setSurname(final String surname) {
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getAvatar() {
        return avatar;
    }
}
