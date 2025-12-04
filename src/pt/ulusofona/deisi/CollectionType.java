package pt.ulusofona.deisi;

import java.util.Objects;

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

    public static CollectionType fromCode(int code, String name) {
        for (CollectionType opt : values()) {
            if(opt.code == code|| Objects.equals(opt.name, name)) {
                return opt;
            }
        }
        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
