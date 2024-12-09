import { Component, OnInit } from '@angular/core';
import { Empleado } from './empleado';
import { EmpleadoService } from './empleado.services';
import Swal from 'sweetalert2';
import { ActivatedRoute, Router } from '@angular/router';
import { Usuario } from '../usuario/usuario';
import { AuthService } from '../auth.service';


@Component({
  selector: 'app-empleado',
  templateUrl: './empleado.component.html',
})
export class EmpleadoComponent implements OnInit {
  empleados: Empleado[] | undefined;
  usuarioAutenticado: Usuario = new Usuario();
  isAdmin: boolean = false;
  filtroTexto: string = '';
  fechaInicio: string | null = null; // Inicializamos las fechas como null
  fechaFin: string | null = null;



  constructor(private empleadoService: EmpleadoService, private activeRoutes: ActivatedRoute, private authService: AuthService, private router:Router) { }
  ngOnInit() {
    const user = this.authService.obtenerUsuario();
    this.isAdmin = user?.role === 'ADMIN';
    this.empleadoService.getEmpleados().subscribe((empleados) => { this.empleados = empleados });
  }

  filtrarEmpleados(): void {
    const filtroValor = this.filtroTexto.trim().toUpperCase(); // Convertir a mayúsculas para comparación uniforme
    const filtros: { [key: string]: string } = {};
  
    // Determinar el filtro en base al valor ingresado
    if (filtroValor === 'VACUNADO' || filtroValor === 'NO_VACUNADO') {
      filtros['estado'] = filtroValor;
    } else if (['SPUTNIK', 'ASTRAZENECA', 'PFIZER', 'JHONSON_JHONSON'].includes(filtroValor)) {
      filtros['tipo'] = filtroValor;
    } else if (this.fechaInicio && this.fechaFin){
      const fechaInicioDate = new Date(this.fechaInicio);
      const fechaFinDate = new Date(this.fechaFin)
      filtros['fechaInicio'] = this.fechaInicio;
      filtros['fechaFin'] = this.fechaFin;
      
    }else {
      console.error('Valor de filtro no reconocido:', filtroValor);
      return; // Salir si no es un valor válido
    }
  
    console.log('Filtros generados:', filtros);
  
    // Llamar al servicio para aplicar los filtros
    this.empleadoService.filtrarEmpleados(filtros).subscribe(
      (empleados) => {
        console.log('Empleados filtrados:', empleados);
        this.empleados = empleados; // Actualizar la lista en pantalla
      },
      (error) => {
        console.error('Error al filtrar empleados:', error);
      }
    );
  }

  public deleteEmpleado(empleado1: Empleado): void {
    Swal.fire({
      title: "Are you sure?",
      text: "You won't be able to revert this!",
      icon: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: "Yes, delete it!"
    }).then((result) => {
      if (result.isConfirmed) {
        this.empleadoService.deleteEmpleado(empleado1.idempleado).subscribe(
          Response => {
            this.empleados = this.empleados?.filter(empl => empl != empleado1)
          }
        )
        Swal.fire({
          title: "Deleted!",
          text: "Your file has been deleted.",
          icon: "success"
        });
      }
    });
  }




}
