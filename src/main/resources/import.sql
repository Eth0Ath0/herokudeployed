insert into responsables (primer_nombre_responsable,segundo_nombre_responsable,primer_apellido_responsable,segundo_apellido_responsable,dpi_responsable,fecha_nacimiento_responsable,edad_responsable,sexo_responsable,direccion_responsable,telefono_responsable,email_responsable)values('luis','enrique','Estrada','Yoc',12131321,'19/05/2021',30,'masculino','huehuetenango','78562345','yo@gmail.com')
insert into grados(nombre_grado) values('Primero')
insert into aulas(capacidad_aula,nombre_aula,seccion_aula,grado_id) values(10,'Caperucita Roja','B',1)
insert into roles(nombre_rol) values('administrador')
insert into usuarios(enabled,nombre_usuario,contraseña_usuario) values(1,'Luis Enrique','secreto')
insert into estudiantes (codigo_personal,primer_nombre_estudiante,segundo_nombre_estudiante,primer_apellido_estudiante,segundo_apellido_estudiante,fecha_nacimiento,edad_estudiante,sexo_estudiante,idioma_estudiante,lateralidad_estudiante,direccion_estudiante,Observacion,responsable_id,grado_id,aula_id,usuario_id) values ('d12d','luis','enrique','Estrada','Yoc','10/05/2021',31,'masculino','castellano','bien','quetgo','ninguna',1,1,1,1)
insert into profesores (primer_nombre_profesor,segundo_nombre_profesor,primer_apellido_profesor,segundo_apellido_profesor,dpi_profesor,fecha_nacimiento_profesor,edad_profesor,sexo_profesor,direccion_profesor,telefono_profesor,email_profesor,usuario_id) values ('alberto','eslin','granados','perez',1235454454545,'1905/2021',50,'masculino','guatemala','45625478','alberto@gmail.com',1)
insert into matriculas (fecha_matricula,observaciones,codigo_personal) values ('19/09/2021','matricula correcta','d12d')
insert into cursos(nombre_curso) values('matemáticas')
insert into calificaciones(nota_bim1,nota_bim2,nota_bim3,nota_bim4,curso_id,estudiante_id) values(50,80,70,60,1,'d12d')
insert into clases (descripcion,aula_id,curso_id,profesor_id) values('aula niños de 7 a 8 años',1,1,1)
insert into contenidos (nombre_contenido,fecha_creacion,archivo,clase_id) values('contenido seman 1','20/10/2021','pruebaArchivo',1)