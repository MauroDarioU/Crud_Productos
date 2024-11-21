package com.universidad.crud.validation;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.RequiredArgsConstructor;
import static java.lang.String.format;
@RequiredArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)

public enum CodigoError {

    PRODUCTO_NO_ENCONTRADO("Usuario con id %d no encontrado"),
    PRODUCTO_POR_ID_ACTIVO_NO_ENCONTRADO("Usuario activo con id %d no encontrado"),
    PRODUCTO_POR_NOMBRE_NO_ENCONTRADO("Usuario con referencia %s no encontrado"),
    PRODUCTO_POR_DESCRIPCION_NO_ENCONTRADO("No se encontró ningún usuario con el email %s"),
    PRODUCTO_NO_PUDO_SER_CREADO("Usuario con el email %s no pudo ser creado"),
    PRODUCTO_NO_PUDO_SER_ACTUALIZADO("Usuario con id %d no pudo ser actualizado"),
    PRODUCTO_NO_PUDO_SER_BORRADO("Usuario con id %d no pudo ser borrado");

    private final String descripcion;
    public String getCodigo() {
        return this.name();
    }
    public String getDescripcion(Object... params) {
        return format(descripcion, params);
    }
}
