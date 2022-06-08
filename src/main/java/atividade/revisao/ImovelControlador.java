package atividade.revisao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Aluno
 */
public class ImovelControlador {

    public enum OrdenacaoEnum {
        ASCENDENTE, DESCENDENTE
    }

    public enum OrdenacaoValorEnum {
        TOTAL, LOCACAO
    }
    private int contador = 1;
    private ArrayList<Imovel> imoveis = new ArrayList<>();

    public void salvar(Imovel imovel) {
        imovel.setId(contador);

        imoveis.add(imovel);

        contador++;
    }

    public void remover(Imovel imovel) {
        imoveis.remove(imovel);
    }

    public void remover(int id) {
        Imovel imovelParaRemover = null;
        for (Imovel imovel : imoveis) {
            if (imovel.getId() == id) {
                imovelParaRemover = imovel;
                break;
            }
        }
        if (imovelParaRemover != null) {
            remover(imovelParaRemover);
            System.out.printf("Imóvel %s removido com sucesso\n", id);
        } else {
            System.out.printf("Imóvel %s não encontrado\n", id);

        }
    }

    public void alterar(int id, Imovel imovelNovo) {

        Imovel imovelAntigo = null;
        for (Imovel imovel : imoveis) {
            if (imovel.getId() == id) {
                imovelAntigo = imovel;
            }
        }
        if (imovelAntigo != null) {
            imovelAntigo.setBanheiro(imovelNovo.getBanheiro());
            imovelAntigo.setQuarto(imovelNovo.getQuarto());
            imovelAntigo.setNegocio(imovelNovo.getNegocio());
            imovelAntigo.setTipo(imovelNovo.getTipo());
            imovelAntigo.setGaragem(imovelNovo.getGaragem());
            imovelAntigo.setValorLocacao(imovelNovo.getValorLocacao());
            imovelAntigo.setValorCondominio(imovelNovo.getValorCondominio());
            System.out.printf("Imóvel %s alterado com sucesso!", id);
        } else {
            System.out.printf("Imóvel %s não encontrado!", id);
        }
    }

    public ArrayList<Imovel> getPorNegocio(Imovel.NegocioEnum negocio,
            OrdenacaoValorEnum ordemValor, OrdenacaoEnum ordenacao) {
        ArrayList<Imovel> busca = new ArrayList<>();

        if (negocio != null) {
            for (Imovel imovel : imoveis) {
                if (imovel.getNegocio() == negocio) {
                    busca.add(imovel);
                }
            }
        } else {
            busca.addAll(imoveis);
        }

        busca.sort(new ComparadorImovel(ordenacao, ordemValor));
        return busca;
    }

    public ArrayList<Imovel> getPorTipo(Imovel.TipoEnum tipo,
            OrdenacaoValorEnum ordemValor, OrdenacaoEnum ordenacao) {
        ArrayList<Imovel> busca = new ArrayList<>();
        if (tipo != null) {
            for (Imovel imovel : imoveis) {
                if (imovel.getTipo() == tipo) {
                    busca.add(imovel);
                }
            }
        } else {
            busca.addAll(imoveis);

        }

        busca.sort(new ComparadorImovel(ordenacao, ordemValor));
        return busca;
    }

    public ArrayList<Imovel> getPorValorLocacao(Float min, Float max,
            OrdenacaoValorEnum ordemValor, OrdenacaoEnum ordenacao) {
        ArrayList<Imovel> busca = new ArrayList<>();
        for (Imovel imovel : imoveis) {
            if (imovel.getValorLocacao() >= min && imovel.getValorLocacao() <= max) {
                busca.add(imovel);
            }
        }
        busca.sort(new ComparadorImovel(ordenacao, ordemValor));
        return busca;
    }

    public ArrayList<Imovel> getPorGaragem(Boolean garagem,
            OrdenacaoValorEnum ordemValor, OrdenacaoEnum ordenacao) {
        ArrayList<Imovel> busca = new ArrayList<>();
        if (garagem == null) {
            for (Imovel imovel : imoveis) {
                if (imovel.getGaragem().equals(garagem)) {
                    busca.add(imovel);
                }
            }
        } else {
            busca.addAll(imoveis);
        }
        busca.sort(new ComparadorImovel(ordenacao, ordemValor));

        return busca;
    }

    public Imovel getById(int id) {
        for (Imovel imovel : imoveis) {
            if (imovel.getId() == id) {
                return imovel;
            }
        }
        System.out.println("Imóvel não encontrado.");
        return null;
    }

    
}
