package Game;

public class FullyAttack extends Card {
    public FullyAttack(int cub_val) {
        def_pick_first = 0;
        def_pick_second = 0;
        attack_first = 3 + (int) (Math.random() * 4) + cub_val;
        attack_second = 3 + (int) (Math.random() * 4) + cub_val;
        coubter_cube = 0;
    }
}
