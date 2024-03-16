package sistema;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProgramaPricnipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner leitor = new Scanner(System.in);

		List<Produto> produtos = new ArrayList<>();

		int opcao;
		int opcaoAlteracao;

		do {

			System.out.println("**********************");
			System.out.println(" MENU PRINCIPAL");
			System.out.println("*****************");
			System.out.println();
			System.out.println(" 1 - CADASTRAR PRODUTO");
			System.out.println("2- MOSTRAR TODOS OS PRODUTOS");
			System.out.println("3 - MOSTRAR PRODUTO DESEJADO");
			System.out.println("4 - ALTERAR  PREÇO DO PRODUTO");
			System.out.println("5 - EXCLUIR PRODUTO");
			System.out.println("6 - SAIR DO SISTEMA");
			System.out.print("Digite a opção desejada: ");

			opcao = leitor.nextInt();

			switch (opcao) {

			case 1:
				System.out.println("**********************");
				System.out.println(" CADASTRANDO PRODUTO");
				System.out.println("*****************");
				System.out.println();

				System.out.println("Códido:");
				int codigo = leitor.nextInt();

				System.out.println("Produto: ");
				String nomeDoProduto = leitor.next();

				System.out.println("Preço: ");
				double preco = leitor.nextDouble();

				// Cria o objeto e indere as informações dentro dele
				Produto prod = new Produto(codigo, nomeDoProduto, preco);
				// adiciona o objeto dentro do vetor(simulando o banco de dados)
				produtos.add(prod);

				System.out.println("Produto cadastrado com sucesso!!!");
				break;

			case 2:
				System.out.println("**********************");
				System.out.println(" MOSTRANDO TODOS OS PRODUTOS");
				System.out.println("*****************");

				for (Produto produto : produtos) {

					System.out.println("código:" + produto.getCodigo());
					System.out.println("Produto:" + produto.getProduto());
					System.out.println("Preço:" + produto.getPreco());
					System.out.println("**************");

				}
				break;

			case 3:
				System.out.println("**********************");
				System.out.println(" MOSTRANDO PRODUTO DESEJADO");
				System.out.println("*****************");

				System.out.print("Digite o código do produto desejado: ");
				int codigoDesejado = leitor.nextInt();

				boolean produtoEncontrado = false;
				for (Produto produto : produtos) {
					if (produto.getCodigo() == codigoDesejado) {
						System.out.println("Código: " + produto.getCodigo());
						System.out.println("Produto: " + produto.getProduto());
						System.out.println("Preço: " + produto.getPreco());
						produtoEncontrado = true;
						break; // Sai do loop assim que encontrar o produto
					}
				}

				if (!produtoEncontrado) {
					System.out.println("Produto não encontrado.");
				}
				break;

			case 4:
				System.out.println("**********************");
				System.out.println(" ALTERANDO PRODUTO ");
				System.out.println("*****************");

				System.out.println("Digite o código do produto a ser alterado: ");
				int codigoAlterado = leitor.nextInt();

				boolean produtoEncontrado2 = false; // Declaração correta da variável
				for (Produto produto : produtos) {
					if (produto.getCodigo() == codigoAlterado) {
						System.out.println("Código: " + produto.getCodigo());
						System.out.println("Produto: " + produto.getProduto());
						System.out.println("Preço: " + produto.getPreco());
						System.out.println();
						System.out.println("O que vai ser alterado?");
						System.out.println(" Se for código, digite 1");
						System.out.println(" Se for produto, digite 2");
						System.out.println(" Se for preço, digite 3");
						opcaoAlteracao = leitor.nextInt();

						switch (opcaoAlteracao) {
						case 1:
							System.out.println("Digite o novo código: ");
							int novoCodigo = leitor.nextInt();
							produto.setCodigo(novoCodigo);
							System.out.println("Alteração feita com sucesso!!!");

							break;

						case 2:
							System.out.println("Digite o novo produto: ");
							String novoProduto = leitor.next();
							produto.setProduto(novoProduto);
							System.out.println("Alteração feita com sucesso!!!");
							break;

						case 3:
							System.out.println("Digite o novo preco: ");
							double novoPreco = leitor.nextDouble();
							produto.setPreco(novoPreco);
							System.out.println("Alteração feita com sucesso!!!");
							break;
						default:
							System.out.println("Opção inválida");
							break;
						}
						produtoEncontrado2 = true;
						break;
					}
				}

				if (!produtoEncontrado2) {
					System.out.println("Produto não encontrado.");
				}

				break;
			case 5:
				System.out.println("**********************");
				System.out.println(" EXCLUINDO PRODUTO ");
				System.out.println("*****************");
				
				System.out.print("Digite o código do produto a ser excluido: ");
				int codigoExcluir = leitor.nextInt();

				boolean produtoEncontrado3 = false;
				for (Produto produto : produtos) {
					if (produto.getCodigo() == codigoExcluir) {
						System.out.println("Código: " + produto.getCodigo());
						System.out.println("Produto: " + produto.getProduto());
						System.out.println("Preço: " + produto.getPreco());
						
						produtos.remove(produto);
			            
			            System.out.println("Produto excluído com sucesso.");
			            
						produtoEncontrado3 = true;
						break; // Sai do loop assim que encontrar o produto
					}
				}

				if (!produtoEncontrado3) {
					System.out.println("Produto não encontrado.");
				}
				break;

			case 6:
				System.out.println("**********************");
				System.out.println(" FINALIZANDO SISTEMA ");
				System.out.println("*****************");
				break;

			default:
				System.out.println("**********************");
				System.out.println(" OPÇÃO INVÁLIDA ");
				System.out.println("*****************");
				break;
			}
		} while (opcao != 6);
		leitor.close();

	}

}
