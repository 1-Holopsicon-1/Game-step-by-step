package Game;
import java.util.Objects;
import java.util.Scanner;

public class Player {

    public int total_damage;
    public Cube first_cube = new Cube(2, 7);
    public Cube second_cube = new Cube(2, 7);
    public Cube third_cube = new Cube(2, 7);
    public Cube[] cubes = new Cube[] {first_cube, second_cube, third_cube};

    public void actionCube(){
        System.out.println("Выберите кубик, написав его индекс");
        Scanner in = new Scanner(System.in);
        int pick = in.nextInt();
        while (true){
            if (pick > cubes.length || pick < 0){
                System.out.println("Не прокатит, такого кубика нет");
                actionCube();
            }else if (cubes[pick].card_have){
                System.out.println("Ты уверен что хочешь поменять карту? [Y/N]");
                String answer = in.next();
                if (Objects.equals(answer, "Y")){
                    total_damage -= cubes[pick].value;
                    total_damage -= cubes[pick].value;

                    cubes[pick].card_have = true;
                    Card chosen_card = pickCard(cubes[pick]);
                    total_damage += chosen_card.attack_first;
                    total_damage += chosen_card.attack_second;
                    System.out.println("Карта выбрана");
                    break;
                }else{
                    System.out.println("Ну нет так нет давай дальше");
                    actionCube();
                }
            }
            else{
                cubes[pick].card_have = true;
                Card chosen_card = pickCard(cubes[pick]);
                total_damage += chosen_card.attack_first;
                total_damage += chosen_card.attack_second;
                System.out.println("Карта выбрана");
                break;
            }

        }

    }

    public int showDamage(){
        return total_damage;
    }

    public Card pickCard(Cube cube){
        System.out.println("Pick Attack or Def card by 1 or 2");
        FullyAttack atck = new FullyAttack(cube.value);
        DefCard def = new DefCard(cube.value);
        Scanner in = new Scanner(System.in);
        int card_number = in.nextInt();
        Card[] returnal = new Card[] {atck, def};
        while(true){
            if (card_number > 2 || card_number < 1){
                System.out.println("Неа такой карты нет");
                pickCard(cube);
            }else{
                break;
            }
        }
        return returnal[card_number - 1];
    }

}
