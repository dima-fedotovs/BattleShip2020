package lv.tsi.courses.battleship.model;

public class GameManager {
    private static Game incomplete;

    public static Game getIncompleteGameAndJoin(Player player) {
        if (incomplete == null) {
            incomplete = new Game();
        }
        incomplete.join(player);
        var tmp = incomplete;
        if (incomplete.isReady()) {
            incomplete = null;
        }
        return tmp;
    }

}
