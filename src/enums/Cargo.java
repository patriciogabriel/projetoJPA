package enums;

public enum Cargo {
    A("Administrativo"),
    I("Instrutor"),
    At("Atendente"),
    F("Limpeza");
    
    String descricao;

    private Cargo(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    } 
}
