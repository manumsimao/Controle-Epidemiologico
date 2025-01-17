package UseCases.LocalUseCases;

import DAOs.localDAO;
import DAOs.pragaDAO;
import Entities.Local;
import Entities.Praga;

import java.util.Scanner;

public class alterarLocal {

    public static void alterar(){
        Scanner scanner = new Scanner(System.in);

        System.out.printf("\nDigite o CEP do Local que deseja editar: ");
        String codigo = scanner.nextLine();

        if(localDAO.listarUmLocal(codigo)!=null){
            Local local = localDAO.listarUmLocal(codigo);
            System.out.println("\n\n**** == **** Editor de Local **** == ****\n");
            System.out.println(
                    "Raio: " + local.getRaio()+
                    "\nPopulação: " + local.getPopulacao()+
                    "\nCaracteristicas: " + local.getCaracteristicas()+
                    "\nTelefone defesa civil: " + local.getTelefone_defesaCivil()
            );
            //scanner.nextLine();
            System.out.print("\nQual informação deseja alterar: ");
            String opcao = scanner.nextLine().toLowerCase();
            if(opcao.equals("raio")){
                System.out.print("Digite um novo raio: ");
                localDAO.localArrayList.get(localDAO.localArrayList.indexOf(local)).setRaio(scanner.nextInt());
                System.out.print("\n** raio atualizado com sucesso!\n");
            }else if(opcao.equals("caracteristicas")){
                System.out.print("Digite as novas Caracteristicas: ");
                localDAO.localArrayList.get(localDAO.localArrayList.indexOf(local)).setCaracteristicas(scanner.nextLine());
                System.out.print("\n** Caracteristicas atualizadas com sucesso!\n");
            }else if(opcao.equals("telefone defesa civil")){
                System.out.print("Digite o novo telefone da defesa civil: ");
                localDAO.localArrayList.get(localDAO.localArrayList.indexOf(local)).setTelefone_defesaCivil(scanner.nextLine());
                System.out.print("\n** Telefone defesa civil atualizado com sucesso!\n");
            }else if(opcao.equals("populacao")){
                System.out.print("Digite a nova populacao: ");
                localDAO.localArrayList.get(localDAO.localArrayList.indexOf(local)).setPopulacao(scanner.nextInt());
                System.out.print("\n** Populacao atualizada com sucesso!\n");
            }else{
                System.out.println("** Opção invalida! Digite um dos nomes dos atributos.");
            }
        }else{
            System.out.println("\n** Local não encontrado. Liste todos para obter seus respectivos CEPs.");
        }
    }

    public static void alterar(String codigo, String opcao, String viriavel){
        if(localDAO.listarUmLocal(codigo)!=null){
            Local local = localDAO.listarUmLocal(codigo);
            if(opcao.equals("raio")){
                localDAO.localArrayList.get(localDAO.localArrayList.indexOf(local)).setRaio(Integer.parseInt(viriavel));
                System.out.print("\n** raio atualizado com sucesso!\n");
            }else if(opcao.equals("caracteristicas")){
                localDAO.localArrayList.get(localDAO.localArrayList.indexOf(local)).setCaracteristicas(viriavel);
                System.out.print("\n** Caracteristicas atualizadas com sucesso!\n");
            }else if(opcao.equals("telefone defesa civil")){
                localDAO.localArrayList.get(localDAO.localArrayList.indexOf(local)).setTelefone_defesaCivil(viriavel);
                System.out.print("\n** Telefone defesa civil atualizado com sucesso!\n");
            }else if(opcao.equals("populacao")){
                localDAO.localArrayList.get(localDAO.localArrayList.indexOf(local)).setPopulacao(Integer.parseInt(viriavel));
                System.out.print("\n** Populacao atualizada com sucesso!\n");
            }else{
                System.out.println("** Opção invalida! Digite um dos nomes dos atributos.");
            }
        }else{
            System.out.println("\n** Local não encontrado. Liste todos para obter seus respectivos CEPs.");
        }
    }
}
