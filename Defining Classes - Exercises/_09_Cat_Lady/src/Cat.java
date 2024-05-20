public class Cat
{
    private Cymric cymric;
    private Siamese siamese;
    private StreetExtraordinaire streetExtraordinaire;

    public Cat(Cymric cymric, Siamese siamese, StreetExtraordinaire streetExtraordinaire) {
        this.cymric = cymric;
        this.siamese = siamese;
        this.streetExtraordinaire = streetExtraordinaire;
    }

    public Cymric getCymric() {
        return cymric;
    }

    public void setCymric(Cymric cymric) {
        this.cymric = cymric;
    }

    public Siamese getSiamese() {
        return siamese;
    }

    public void setSiamese(Siamese siamese) {
        this.siamese = siamese;
    }

    public StreetExtraordinaire getStreetExtraordinaire() {
        return streetExtraordinaire;
    }

    public void setStreetExtraordinaire(StreetExtraordinaire streetExtraordinaire) {
        this.streetExtraordinaire = streetExtraordinaire;
    }
}
