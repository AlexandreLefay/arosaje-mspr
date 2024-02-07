class Message {
    id: number;
    sender: User;
    receiver: User;
    guardianship: Guardianship;
    content: string;
    createdAt: Date;
    updatedAt: Date;

    constructor(id: number, sender: User, receiver: User, guardianship: Guardianship, content: string, createdAt: Date, updatedAt: Date) {
        this._createdAt = createdAt;
        this._id = id;
        this._sender = sender;
        this._receiver = receiver;
        this._guardianship = guardianship;
        this._content = content;
        this._updatedAt = updatedAt;
    }

    get id(): number {
        return this._id;
    }

    set id(value: number) {
        this._id = value;
    }

    get sender(): User {
        return this._sender;
    }

    set sender(value: User) {
        this._sender = value;
    }

    get receiver(): User {
        return this._receiver;
    }

    set receiver(value: User) {
        this._receiver = value;
    }

    get guardianship(): Guardianship {
        return this._guardianship;
    }

    set guardianship(value: Guardianship) {
        this._guardianship = value;
    }

    get content(): string {
        return this._content;
    }

    set content(value: string) {
        this._content = value;
    }

    get createdAt(): Date {
        return this._createdAt;
    }

    set createdAt(value: Date) {
        this._createdAt = value;
    }

    get updatedAt(): Date {
        return this._updatedAt;
    }

    set updatedAt(value: Date) {
        this._updatedAt = value;
    }
}