package blobs.models.attacks;

import blobs.models.Blob;

public class PutridFart extends AbstractAttack {

    @Override
    public void execute(Blob source, Blob target) {
        if (source.getHealth() <= 0 || target.getHealth() <= 0){
            return;
        }
        super.targetRespond(target, source.getDamage());
    }
}
