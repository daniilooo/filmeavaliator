/*Um cinema possui capacidade de 40 lugares e está sempre com ocupação total. Certo dia, 
cada espectador respondeu a um questionário, no qual constava:
- idade;
- opinião em relação ao filme, segundo as seguintes notas:

      A - Ótimo /  B - Bom / C - Regular  / D - Ruim  / E -  Péssimo.

 Elabore a codificação em JAVA para que leia os dados, calcule e exiba na tela:
- a quantidade de respostas "ótimo";
- a média de idade das pessoas que responderam "ruim";
- a porcentagem de respostas "péssimo".
*/
package filmeavaliator;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;


public class FilmeAvaliatorIG {
    public static void main (String[] args){
    
        float lugares = Float.parseFloat(JOptionPane.showInputDialog("Quantas pessoas assistiram o filme ?"));
        float idade = 0;
        int opiniao;
        float contOtimo = 0, contBOm = 0, contRegular = 0, contRuim = 0, contPessimo = 0;
        float somaDasIdades = 0;
        float mediaDeIdades;
        DecimalFormat formatPercent = new DecimalFormat("##,##");
        DecimalFormat formatInteiro = new DecimalFormat("#");
        int verificacao = 1;
        
        
        while(lugares >= verificacao){
           boolean idadeValida = false;
           
           while(!idadeValida){
               try{
                idade = Float.parseFloat(JOptionPane.showInputDialog("Qual a sua idade ?"));
                idadeValida = true;
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Digite um número válido");
            }
           }

            String[] opcoes = {"A - Ótimo", "B - Bom", "C - Regular", "D - Ruim", "E - Péssimo"};
            opiniao = JOptionPane.showOptionDialog(null, "Qual é a sua opinião sobre o filme?", "Opinião", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, null);

            switch(opiniao) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Que legal que você adorou o filme \n Espectador nº: " +verificacao);
                    contOtimo++;
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, "Que bom que você achou o filme bom \n Espectador nº: " +verificacao);
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Você achou o filme regular \n Espectador nº: " +verificacao);
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Que pena que você não gostou do filme... \n Espectador nº: " +verificacao);
                    contRuim++;
                    somaDasIdades = somaDasIdades + idade;
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Nossa, ficamos na bad que você odiou o filme \n Espectador nº: " +verificacao);
                    contPessimo++;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
                    verificacao--;
                    break;
            }
            verificacao++;
        }
        
        String contOtimoFormatado = formatInteiro.format(contOtimo);
        
        if(contRuim != 0){
            mediaDeIdades = somaDasIdades / contRuim;
        }else {
            mediaDeIdades = 0; 
        }
        
        String contMediaFormatado = formatInteiro.format(mediaDeIdades);
 
        float percentPessimo = (contPessimo / lugares)*100;
        String percentFormatado = formatPercent.format(percentPessimo);
        
        JOptionPane.showMessageDialog(null, "Quantidade de pessoas que achou o filme ótimo: " +contOtimoFormatado+ "\nMédia da idade das pessoas que acharam o filme ruim: " +contMediaFormatado+ "\nPercentual de pessoas que acharam o filme péssimo: " +percentFormatado+"%");
    
    }
    
}