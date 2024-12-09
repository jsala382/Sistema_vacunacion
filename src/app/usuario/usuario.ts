import { Token } from "@angular/compiler";

export class Usuario{
    idusuario!: number;
    username!: string; 
    password!: string;
    idempleado!: number;
   
}
export interface LoginResponse {
    token: string;
    role: { authority: string }[];
    idEmpleado: string;      
  }