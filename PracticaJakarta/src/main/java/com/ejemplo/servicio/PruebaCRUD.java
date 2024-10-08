package com.ejemplo.servicio;

import com.ejemplo.dao.UsuarioDAOImpl;
import com.ejemplo.modelo.Usuario;

public class PruebaCRUD {
    public static void main(String[] args) {
        // Instanciar el DAO de Usuario
        UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();

        // Agregar a José López
        Usuario usuario1 = new Usuario();
        usuario1.setNombre("José López");
        usuario1.setCarrera("Ingeniería en Sistemas");
        usuario1.setEdad(19);
        usuario1.setSexo("M");
        usuarioDAO.guardar(usuario1);

        // Imprimir los detalles de José López
        System.out.println("Usuario agregado:");
        System.out.println("Nombre: " + usuario1.getNombre());
        System.out.println("Carrera: " + usuario1.getCarrera());
        System.out.println("Edad: " + usuario1.getEdad());
        System.out.println("Sexo: " + usuario1.getSexo());

        // Buscar a José López por su ID y confirmar que fue guardado correctamente
        Usuario usuarioEncontrado1 = usuarioDAO.encontrarPorId(usuario1.getId());
        System.out.println("\nUsuario encontrado:");
        System.out.println("Nombre: " + usuarioEncontrado1.getNombre());
        System.out.println("Carrera: " + usuarioEncontrado1.getCarrera());
        System.out.println("Edad: " + usuarioEncontrado1.getEdad());
        System.out.println("Sexo: " + usuarioEncontrado1.getSexo());

        // Agregar a Andrea Cuadra
        Usuario usuario2 = new Usuario();
        usuario2.setNombre("Andrea Cuadra");
        usuario2.setCarrera("Ingenieria en Sistemas");
        usuario2.setEdad(19);
        usuario2.setSexo("F");
        usuarioDAO.guardar(usuario2);

        // Imprimir los detalles de Andrea Cuadra
        System.out.println("\nUsuario agregado:");
        System.out.println("Nombre: " + usuario2.getNombre());
        System.out.println("Carrera: " + usuario2.getCarrera());
        System.out.println("Edad: " + usuario2.getEdad());
        System.out.println("Sexo: " + usuario2.getSexo());

        // Buscar a Andrea Cuadra por su ID y confirmar que fue guardada correctamente
        Usuario usuarioEncontrado2 = usuarioDAO.encontrarPorId(usuario2.getId());
        System.out.println("\nUsuario encontrado:");
        System.out.println("Nombre: " + usuarioEncontrado2.getNombre());
        System.out.println("Carrera: " + usuarioEncontrado2.getCarrera());
        System.out.println("Edad: " + usuarioEncontrado2.getEdad());
        System.out.println("Sexo: " + usuarioEncontrado2.getSexo());
    }
}
