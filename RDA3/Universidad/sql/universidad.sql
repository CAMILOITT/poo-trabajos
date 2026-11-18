-- Base de datos universidad.db (SQLite)
-- Caso 2 Sistema Academico
-- Notas sobre 50, se aprueba con 30

PRAGMA foreign_keys = ON;

DROP TABLE IF EXISTS calificaciones;
DROP TABLE IF EXISTS matriculas;
DROP TABLE IF EXISTS asignaturas;
DROP TABLE IF EXISTS estudiantes;
DROP TABLE IF EXISTS carreras;

CREATE TABLE carreras (
    id_carrera INTEGER PRIMARY KEY,
    nombre     TEXT NOT NULL UNIQUE,
    facultad   TEXT NOT NULL
);

CREATE TABLE estudiantes (
    id_estudiante INTEGER PRIMARY KEY,
    cedula        TEXT NOT NULL UNIQUE,
    nombres       TEXT NOT NULL,
    apellidos     TEXT NOT NULL,
    id_carrera    INTEGER NOT NULL,
    FOREIGN KEY (id_carrera) REFERENCES carreras (id_carrera)
);

CREATE TABLE asignaturas (
    id_asignatura INTEGER PRIMARY KEY,
    nombre        TEXT NOT NULL,
    creditos      INTEGER NOT NULL CHECK (creditos > 0),
    semestre      INTEGER NOT NULL CHECK (semestre BETWEEN 1 AND 10),
    id_carrera    INTEGER NOT NULL,
    FOREIGN KEY (id_carrera) REFERENCES carreras (id_carrera)
);

CREATE TABLE matriculas (
    id_matricula  INTEGER PRIMARY KEY,
    id_estudiante INTEGER NOT NULL,
    id_asignatura INTEGER NOT NULL,
    periodo       TEXT NOT NULL,
    UNIQUE (id_estudiante, id_asignatura, periodo),
    FOREIGN KEY (id_estudiante) REFERENCES estudiantes (id_estudiante),
    FOREIGN KEY (id_asignatura) REFERENCES asignaturas (id_asignatura)
);

CREATE TABLE calificaciones (
    id_calificacion INTEGER PRIMARY KEY,
    id_matricula    INTEGER NOT NULL,
    tipo            TEXT NOT NULL,
    nota            REAL NOT NULL CHECK (nota BETWEEN 0 AND 50),
    FOREIGN KEY (id_matricula) REFERENCES matriculas (id_matricula)
);

-- Carreras
INSERT INTO carreras (id_carrera, nombre, facultad) VALUES (1, 'Ingeniería de Sistemas', 'Ingeniería');
INSERT INTO carreras (id_carrera, nombre, facultad) VALUES (2, 'Medicina', 'Ciencias de la Salud');
INSERT INTO carreras (id_carrera, nombre, facultad) VALUES (3, 'Derecho', 'Jurisprudencia');
INSERT INTO carreras (id_carrera, nombre, facultad) VALUES (4, 'Administración de Empresas', 'Ciencias Administrativas');

-- Asignaturas
INSERT INTO asignaturas (id_asignatura, nombre, creditos, semestre, id_carrera) VALUES (1, 'Fundamentos de Sistemas', 3, 1, 1);
INSERT INTO asignaturas (id_asignatura, nombre, creditos, semestre, id_carrera) VALUES (2, 'Introducción a Sistemas', 3, 1, 1);
INSERT INTO asignaturas (id_asignatura, nombre, creditos, semestre, id_carrera) VALUES (3, 'Taller de Sistemas', 3, 2, 1);
INSERT INTO asignaturas (id_asignatura, nombre, creditos, semestre, id_carrera) VALUES (4, 'Fundamentos de Medicina', 3, 1, 2);
INSERT INTO asignaturas (id_asignatura, nombre, creditos, semestre, id_carrera) VALUES (5, 'Introducción a Medicina', 2, 2, 2);
INSERT INTO asignaturas (id_asignatura, nombre, creditos, semestre, id_carrera) VALUES (6, 'Taller de Medicina', 5, 3, 2);
INSERT INTO asignaturas (id_asignatura, nombre, creditos, semestre, id_carrera) VALUES (7, 'Fundamentos de Derecho', 4, 1, 3);
INSERT INTO asignaturas (id_asignatura, nombre, creditos, semestre, id_carrera) VALUES (8, 'Introducción a Derecho', 5, 1, 3);
INSERT INTO asignaturas (id_asignatura, nombre, creditos, semestre, id_carrera) VALUES (9, 'Taller de Derecho', 3, 2, 3);
INSERT INTO asignaturas (id_asignatura, nombre, creditos, semestre, id_carrera) VALUES (10, 'Fundamentos de Administración de Empresas', 3, 1, 4);
INSERT INTO asignaturas (id_asignatura, nombre, creditos, semestre, id_carrera) VALUES (11, 'Introducción a Administración de Empresas', 4, 1, 4);
INSERT INTO asignaturas (id_asignatura, nombre, creditos, semestre, id_carrera) VALUES (12, 'Taller de Administración de Empresas', 3, 2, 4);

-- Estudiantes
INSERT INTO estudiantes (id_estudiante, cedula, nombres, apellidos, id_carrera) VALUES (1, '2231954690', 'Lucía', 'Espinoza Espinoza', 1);
INSERT INTO estudiantes (id_estudiante, cedula, nombres, apellidos, id_carrera) VALUES (2, '1326581533', 'Doménica', 'Cabrera Proaño', 1);
INSERT INTO estudiantes (id_estudiante, cedula, nombres, apellidos, id_carrera) VALUES (3, '0159580059', 'Iván', 'Mora Lara', 1);
INSERT INTO estudiantes (id_estudiante, cedula, nombres, apellidos, id_carrera) VALUES (4, '2133622510', 'Kevin', 'Naranjo Proaño', 1);
INSERT INTO estudiantes (id_estudiante, cedula, nombres, apellidos, id_carrera) VALUES (5, '2238744078', 'Iván', 'Guerrero Torres', 1);
INSERT INTO estudiantes (id_estudiante, cedula, nombres, apellidos, id_carrera) VALUES (6, '0731271003', 'Miguel', 'Paredes Morales', 1);
INSERT INTO estudiantes (id_estudiante, cedula, nombres, apellidos, id_carrera) VALUES (7, '0401127659', 'Jorge', 'Lara Rodríguez', 1);
INSERT INTO estudiantes (id_estudiante, cedula, nombres, apellidos, id_carrera) VALUES (8, '2246910893', 'Carolina', 'Vásquez González', 1);
INSERT INTO estudiantes (id_estudiante, cedula, nombres, apellidos, id_carrera) VALUES (9, '0917520975', 'Belén', 'Chávez Ruiz', 2);
INSERT INTO estudiantes (id_estudiante, cedula, nombres, apellidos, id_carrera) VALUES (10, '1332778883', 'Daniela', 'González Castro', 2);
INSERT INTO estudiantes (id_estudiante, cedula, nombres, apellidos, id_carrera) VALUES (11, '1250550330', 'Sofía', 'Paredes Herrera', 2);
INSERT INTO estudiantes (id_estudiante, cedula, nombres, apellidos, id_carrera) VALUES (12, '0751733361', 'Lucía', 'Lara Erazo', 2);
INSERT INTO estudiantes (id_estudiante, cedula, nombres, apellidos, id_carrera) VALUES (13, '1259577052', 'Ximena', 'Ortega Arias', 2);
INSERT INTO estudiantes (id_estudiante, cedula, nombres, apellidos, id_carrera) VALUES (14, '1516099874', 'Pablo', 'Villacís Ruiz', 2);
INSERT INTO estudiantes (id_estudiante, cedula, nombres, apellidos, id_carrera) VALUES (15, '1756056030', 'Ana', 'Romero Ortega', 2);
INSERT INTO estudiantes (id_estudiante, cedula, nombres, apellidos, id_carrera) VALUES (16, '2249872322', 'Miguel', 'Suárez Torres', 2);
INSERT INTO estudiantes (id_estudiante, cedula, nombres, apellidos, id_carrera) VALUES (17, '1809453895', 'Nicolás', 'Salazar Vega', 3);
INSERT INTO estudiantes (id_estudiante, cedula, nombres, apellidos, id_carrera) VALUES (18, '1731190201', 'Sebastián', 'Vásquez Lara', 3);
INSERT INTO estudiantes (id_estudiante, cedula, nombres, apellidos, id_carrera) VALUES (19, '1202135891', 'Natalia', 'Calderón Andrade', 3);
INSERT INTO estudiantes (id_estudiante, cedula, nombres, apellidos, id_carrera) VALUES (20, '0442765731', 'Kevin', 'Villacís Villacís', 3);
INSERT INTO estudiantes (id_estudiante, cedula, nombres, apellidos, id_carrera) VALUES (21, '1552452946', 'María', 'Salazar Sánchez', 3);
INSERT INTO estudiantes (id_estudiante, cedula, nombres, apellidos, id_carrera) VALUES (22, '2007325224', 'Samuel', 'Pérez Paredes', 3);
INSERT INTO estudiantes (id_estudiante, cedula, nombres, apellidos, id_carrera) VALUES (23, '1735884791', 'Belén', 'Arias Montalvo', 3);
INSERT INTO estudiantes (id_estudiante, cedula, nombres, apellidos, id_carrera) VALUES (24, '0122042310', 'Ricardo', 'Calderón Tapia', 3);
INSERT INTO estudiantes (id_estudiante, cedula, nombres, apellidos, id_carrera) VALUES (25, '1200405197', 'Pablo', 'Erazo Erazo', 4);
INSERT INTO estudiantes (id_estudiante, cedula, nombres, apellidos, id_carrera) VALUES (26, '0330274226', 'Pablo', 'Cevallos Ortega', 4);
INSERT INTO estudiantes (id_estudiante, cedula, nombres, apellidos, id_carrera) VALUES (27, '0435958111', 'Mónica', 'Lara Zambrano', 4);
INSERT INTO estudiantes (id_estudiante, cedula, nombres, apellidos, id_carrera) VALUES (28, '2333662688', 'Natalia', 'Vásquez Vega', 4);
INSERT INTO estudiantes (id_estudiante, cedula, nombres, apellidos, id_carrera) VALUES (29, '1859057778', 'Patricia', 'Pérez Lara', 4);
INSERT INTO estudiantes (id_estudiante, cedula, nombres, apellidos, id_carrera) VALUES (30, '1415324555', 'Luis', 'Espinoza Zambrano', 4);
INSERT INTO estudiantes (id_estudiante, cedula, nombres, apellidos, id_carrera) VALUES (31, '0102098043', 'Ana', 'Romero Morales', 4);
INSERT INTO estudiantes (id_estudiante, cedula, nombres, apellidos, id_carrera) VALUES (32, '1105330649', 'Nicole', 'Cedeño Vásquez', 4);

-- Matriculas
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (1, 1, 1, '2025-2');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (2, 1, 2, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (3, 2, 1, '2025-2');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (4, 2, 2, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (5, 2, 3, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (6, 3, 1, '2025-2');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (7, 3, 2, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (8, 3, 3, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (9, 4, 1, '2025-2');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (10, 4, 2, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (11, 4, 3, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (12, 5, 1, '2025-2');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (13, 5, 2, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (14, 6, 1, '2025-2');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (15, 6, 2, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (16, 7, 1, '2025-2');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (17, 7, 2, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (18, 8, 1, '2025-2');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (19, 8, 2, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (20, 8, 3, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (21, 9, 5, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (22, 9, 6, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (23, 10, 5, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (24, 10, 6, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (25, 11, 4, '2025-2');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (26, 11, 6, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (27, 12, 4, '2025-2');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (28, 12, 5, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (29, 13, 4, '2025-2');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (30, 13, 5, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (31, 14, 4, '2025-2');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (32, 14, 5, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (33, 14, 6, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (34, 15, 4, '2025-2');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (35, 15, 6, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (36, 16, 4, '2025-2');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (37, 16, 6, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (38, 17, 7, '2025-2');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (39, 17, 9, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (40, 18, 7, '2025-2');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (41, 18, 8, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (42, 18, 9, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (43, 19, 7, '2025-2');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (44, 19, 8, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (45, 19, 9, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (46, 20, 7, '2025-2');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (47, 20, 8, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (48, 20, 9, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (49, 21, 8, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (50, 21, 9, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (51, 22, 8, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (52, 22, 9, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (53, 23, 7, '2025-2');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (54, 23, 8, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (55, 23, 9, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (56, 24, 7, '2025-2');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (57, 24, 8, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (58, 24, 9, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (59, 25, 10, '2025-2');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (60, 25, 11, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (61, 25, 12, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (62, 26, 10, '2025-2');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (63, 26, 11, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (64, 27, 10, '2025-2');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (65, 27, 11, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (66, 27, 12, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (67, 28, 10, '2025-2');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (68, 28, 12, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (69, 29, 10, '2025-2');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (70, 29, 11, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (71, 29, 12, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (72, 30, 10, '2025-2');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (73, 30, 11, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (74, 30, 12, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (75, 31, 10, '2025-2');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (76, 31, 11, '2026-1');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (77, 32, 10, '2025-2');
INSERT INTO matriculas (id_matricula, id_estudiante, id_asignatura, periodo) VALUES (78, 32, 11, '2026-1');

-- Calificaciones
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (1, 1, 'Primer parcial', 39.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (2, 1, 'Segundo parcial', 50.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (3, 1, 'Examen final', 50.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (4, 2, 'Primer parcial', 35.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (5, 2, 'Segundo parcial', 34.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (6, 2, 'Examen final', 34.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (7, 3, 'Primer parcial', 43.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (8, 3, 'Segundo parcial', 33.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (9, 3, 'Examen final', 31.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (10, 4, 'Primer parcial', 33.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (11, 4, 'Segundo parcial', 22.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (12, 4, 'Examen final', 24.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (13, 5, 'Primer parcial', 18.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (14, 5, 'Segundo parcial', 21.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (15, 5, 'Examen final', 14.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (16, 6, 'Primer parcial', 37.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (17, 6, 'Segundo parcial', 42.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (18, 6, 'Examen final', 34.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (19, 7, 'Primer parcial', 29.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (20, 7, 'Segundo parcial', 38.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (21, 7, 'Examen final', 29.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (22, 8, 'Primer parcial', 28.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (23, 8, 'Segundo parcial', 35.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (24, 8, 'Examen final', 30.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (25, 9, 'Primer parcial', 50.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (26, 9, 'Segundo parcial', 41.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (27, 9, 'Examen final', 32.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (28, 10, 'Primer parcial', 39.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (29, 10, 'Segundo parcial', 38.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (30, 10, 'Examen final', 41.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (31, 11, 'Primer parcial', 22.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (32, 11, 'Segundo parcial', 30.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (33, 11, 'Examen final', 37.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (34, 12, 'Primer parcial', 41.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (35, 12, 'Segundo parcial', 47.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (36, 12, 'Examen final', 35.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (37, 13, 'Primer parcial', 37.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (38, 13, 'Segundo parcial', 35.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (39, 13, 'Examen final', 44.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (40, 14, 'Primer parcial', 30.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (41, 14, 'Segundo parcial', 44.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (42, 14, 'Examen final', 38.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (43, 15, 'Primer parcial', 32.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (44, 15, 'Segundo parcial', 27.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (45, 15, 'Examen final', 25.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (46, 16, 'Primer parcial', 23.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (47, 16, 'Segundo parcial', 34.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (48, 16, 'Examen final', 27.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (49, 17, 'Primer parcial', 35.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (50, 17, 'Segundo parcial', 30.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (51, 17, 'Examen final', 30.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (52, 18, 'Primer parcial', 40.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (53, 18, 'Segundo parcial', 32.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (54, 18, 'Examen final', 38.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (55, 19, 'Primer parcial', 17.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (56, 19, 'Segundo parcial', 25.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (57, 19, 'Examen final', 34.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (58, 20, 'Primer parcial', 21.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (59, 20, 'Segundo parcial', 32.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (60, 20, 'Examen final', 22.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (61, 21, 'Primer parcial', 27.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (62, 21, 'Segundo parcial', 41.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (63, 21, 'Examen final', 33.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (64, 22, 'Primer parcial', 25.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (65, 22, 'Segundo parcial', 26.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (66, 22, 'Examen final', 22.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (67, 23, 'Primer parcial', 25.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (68, 23, 'Segundo parcial', 33.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (69, 23, 'Examen final', 23.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (70, 24, 'Primer parcial', 21.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (71, 24, 'Segundo parcial', 17.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (72, 24, 'Examen final', 22.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (73, 25, 'Primer parcial', 44.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (74, 25, 'Segundo parcial', 44.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (75, 25, 'Examen final', 39.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (76, 26, 'Primer parcial', 20.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (77, 26, 'Segundo parcial', 27.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (78, 26, 'Examen final', 31.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (79, 27, 'Primer parcial', 42.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (80, 27, 'Segundo parcial', 50.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (81, 27, 'Examen final', 39.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (82, 28, 'Primer parcial', 25.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (83, 28, 'Segundo parcial', 26.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (84, 28, 'Examen final', 34.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (85, 29, 'Primer parcial', 31.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (86, 29, 'Segundo parcial', 36.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (87, 29, 'Examen final', 27.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (88, 30, 'Primer parcial', 25.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (89, 30, 'Segundo parcial', 31.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (90, 30, 'Examen final', 33.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (91, 31, 'Primer parcial', 42.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (92, 31, 'Segundo parcial', 45.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (93, 31, 'Examen final', 34.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (94, 32, 'Primer parcial', 38.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (95, 32, 'Segundo parcial', 39.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (96, 32, 'Examen final', 18.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (97, 33, 'Primer parcial', 15.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (98, 33, 'Segundo parcial', 27.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (99, 33, 'Examen final', 27.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (100, 34, 'Primer parcial', 50.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (101, 34, 'Segundo parcial', 45.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (102, 34, 'Examen final', 37.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (103, 35, 'Primer parcial', 23.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (104, 35, 'Segundo parcial', 37.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (105, 35, 'Examen final', 27.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (106, 36, 'Primer parcial', 30.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (107, 36, 'Segundo parcial', 40.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (108, 36, 'Examen final', 45.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (109, 37, 'Primer parcial', 25.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (110, 37, 'Segundo parcial', 28.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (111, 37, 'Examen final', 28.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (112, 38, 'Primer parcial', 35.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (113, 38, 'Segundo parcial', 28.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (114, 38, 'Examen final', 35.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (115, 39, 'Primer parcial', 42.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (116, 39, 'Segundo parcial', 34.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (117, 39, 'Examen final', 44.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (118, 40, 'Primer parcial', 48.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (119, 40, 'Segundo parcial', 40.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (120, 40, 'Examen final', 38.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (121, 41, 'Primer parcial', 29.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (122, 41, 'Segundo parcial', 23.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (123, 41, 'Examen final', 38.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (124, 42, 'Primer parcial', 36.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (125, 42, 'Segundo parcial', 34.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (126, 42, 'Examen final', 50.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (127, 43, 'Primer parcial', 43.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (128, 43, 'Segundo parcial', 33.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (129, 43, 'Examen final', 38.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (130, 44, 'Primer parcial', 32.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (131, 44, 'Segundo parcial', 35.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (132, 44, 'Examen final', 18.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (133, 45, 'Primer parcial', 34.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (134, 45, 'Segundo parcial', 31.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (135, 45, 'Examen final', 41.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (136, 46, 'Primer parcial', 32.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (137, 46, 'Segundo parcial', 39.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (138, 46, 'Examen final', 48.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (139, 47, 'Primer parcial', 32.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (140, 47, 'Segundo parcial', 23.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (141, 47, 'Examen final', 29.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (142, 48, 'Primer parcial', 41.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (143, 48, 'Segundo parcial', 28.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (144, 48, 'Examen final', 46.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (145, 49, 'Primer parcial', 30.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (146, 49, 'Segundo parcial', 33.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (147, 49, 'Examen final', 36.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (148, 50, 'Primer parcial', 40.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (149, 50, 'Segundo parcial', 46.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (150, 50, 'Examen final', 41.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (151, 51, 'Primer parcial', 28.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (152, 51, 'Segundo parcial', 35.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (153, 51, 'Examen final', 34.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (154, 52, 'Primer parcial', 49.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (155, 52, 'Segundo parcial', 50.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (156, 52, 'Examen final', 35.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (157, 53, 'Primer parcial', 39.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (158, 53, 'Segundo parcial', 35.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (159, 53, 'Examen final', 40.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (160, 54, 'Primer parcial', 37.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (161, 54, 'Segundo parcial', 42.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (162, 54, 'Examen final', 22.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (163, 55, 'Primer parcial', 43.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (164, 55, 'Segundo parcial', 50.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (165, 55, 'Examen final', 37.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (166, 56, 'Primer parcial', 37.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (167, 56, 'Segundo parcial', 36.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (168, 56, 'Examen final', 42.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (169, 57, 'Primer parcial', 28.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (170, 57, 'Segundo parcial', 12.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (171, 57, 'Examen final', 19.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (172, 58, 'Primer parcial', 36.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (173, 58, 'Segundo parcial', 34.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (174, 58, 'Examen final', 33.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (175, 59, 'Primer parcial', 39.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (176, 59, 'Segundo parcial', 24.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (177, 59, 'Examen final', 32.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (178, 60, 'Primer parcial', 30.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (179, 60, 'Segundo parcial', 12.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (180, 60, 'Examen final', 25.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (181, 61, 'Primer parcial', 28.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (182, 61, 'Segundo parcial', 25.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (183, 61, 'Examen final', 43.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (184, 62, 'Primer parcial', 26.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (185, 62, 'Segundo parcial', 34.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (186, 62, 'Examen final', 25.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (187, 63, 'Primer parcial', 16.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (188, 63, 'Segundo parcial', 23.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (189, 63, 'Examen final', 29.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (190, 64, 'Primer parcial', 31.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (191, 64, 'Segundo parcial', 36.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (192, 64, 'Examen final', 31.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (193, 65, 'Primer parcial', 31.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (194, 65, 'Segundo parcial', 25.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (195, 65, 'Examen final', 26.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (196, 66, 'Primer parcial', 35.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (197, 66, 'Segundo parcial', 33.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (198, 66, 'Examen final', 31.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (199, 67, 'Primer parcial', 26.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (200, 67, 'Segundo parcial', 29.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (201, 67, 'Examen final', 26.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (202, 68, 'Primer parcial', 34.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (203, 68, 'Segundo parcial', 26.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (204, 68, 'Examen final', 31.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (205, 69, 'Primer parcial', 33.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (206, 69, 'Segundo parcial', 40.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (207, 69, 'Examen final', 27.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (208, 70, 'Primer parcial', 25.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (209, 70, 'Segundo parcial', 36.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (210, 70, 'Examen final', 30.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (211, 71, 'Primer parcial', 22.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (212, 71, 'Segundo parcial', 32.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (213, 71, 'Examen final', 33.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (214, 72, 'Primer parcial', 30.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (215, 72, 'Segundo parcial', 25.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (216, 72, 'Examen final', 26.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (217, 73, 'Primer parcial', 36.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (218, 73, 'Segundo parcial', 23.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (219, 73, 'Examen final', 31.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (220, 74, 'Primer parcial', 36.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (221, 74, 'Segundo parcial', 27.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (222, 74, 'Examen final', 33.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (223, 75, 'Primer parcial', 33.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (224, 75, 'Segundo parcial', 26.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (225, 75, 'Examen final', 34.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (226, 76, 'Primer parcial', 25.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (227, 76, 'Segundo parcial', 26.0);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (228, 76, 'Examen final', 22.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (229, 77, 'Primer parcial', 35.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (230, 77, 'Segundo parcial', 38.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (231, 77, 'Examen final', 32.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (232, 78, 'Primer parcial', 36.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (233, 78, 'Segundo parcial', 32.5);
INSERT INTO calificaciones (id_calificacion, id_matricula, tipo, nota) VALUES (234, 78, 'Examen final', 30.5);
