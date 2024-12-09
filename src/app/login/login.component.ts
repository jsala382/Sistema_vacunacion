import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { NgForm } from '@angular/forms';
import { EmpleadoService } from '../empleado/empleado.services';
import { Empleado } from '../empleado/empleado';

import { Usuario } from '../usuario/usuario';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent  implements OnInit{
  empleados: Empleado[] | undefined;
  usuario: Usuario= new  Usuario()
  username: string= '';
  password: string = '';
  errorMessage: String= '';
  constructor(private authService: AuthService,   private router: Router, private empleadoService: EmpleadoService){}
  ngOnInit(): void {
    this.empleadoService.getEmpleados().subscribe(empleados => this.empleados=empleados)    
  }
  login(form:NgForm){
    if(form.invalid) return;
    this.authService.login(this.usuario).subscribe(
      response =>{
        this.authService.guardarToken(response);
        if(this.authService.isAdmin()){
          this.router.navigate(['/empleado']);
        }else{
          this.router.navigate(['/empleado-logeado']);
        }
      },
      error =>{
        this.errorMessage= 'Credenciales incorrectas, por favor intente de nuevo'
      },
    );

  }
}