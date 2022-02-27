package Game;

import java.util.Objects;
import java.util.Scanner;

public class Engine {
    public static void game() {
        Scanner in = new Scanner(System.in);
        Player pl1 = new Player();
        //Player pl2 = new Player(); //off on test
        //EnemyAttack enemy1 = new EnemyAttack(); //Этого класса нет на гите ибо я не успел закончить реализацию

        System.out.println("Игра началась вот ваши кубики:");
        for (int i = 0; i < pl1.cubes.length; i++) {
            System.out.print(pl1.cubes[i].value + " ");
        }
        System.out.println();
        while (true) {
            pl1.actionCube();
            int count = 0;
            for (int i = 0; i < pl1.cubes.length; i++) {
                if (pl1.cubes[i].card_have) {
                    count++;
                }
            }
            if (count == pl1.cubes.length) {
                System.out.println("Все кубики выбраны готовы гдействиям? [Y/N]");
                String continuer = in.next();
                if (Objects.equals(continuer, "Y")) {
                    System.out.println("Итак вот нанесённый вами урон:");
                    System.out.println(pl1.showDamage());
                    System.out.println("Вот и конец демки :P");
                    break;
                } else {
                    System.out.println("Ну раз так то вот тебе обнуление кубиков начинай заного");
                    pl1.total_damage = 0;

                    for (int i = 0; i < pl1.cubes.length; i++) {
                        pl1.cubes[i].card_have = false;
                    }
                }
            }
        }

    }
}