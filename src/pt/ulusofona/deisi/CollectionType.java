package pt.ulusofona.deisi;

public enum CollectionType {
    MOVIES(1, "Filme"),
    GAMES(2, "Jogos"),
    MUSICS(3, "Música");

    private final int code;
    private final String name;

    CollectionType(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static CollectionType fromCode(int code) {
        for (CollectionType opt : values()) {
            if(opt.code == code) {
                return opt;
            }
        }
        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
