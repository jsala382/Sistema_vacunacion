import { HttpClient, HttpParams} from "@angular/common/http"
import { Injectable } from "@angular/core"
import { filter, Observable} from "rxjs"
import { of } from "rxjs"
import { Empleado } from "./empleado"
import { EstadoVacunacion } from "./estadoVacunacion"
import { TipoVacuna } from "./tipoVacuna"




@Injectable()
export class EmpleadoService{

     private urlEndpoint: string = 'http://localhost:8080/api/empleados'
     private urlEndppoint2: string= "http://localhost:8080/api/empleados/filtros?estado=VACUNADO"
    constructor(private http: HttpClient){}

    getEmpleados():Observable< Empleado[]>{
        return this.http.get<Empleado[]>(this.urlEndpoint);
     }

     create(empleado: Empleado ): Observable<Empleado>{
        return this.http.post<Empleado>(this.urlEndpoint, empleado)
     }

     getEmpleado(idempleado:number): Observable<Empleado>{
      return this.http.get<Empleado>(`${this.urlEndpoint}/${idempleado}`)
    }

    updateEmpleado(empleado: Empleado): Observable<Empleado>{
      return this.http.put<Empleado>(`${this.urlEndpoint}/${empleado.idempleado}`,empleado)
    }

    deleteEmpleado(idempleado: number):Observable<Empleado>{
      return this.http.delete<Empleado>(`${this.urlEndpoint}/${idempleado}`)
    }

    filtrarEmpleados(filtros: { [key: string]: string }): Observable<Empleado[]> {
      const params = new HttpParams({ fromObject: filtros });
      return this.http.get<Empleado[]>(`${this.urlEndpoint}/filtros`, { params });
    }
}