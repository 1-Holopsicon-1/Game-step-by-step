package Game;

public class DefCard extends Card {
    public DefCard(int cub_val) {
        def_pick_first = 3 + (int) (Math.random() * 4) + cub_val;
        def_pick_second = 4 + (int) (Math.random() * 6) + cub_val;
        attack_first = 0;
        attack_second = 0;
        coubter_cube = 0;
    }
}
