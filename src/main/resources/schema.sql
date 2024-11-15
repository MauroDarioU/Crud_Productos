CREATE TABLE IF NOT EXISTS crud_producto (
    reference VARCHAR(50) PRIMARY KEY,
    id INT NOT NULL,
    nombre VARCHAR(255) NOT NULL,
    descripcion VARCHAR(255) NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    stock INT NOT NULL,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);
