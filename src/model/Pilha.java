package model;

public class Pilha {
    // Estrutura de Dados que segue a Disciplina Last In First Out

    private No topo;

    public boolean IsEmpty(){
        return this.topo == null;
    }

    public void Init(){
        this.topo = null;
    }

    public void Push(int dado){
        No novo = new No();
        novo.dado = dado;
        novo.prox = this.topo;
        this.topo = novo;
    }

    public static class Retorno{
        private int dado;
        private boolean ok;

        public int getDado() {
            return dado;
        }
        public boolean isOk() {
            return ok;
        }
    }

    public Retorno Pop(){
        Retorno r = new Retorno();
        if (!IsEmpty()){
            r.dado = this.topo.dado;
            this.topo = this.topo.prox;
            r.ok = true;
            return r;
        }
        r.ok = false;
        return r;
    }

    public Retorno Top(){
        Retorno r = new Retorno();
        if (!IsEmpty()){
            r.dado = this.topo.dado;
            r.ok = true;
            return r;
        }
        r.ok = false;
        return r;
    }

    public void View(){
        No aux = topo;
        if (!IsEmpty()){
            while (aux != null){
                System.out.println(aux.dado);
                aux = aux.prox;
            }
        } else {
            System.out.println("Erro: Pilha vazia!");
        }

    }


    public Pilha(){}

}
