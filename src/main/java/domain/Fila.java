package domain;


public class Fila <T> {
        
        private T[] vetor;
        private int quantidadeElementos = 0;

        public Fila(){
            vetor = (T[]) new Object[6];

        }
        
        public void inserir(T elemento) {
        this.redimensionar();
        vetor[quantidadeElementos] = elemento;
        this.quantidadeElementos++;
      }

        public boolean existeDado(T elemento) {
            if (isEmpty()) {
              System.out.println("Erro! A fila Vazia!");
              return false;
            }
            return vetor[0] == elemento;
          }

      public boolean isEmpty() {
        return quantidadeElementos == 0;
      }

      public T recuperar() {
            if (isEmpty()) {
              System.out.println("Erro! A fila Vazia!");
              return null;
            }
            return vetor[0];
          }

      public void alterar(T elemento) {
            if (isEmpty()) {
              System.out.println("Erro! A fila Vazia!");
            } else {
              vetor[0] = elemento;
            }
          }

        public void remover() {
            if (isEmpty()) {
              System.out.println("Erro! A fila Vazia!");
            } else {
              Iterador<T> iterador = new Iterador<>(vetor);
              while (iterador.hasNext()) {
                vetor[iterador.getPosicao()] = vetor[iterador.getPosicao() + 1];
                iterador.next();
              }
              vetor[quantidadeElementos] = null;
              this.quantidadeElementos--;
            }
      }


      public int tamanho() {
        return quantidadeElementos;
      }


      public void limpar() {
        Iterador<T> iterador = new Iterador<>(vetor);
        while (iterador.hasNext()) {
          vetor[iterador.getPosicao()] = null;
          iterador.next();
        }
        this.quantidadeElementos = 0;
      }


      private void redimensionar() {
        if (this.quantidadeElementos == this.vetor.length) {

          T[] filaCopia = (T[]) new Object[this.quantidadeElementos * 2];

          Iterador<T> iterador = new Iterador<>(vetor);
          while (iterador.hasNext()) {
            filaCopia[iterador.getPosicao()] = this.vetor[iterador.getPosicao()];
            iterador.next();
          }

          this.vetor = filaCopia;
        }
      }

      @Override
      public String toString() {

        if (this.isEmpty()) return "[]";
        Iterador<T> iterador = new Iterador<>(vetor);
        String filaToString = "[" + iterador.next();
        while (iterador.hasNext()) {
          filaToString += ", " + iterador.next();
        }
        filaToString += "]";

        return filaToString;
      }
}
