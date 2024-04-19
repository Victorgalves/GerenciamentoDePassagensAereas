package br.edu.cesarschool.cc.poo.ac.passagem;

import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;

public class BilheteVipDAO {
    private CadastroObjetos cadastro= new CadastroObjetos(CadastroObjetos.class);

    public BilheteVipDAO() {

    }
    private String obterIdUnico(BilheteVip bilheteVip){
        return bilheteVip.gerarNumero();
    }
    public BilheteVip buscar(String numeroBilhete){
        return (BilheteVip) cadastro.buscar(numeroBilhete);
    }

    public boolean incluir(BilheteVip bilhetevip) {
        String idUnico = obterIdUnico(bilhetevip);
        BilheteVip b = buscar(idUnico);
        if (b == null) {
            cadastro.incluir(bilhetevip, idUnico);
            return true;
        }
        return false;
    }

    public boolean alterar(BilheteVip bilhetevip){
        String idUnico = obterIdUnico(bilhetevip);
        BilheteVip b = buscar(idUnico);
        if (b!= null) {
            cadastro.alterar(bilhetevip, idUnico);
            return true;
        }
        return false;
    }

    public boolean excluir(String numeroBilhete){
        BilheteVip b = buscar(numeroBilhete);
        if (b != null) {
            cadastro.excluir(numeroBilhete);
            return true;
        }
        return false;
    }

}
