-- =====================================================
-- CASO 3. SISTEMA DE INVENTARIO  (PostgreSQL)
-- Ejecutar en pgAdmin > Query Tool sobre una base vacia
-- =====================================================
-- (Opcional) crear la base desde la conexion 'postgres':
-- CREATE DATABASE inventario;
-- \c inventario

DROP TABLE IF EXISTS movimientos CASCADE;
DROP TABLE IF EXISTS articulos   CASCADE;
DROP TABLE IF EXISTS proveedores CASCADE;
DROP TABLE IF EXISTS categorias  CASCADE;

-- ---------- TABLAS ----------
CREATE TABLE categorias (
    id_categoria SERIAL       PRIMARY KEY,
    nombre       VARCHAR(50)  NOT NULL UNIQUE,
    descripcion  VARCHAR(150),
    estado       CHAR(1)      NOT NULL DEFAULT 'A',
    CONSTRAINT ck_categorias_estado CHECK (estado IN ('A','I'))
);

CREATE TABLE proveedores (
    id_proveedor SERIAL       PRIMARY KEY,
    ruc          CHAR(13)     NOT NULL UNIQUE,
    nombre       VARCHAR(100) NOT NULL,
    contacto     VARCHAR(80),
    telefono     VARCHAR(15),
    email        VARCHAR(100),
    direccion    VARCHAR(150),
    ciudad       VARCHAR(50),
    estado       CHAR(1)      NOT NULL DEFAULT 'A',
    CONSTRAINT ck_proveedores_estado CHECK (estado IN ('A','I'))
);

CREATE TABLE articulos (
    id_articulo    SERIAL        PRIMARY KEY,
    codigo         CHAR(7)       NOT NULL UNIQUE,
    nombre         VARCHAR(100)  NOT NULL,
    descripcion    VARCHAR(200),
    unidad_medida  VARCHAR(20)   NOT NULL DEFAULT 'unidad',
    precio_compra  NUMERIC(10,2) NOT NULL CHECK (precio_compra >= 0),
    precio_venta   NUMERIC(10,2) NOT NULL,
    stock_minimo   INTEGER       NOT NULL DEFAULT 0 CHECK (stock_minimo >= 0),
    estado         CHAR(1)       NOT NULL DEFAULT 'A',
    id_categoria   INTEGER       NOT NULL,
    id_proveedor   INTEGER       NOT NULL,
    CONSTRAINT ck_articulos_estado  CHECK (estado IN ('A','I')),
    CONSTRAINT ck_articulos_precios CHECK (precio_venta >= precio_compra),
    CONSTRAINT fk_articulos_categoria FOREIGN KEY (id_categoria) REFERENCES categorias(id_categoria),
    CONSTRAINT fk_articulos_proveedor FOREIGN KEY (id_proveedor) REFERENCES proveedores(id_proveedor)
);

CREATE TABLE movimientos (
    id_movimiento   SERIAL        PRIMARY KEY,
    id_articulo     INTEGER       NOT NULL,
    tipo            VARCHAR(6)    NOT NULL,
    cantidad        INTEGER       NOT NULL CHECK (cantidad > 0),
    precio_unitario NUMERIC(10,2) NOT NULL CHECK (precio_unitario >= 0),
    fecha           DATE          NOT NULL DEFAULT CURRENT_DATE,
    documento       VARCHAR(20),
    observacion     VARCHAR(200),
    CONSTRAINT ck_movimientos_tipo CHECK (tipo IN ('COMPRA','VENTA')),
    CONSTRAINT fk_movimientos_articulo FOREIGN KEY (id_articulo) REFERENCES articulos(id_articulo)
);

-- ---------- INDICES ----------
CREATE INDEX idx_articulos_categoria  ON articulos(id_categoria);
CREATE INDEX idx_articulos_proveedor  ON articulos(id_proveedor);
CREATE INDEX idx_movimientos_articulo ON movimientos(id_articulo);
CREATE INDEX idx_movimientos_fecha    ON movimientos(fecha);

-- ---------- DATOS DE PRUEBA ----------
INSERT INTO categorias (nombre, descripcion) VALUES
 ('Tecnologia', 'Perifericos y accesorios de computo'),
 ('Papeleria',  'Papel y articulos de oficina'),
 ('Limpieza',   'Productos de aseo y limpieza');

INSERT INTO proveedores (ruc, nombre, contacto, telefono, email, direccion, ciudad) VALUES
 ('1790012345001', 'TecnoAndes S.A.', 'Carlos Mena',   '022345678', 'ventas@tecnoandes.com', 'Av. 6 de Diciembre N34-120', 'Quito'),
 ('1791123456001', 'PapelCorp',       'Lucia Paredes', '022456789', 'info@papelcorp.com',    'Av. Amazonas N21-45',        'Quito'),
 ('1792234567001', 'Limpio Total',    'Jorge Salazar', '022567890', 'pedidos@limpiototal.ec','Calle Rumipamba E3-10',      'Sangolqui');

INSERT INTO articulos (codigo, nombre, descripcion, unidad_medida, precio_compra, precio_venta, stock_minimo, id_categoria, id_proveedor) VALUES
 ('ART-001', 'Mouse inalambrico',  'Mouse optico 2.4 GHz',        'unidad', 8.50, 12.00, 10, 1, 1),
 ('ART-002', 'Teclado USB',        'Teclado espanol estandar',    'unidad', 12.00, 18.00, 8, 1, 1),
 ('ART-003', 'Memoria USB 32GB',   'Memoria flash USB 3.0',       'unidad', 6.00,  9.50, 25, 1, 1),
 ('ART-004', 'Resma papel A4',     'Resma 500 hojas 75 g',        'resma',  3.20,  4.50, 20, 2, 2),
 ('ART-005', 'Cuaderno 100 hojas', 'Cuaderno universitario',      'unidad', 1.10,  1.80, 15, 2, 2),
 ('ART-006', 'Esferos azules',     'Caja de 12 esferos',          'caja',   2.50,  4.00, 15, 2, 2),
 ('ART-007', 'Desinfectante 1L',   'Desinfectante multiuso 1 litro','litro',1.80,  2.75, 10, 3, 3),
 ('ART-008', 'Escoba',             'Escoba de cerdas plasticas',  'unidad', 2.20,  3.50, 10, 3, 3);

-- COMPRAS (id_articulo, tipo, cantidad, precio, fecha, documento)
INSERT INTO movimientos (id_articulo, tipo, cantidad, precio_unitario, fecha, documento, observacion) VALUES
 (1, 'COMPRA', 40,  8.50, '2026-10-02', 'FC-0001', 'Compra inicial'),
 (2, 'COMPRA', 30, 12.00, '2026-10-02', 'FC-0001', 'Compra inicial'),
 (3, 'COMPRA', 25,  6.00, '2026-10-02', 'FC-0001', 'Compra inicial'),
 (4, 'COMPRA', 80,  3.20, '2026-10-03', 'FC-0002', 'Compra inicial'),
 (5, 'COMPRA', 50,  1.10, '2026-10-03', 'FC-0002', 'Compra inicial'),
 (6, 'COMPRA', 30,  2.50, '2026-10-03', 'FC-0002', 'Compra inicial'),
 (7, 'COMPRA', 25,  1.80, '2026-10-04', 'FC-0003', 'Compra inicial'),
 (8, 'COMPRA', 20,  2.20, '2026-10-04', 'FC-0003', 'Compra inicial');

-- VENTAS
INSERT INTO movimientos (id_articulo, tipo, cantidad, precio_unitario, fecha, documento, observacion) VALUES
 (1, 'VENTA', 15, 12.00, '2026-10-10', 'FV-0001', NULL),
 (2, 'VENTA', 10, 18.00, '2026-10-11', 'FV-0002', NULL),
 (3, 'VENTA',  5,  9.50, '2026-10-12', 'FV-0003', NULL),
 (4, 'VENTA', 30,  4.50, '2026-10-13', 'FV-0004', NULL),
 (5, 'VENTA', 20,  1.80, '2026-10-14', 'FV-0005', NULL),
 (6, 'VENTA', 10,  4.00, '2026-10-15', 'FV-0006', NULL),
 (7, 'VENTA', 10,  2.75, '2026-10-16', 'FV-0007', NULL),
 (8, 'VENTA',  5,  3.50, '2026-10-17', 'FV-0008', NULL);

-- ---------- VISTA DE EXISTENCIAS (derivadas de movimientos) ----------
CREATE OR REPLACE VIEW v_existencias AS
SELECT a.id_articulo, a.codigo, a.nombre,
       COALESCE(SUM(CASE m.tipo WHEN 'COMPRA' THEN m.cantidad
                                WHEN 'VENTA'  THEN -m.cantidad END), 0) AS existencias,
       a.stock_minimo
FROM articulos a
LEFT JOIN movimientos m ON m.id_articulo = a.id_articulo
GROUP BY a.id_articulo, a.codigo, a.nombre, a.stock_minimo;

-- ---------- CONSULTAS DE EJEMPLO ----------
-- Existencias actuales por articulo
SELECT * FROM v_existencias ORDER BY codigo;

-- Articulos por debajo del stock minimo
SELECT * FROM v_existencias WHERE existencias < stock_minimo;

-- Proveedores con mas de 50 unidades compradas
SELECT p.nombre, SUM(m.cantidad) AS total_comprado
FROM proveedores p
JOIN articulos a    ON a.id_proveedor = p.id_proveedor
JOIN movimientos m  ON m.id_articulo  = a.id_articulo
WHERE m.tipo = 'COMPRA'
GROUP BY p.nombre
HAVING SUM(m.cantidad) > 50;