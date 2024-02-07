class TicketComment{
    id: number;
    ticket: Ticket;
    user: User;
    comment: string;
    createdAt: Date;

    constructor(id: number, ticket: Ticket, user: User, comment: string, createdAt: Date) {
        this._id = id;
        this._ticket = ticket;
        this._user = user;
        this._comment = comment;
        this._createdAt = createdAt;
    }

    get id(): number {
        return this._id;
    }

    set id(value: number) {
        this._id = value;
    }

    get ticket(): Ticket {
        return this._ticket;
    }

    set ticket(value: Ticket) {
        this._ticket = value;
    }

    get user(): User {
        return this._user;
    }

    set user(value: User) {
        this._user = value;
    }

    get comment(): string {
        return this._comment;
    }

    set comment(value: string) {
        this._comment = value;
    }

    get createdAt(): Date {
        return this._createdAt;
    }

    set createdAt(value: Date) {
        this._createdAt = value;
    }
}