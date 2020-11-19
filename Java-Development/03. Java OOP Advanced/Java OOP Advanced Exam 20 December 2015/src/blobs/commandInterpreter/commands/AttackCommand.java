package blobs.commandInterpreter.commands;

import blobs.annotations.Alias;
import blobs.annotations.Inject;
import blobs.interfaces.OutputWriter;
import blobs.models.Blob;
import blobs.models.BlobRepository;

@Alias(value = "attack")
public class AttackCommand extends Command {

    @Inject
    private BlobRepository repository;

    @Inject
    private OutputWriter writer;

    public AttackCommand(String[] data) {
        super(data);
    }

    @Override
    public void execute() {
        String attackerName = super.getData()[1];
        String targetName = super.getData()[2];

        Blob attacker = this.repository.find(attackerName);
        Blob target = this.repository.find(targetName);

        attacker.attack(target);

        if (this.repository.isEventReportTriggered()){
            this.reportResults(attacker, target);
        }

        this.repository.update();
    }

    private void reportResults(Blob attacker, Blob target){
        if (attacker.getTriggerCount() == 0 && attacker.getBehavior().isTriggered()) {
            attacker.setTriggerCount(1);
            this.writer.writeLine("Blob %s toggled %sBehavior", attacker.getName(), attacker.getBehavior().getClass().getSimpleName());
        }

        if (target.getTriggerCount() == 0 && target.getBehavior().isTriggered()) {
            target.setTriggerCount(1);
            this.writer.writeLine("Blob %s toggled %sBehavior", target.getName(), target.getBehavior().getClass().getSimpleName());
        }

        if (target.getHealth() <= 0) {
            this.writer.writeLine("Blob %s was killed", target.getName());
        }
    }
}
