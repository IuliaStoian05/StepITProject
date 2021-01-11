package AccountingSoftware.model;

public enum Gender {
    M(1),
    F(2),
    O(3);
    private int value;

    Gender(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    }

