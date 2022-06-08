package atividade.revisao;

public class Imovel implements Comparable<Imovel> {

    @Override
    public int compareTo(Imovel o) {
        return Integer.valueOf(id).compareTo(o.getId());
    }

    public enum NegocioEnum {
        VENDA, LOCACAO
    }

    public enum TipoEnum {
        CASA, APT, TERRENO, KITNET
    }

    private int id;
    private NegocioEnum negocio;
    private TipoEnum tipo;
    private Integer quarto;
    private Integer banheiro;
    private Boolean garagem;
    private Float valorLocacao;
    private Float valorCondominio;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Imovel(NegocioEnum negocio, TipoEnum tipo, Integer quarto, Integer banheiro, Boolean garagem, Float valorLocacao, Float valorCondominio) {
        this.negocio = negocio;
        this.tipo = tipo;
        this.quarto = quarto;
        this.banheiro = banheiro;
        this.garagem = garagem;
        this.valorLocacao = valorLocacao;
        this.valorCondominio = valorCondominio;
    }

    public Imovel(Float valor) {
        this.valorLocacao = valor;
    }

    /**
     * @return the negocio
     */
    public NegocioEnum getNegocio() {
        return negocio;
    }

    /**
     * @param negocio the negocio to set
     */
    public void setNegocio(NegocioEnum negocio) {
        this.negocio = negocio;
    }

    /**
     * @return the tipo
     */
    public TipoEnum getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoEnum tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the quarto
     */
    public Integer getQuarto() {
        return quarto;
    }

    /**
     * @param quarto the quarto to set
     */
    public void setQuarto(Integer quarto) {
        this.quarto = quarto;
    }

    /**
     * @return the banheiro
     */
    public Integer getBanheiro() {
        return banheiro;
    }

    /**
     * @param banheiro the banheiro to set
     */
    public void setBanheiro(Integer banheiro) {
        this.banheiro = banheiro;
    }

    /**
     * @return the garagem
     */
    public Boolean getGaragem() {
        return garagem;
    }

    /**
     * @param garagem the garagem to set
     */
    public void setGaragem(Boolean garagem) {
        this.garagem = garagem;
    }

    /**
     * @return the valorLocacao
     */
    public Float getValorLocacao() {
        return valorLocacao;
    }

    /**
     * @param valorLocacao the valorLocacao to set
     */
    public void setValorLocacao(Float valorLocacao) {
        this.valorLocacao = valorLocacao;
    }

    /**
     * @return the valorCondominio
     */
    public Float getValorCondominio() {
        return valorCondominio;
    }

    /**
     * @param valorCondominio the valorCondominio to set
     */
    public void setValorCondominio(Float valorCondominio) {
        this.valorCondominio = valorCondominio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("ID: %s\n", id));
        sb.append(String.format("Negócio: %s\n", negocio));
        sb.append(String.format("Tipo: %s\n", tipo));
        sb.append(String.format("Quartos: %s\n", quarto));
        sb.append(String.format("Banheiros: %s\n", banheiro));
        sb.append(String.format("Garagem: %s\n", garagem ? "Sim" : "Não"));
        sb.append(String.format("Valor locação: %s\n", valorLocacao));
        sb.append(String.format("Valor condomínio: %s\n", valorCondominio));
        sb.append(String.format("Valor total: %s\n", (valorLocacao + valorCondominio)));

        return sb.toString();
    }

}
