package br.com.fuzusnoary.passrepositoryapi.entities.enums;

public enum PassType {
    TEXT(0),
    NUMERIC(1);

    int value;

    PassType(int value) {
        this.value = value;
    }

    public static PassType valueOf(int value) {
        for (PassType passType : PassType.values()) {
            if (passType.value == value) {
                return passType;
            }
        }
        throw new RuntimeException("value not found: " + value);
    }

}
