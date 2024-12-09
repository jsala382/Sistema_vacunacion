import { EstadoVacunacion } from "./estadoVacunacion";
import { TipoVacuna } from "./tipoVacuna";
export class Empleado{
    idempleado!: number;
    cedula!: string;
    nombres!: string;
    apellidos!: string;
    correo_electronico!: string;
    fecha_nacimiento!: Date;
    direccion!: string
    telefono_movil!: string
    estado_vacunacion!: EstadoVacunacion;
    tipo_vacuna!: TipoVacuna;
    fecha_vacunacion!:Date;
    num_dosis!: number
}