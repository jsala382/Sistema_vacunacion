import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { AppComponent } from "./app.component";
import { HeaderComponent } from "./header/header.component";
import { HttpClientModule } from "@angular/common/http";
import { EmpleadoComponent } from "./empleado/empleado.component";
import { EmpleadoService } from "./empleado/empleado.services";
import { UsuarioComponent } from "./usuario/usuario.component";
import { UsuarioService } from "./usuario/usuario.services";
import { RouterModule,  Routes } from "@angular/router";
import { FormComponent } from "./empleado/form.component";
import { FormComponentUsuario } from "./usuario/formUsuario.component";
import { LoginComponent } from "./login/login.component";
import { FormsModule } from "@angular/forms";
import { CUSTOM_ELEMENTS_SCHEMA } from "@angular/core";
import { AuthService } from "./auth.service";
import { AuthGuard } from "./auth.guard";
import { JwtInterceptorService } from "./jwt-interceptor.service";
import { JwtModule } from '@auth0/angular-jwt';
import { EmpleadoFiltroComponent } from "./empleado-filtro/empleado-filtro.component";
import { EmpleadoLogueadoComponent } from "./empleado-logueado/empleado-logueado.component";


const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' }, // Página inicial: Login
  { path: 'login', component: LoginComponent }, // Componente de Login
  { path: 'empleado', component: EmpleadoComponent, canActivate: [AuthGuard] }, // Protegido
  { path: 'empleado/form', component: FormComponent, canActivate: [AuthGuard] }, // Protegido
  { path: 'empleado/form/:idempleado', component: FormComponent, canActivate: [AuthGuard] }, // Protegido
  { path: 'usuario', component: UsuarioComponent, canActivate: [AuthGuard] }, // Protegido
  { path: 'usuario/formUsuario', component: FormComponentUsuario, canActivate: [AuthGuard] }, // Protegido
  { path: 'usuario/formUsuario/:idusuario', component: FormComponentUsuario, canActivate: [AuthGuard] }, // Protegido
  { path: 'empleados/filtro', component: EmpleadoFiltroComponent, canActivate: [AuthGuard] }, // Protegido
  { path: 'empleado-logeado', component: EmpleadoLogueadoComponent, canActivate: [AuthGuard] }, // Protegido
  { path: '**', redirectTo: '/login' }, // Redirección a Login para rutas inexistentes
  
];

export function tokenGetter() {
    return localStorage.getItem('token');
  }
@NgModule({
    declarations:[
        AppComponent,
        HeaderComponent, 
        EmpleadoComponent,
        UsuarioComponent,
        FormComponent,
        FormComponentUsuario,
        LoginComponent, 
        EmpleadoFiltroComponent,
        EmpleadoLogueadoComponent
       
    ],
    imports: [
        BrowserModule,
        HttpClientModule,
        FormsModule,
        RouterModule.forRoot(routes),
        JwtModule.forRoot({
            config: {
              tokenGetter: tokenGetter,
              allowedDomains: ['localhost:8080'], // Ajusta según tu dominio del backend
              disallowedRoutes: ['http://localhost:8080/login'],
            },
          })
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA],
    providers:[EmpleadoService, UsuarioService,AuthService,AuthGuard,JwtInterceptorService],
    bootstrap:[AppComponent]

})
export class AppModule{

}