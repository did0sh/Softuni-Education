package blobs.commandInterpreter.commands;

import blobs.annotations.Alias;
import blobs.annotations.Inject;
import blobs.factories.AttackFactory;
import blobs.factories.BehaviorFactory;
import blobs.interfaces.Attack;
import blobs.interfaces.Behavior;
import blobs.models.Blob;
import blobs.models.BlobRepository;

@Alias(value = "create")
public class CreateCommand extends Command {
    @Inject
    private BehaviorFactory behaviorFactory;

    @Inject
    private AttackFactory attackFactory;

    @Inject
    private BlobRepository repository;

    public CreateCommand(String[] data) {
        super(data);
    }

    @Override
    public void execute() {
        String blobName = super.getData()[1];
        int initialHealth = Integer.parseInt(super.getData()[2]);
        int initialDamage = Integer.parseInt(super.getData()[3]);
        String behaviorType = super.getData()[4];
        String attackType = super.getData()[5];

        try {
            Behavior behavior = this.behaviorFactory.createBehavior(behaviorType);
            Attack attack = this.attackFactory.createAttack(attackType);

            Blob blob = new Blob(blobName, initialHealth, initialDamage, behavior, attack);
            this.repository.add(blob);
        } catch (IllegalAccessException | ClassNotFoundException | InstantiationException e) {
            e.printStackTrace();
        }

        this.repository.update();
    }
}
