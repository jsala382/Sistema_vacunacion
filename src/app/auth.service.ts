import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LoginResponse } from './usuario/usuario';

import { Usuario } from './usuario/usuario';
@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8080/login';
  private tokenKey = 'token';
  private userKey = 'authUser';
  private idEmpleadoKey = 'idempleado';

  constructor(private http: HttpClient) { }

  login(usuario: Usuario): Observable<LoginResponse> {
    return this.http.post<LoginResponse>(this.apiUrl, usuario);
  }

  guardarToken(response: LoginResponse): void {
    localStorage.setItem(this.tokenKey, response.token);

    // Extraer el primer rol del array y guardarlo
    const userRole = response.role && response.role.length > 0 ? response.role[0].authority : 'USER';
    localStorage.setItem(this.userKey, JSON.stringify({ role: userRole }));
    if (response.idEmpleado) {
      localStorage.setItem(this.idEmpleadoKey, response.idEmpleado.toString());
    }
  }

  obtenerToken(): string | null {
    return localStorage.getItem(this.tokenKey);
  }
  
  obtenerUsuario(): { role: string } | null {
    const userData = localStorage.getItem(this.userKey);
    return userData ? JSON.parse(userData) : null;
  }

  obtenerRol(): string {
    const user = this.obtenerUsuario();
    return user ? user.role : ''; // Retornar el rol o una cadena vacía si no existe
  }

  getIdEmpleado(): number| null {
    const id = localStorage.getItem(this.idEmpleadoKey);
    return id ? parseInt(id, 10) : null;
  }

  eliminarToken(): void {
    localStorage.removeItem(this.tokenKey);
    localStorage.removeItem(this.userKey);
  }

  logout(): void {
    this.eliminarToken();
  }

  isAdmin(): boolean {
    return this.obtenerRol() === 'ADMIN'; // Verificar si el rol es ADMIN
  }

}
