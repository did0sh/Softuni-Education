package blobs.commandInterpreter.commands;

import blobs.annotations.Alias;
import blobs.annotations.Inject;
import blobs.models.BlobRepository;

@Alias(value = "report-events")
public class ReporteventsCommand extends Command {
    @Inject
    private BlobRepository repository;

    public ReporteventsCommand(String[] data) {
        super(data);
    }

    @Override
    public void execute() {
        this.repository.triggerReportEvents();
    }
}
