package com.general;

import java.util.List;

public interface Acciones {
	List mostrar();
	String guardar(Object ob);
	String actualizar(Object ob);
	Object buscar(int id);
	String eliminar(int id);

}
