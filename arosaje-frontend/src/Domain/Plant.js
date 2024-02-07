class Plant{
    id: number;
    user: User;
    name: string;
    species: string;
    careInstruction: string
    createdAt: Date;
    updatedAt: Date;

    constructor(id: number, user: User, name: string, species: string, careInstruction: string, createdAt: Date, updatedAt: Date) {
        this._id = id;
        this._user = user;
        this._name = name;
        this._species = species;
        this._careInstruction = careInstruction;
        this._createdAt = createdAt;
        this._updatedAt = updatedAt;
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

    get name(): string {
        return this._name;
    }

    set name(value: string) {
        this._name = value;
    }

    get species(): string {
        return this._species;
    }

    set species(value: string) {
        this._species = value;
    }

    get careInstruction(): string {
        return this._careInstruction;
    }

    set careInstruction(value: string) {
        this._careInstruction = value;
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