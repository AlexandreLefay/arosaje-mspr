class User {
    private _id: number;
    private _username: string;
    private _firstname: string
    private _lastname: string;
    private _email: string;
    private _phone: string;
    private _active: boolean;
    private _address: Adress;
    private _x: number;
    private _y: number;
    private _password: string;
    private _createdAt: Date;
    private _updatedAt: Date;
    private _roles: Role[];

    constructor(id: number, username: string, firstname: string, lastname: string, email: string, phone: string, active: boolean, address: Adress, password: string, createdAt: Date, updatedAt: Date, roles: Role[]) {
        this._id = id;
        this._username = username;
        this._firstname = firstname;
        this._lastname = lastname;
        this._email = email;
        this._phone = phone;
        this._active = active;
        this._address = address;
        this._password = password;
        this._createdAt = createdAt;
        this._updatedAt = updatedAt;
        this._roles = roles;
        const coord: XYControleur = new XMLDocument(address.street, address.city);
        this._x = coord.x;
        this._y = coord.y;

    }

    get id(): number {
        return this._id;
    }

    set id(value: number) {
        this._id = value;
    }

    get username(): string {
        return this._username;
    }

    set username(value: string) {
        this._username = value;
    }

    get firstname(): string {
        return this._firstname;
    }

    set firstname(value: string) {
        this._firstname = value;
    }

    get lastname(): string {
        return this._lastname;
    }

    set lastname(value: string) {
        this._lastname = value;
    }

    get email(): string {
        return this._email;
    }

    set email(value: string) {
        this._email = value;
    }

    get phone(): string {
        return this._phone;
    }

    set phone(value: string) {
        this._phone = value;
    }

    get active(): boolean {
        return this._active;
    }

    set active(value: boolean) {
        this._active = value;
    }

    get address(): Adress {
        return this._address;
    }

    set address(value: Adress) {
        this._address = value;
    }

    get x(): number {
        return this._x;
    }

    set x(value: number) {
        this._x = value;
    }

    get y(): number {
        return this._y;
    }

    set y(value: number) {
        this._y = value;
    }

    get password(): string {
        return this._password;
    }

    set password(value: string) {
        this._password = value;
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

    get roles(): Role[] {
        return this._roles;
    }

    set roles(value: Array) {
        this._roles = value;
    }
}