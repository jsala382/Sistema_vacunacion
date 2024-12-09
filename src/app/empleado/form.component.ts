import { Component, OnInit } from '@angular/core';
import { Empleado } from './empleado';
import { EmpleadoService } from './empleado.services';
import { Router,ActivatedRoute } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
})
export class FormComponent implements OnInit {
    titulo: string= "Crear Empleado";
    empleado: Empleado= new   Empleado()
    constructor(private empleadoService :EmpleadoService, private router: Router, private activeRoutes: ActivatedRoute ){}
   
   
    ngOnInit(): void { 
      this.cargarEmpleado();
    }
  /// Este metodo crea un nuevo empleado
    public createEmpleado(): void{
      this.empleadoService.create(this.empleado).subscribe(
        empleado =>{
          this.router.navigate(['/empleado'])
          Swal.fire('Nuevo Empleado','Empleado creado con exito', 'success')
        }
        );  
        
    }


    //Este metodo es para obtener un empleado
    public cargarEmpleado(): void {
      this.activeRoutes.params.subscribe(params => {
        let id = params[`idempleado`]
        if (id) {
          this.empleadoService.getEmpleado(id).subscribe((empleado)  => this.empleado = empleado)     
        }
      })
    }
    


    //Este metodo actualiza el empleado
    public updateEmpleado(): void{
      this.empleadoService.updateEmpleado(this.empleado)
      .subscribe(empleado => {
        this.router.navigate(['/empleado'])
        Swal.fire('Tabla Empleado Actulaizado','Empleado actualizado con exito!', 'success')
      }
    );
    }
  

   
  
    
  
}
