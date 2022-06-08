/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividade.revisao;

import java.util.Comparator;

/**
 *
 * @author Aluno
 */
public class ComparadorImovel implements Comparator<Imovel> {

    /**
     * @return the ordem
     */
    public ImovelControlador.OrdenacaoEnum getOrdem() {
        return ordem;
    }

    /**
     * @param ordem the ordem to set
     */
    public void setOrdem(ImovelControlador.OrdenacaoEnum ordem) {
        this.ordem = ordem;
    }

    /**
     * @return the ordemValor
     */
    public ImovelControlador.OrdenacaoValorEnum getOrdemValor() {
        return ordemValor;
    }

    /**
     * @param ordemValor the ordemValor to set
     */
    public void setOrdemValor(ImovelControlador.OrdenacaoValorEnum ordemValor) {
        this.ordemValor = ordemValor;
    }

    private ImovelControlador.OrdenacaoEnum ordem;
    private ImovelControlador.OrdenacaoValorEnum ordemValor;

    public ComparadorImovel(ImovelControlador.OrdenacaoEnum ordem, ImovelControlador.OrdenacaoValorEnum ordemValor) {
        this.ordem = ordem;
        this.ordemValor = ordemValor;
    }

    @Override
    public int compare(Imovel o1, Imovel o2) {
        if (getOrdemValor() == ImovelControlador.OrdenacaoValorEnum.LOCACAO) {
            //Ordenação de forma descendente
            if (getOrdem() == ImovelControlador.OrdenacaoEnum.DESCENDENTE) {
                return o2.getValorLocacao().compareTo(o1.getValorLocacao());
            }
            //Ordenação de forma ascendente
            return o1.getValorLocacao().compareTo(o2.getValorLocacao());

        } else {
            //Ordenação por valor total do pacote
            Float totalO1 = o1.getValorLocacao() + o1.getValorCondominio();
            Float totalO2 = o2.getValorLocacao() + o2.getValorCondominio();
            //Ordenação de forma descendente
            if (getOrdem() == ImovelControlador.OrdenacaoEnum.DESCENDENTE) {
                return totalO2.compareTo(totalO1);
            }
            //Ordenação de forma ascendente
            return totalO1.compareTo(totalO2);

        }

    }

}
