package atividade.revisao;

import java.util.ArrayList;

public class Teste {

    public static void main(String[] args) {
        ImovelControlador controlador = new ImovelControlador();
        controlador.salvar(new Imovel(Imovel.NegocioEnum.LOCACAO,
                Imovel.TipoEnum.APT,
                2,
                1,
                Boolean.TRUE,
                1000f,
                360f));
        controlador.salvar(new Imovel(Imovel.NegocioEnum.LOCACAO,
                Imovel.TipoEnum.APT,
                2,
                1,
                Boolean.TRUE,
                800f,
                600f));
        controlador.salvar(new Imovel(Imovel.NegocioEnum.LOCACAO,
                Imovel.TipoEnum.CASA,
                3,
                3,
                Boolean.FALSE,
                1900f,
                0f));
        controlador.salvar(new Imovel(Imovel.NegocioEnum.VENDA,
                Imovel.TipoEnum.CASA,
                2,
                1,
                Boolean.FALSE,
                500000f,
                0f));
        ArrayList<Imovel> busca = controlador.getPorNegocio(
                Imovel.NegocioEnum.LOCACAO,
                ImovelControlador.OrdenacaoValorEnum.TOTAL,
                ImovelControlador.OrdenacaoEnum.DESCENDENTE);

        System.out.println("Busca por LOCACAO");
        busca = controlador.getPorNegocio(
                Imovel.NegocioEnum.LOCACAO,
                ImovelControlador.OrdenacaoValorEnum.LOCACAO,
                ImovelControlador.OrdenacaoEnum.ASCENDENTE);

        controlador.getPorGaragem(Boolean.TRUE, ImovelControlador.OrdenacaoValorEnum.TOTAL, ImovelControlador.OrdenacaoEnum.ASCENDENTE);
        controlador.getPorTipo(Imovel.TipoEnum.APT, ImovelControlador.OrdenacaoValorEnum.TOTAL, ImovelControlador.OrdenacaoEnum.ASCENDENTE);

        for (Imovel imovel : busca) {
            System.out.println(imovel);
        }
        System.out.println("");

        Imovel imovelParaAlterar = controlador.getById(1);
        System.out.println("Imóvel para alterar:");
        System.out.println(imovelParaAlterar);
        System.out.println("Imóvel que irá alterar o principal");
        Imovel novoImovel = new Imovel(Imovel.NegocioEnum.LOCACAO, Imovel.TipoEnum.APT, 5, 2, Boolean.TRUE, 2500f, 1000f);
        System.out.println(novoImovel);
        controlador.alterar(1, novoImovel);
        System.out.println("Novos dados do imóvel");
        System.out.println(controlador.getById(1));

    }
}
