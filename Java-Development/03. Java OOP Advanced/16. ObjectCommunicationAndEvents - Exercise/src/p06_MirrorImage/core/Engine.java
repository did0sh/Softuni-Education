package p06_MirrorImage.core;

import p06_MirrorImage.io.Reader;
import p06_MirrorImage.io.Writer;
import p06_MirrorImage.models.Repository;
import p06_MirrorImage.models.Wizard;

import java.io.IOException;

public class Engine {
    private Writer writer;
    private Reader reader;
    private Repository wizardRepository;

    public Engine(Writer writer, Reader reader, Repository wizardRepository) {
        this.writer = writer;
        this.reader = reader;
        this.wizardRepository = wizardRepository;
    }

    public void run() throws IOException {
        String[] tokens = reader.readLine().split("\\s+");
        String name = tokens[0];
        int magicalPower = Integer.parseInt(tokens[1]);
        Wizard wizard = new Wizard(name, magicalPower, this.wizardRepository);
        this.wizardRepository.addWizard(wizard);

        for (String line = this.reader.readLine(); !line.equals("END"); line = this.reader.readLine()) {
            tokens = line.split("\\s+");
            int wizardId = Integer.parseInt(tokens[0]);
            String spell = tokens[1];
            Wizard wiz = this.wizardRepository.getWizardById(wizardId);
            if (spell.equals("FIREBALL")) {
                this.writer.write(wiz.castFireBall());
            } else {
                this.writer.write(wiz.castReflection());
            }
        }
    }
}
