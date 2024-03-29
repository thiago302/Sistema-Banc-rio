package profit_bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner leitor = new Scanner(System.in);
		
		List<Titular> titulares = new ArrayList<>();

		Titular titu = new Titular();
		int opcao;

		do {
			 System.out.println("*********************");
	            System.out.println("     MENU PRINCIPAL  ");
	            System.out.println("*********************");
	            System.out.println();
	            System.out.println("1 - CRIAÇÃO DA CONTA CORRENTE:");
	            System.out.println("2 - MOSTRAR TODOS OS CORRENTISTAS:");
	            System.out.println("3 - MOSTRAR DADOS DA CONTA CORRENTE:");
	            System.out.println("4 - ALTERAR DADOS DA CONTA CORRENTE:");
	            System.out.println("5 - EXCLUIR CONTA CORRENTE:");
	            System.out.println("6 - EFETUAR DEPÓSITO:");
	            System.out.println("7 - EFETUAR PAGAMENTO:");
	            System.out.println("8 - TRANSFERÊNCIA ENTRE CONTAS:");
	            System.out.println("9 - FINALIZAR O SISTEMA");
	            System.out.print("Digite a opção desejada: ");
			opcao = leitor.nextInt();

			switch (opcao) {
			case 1:
				titu.criar(leitor,titulares);
				
				break;
			case 2:
				titu.mostrarTodos(titulares);
				
				break;
			case 3:
				titu.mostrarDadosDaContaCorrente(leitor,titulares);
				
				break;
			case 4:
				titu.alterarDadosDaContaCorrente(leitor, titulares);
				
				break;
			case 5:
				titu.excluirContaCorrente(leitor, titulares);
				break;
				
			case 6:
                titu.efetuarDeposito(leitor, titulares);
                break;
            case 7:
                titu.efetuarPagamento(leitor, titulares);
                break;
            case 8:
                titu.transferenciaEntreContas(leitor, titulares);
                break;
            case 9:
                System.out.println("*****************************");
                System.out.println("     FINALIZANDO SISTEMA     ");
                System.out.println("*****************************");
                break;
            default:
                System.out.println("*****************************");
                System.out.println("        OPÇÃO INVÁLIDA       ");
                System.out.println("*****************************");
                break;
			}

		} while (opcao != 9);
		
		leitor.close();
		
	}

}
