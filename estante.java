import java.util.ArrayList;

public class estante {
    ArrayList<livroLido> listaLidos;
    ArrayList<livroTBR> listaTBR;

    public estante(ArrayList<livroLido> listaLidos, ArrayList<livroTBR> listaTBR) {
        this.listaLidos = listaLidos;
        this.listaTBR = listaTBR;
    }
    public ArrayList<livroLido> getListaLidos() {
        return listaLidos;
    }
    public void setListaLidos(ArrayList<livroLido> listaLidos) {
        this.listaLidos = listaLidos;
    }
    public void addLivroLido(livroLido livro){
        this.listaLidos.add(livro);
    }
    public ArrayList<livroTBR> getListaTBR() {
        return listaTBR;
    }
    public void setListaTBR(ArrayList<livroTBR> listaTBR) {
        this.listaTBR = listaTBR;
    }
    public void addLivroTBR(livroTBR livro){
        this.listaTBR.add(livro);
    }
}