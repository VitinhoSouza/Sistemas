package br.ufc.quixada.si.exec;

import java.sql.SQLException;
import java.util.Scanner;

import br.ufc.quixada.si.dao.PessoaDao;
import br.ufc.quixada.si.dao.ProdutoDao;
import br.ufc.quixada.si.dao.PedidoDao;
import br.ufc.quixada.si.model.Pedido;
import br.ufc.quixada.si.model.Pessoa;
import br.ufc.quixada.si.model.Produto;

public class Principal {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int opcao1,opcao2,opcao3,opcao4,opcao5,opcao6,opcao7;
		do {
			System.out.println("Digite 1 para cadastrar produto ou cliente:");
			System.out.println("Digite 2 para cadastrar pedido:");
			System.out.println("Digite 3 para remoções:");
			System.out.println("Digite 4 para consultas:");
			System.out.println("Digite 5 para alterações:");
			System.out.println("Digite 6 para relatórios:");
			System.out.println("Digite 7 para encerrar:");
			opcao1 = scan.nextInt();
			switch(opcao1){
				case 1:
					do {
						System.out.println("Digite 1 para cadastrar produto:");
						System.out.println("Digite 2 para cadastrar cliente:");
						System.out.println("Digite 3 para voltar:");
						opcao2 = scan.nextInt();
						switch(opcao2) {
							case 1: 
								System.out.println("Digite o nome do produto:");
								String nome_produto = scan.next();
								//scan.next();
								System.out.println("Digite o preço do produto:");
								double preco = scan.nextDouble();
								System.out.println("Digite a quantidade do produto:");
								int quantidade = scan.nextInt();
								Produto prod = new Produto();
								prod.setNome(nome_produto);
								prod.setPreco(preco);
								prod.setQuantidade(quantidade);
								ProdutoDao dao1 = new ProdutoDao();
								dao1.inserir(prod);
								break;
							case 2:
								System.out.println("Digite o nome do cliente:");
								String nome_pessoa = scan.next();
								Pessoa pes = new Pessoa(1,"padrao");
								pes.setNome(nome_pessoa);
								PessoaDao dao2 = new PessoaDao();
								dao2.inserir(pes);
								break;
							case 3:
								break;
							default:
								System.out.println("Opção não identificada!");
								break;
						}
						
					}while(opcao2!=3);
					
					break;
				case 2:
					do {
						System.out.println("Digite 1 para mostrar o cardapio:");
						System.out.println("Digite 2 para realizar pedido:");
						System.out.println("Digite 3 para voltar:");
						opcao3 = scan.nextInt();
						switch(opcao3) {
							case 1: 
								ProdutoDao dao = new ProdutoDao();
								dao.listar();
								break;
							case 2:
								System.out.println("Digite o codigo do produto:");
								int codprod = scan.nextInt();
								System.out.println("Digite o codigo do cliente:");
								int id_pes = scan.nextInt();
								Pedido ped = new Pedido();
								PedidoDao dao2 = new PedidoDao();
								ped.setCod_produto(codprod);
								ped.setId_pessoa(id_pes);
								dao2.inserir(ped);
								
								break;
							case 3:
								break;
							default:
								System.out.println("Opção não identificada!");
								break;
						}
					}while(opcao3!=3);
					break;
				
				case 3:
					do {
						System.out.println("Digite 1 para remover produtos:");
						System.out.println("Digite 2 para remover clientes:");
						System.out.println("Digite 3 para cancelar pedidos:");
						System.out.println("Digite 4 para voltar:");
						opcao4 = scan.nextInt();
						switch(opcao4) {
							case 1: 
								System.out.println("Digite o codigo do produto:");
								int codprod = scan.nextInt();
								Produto prod = new Produto();
								prod.setCodigo(codprod);
								ProdutoDao dao3 = new ProdutoDao();
								dao3.remover(prod);
								break;
							case 2:
								System.out.println("Digite o codigo do cliente:");
								int idcli = scan.nextInt();
								Pessoa pes = new Pessoa(1,"padrao");
								pes.setId(idcli);
								PessoaDao dao4 = new PessoaDao();
								dao4.remover(pes);
								break;
							case 3:
								System.out.println("Digite o codigo do pedido:");
								int codped = scan.nextInt();
								Pedido ped = new Pedido();
								ped.setCodigo(codped);
								PedidoDao dao5 = new PedidoDao();
								dao5.remover(ped);
								break;
							case 4:
								break;
							default:
								System.out.println("Opção não identificada!");
								break;
						}
					}while(opcao4!=4);
					break;
					
				case 4:
					do {
						System.out.println("Digite 1 para buscar produto:");
						System.out.println("Digite 2 para buscar cliente:");
						System.out.println("Digite 3 para buscar pedido:");
						System.out.println("Digite 4 para saber valor total gasto por cliente:");
						System.out.println("Digite 5 para voltar:");
						opcao5 = scan.nextInt();
						switch(opcao5) {
							case 1: 
								System.out.println("Digite o codigo do produto:");
								int codprod = scan.nextInt();
								ProdutoDao dao = new ProdutoDao();
								dao.listar(codprod);
								break;
							case 2:
								System.out.println("Digite o codigo do cliente:");
								int idcli = scan.nextInt();
								PessoaDao dao2 = new PessoaDao();
								dao2.listar(idcli);
								break;
							case 3:
								System.out.println("Digite o codigo do pedido:");
								int codped = scan.nextInt();
								PedidoDao dao3 = new PedidoDao();
								dao3.listar(codped);
								break;
							case 4:
								System.out.println("Digite o codigo do cliente:");
								int codcli = scan.nextInt();
								PedidoDao dao4 = new PedidoDao();
								dao4.listar_valor(codcli);
								break;
							case 5:
								break;
							default:
								System.out.println("Opção não identificada!");
								break;
						}
					}while(opcao5!=5);
					break;
				
				case 5:
					do {
						System.out.println("Digite 1 para alterar produto:");
						System.out.println("Digite 2 para alterar cliente:");
						System.out.println("Digite 3 para alterar pedido:");
						System.out.println("Digite 4 para voltar:");
						opcao6 = scan.nextInt();
						switch(opcao6) {
							case 1: 
								System.out.println("Digite o codigo do produto:");
								int codprod = scan.nextInt();
								System.out.println("Digite o novo nome do produto:");
								String nome_produto = scan.next();
								System.out.println("Digite o novo preço do produto:");
								double preco = scan.nextDouble();
								System.out.println("Digite a nova quantidade do produto:");
								int quantidade = scan.nextInt();
								Produto prod = new Produto();
								ProdutoDao dao1 = new ProdutoDao();
								prod.setCodigo(codprod);
								prod.setNome(nome_produto);
								prod.setPreco(preco);
								prod.setQuantidade(quantidade);
								dao1.editar(prod);
								break;
							case 2:
								System.out.println("Digite o codigo do cliente:");
								int idpes = scan.nextInt();
								System.out.println("Digite o novo nome do cliente:");
								String nomecli = scan.next();
								Pessoa pes = new Pessoa(0,"padrao");
								PessoaDao dao2 = new PessoaDao();
								pes.setId(idpes);
								pes.setNome(nomecli);
								dao2.editar(pes);
								break;
							case 3:
								System.out.println("Digite o codigo do pedido:");
								int codped = scan.nextInt();
								System.out.println("Digite o codigo do novo produto:");
								int codproduto = scan.nextInt();
								//alterar pedido
								Pedido ped = new Pedido();
								PedidoDao dao3 = new PedidoDao();
								ped.setCodigo(codped);
								ped.setCod_produto(codproduto);
								dao3.editar(ped);
								break;
							case 4:
								break;
							default:
								System.out.println("Opção não identificada!");
								break;
						}
					}while(opcao6!=4);
					break;
				case 6:
					do {
						System.out.println("Digite 1 para listar todos os clientes:");
						System.out.println("Digite 2 para listar todos os pedidos:");
						System.out.println("Digite 3 para listar todos os produtos:");
						System.out.println("Digite 4 para voltar:");
						opcao7 = scan.nextInt();
						switch(opcao7) {
							case 1: 
								PessoaDao dao = new PessoaDao();
								dao.listar();
								break;
							case 2:
								PedidoDao dao2 = new PedidoDao();
								dao2.listar();
								break;
							case 3:
								ProdutoDao dao3 = new ProdutoDao();
								dao3.listar();
								break;
							case 4:
								break;
							default:
								System.out.println("Opção não identificada!");
								break;
						}
					}while(opcao7!=4);
					break;
					
				case 7:
					System.out.println("Até a próxima!");
					break;
				default:
					System.out.println("Opção não identificada!");
					break;
			}
		}while(opcao1!=7);
	}

}
