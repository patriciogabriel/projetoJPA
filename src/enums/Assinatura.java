package enums;

public enum Assinatura {
    A("Anual"),
    M("Mensal"),
    T("Trimestral"),
    S("Semestral");
    
    String descricao;

    private Assinatura(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}
