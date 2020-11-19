package blobs.commandInterpreter.commands;

import blobs.annotations.Alias;
import blobs.annotations.Inject;
import blobs.interfaces.OutputWriter;
import blobs.models.BlobRepository;

@Alias(value = "status")
public class StatusCommand extends Command {

    @Inject
    private BlobRepository repository;

    @Inject
    private OutputWriter writer;

    public StatusCommand(String[] data) {
        super(data);
    }

    @Override
    public void execute() {
        this.writer.writeLine(this.repository.printStatus());
        this.repository.update();
    }
}
