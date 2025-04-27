package projetoFinal.Projeto.Final.enus;

public enum MeioDePagamento {
    BOLETO(1),
    CARTAO_CREDITO(2),
    CARTAO_DEBITO(3),
    CHEQUE(4),
    DINHEIRO(5),
    PIX(6);

    private final int value;

    MeioDePagamento(int value) {
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
        throw new IllegalArgumentException("Valor inválido para MeioPagamento: " + value);
    }
}