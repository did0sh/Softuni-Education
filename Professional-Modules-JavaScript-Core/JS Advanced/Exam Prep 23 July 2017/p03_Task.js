class Task {
    constructor(title, deadline) {
        this.title = title;
        this.status = 'Open';
        this.deadline = deadline;
    }

    get rank() {
        if(this.isOverdue){
            return 0;
        } else if(this.status === 'In Progress'){
            return 1;
        } else if(this.status === 'Open'){
            return 2;
        } else {
            return 3;
        }
    }

    get deadline() {
        return this._deadline;
    }

    set deadline(value) {
        if(value < Date.now()){
            throw new Error('Deadline cannot be in the past!');
        }

        this._deadline = value;
    }

    get isOverdue() {
        return this.deadline < Date.now() && this.status !== 'Complete';
    }

    get taskIcon() {
        if (this.isOverdue){
            return '\u26A0';
        } else if (this.status === 'Open'){
            return '\u2731';
        } else if (this.status === 'In Progress'){
            return '\u219D';
        } else {
            return '\u2714';
        }
    }


    toString() {
        if(this.isOverdue){
            return `[${this.taskIcon}] ${this.title} (overdue)`;
        }

        return `[${this.taskIcon}] ${this.title} (deadline: ${this.deadline.toString()})`
    }

    static comparator(a, b) {
        let criteria = a.rank - b.rank;

        if(criteria !== 0){
            return criteria;
        } else {
            return a.deadline - b.deadline;
        }
    }
}