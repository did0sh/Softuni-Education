package p06_MirrorImage.models;

public class Wizard {
    private int id;
    private String name;
    private int magicalPower;
    private Wizard[] reflections;
    private Repository wizardRepository;

    public Wizard(String name, int magicalPower, Repository wizardRepository) {
        this.name = name;
        this.magicalPower = magicalPower;
        this.wizardRepository = wizardRepository;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String castFireBall() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s %d casts Fireball for %d damage", this.name, this.id, this.magicalPower))
                .append(System.lineSeparator());
        if (this.reflections != null) {
            sb.append(this.reflections[0].castFireBall()).append(System.lineSeparator());
            sb.append(this.reflections[1].castFireBall()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    public String castReflection() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s %d casts Reflection", this.name, this.id))
                .append(System.lineSeparator());
        if (this.reflections == null) {
            this.reflections = new Wizard[2];
            Wizard firstImage = new Wizard(this.name, this.magicalPower / 2, this.wizardRepository);
            Wizard secondImage = new Wizard(this.name, this.magicalPower / 2, this.wizardRepository);
            this.reflections[0] = firstImage;
            this.reflections[1] = secondImage;
            this.wizardRepository.addWizard(firstImage);
            this.wizardRepository.addWizard(secondImage);
        } else {
            sb.append(this.reflections[0].castReflection()).append(System.lineSeparator());
            sb.append(this.reflections[1].castReflection()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}