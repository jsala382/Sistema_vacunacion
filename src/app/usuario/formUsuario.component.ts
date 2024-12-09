import { Component, OnInit } from '@angular/core';
import { Usuario } from './usuario';
import { UsuarioService } from './usuario.services';
import { Router, ActivatedRoute } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-form',
  templateUrl: './formUsuario.component.html',
  
})
export class FormComponentUsuario implements OnInit {
  titulo: string= "Crear Usuario";
    usuario: Usuario= new  Usuario()
    constructor(private  usuarioService :UsuarioService, private router: Router, private activeRoutes: ActivatedRoute ){}
   
   
    ngOnInit(): void {
      this.cargarUsuarios();
    }

    public cargarUsuarios():void{
      this.activeRoutes.params.subscribe(params =>{
        let id= params['idusuario']
        if(id){
          this.usuarioService.getUsuario(id).subscribe((usuario)=> this.usuario= usuario)
        }

      })
    }

    public updateUsuario(): void{
      this.usuarioService.updateUsuario(this.usuario)
      .subscribe(usaurio => {
        this.router.navigate(['/usuario'])
        Swal.fire('Usuario Actulaizado','Usuario  actualizado con exito!', 'success')
      }
    );
    }
  

    public create(): void{
      this.usuarioService.create(this.usuario).
      subscribe(usuario =>{
        this.router.navigate(['/usuario'])
        Swal.fire("Usuario creado",'Usuario creado con exito', 'success')
      }
    )
    }
}
