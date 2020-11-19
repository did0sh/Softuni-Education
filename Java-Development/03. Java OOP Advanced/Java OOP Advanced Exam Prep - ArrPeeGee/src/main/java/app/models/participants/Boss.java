package app.models.participants;

import app.contracts.Targetable;
import app.models.Config;

public class Boss extends BaseTargetable {

    public Boss(String name) {
        super(name, Config.BOSS_HEALTH, Config.BOSS_DAMAGE, Config.BOSS_GOLD);
    }

    @Override
    public void levelUp() {
        super.setHealth(Config.BOSS_HEALTH);
    }
}
