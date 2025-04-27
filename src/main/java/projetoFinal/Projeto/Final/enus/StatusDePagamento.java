package projetoFinal.Projeto.Final.enus;

public enum StatusDePagamento {
    EM_ABERTO(1),
    EM_ATRASO(2),
    PAGO(3);

    private final int value;

    StatusDePagamento(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static MeioDePagamento fromValue(int value) {
        for (MeioDePagamento meio : MeioDePagamento.values()) {
            if (meio.getValue() == value) {
                return meio;
            }
        }
        throw new IllegalArgumentException("Status inválido: " + value);
    }
}