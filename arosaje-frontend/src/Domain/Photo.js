class Photo{
    id: number;
    user: User;
    referenceId: number;
    referenceType: string;
    imageBlob: Blob;
    createdAt: Date;

    constructor(id: number, user: User, referenceId: number, referenceType: string, imageBlob: Blob, createdAt: Date) {
        this._id = id;
        this._user = user;
        this._referenceId = referenceId;
        this._referenceType = referenceType;
        this._imageBlob = imageBlob;
        this._createdAt = createdAt;
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

    get referenceId(): number {
        return this._referenceId;
    }

    set referenceId(value: number) {
        this._referenceId = value;
    }

    get referenceType(): string {
        return this._referenceType;
    }

    set referenceType(value: string) {
        this._referenceType = value;
    }

    get imageBlob(): Blob {
        return this._imageBlob;
    }

    set imageBlob(value: Blob) {
        this._imageBlob = value;
    }

    get createdAt(): Date {
        return this._createdAt;
    }

    set createdAt(value: Date) {
        this._createdAt = value;
    }
}