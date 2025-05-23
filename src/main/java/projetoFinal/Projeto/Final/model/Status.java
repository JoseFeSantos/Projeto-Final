package projetoFinal.Projeto.Final.model;

public enum Status {
    ACTIVE(1),
    INACTIVE(0),
    BLOQUEADO(-1);

    private final int value;

    Status(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Status fromValue(int value) {
        for (Status status : Status.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Valor inválido: " + value);
    }
}
