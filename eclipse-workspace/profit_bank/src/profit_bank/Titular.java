package profit_bank;

import java.util.List;
import java.util.Scanner;

public class Titular {
	
	//CONSTRUTOR
	public Titular(int numeroConta, String nomeTitular, double saldo, double limite) {
		this.numeroConta = numeroConta;
		this.nomeTitular = nomeTitular;
		this.saldo = saldo;
		this.limite = limite;
	}
	
	//Construtor Padrão
	public Titular() {}
	
	//ATRIBUTOS
	private int numeroConta;
	private String nomeTitular;
	private double saldo;
	private double limite;
	
	//MÉTODOS DO MENU
	public void criar(Scanner leitor,List<Titular> titulares) {
		
		System.out.println("*********************");
		System.out.println(" CRIAÇÃO DA CONTA CORRENTE: ");
		System.out.println("*********************");
		System.out.println();
		
		System.out.print("Número da Conta: ");
		int numeroConta = leitor.nextInt();
		
		System.out.print("Nome do Correntista: ");
		String nomeTitular = leitor.next();
		
		System.out.print("Saldo: ");
		double saldo = leitor.nextDouble();
		
		System.out.print("Limite: ");
		double limite = leitor.nextDouble();
		
		//Cria o objeto e insere as informações dentro dele
		Titular titu = new Titular(numeroConta,nomeTitular,saldo,limite);
		
		//Adiciona o objeto dentro do vetor (simulando o banco de dados)
		titulares.add(titu);
		
		System.out.println("*** Conta Criada com Sucesso!!! ***");
		
	}
	
	public void mostrarTodos(List<Titular> titulares) {
		System.out.println("*****************************");
		System.out.println(" MOSTRAR TODOS OS CORRENTISTAS: ");
		System.out.println("*****************************");
		
		for(Titular titular:titulares) {
			System.out.println("Número da Conta: " + titular.getNumeroConta());
			System.out.println("Nome do Titular: " + titular.getNomeTitular());
			System.out.println("Saldo Disponível: " + titular.getSaldo());
			System.out.println("Limite Disponível: " + titular.getLimite());
			System.out.println("--------------------------");
		}
	}
	
	public void mostrarDadosDaContaCorrente(Scanner leitor,List<Titular> titulares) {
		System.out.println("*****************************");
		System.out.println(" MOSTRANDO CONTA DESEJADA  ");
		System.out.println("*****************************");
		System.out.println();
		System.out.print("Digite o número da conta: ");
		int pesquisarConta = leitor.nextInt();
		
		
		
		for(Titular titular:titulares) {
			
			if(pesquisarConta ==(titular.getNumeroConta())) {
				System.out.println("Número da Conta: " + titular.getNumeroConta());
				System.out.println("Nome do Correntista: " + titular.getNomeTitular());
				System.out.println("Saldo: " + titular.getSaldo());
				System.out.println("Limite: " + titular.getLimite());
				break;
			}
			
		}
		
		
	}
	
	public void alterarDadosDaContaCorrente(Scanner leitor,List<Titular> titulares) {
		System.out.println("*****************************");
		System.out.println("     ALTERANDO DADOS DA CONTA     ");
		System.out.println("*****************************");
		System.out.println();
		System.out.print("Digite o número da conta: ");
		int pesquisarConta = leitor.nextInt();
		
		for(Titular titular:titulares) {
			if(pesquisarConta ==(titular.getNumeroConta())) {
				System.out.println("Escolha o que deseja alterar:");
		        System.out.println("1 - Nome do Correntista");
		        System.out.println("2 - Limite");
		        String opcaoAlteracao = leitor.next();

		        switch (opcaoAlteracao) {
		            case "1":
		                System.out.print("Digite o novo Nome: ");
		                titular.setNomeTitular(leitor.next());
		                break;
		            case "2":
		                System.out.print("Digite o novo Limite: ");
		                titular.setLimite(leitor.nextDouble());
		                break;
		            default:
		                System.out.println("OPÇÃO INVÁLIDA!");
				
		}
		        return;
		}
		
	
        	}
		System.out.println("Conta não encontrada");
	}
	
	public void excluirContaCorrente(Scanner leitor, List<Titular> titulares) {
	    System.out.println("*****************************");
	    System.out.println("       EXCLUINDO CONTA     ");
	    System.out.println("*****************************");
	    System.out.println();
	    System.out.print("Digite o número da conta: ");
	    int pesquisarConta = leitor.nextInt();

	    boolean continuar = true;

	    do {
	        System.out.println("Deseja excluir sua conta permanentemente?");
	        System.out.println("Digite 1 para SIM OU Digite 2 para NÃO");
	        int desejaExcluir = leitor.nextInt();

	        switch (desejaExcluir) {
	            case 1:
	                for (Titular titular : titulares) {
	                    if (titular.getNumeroConta() == pesquisarConta) {
	                        if (titular.getSaldo() == 0) {
	                            titulares.remove(titular);
	                            System.out.println("*** Conta Excluída com Sucesso! ***");
	                            continuar = false;
	                        } else {
	                            System.out.println("*** Deixe o saldo zerado para poder excluir!!! ***");
	                        }
	                        
	                    }
	                }
	                break; 
	            case 2:
	                System.out.println("*** Sua conta continua ativa ***");
	                continuar = false;
	                break;
	            default:
	                System.out.println("*** Opção inválida. Digite novamente. ***");
	        }
	    } while (continuar);
	}
	
	
	public void efetuarDeposito(Scanner leitor, List<Titular> titulares) {
        System.out.println("*****************************");
        System.out.println("     EFETUAR DEPÓSITO     ");
        System.out.println("*****************************");
        System.out.println();
        System.out.print("Digite o número da conta para depósito: ");
        int numeroConta = leitor.nextInt();

        System.out.print("Digite o valor a ser depositado: ");
        double valorDeposito = leitor.nextDouble();

        for (Titular titular : titulares) {
            if (titular.getNumeroConta() == numeroConta) {
                titular.setSaldo(titular.getSaldo() + valorDeposito);
                System.out.println("Depósito efetuado com sucesso! Novo saldo: " + titular.getSaldo());
                return;
            }
        }

        System.out.println("Conta não encontrada!");
    }
	
	public void efetuarPagamento(Scanner leitor, List<Titular> titulares) {
        System.out.println("*****************************");
        System.out.println("     EFETUAR PAGAMENTO     ");
        System.out.println("*****************************");
        System.out.println();
        System.out.print("Digite o número da conta para pagamento: ");
        int numeroConta = leitor.nextInt();

        System.out.print("Digite o valor a ser pago: ");
        double valorPagamento = leitor.nextDouble();

        for (Titular titular : titulares) {
            if (titular.getNumeroConta() == numeroConta) {
                if (titular.getSaldo() >= valorPagamento) {
                    titular.setSaldo(titular.getSaldo() - valorPagamento);
                    System.out.println("Pagamento efetuado com sucesso! Novo saldo: " + titular.getSaldo());
                } else {
                    System.out.println("Saldo insuficiente para efetuar o pagamento!");
                }
                return;
            }
        }

        System.out.println("Conta não encontrada!");
    }
	
	public void transferenciaEntreContas(Scanner leitor, List<Titular> titulares) {
        System.out.println("*****************************");
        System.out.println("     TRANSFERÊNCIA ENTRE CONTAS     ");
        System.out.println("*****************************");
        System.out.println();
        System.out.print("Digite o número da conta de origem: ");
        int contaOrigem = leitor.nextInt();

        System.out.print("Digite o número da conta de destino: ");
        int contaDestino = leitor.nextInt();

        System.out.print("Digite o valor a ser transferido: ");
        double valorTransferencia = leitor.nextDouble();

        Titular origem = null;
        Titular destino = null;

        for (Titular titular : titulares) {
            if (titular.getNumeroConta() == contaOrigem) {
                origem = titular;
            }
            if (titular.getNumeroConta() == contaDestino) {
                destino = titular;
            }
        }

        if (origem != null && destino != null) {
            if (origem.getSaldo() >= valorTransferencia) {
                origem.setSaldo(origem.getSaldo() - valorTransferencia);
                destino.setSaldo(destino.getSaldo() + valorTransferencia);
                System.out.println("Transferência realizada com sucesso!");
            } else {
                System.out.println("Saldo insuficiente para efetuar a transferência!");
            }
        } else {
            System.out.println("Conta de origem ou conta de destino não encontrada!");
        }
    }


	
	
	
	
	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	//MÉTODOS GETTERS E SETTERS
	public int getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}
	public String getNomeTitular() {
		return nomeTitular;
	}
	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
}
