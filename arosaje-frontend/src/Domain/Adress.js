class Adress {
    private _street : string;
    private _city : string;
    private _zip: string;
   constructor(street: string, city: string, zip: string) {
       this._street = street;
       this._city = city;
       this._zip = zip;
   }

    get street() {
        return this._street;
    }

    set street(value) {
        this._street = value;
    }

    get city() {
        return this._city;
    }

    set city(value) {
        this._city = value;
    }

    get zip() {
        return this._zip;
    }

    set zip(value) {
        this._zip = value;
    }
}