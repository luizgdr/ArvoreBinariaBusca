class Node {
    private int valor;
    private Node esquerda, direita;
    public Node(int valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }

    public Node pop(int n, Node pai) {
        Node ret = null;
        if (this.valor == n) {
            if (this.folha()) {
                // remover referência no nó pai
                if (pai.getEsquerda() == this) {
                    pai.setEsquerda(null);
                } else {
                    pai.setDireita(null);
                }
            } else {
                // checar se existe apenas um filho, caso verdade o pai de ret
                // agora referencia o nó filho de ret
                if (this.getDireita() == null && this.getEsquerda() != null) {
                    if (pai.getEsquerda() == this) {
                        pai.setEsquerda(this.getEsquerda());
                    } else {
                        pai.setDireita(this.getEsquerda());
                    }
                } else if
                   (this.getDireita() != null && this.getEsquerda() == null) {
                    if (pai.getEsquerda() == this) {
                        pai.setEsquerda(this.getDireita());
                    } else {
                        pai.setDireita(this.getDireita());
                    }
                }
                // se ret tiver mais de um filho, procurar pelo maior elemento
                // da subárvore esquerda e substituir no lugar de ret
                else {
                    Node anterior = this, maior = this.getEsquerda();
                    while (maior.getDireita() != null) {
                        anterior = maior;
                        maior = maior.getDireita();
                    }
                    // tirar referências do nó filho antes de substituir pelo
                    // ret
                    if (anterior.getEsquerda() == this) {
                        anterior.setEsquerda(null);
                    } else {
                        anterior.setDireita(null);
                    }
                    if (pai.getEsquerda() != this) {
                        pai.setEsquerda(maior);
                    } else {
                        pai.setDireita(maior);
                    }
                    maior.setEsquerda(this.esquerda);
                    maior.setDireita(this.direita);
                }
            }
            return this;
        }

        if (this.esquerda != null) {
            ret = esquerda.pop(n, this);
        }

        /* Considerar que existe apenas um elemento com valor n */
        if (this.direita != null && ret == null) {
            ret = direita.pop(n, this);
        }
        return ret;
    }

    public void imprimir() {
        System.out.println("Valor: " + this.valor + " " + this);
        if (this.esquerda != null) {
            System.out.println("Esquerda: " + this.esquerda.getValor());
        } else {
            System.out.println("Esquerda: " + this.esquerda);
        }
        if (this.direita != null) {
            System.out.println("Direita: " + this.direita.getValor() + "\n");
        } else {
            System.out.println("Direita: " + this.direita + "\n");
        }
    }

    public void imprimir_preordem() {
        this.imprimir();

        if (this.esquerda != null) {
            this.esquerda.imprimir_preordem();
        }

        if (this.direita != null) {
            this.direita.imprimir_preordem();
        }
    }

    public void imprimir_inordem() {
        if (this.esquerda != null) {
            this.esquerda.imprimir_inordem();
        }

        this.imprimir();

        if (this.direita != null) {
            this.direita.imprimir_inordem();
        }
    }

    public void imprimir_posordem() {
        if (this.esquerda != null) {
            this.esquerda.imprimir_posordem();
        }

        if (this.direita != null) {
            this.direita.imprimir_posordem();
        }

        this.imprimir();
    }

    public void setEsquerda(Node n) {
        esquerda = n;
    }

    public void setDireita(Node n) {
        direita = n;
    }

    public void setValor(int i) {
        valor = i;
    }

    public int getValor() {
        return valor;
    }

    public Node getEsquerda() {
        return esquerda;
    }

    public Node getDireita() {
        return direita;
    }

    public boolean folha() {
        return (esquerda == null) && (direita == null);
    }
}

public class ArvoreBinariaBusca {
    // Inserir um elemento em uma árvore binária de busca
    // Percorrer a árvore binária nas formas préordem, inordem e pósordem
    // Remover o maior elemento de uma árvore binária de busca
    // Remover o menor elemento de uma árvore binária de busca
    // Remover o elemento de valor N de uma árvore binária de busca
    private Node arvore;
    public ArvoreBinariaBusca() {
        arvore = null;
    }

    public void inserir(int valor) {
        if (arvore == null) {
            arvore = new Node(valor);
            return;
        }

        Node atual = arvore;
        while (atual != null) {
            // ir para direita
            if (atual.getValor() <= valor) {
                if (atual.getDireita() != null) {
                    atual = atual.getDireita();
                } else {
                    atual.setDireita(new Node(valor));
                    break;
                }
            } else {
                // ir para esquerda
                if (atual.getEsquerda() != null) {
                    atual = atual.getEsquerda();
                } else {
                    atual.setEsquerda(new Node(valor));
                    break;
                }
            }
        }
    }

    public void imprimir() {
        arvore.imprimir();
    }

    public void imprimir_preordem() {
        arvore.imprimir_preordem();
    }

    public void imprimir_inordem() {
        arvore.imprimir_inordem();
    }

    public void imprimir_posordem() {
        arvore.imprimir_posordem();
    }

    public void remover_maior() {
        Node anterior, atual = arvore;
        while (true) {
            anterior = atual;
            atual = atual.getDireita();
            if (atual.getDireita() == null) {
                break;
            }
        }
        atual = null;
        anterior.setDireita(null);
    }

    public void remover_menor() {
        Node anterior, atual = arvore;
        while (true) {
            anterior = atual;
            atual = atual.getEsquerda();
            if (atual.getEsquerda() == null) {
                break;
            }
        }
        atual = null;
        anterior.setEsquerda(null);
    }

    public void remover(int n) {
        Node ret = arvore.pop(n, arvore);
        if (ret == null) return;
        System.out.println("Removendo " + ret + "\n");
    }

/*                 14
 *                /  \
 *               04  15
 *              /  \ 
 *             03  09
 *                /  \
 *               07  09
 *              /
 *             05
 *            /  \
 *           04  05
 *  
 *  
 *  
 *  
 *  
 *  
 *  
 *  
 *  
 *  
 *  
 *  
 * */
    public static void main(String args[]) {
        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
        arvore.inserir(14); //                14
        arvore.inserir(15); //     /   04                    15
        arvore.inserir(4);  //   03          09           14     18
        arvore.inserir(9);  //          07        09           16  20
        arvore.inserir(7);  //      05                          17
        arvore.inserir(18); //   04    05
        arvore.inserir(3);  //
        arvore.inserir(5);  //
        arvore.inserir(16); //
        arvore.inserir(4);  //
        arvore.inserir(20); //
        arvore.inserir(17); //
        arvore.inserir(9);  //
        arvore.inserir(14); //
        arvore.inserir(5);  //
        System.out.println("Pré-ordem\n");
        arvore.imprimir_preordem();
        System.out.println("In-ordem\n");
        arvore.imprimir_inordem();
        System.out.println("Pós-ordem\n");
        arvore.imprimir_posordem();
        System.out.println("Removendo maior\n");
        arvore.remover_maior();
        arvore.imprimir_preordem();
        System.out.println("Removendo menor\n");
        arvore.remover_menor();
        arvore.imprimir_preordem();
        arvore.remover(7);
        arvore.imprimir_preordem();
    }
}