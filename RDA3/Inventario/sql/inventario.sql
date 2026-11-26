-- Base de datos inventario.db (SQLite)
-- Caso 3 Sistema de Inventario
-- Movimientos de tipo ENTRADA suman al stock y de tipo SALIDA lo restan

PRAGMA foreign_keys = ON;

DROP TABLE IF EXISTS movimientos;
DROP TABLE IF EXISTS articulos;
DROP TABLE IF EXISTS categorias;
DROP TABLE IF EXISTS proveedores;

CREATE TABLE proveedores (
    id_proveedor INTEGER PRIMARY KEY,
    ruc          TEXT NOT NULL UNIQUE,
    nombre       TEXT NOT NULL,
    ciudad       TEXT NOT NULL,
    telefono     TEXT NOT NULL
);

CREATE TABLE categorias (
    id_categoria INTEGER PRIMARY KEY,
    nombre       TEXT NOT NULL UNIQUE,
    descripcion  TEXT NOT NULL
);

CREATE TABLE articulos (
    id_articulo     INTEGER PRIMARY KEY,
    codigo          TEXT NOT NULL UNIQUE,
    nombre          TEXT NOT NULL,
    precio_unitario REAL NOT NULL CHECK (precio_unitario > 0),
    stock_minimo    INTEGER NOT NULL CHECK (stock_minimo >= 0),
    id_categoria    INTEGER NOT NULL,
    id_proveedor    INTEGER NOT NULL,
    FOREIGN KEY (id_categoria) REFERENCES categorias (id_categoria),
    FOREIGN KEY (id_proveedor) REFERENCES proveedores (id_proveedor)
);

CREATE TABLE movimientos (
    id_movimiento INTEGER PRIMARY KEY,
    id_articulo   INTEGER NOT NULL,
    tipo          TEXT NOT NULL CHECK (tipo IN ('ENTRADA', 'SALIDA')),
    cantidad      INTEGER NOT NULL CHECK (cantidad > 0),
    fecha         TEXT NOT NULL,
    FOREIGN KEY (id_articulo) REFERENCES articulos (id_articulo)
);

-- Proveedores
INSERT INTO proveedores (id_proveedor, ruc, nombre, ciudad, telefono) VALUES (1, '1790012345001', 'Distribuidora Andina', 'Quito', '022456789');
INSERT INTO proveedores (id_proveedor, ruc, nombre, ciudad, telefono) VALUES (2, '0990123456001', 'Ferremundo', 'Guayaquil', '042345678');
INSERT INTO proveedores (id_proveedor, ruc, nombre, ciudad, telefono) VALUES (3, '0190234567001', 'Importadora El Volcán', 'Cuenca', '072876543');
INSERT INTO proveedores (id_proveedor, ruc, nombre, ciudad, telefono) VALUES (4, '1791234567001', 'ElectroQuito', 'Quito', '022987654');
INSERT INTO proveedores (id_proveedor, ruc, nombre, ciudad, telefono) VALUES (5, '1890345678001', 'Pinturas del Pacífico', 'Ambato', '032765432');

-- Categorias
INSERT INTO categorias (id_categoria, nombre, descripcion) VALUES (1, 'Herramientas', 'Herramientas manuales y eléctricas');
INSERT INTO categorias (id_categoria, nombre, descripcion) VALUES (2, 'Electricidad', 'Material eléctrico y de iluminación');
INSERT INTO categorias (id_categoria, nombre, descripcion) VALUES (3, 'Plomería', 'Tubería, llaves y accesorios de agua');
INSERT INTO categorias (id_categoria, nombre, descripcion) VALUES (4, 'Pinturas', 'Pinturas, lacas y brochas');
INSERT INTO categorias (id_categoria, nombre, descripcion) VALUES (5, 'Tornillería', 'Tornillos, pernos, clavos y anclajes');

-- Articulos
INSERT INTO articulos (id_articulo, codigo, nombre, precio_unitario, stock_minimo, id_categoria, id_proveedor) VALUES (1, 'HER-001', 'Martillo de uña 16 oz', 8.50, 5, 1, 1);
INSERT INTO articulos (id_articulo, codigo, nombre, precio_unitario, stock_minimo, id_categoria, id_proveedor) VALUES (2, 'HER-002', 'Taladro percutor 600W', 65.90, 2, 1, 2);
INSERT INTO articulos (id_articulo, codigo, nombre, precio_unitario, stock_minimo, id_categoria, id_proveedor) VALUES (3, 'HER-003', 'Juego de destornilladores 6 piezas', 12.75, 4, 1, 1);
INSERT INTO articulos (id_articulo, codigo, nombre, precio_unitario, stock_minimo, id_categoria, id_proveedor) VALUES (4, 'ELE-001', 'Cable flexible #12 (rollo 100 m)', 48.00, 3, 2, 4);
INSERT INTO articulos (id_articulo, codigo, nombre, precio_unitario, stock_minimo, id_categoria, id_proveedor) VALUES (5, 'ELE-002', 'Foco LED 12W', 2.40, 20, 2, 4);
INSERT INTO articulos (id_articulo, codigo, nombre, precio_unitario, stock_minimo, id_categoria, id_proveedor) VALUES (6, 'ELE-003', 'Tomacorriente doble', 3.10, 15, 2, 4);
INSERT INTO articulos (id_articulo, codigo, nombre, precio_unitario, stock_minimo, id_categoria, id_proveedor) VALUES (7, 'PLO-001', 'Tubo PVC 1/2 pulgada (6 m)', 4.85, 10, 3, 3);
INSERT INTO articulos (id_articulo, codigo, nombre, precio_unitario, stock_minimo, id_categoria, id_proveedor) VALUES (8, 'PLO-002', 'Llave de paso 1/2 pulgada', 6.20, 6, 3, 3);
INSERT INTO articulos (id_articulo, codigo, nombre, precio_unitario, stock_minimo, id_categoria, id_proveedor) VALUES (9, 'PLO-003', 'Cinta teflón', 0.65, 30, 3, 2);
INSERT INTO articulos (id_articulo, codigo, nombre, precio_unitario, stock_minimo, id_categoria, id_proveedor) VALUES (10, 'PIN-001', 'Pintura látex blanca (galón)', 18.90, 6, 4, 5);
INSERT INTO articulos (id_articulo, codigo, nombre, precio_unitario, stock_minimo, id_categoria, id_proveedor) VALUES (11, 'PIN-002', 'Laca transparente (litro)', 9.40, 5, 4, 5);
INSERT INTO articulos (id_articulo, codigo, nombre, precio_unitario, stock_minimo, id_categoria, id_proveedor) VALUES (12, 'PIN-003', 'Brocha 3 pulgadas', 2.95, 12, 4, 5);
INSERT INTO articulos (id_articulo, codigo, nombre, precio_unitario, stock_minimo, id_categoria, id_proveedor) VALUES (13, 'TOR-001', 'Tornillo drywall 1 pulgada (caja 100)', 3.60, 10, 5, 2);
INSERT INTO articulos (id_articulo, codigo, nombre, precio_unitario, stock_minimo, id_categoria, id_proveedor) VALUES (14, 'TOR-002', 'Perno hexagonal 3/8 (unidad)', 0.45, 50, 5, 3);
INSERT INTO articulos (id_articulo, codigo, nombre, precio_unitario, stock_minimo, id_categoria, id_proveedor) VALUES (15, 'TOR-003', 'Taco fisher 8 mm (funda 50)', 2.10, 10, 5, 1);

-- Movimientos
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (1, 1, 'ENTRADA', 7, '2026-09-04');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (2, 11, 'ENTRADA', 3, '2026-09-04');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (3, 1, 'SALIDA', 2, '2026-09-07');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (4, 10, 'ENTRADA', 4, '2026-09-07');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (5, 3, 'ENTRADA', 5, '2026-09-08');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (6, 12, 'ENTRADA', 4, '2026-09-08');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (7, 15, 'ENTRADA', 3, '2026-09-08');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (8, 4, 'ENTRADA', 8, '2026-09-09');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (9, 5, 'ENTRADA', 48, '2026-09-09');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (10, 14, 'ENTRADA', 68, '2026-09-09');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (11, 11, 'SALIDA', 2, '2026-09-11');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (12, 8, 'ENTRADA', 9, '2026-09-12');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (13, 2, 'ENTRADA', 5, '2026-09-13');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (14, 4, 'SALIDA', 3, '2026-09-13');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (15, 6, 'ENTRADA', 12, '2026-09-13');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (16, 9, 'ENTRADA', 38, '2026-09-13');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (17, 7, 'ENTRADA', 11, '2026-09-14');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (18, 12, 'SALIDA', 2, '2026-09-14');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (19, 14, 'SALIDA', 43, '2026-09-14');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (20, 1, 'ENTRADA', 10, '2026-09-15');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (21, 2, 'SALIDA', 3, '2026-09-15');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (22, 3, 'SALIDA', 3, '2026-09-15');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (23, 10, 'SALIDA', 2, '2026-09-15');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (24, 5, 'SALIDA', 29, '2026-09-16');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (25, 8, 'SALIDA', 3, '2026-09-16');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (26, 9, 'SALIDA', 14, '2026-09-16');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (27, 13, 'ENTRADA', 11, '2026-09-16');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (28, 15, 'SALIDA', 2, '2026-09-16');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (29, 6, 'SALIDA', 7, '2026-09-17');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (30, 11, 'ENTRADA', 3, '2026-09-17');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (31, 3, 'ENTRADA', 2, '2026-09-18');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (32, 4, 'SALIDA', 4, '2026-09-18');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (33, 10, 'SALIDA', 1, '2026-09-19');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (34, 2, 'ENTRADA', 2, '2026-09-20');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (35, 6, 'ENTRADA', 30, '2026-09-20');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (36, 7, 'SALIDA', 7, '2026-09-20');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (37, 3, 'SALIDA', 1, '2026-09-21');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (38, 4, 'ENTRADA', 7, '2026-09-21');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (39, 12, 'ENTRADA', 5, '2026-09-21');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (40, 2, 'SALIDA', 1, '2026-09-22');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (41, 8, 'SALIDA', 3, '2026-09-22');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (42, 1, 'SALIDA', 4, '2026-09-23');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (43, 3, 'SALIDA', 1, '2026-09-23');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (44, 5, 'SALIDA', 12, '2026-09-23');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (45, 13, 'SALIDA', 5, '2026-09-23');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (46, 14, 'SALIDA', 24, '2026-09-23');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (47, 15, 'ENTRADA', 3, '2026-09-23');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (48, 7, 'SALIDA', 3, '2026-09-24');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (49, 9, 'SALIDA', 23, '2026-09-25');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (50, 10, 'ENTRADA', 4, '2026-09-25');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (51, 12, 'SALIDA', 3, '2026-09-25');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (52, 13, 'SALIDA', 5, '2026-09-25');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (53, 1, 'ENTRADA', 8, '2026-09-26');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (54, 11, 'SALIDA', 1, '2026-09-26');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (55, 15, 'SALIDA', 1, '2026-09-26');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (56, 4, 'SALIDA', 3, '2026-09-27');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (57, 13, 'ENTRADA', 20, '2026-09-27');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (58, 8, 'ENTRADA', 4, '2026-09-28');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (59, 14, 'ENTRADA', 53, '2026-09-28');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (60, 6, 'SALIDA', 14, '2026-09-29');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (61, 5, 'ENTRADA', 27, '2026-09-30');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (62, 8, 'SALIDA', 2, '2026-09-30');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (63, 1, 'SALIDA', 3, '2026-10-01');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (64, 6, 'SALIDA', 17, '2026-10-01');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (65, 7, 'ENTRADA', 9, '2026-10-02');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (66, 10, 'SALIDA', 2, '2026-10-02');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (67, 9, 'ENTRADA', 50, '2026-10-03');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (68, 13, 'SALIDA', 10, '2026-10-03');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (69, 8, 'ENTRADA', 5, '2026-10-04');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (70, 15, 'SALIDA', 2, '2026-10-04');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (71, 9, 'SALIDA', 24, '2026-10-05');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (72, 14, 'SALIDA', 22, '2026-10-05');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (73, 4, 'SALIDA', 3, '2026-10-06');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (74, 6, 'ENTRADA', 21, '2026-10-06');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (75, 7, 'SALIDA', 5, '2026-10-08');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (76, 5, 'SALIDA', 12, '2026-10-09');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (77, 10, 'ENTRADA', 6, '2026-10-09');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (78, 9, 'ENTRADA', 48, '2026-10-10');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (79, 6, 'SALIDA', 12, '2026-10-12');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (80, 8, 'SALIDA', 2, '2026-10-12');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (81, 13, 'ENTRADA', 19, '2026-10-12');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (82, 9, 'SALIDA', 22, '2026-10-13');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (83, 5, 'SALIDA', 15, '2026-10-18');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (84, 9, 'SALIDA', 22, '2026-10-18');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (85, 10, 'SALIDA', 2, '2026-10-18');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (86, 13, 'SALIDA', 7, '2026-10-18');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (87, 5, 'ENTRADA', 29, '2026-10-21');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (88, 5, 'SALIDA', 16, '2026-10-24');
INSERT INTO movimientos (id_movimiento, id_articulo, tipo, cantidad, fecha) VALUES (89, 5, 'SALIDA', 10, '2026-10-30');
