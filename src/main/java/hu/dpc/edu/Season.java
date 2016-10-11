package hu.dpc.edu;

/**
 * Created by vrg on 11/10/16.
 */
public enum Season {
    WINTER("Tel"),
    SPRING("Tavasz"),
    SUMMER("Nyar"),
    AUTUMN("Osz");

    private String displayName;

    private Season(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
