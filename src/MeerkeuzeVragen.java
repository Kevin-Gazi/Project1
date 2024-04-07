class MeerkeuzeVragen extends Vraag {
    private String[] opties;

    public MeerkeuzeVragen(String vraag, String[] opties) {
        super(vraag);
        this.opties = opties;
    }

    public String[] getOpties() {
        return opties;
    }
}
