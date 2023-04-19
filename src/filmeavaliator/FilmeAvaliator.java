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
import java.text.DecimalFormat;
import java.util.Scanner;
/**
 *
 * @author engdanilofranco
 */
public class FilmeAvaliator {

    
    public static void main(String[] args) {
        
        //primeiro vamos fazer a parte onde o usuário entra com a idade e avaliação do filme
        
        /*declaração das variaveis necessárias para isso. Precisamos armazenar a idade, 
        a avaliação e precisamos de uma variavel que vai ser responsável pela contagem dos 40 lugares*/
        
        int idade;
        char avaliacao;
        int lugares = 0;
        int contOtimo = 0;
        float contBom = 0;
        float contRegular = 0;
        //variavel utilizada para contar quantas pessoas apontaram que o filme é ruim
        float contRuim = 0;
        float contPessimo = 0;
        //variavel utilizada para faze a conta das médias das idades
        float somaDasIdades = 0;
        Scanner leitor = new Scanner(System.in);
        //utilizei a classe Decimal format para formatar o número gerado no calculo da porcentagem
        DecimalFormat formatador = new DecimalFormat("#,##");
        
        //A primeira etapa é garantir que o programa vai pedir apenas 40 avaliações, afinal o cinema só tem 40 lugares
        
        while(lugares < 40){
        
            //aqui ja garantimos que o programa só vai pedir 40 avaliações, agora vamos dizer para ele. O que fazer 40 vezes.
            //vamos perguntar ao usuário a idade dele e o que ele achou do filme.
            
            System.out.println("Qual a sua idade ?");
            //verificação se o valor digitado é um inteiro. 
            //utilizando um while para verificar a idade, enquanto o usuário não digitar um inteiro correto o programa fica no loop
            while(!leitor.hasNextInt()){
                System.out.println("Idade inválida, digite um número inteiro\nDigite a sua idade");
                leitor.next();
            }
            //quando a idade digitada for válida, ela será atribuía a variável idade
            idade = leitor.nextInt();
            System.out.println("O que achou do filme? Digite A - Ótimo /  B - Bom / C - Regular  / D - Ruim  / E -  Péssimo.");
            avaliacao = leitor.next().charAt(0);
            
            switch(avaliacao){
                case 'A', 'a':
                    System.out.println("Que bom que gostou MUITO do filme, até a proóxima");
                    contOtimo++;
                    break;
                case 'B', 'b':
                    System.out.println("Que bom que gostou do filme, até a proxima;");
                    contBom++;
                    break;
                case 'C', 'c':
                    System.out.println("Que pena que não superamos a sua espextativa, mas contamos com voc aqui na proxima");
                    contRegular++;
                    break;
                case 'D', 'd':
                    System.out.println("Nossa... Que pena que não gostou do filme, vamos enviar para voc os nossos filmes em cartaz, para voc escolher algo que voc goste mais");
                    contRuim++;
                    //aqui vamos somar as idades das pessoas que responderem que o filme é ruim
                    somaDasIdades = somaDasIdades + idade;
                    break;
                case 'E', 'e':
                    System.out.println("Ficamos chocados com isso !! Vamos disponibilzar um voucher para voc voltar e assisir outro filme para melhorar sua experiência conosco !");
                    contPessimo++;
                    break;
                default:
                    //caso o usuário digite um opção inválida, é solicitado para que digite novamente a idade e a avaliação e é feito o decremento da variável lugares.
                    System.out.println("Opção inválida, Digite A - Ótimo /  B - Bom / C - Regular  / D - Ruim  / E -  Péssimo.");
                    lugares--;
                    break;
            }             
            
            lugares++;
            //aqui já terminamos de capturar as idades e opiniões das pessoas.
        }
        //Aqui vamos mostrar o resultado das estatisticas solicitadas
        //Média de idade das pessoas que responderam ruim
        if(somaDasIdades == 0){
            System.out.println("Ninguém achou o filme ruim");
        } else {
            System.out.println("A média de idade das pessoas que responderam ruim é " + (somaDasIdades/contRuim));
        }
        //O percertual de respostas péssimo
        if(contPessimo == 0){
            System.out.println("Ninguem achou o filme pessimo");
        } else {            
            float percentPessimo = (contPessimo/lugares)*100;
            String percentFormatado = formatador.format(percentPessimo);
            System.out.println("O Percentual de respostas Péssimo é " +percentFormatado +"%");
        }     
        
    }
    
}