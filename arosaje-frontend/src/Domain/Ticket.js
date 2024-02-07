class Ticket{
    id: number;
    user: User;
    title: string;
    description: string;
    status: string;
    createdAt: Date;
    updateAt: Date;
    comments: Ticket[];

    constructor(id: number, user: User, title: string, description: string, status: string, createdAt: Date, updateAt: Date, comments: Ticket[]) {
        this._id = id;
        this._user = user;
        this._title = title;
        this._description = description;
        this._status = status;
        this._createdAt = createdAt;
        this._updateAt = updateAt;
        this._comments = comments;
    }

    get id(): number {
        return this._id;
    }

    set id(value: number) {
        this._id = value;
    }

    get user(): User {
        return this._user;
    }

    set user(value: User) {
        this._user = value;
    }

    get title(): string {
        return this._title;
    }

    set title(value: string) {
        this._title = value;
    }

    get description(): string {
        return this._description;
    }

    set description(value: string) {
        this._description = value;
    }

    get status(): string {
        return this._status;
    }

    set status(value: string) {
        this._status = value;
    }

    get createdAt(): Date {
        return this._createdAt;
    }

    set createdAt(value: Date) {
        this._createdAt = value;
    }

    get updateAt(): Date {
        return this._updateAt;
    }

    set updateAt(value: Date) {
        this._updateAt = value;
    }

    get comments(): Ticket[] {
        return this._comments;
    }

    set comments(value: Array) {
        this._comments = value;
    }
}