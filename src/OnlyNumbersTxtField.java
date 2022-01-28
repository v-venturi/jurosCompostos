import javax.swing.*;
import java.awt.event.KeyEvent;


/**
 * Source: https://www.devmedia.com.br/como-alterar-o-componente-jtextfield-para-aceitar-apenas-numeros/26152
 * The type Only numbers txt field.
 */
public class OnlyNumbersTxtField extends JTextField {
    private int maximoCaracteres=-1;

    /**
     * Instantiates a new Only numbers txt field.
     */
    public OnlyNumbersTxtField() {
        super();
        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldKeyTyped(evt);}});
    }

    /**
     * Instantiates a new Only numbers txt field.
     *
     * @param maximo the maximo
     */
    public OnlyNumbersTxtField(int maximo) {
        super();
        setMaximoCaracteres(maximo);
        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldKeyTyped(evt);}});
    }
    private void jTextFieldKeyTyped(KeyEvent evt) {

        String caracteres="0987654321.";// lista de caracters que não devem ser aceitos
        if(!caracteres.contains(evt.getKeyChar()+"")){// se o caracter que gerou o
//            evento estiver não estiver na lista
            evt.consume();//aciona esse propriedade para eliminar a ação do evento
        }
        if((getText().length()>=getMaximoCaracteres())&&(getMaximoCaracteres()!=-1)){
//if para saber se precisa verificar também o tamanho da string do campo
// maior ou igual ao tamanho máximo, cancela e nao deixa inserir mais
            evt.consume();
            setText(getText().substring(0,getMaximoCaracteres()));
        }
    }

    /**
     * Gets maximo caracteres.
     *
     * @return the maximo caracteres
     */
    public int getMaximoCaracteres() {
        return maximoCaracteres;
    }

    /**
     * Sets maximo caracteres.
     *
     * @param maximoCaracteres the maximo caracteres
     */
    public void setMaximoCaracteres(int maximoCaracteres) {
        this.maximoCaracteres = maximoCaracteres;
    }
}
