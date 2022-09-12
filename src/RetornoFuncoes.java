public class RetornoFuncoes {
    private boolean Sucesso;

    public RetornoFuncoes(Boolean Sucesso) {
        this.Sucesso = Sucesso;
    }

    public String RetornaMensagem(){
        if(this.Sucesso){
            return String.format("Operação realizada com sucesso. %s");
        }
        return String.format("Não foi possível completar a operação. %s");
    }
}
