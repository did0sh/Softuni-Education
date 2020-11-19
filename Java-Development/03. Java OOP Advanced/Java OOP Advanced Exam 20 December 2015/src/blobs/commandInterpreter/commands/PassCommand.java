package blobs.commandInterpreter.commands;

import blobs.annotations.Alias;
import blobs.annotations.Inject;
import blobs.models.BlobRepository;

@Alias(value = "pass")
public class PassCommand extends Command {
    @Inject
    private BlobRepository repository;

    public PassCommand(String[] data) {
        super(data);
    }

    @Override
    public void execute() {
        this.repository.update();
    }
}
