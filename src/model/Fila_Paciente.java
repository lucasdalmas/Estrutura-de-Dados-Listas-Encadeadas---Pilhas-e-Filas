package model;

public class Fila_Paciente {
    // Estrutura de Dados que segue a Disciplina First In First Out

    // Metodos: isEmpty, init, enqueue, dequeue, first e view

    private NoPaciente inicio, fim;

    public boolean isEmpty(){
        return inicio == null && fim == null;
    }

    public void init(){
        this.inicio = null;
        this.fim = null;
    }

    public void enqueue(String dado){
        NoPaciente novo = new NoPaciente();
        novo.dado = dado;
        novo.prox = null;
        if (isEmpty()){
            this.inicio = novo;
        } else {
            this.fim.prox = novo;
        }
        this.fim = novo;
    }

    public static class Resposta{
        private String item;
        private boolean ok;

        public String getItem() {
            return item;
        }

        public boolean isOk() {
            return ok;
        }
    }

    public Resposta dequeue(){
        Resposta res = new Resposta();
        if (!isEmpty()){
            res.ok = true;
            res.item = this.inicio.dado;
            this.inicio = this.inicio.prox;
            // situação onde só há um elemento na fila
            if (this.inicio == null) this.fim = null;
        } else {
            res.ok = false;
        }
        return res;
    }

    public Resposta first(){
        Resposta res = new Resposta();
        if (!isEmpty()){
            res.ok = true;
            res.item = this.inicio.dado;
        } else {
            res.ok = false;
        }
        return res;
    }

    public void view(){
        NoPaciente aux = inicio;
        if (!isEmpty()){
            while (aux != null){
                System.out.println(aux.dado);
                aux = aux.prox;
            }
        } else {
            System.out.println("Erro: Fila vazia!");
        }
    }

}
