package com.julian.taller.punto1.dominio;

import java.util.ArrayList;
import java.util.List;

public class agenda {
    public static final int CAPACIDAD = 50;
    private List<contacto> contactos;

    public agenda() {
        this.contactos = new ArrayList<>();
    }

    public void crearContacto(String nombre, String apellido, long celular) {
        contacto contacto = new contacto(nombre, apellido, celular);

        if (this.contactos.size() < CAPACIDAD) {
            if (this.buscar(celular) == null) {
                this.contactos.add(contacto);
            } else {
                System.out.println("El contacto con el celular " + celular + " ya existe.");
            }
        } else {
            System.out.println("La agenda ya está llena.");
        }
    }

    public void eliminarContacto(long celular) {
//        for (Contacto contacto : this.contactos) {
//            if (contacto.getCelular() == celular) {
//                this.contactos.remove(contacto);
//                break;
//            }
//        }

        this.contactos.removeIf(contacto -> contacto.getCelular() == celular);
    }

    public List<contacto> buscar(String nombre) {
        List<contacto> contactosBuscados = new ArrayList<>();

        for (contacto contacto : this.contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                contactosBuscados.add(contacto);
            }
        }

        return contactosBuscados;
    }

    public List<contacto> buscarPorApellido(String apellido) {
        return this.contactos.stream().filter(cc -> cc.getApellido().equalsIgnoreCase(apellido)).toList();
    }

    public contacto buscar(long celular) {
        contacto contactoBuscado = null;

        for (int i = 0; i < this.contactos.size(); i++) {
            if (this.contactos.get(i).getCelular() == celular) {
                contactoBuscado = this.contactos.get(i);
                break;
            }
        }

        return contactoBuscado;
    }

    public void cambiarCelular(long viejoCelular, long nuevoCelular) {
        contacto contactoACambiar = this.buscar(viejoCelular);

        if (contactoACambiar != null) {
            contactoACambiar.setCelular(nuevoCelular);
        }
    }

    public List<contacto> ordenar() {
        return null;
    }

    public int getNumeroDeContactos() {
        return this.contactos.size();
    }
}