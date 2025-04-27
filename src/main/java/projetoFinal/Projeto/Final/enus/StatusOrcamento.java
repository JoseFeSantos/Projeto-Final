//package projetoFinal.Projeto.Final.enus;
//
//public enum StatusOrcamento {
//
//    RASCUNHO("Rascunho", "bg-gray-200"),
//    EM_ANALISE("Em Análise", "bg-yellow-200"),
//    APROVADO("Aprovado", "bg-green-200"),
//    REPROVADO("Reprovado", "bg-red-200"),
//    CONCLUIDO("Concluído", "bg-blue-200"),
//    CANCELADO("Cancelado", "bg-purple-200");
//
//    private final String descricao;
//    private final String cor; // Para uso em frontend
//
//    StatusOrcamento(String descricao, String cor) {
//        this.descricao = descricao;
//        this.cor = cor;
//    }
//
//    // Getters
//    public String getDescricao() {
//        return descricao;
//    }
//
//    public String getCor() {
//        return cor;
//    }
//
//    // Método para converter de String para enum
//    public static StatusOrcamento fromString(String text) {
//        for (StatusOrcamento status : StatusOrcamento.values()) {
//            if (status.name().equalsIgnoreCase(text)) {
//                return status;
//            }
//        }
//        throw new IllegalArgumentException("Nenhum status encontrado para: " + text);
//    }
//}