import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Empleado } from '../empleado/empleado'; 
import { AuthService } from '../auth.service'; 
import { EmpleadoService } from '../empleado/empleado.services'; 
import Swal from 'sweetalert2';

@Component({
  selector: 'app-empleado-logueado',
  templateUrl: './empleado-logueado.component.html',
  
})


export class EmpleadoLogueadoComponent implements OnInit{
  empleado: Empleado = new Empleado();

  constructor(
    private authService: AuthService,
    private empleadoService: EmpleadoService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.cargarEmpleadoLogeado();
  }

  cargarEmpleadoLogeado(): void {
    const idEmpleado = this.authService.getIdEmpleado();
    if (idEmpleado) {
      this.empleadoService.getEmpleado(idEmpleado).subscribe(
        (empleado) => {  
         this.empleado = empleado; // Cargar los datos del empleado    
        }
        
      );
    } else {
      console.error('No se encontró un idEmpleado en el almacenamiento local.');
    }
  }

  updateEmpleado(): void {
    this.empleadoService.updateEmpleado(this.empleado).subscribe(
      () => {
        Swal.fire('Tabla Empleado Actulaizado','Empleado actualizado con exito!', 'success')
      },
      (error) => {
        console.error('Error al actualizar los datos', error);
        alert('No se pudo actualizar los datos. Intenta de nuevo.');
      }
    );
  }

  logout(): void {
    this.authService.logout();
    this.router.navigate(['/login']);
  }

}
