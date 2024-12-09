import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { EmpleadoService } from '../empleado/empleado.services'; 
import { Empleado } from '../empleado/empleado';

@Component({
  selector: 'app-empleado-filtro',
  templateUrl: './empleado-filtro.component.html',
  styleUrls: ['./empleado-filtro.component.css']
})
export class EmpleadoFiltroComponent implements OnInit {
  empleados: Empleado[] = [];

  constructor(
    private route: ActivatedRoute,
    private empleadoService: EmpleadoService
  ) {}

  ngOnInit(): void {
    this.route.queryParams.subscribe((params) => {
      this.empleadoService.filtrarEmpleados(params).subscribe((data) => {
        this.empleados = data;
      });
    });
  }
}