export default class Car {
    constructor (
        // Parameter w/ access modifier is created as a field.
        public id?:number,
        public brand?:string,
        public model?:string,
        public color?:string,
        public registrationNumber?:string,
        public year?:number,
        public price?:number
    ) {

    }
}