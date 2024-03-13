package aeronave;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class Aeronave {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        //criacao de arrays
        int[][] arrayAssentos = new int[3][4];
        
        //criacao de variaveis
        char escolhaMenu;
        char fimprograma = 'N';
        int  reservaCol;
        int  reservaLin;
        int  contReservas = 0;
        double porcentagemOcupado;
        
        //Loop para verificar se o usuario fica no programa
        while(fimprograma == 'N'){
            
            //limpando saida
            limparSaida();
            
            //Mostrando o menu
            System.out.println("******* MENU *******");
            System.out.println("V = Verificar assentos");
            System.out.println("R = Fazer reserva");
            System.out.println("P = Mostrar o percentual de ocupacao");
            System.out.print("Informe a letra correspondente: ");
            escolhaMenu = sc.next().toUpperCase().charAt(0);

            //limpando saida
            limparSaida();
            
            //Laco para verificar se usuario digitou a letra corresponde
            while (escolhaMenu != 'V' && escolhaMenu != 'R' && escolhaMenu != 'P'){
                System.out.println("Opcao invalida! (V / R / P)");
                escolhaMenu = sc.next().toUpperCase().charAt(0);
            }
            
            //verificar oque o usuario escolheu
            if (escolhaMenu == 'V') {
                //Mostrar os assentos do aviao
                    System.out.println("*** Assentos ***\n");
                    System.out.println("0 - Vagos | 1 - Ocupados\n");
                    System.out.println("   *  A B C D");
            
                    for (int lin = 0; lin < 3; lin++){
                        System.out.print("   " + lin + ". ");
                        for (int col = 0; col < 4; col++){
                            System.out.print(arrayAssentos[lin][col] + " "); 
                        }
                        System.out.println("\n");
                    }
            }
            
                //Fazer a reserva do usuario no aviao
                else if(escolhaMenu == 'R'){ 
                    
                    System.out.print("Informe a linha que deseja reservar: ");
                    reservaLin = sc.nextInt();
                    System.out.print("Informe a coluna que deseja reservar: ");
                    reservaCol = sc.nextInt();
                    contReservas ++;
                        //verifica se assento esta ocupado
                        if(arrayAssentos[reservaLin][reservaCol] == 0){
                            System.out.println("Reserva feita com sucesso na linha " + reservaLin + ", coluna " + reservaCol + " !!");
                            arrayAssentos[reservaLin][reservaCol] = 1;
                        }
                            else{
                                System.out.println("Assento ocupado!!"); 
                            }
                }
            
                    //mostra a porcentagem de assentos ocupados
                    else if(escolhaMenu == 'P'){
                        porcentagemOcupado = (contReservas*100)/12;
                        System.out.println("Porcentagem de assentos ocupados e de " + porcentagemOcupado + "%");
                    }
            
            //Verificar se usuário prossegue no programa
            System.out.print("Finaliza programa? (S / N): ");
            fimprograma = sc.next().toUpperCase().charAt(0);
            
            //Se usuário colocar um valor diferete de S ou N repete a pergunta
            while (fimprograma != 'S' && fimprograma != 'N') {
                System.out.println("Opcao invalida! (S / N)");
                fimprograma = sc.next().toUpperCase().charAt(0);
            }
        }
    }
    /*
    Função que limpa a Saída/Output do Netbeans
    */
    public final static void limparSaida() {
        try {
            Robot robot = new Robot();
            robot.setAutoDelay(10);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_L);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_L);
        } catch (AWTException ex) {
          }
    }
}