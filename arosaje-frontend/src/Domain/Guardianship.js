class Guardianship {
    id: number;
    plantList: Plant[];
    guardianUser: User;
    ownerUser: User;
    title: string;
    description: string;
    startDate: Date;
    endDate: Date;
    status: string;

    constructor(id, plantList, guardianUser, ownerUser, title, description, startDate, endDate, status) {
        this._id = id;
        this._plantList = plantList;
        this._guardianUser = guardianUser;
        this._ownerUser = ownerUser;
        this._title = title;
        this._description = description;
        this._startDate = startDate;
        this._endDate = endDate;
        this._status = status;
    }


    get id() {
        return this._id;
    }

    set id(value) {
        this._id = value;
    }

    get plantList() {
        return this._plantList;
    }

    set plantList(value) {
        this._plantList = value;
    }

    get guardianUser() {
        return this._guardianUser;
    }

    set guardianUser(value) {
        this._guardianUser = value;
    }

    get ownerUser() {
        return this._ownerUser;
    }

    set ownerUser(value) {
        this._ownerUser = value;
    }

    get title() {
        return this._title;
    }

    set title(value) {
        this._title = value;
    }

    get description() {
        return this._description;
    }

    set description(value) {
        this._description = value;
    }

    get startDate() {
        return this._startDate;
    }

    set startDate(value) {
        this._startDate = value;
    }

    get endDate() {
        return this._endDate;
    }

    set endDate(value) {
        this._endDate = value;
    }

    get status() {
        return this._status;
    }

    set status(value) {
        this._status = value;
    }
}

