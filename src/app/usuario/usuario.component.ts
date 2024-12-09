import { Component, OnInit } from '@angular/core';
import { Usuario } from './usuario';
import { UsuarioService} from './usuario.services'
import Swal from 'sweetalert2';
@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
 
})
export class UsuarioComponent implements OnInit {
  usuarios: Usuario[] | undefined;
  constructor(private usuarioService : UsuarioService) {}
  ngOnInit(){
      this.usuarioService.getUsuarios().subscribe(usuarios => this.usuarios = usuarios)
  }

  deleteUsuario(usuario: Usuario): void{
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
        this.usuarioService.deleteUsuario(usuario.idusuario).subscribe(
          Response=>{
            this.usuarios= this.usuarios?.filter(usuar => usuar ==usuario
            )
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
