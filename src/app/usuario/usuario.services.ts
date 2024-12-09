import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable,of } from "rxjs";
import { Usuario } from "./usuario";
import { NumberValueAccessor } from "@angular/forms";

@Injectable()
export class UsuarioService{

    private urlEndpoint: string = 'http://localhost:8080/api/usuarios'
    constructor( private http : HttpClient){}

    getUsuarios():Observable<Usuario[]>{
        return this.http.get<Usuario[]>(this.urlEndpoint);
    }

    create(usuario: Usuario): Observable<Usuario[]>{
        return this.http.post<Usuario[]>(this.urlEndpoint, usuario)
     }

     getUsuario(idusuario: any): Observable<Usuario>{
        return this.http.get<Usuario>(`${this.urlEndpoint}/${idusuario}`)
     }

     updateUsuario(usuario :Usuario): Observable<Usuario>{
        return this.http.put<Usuario>(`${this.urlEndpoint}/${usuario.idusuario}`, usuario)
     }

     deleteUsuario(idusuario: number): Observable<Usuario>{
        return this.http.delete<Usuario>(`${this.urlEndpoint}/${idusuario}`)
     }

    
}
