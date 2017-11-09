export class User{
    public first_name:string;
    public last_name:string;
    public email:string;
    public password:string;
    public confirm:string;
    public street:string;
    public unit:number;
    public city:string;
    public state:string;
    public feeling:boolean;

    constructor(){
        this.first_name = "";
        this.last_name = "";
        this.email = "";
        this.password = "";
        this.confirm = "";
        this.street = "";
        this.unit = 0;
        this.city = "";
        this.state = "";
        this.feeling = false;
    };
}
