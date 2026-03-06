public class ModeleVoiture {
    private int id;
    private MarqueEnum marqueEnum;
    private ModeleEnum modeleEnum;

    public ModeleVoiture(int id, MarqueEnum marqueEnum, ModeleEnum modeleEnum){
        this.id = id;
        this.marqueEnum = marqueEnum;
        this.modeleEnum = modeleEnum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MarqueEnum getMarqueEnum() {
        return marqueEnum;
    }

    public void setMarqueEnum(MarqueEnum marqueEnum) {
        this.marqueEnum = marqueEnum;
    }

    public ModeleEnum getModeleEnum() {
        return modeleEnum;
    }

    public void setModeleEnum(ModeleEnum modeleEnum) {
        this.modeleEnum = modeleEnum;
    }

    @Override
    public String toString() {
        return "ModeleVoiture [id=" + id + ", marque=" + marqueEnum + ", modele=" + modeleEnum + "]";
    }
}
