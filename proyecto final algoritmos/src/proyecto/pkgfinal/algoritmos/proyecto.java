/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto.pkgfinal.algoritmos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

class Usuario {
    private String nombre;
    private String apellido;
    private String correoElectronico;
    private String contraseña;
    private String rol;

    public Usuario(String nombre, String apellido, String correoElectronico, String contraseña, String rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
        this.contraseña = contraseña;
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getRol() {
        return rol;
    }
}

class Candidato {
    private String nombre;
    private int votos;

    public Candidato(String nombre) {
        this.nombre = nombre;
        this.votos = 0;
    }

    public void incrementarVotos() {
        votos++;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVotos() {
        return votos;
    }
}

class Votante {
    private String nombre;
    private String contraseña;
    private String sexo;
    private String fechaNacimiento;
    private String direccionResidencia;
    private String departamentoResidencia;
    private String municipioResidencia;
    private String paisResidencia;
    private boolean haVotado;

    public Votante(String nombre, String contraseña, String sexo, String fechaNacimiento,
                   String direccionResidencia, String departamentoResidencia, String municipioResidencia, String paisResidencia) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.direccionResidencia = direccionResidencia;
        this.departamentoResidencia = departamentoResidencia;
        this.municipioResidencia = municipioResidencia;
        this.paisResidencia = paisResidencia;
        this.haVotado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getSexo() {
        return sexo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getDireccionResidencia() {
        return direccionResidencia;
    }

    public String getDepartamentoResidencia() {
        return departamentoResidencia;
    }

    public String getMunicipioResidencia() {
        return municipioResidencia;
    }

    public String getPaisResidencia() {
        return paisResidencia;
    }

    public boolean haVotado() {
        return haVotado;
    }

    public void emitirVoto() {
        haVotado = true;
    }
}

public class proyecto {
    public static void main(String[] args) {
        List<Usuario> usuarios = new ArrayList<>();
        List<Votante> votantes = new ArrayList<>();
        List<Candidato> candidatos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Agregar candidatos
        candidatos.add(new Candidato("Bernardo Arevalo"));
        candidatos.add(new Candidato("Sandra Torres"));
        candidatos.add(new Candidato("Carlos Pineda"));
        candidatos.add(new Candidato("Otto Perez"));
        candidatos.add(new Candidato("Miguel Catalan"));

        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Registrar un votante y votar");
            System.out.println("2. Registrar un usuario");
            System.out.println("3. Reporte de Conteo General de Votos");
            System.out.println("4. Reporte de Votos por Sexo");
            System.out.println("5. Reporte de Votos por Ubicación Geográfica");
            System.out.println("0. Salir");
            System.out.print("Ingrese la opción: ");
            int opcion = Integer.parseInt(scanner.nextLine());

            if (opcion == 1) {
                // Registro de votantes y votar
                System.out.print("Ingrese su nombre: ");
                String nombre = scanner.nextLine();
                System.out.print("Ingrese su contraseña: ");
                String contraseña = scanner.nextLine();
                System.out.print("Ingrese su sexo: ");
                String sexo = scanner.nextLine();
                System.out.print("Ingrese su fecha de nacimiento: ");
                String fechaNacimiento = scanner.nextLine();
                System.out.print("Ingrese su dirección de residencia: ");
                String direccionResidencia = scanner.nextLine();
                System.out.print("Ingrese su departamento de residencia: ");
                String departamentoResidencia = scanner.nextLine();
                System.out.print("Ingrese su municipio de residencia: ");
                String municipioResidencia = scanner.nextLine();
                System.out.print("Ingrese su país de residencia: ");
                String paisResidencia = scanner.nextLine();

                Votante votante = new Votante(nombre, contraseña, sexo, fechaNacimiento,
                        direccionResidencia, departamentoResidencia, municipioResidencia, paisResidencia);
                votantes.add(votante);

                // Emitir voto
                System.out.println("Candidatos disponibles:");
                for (int i = 0; i < candidatos.size(); i++) {
                    Candidato candidato = candidatos.get(i);
                    System.out.println((i + 1) + ". " + candidato.getNombre());
                }
                System.out.print("Seleccione el número del candidato al que desea votar: ");
                int seleccion = Integer.parseInt(scanner.nextLine());

                if (seleccion >= 1 && seleccion <= candidatos.size()) {
                    Candidato candidatoSeleccionado = candidatos.get(seleccion - 1);
                    candidatoSeleccionado.incrementarVotos();
                    votante.emitirVoto();
                    System.out.println("¡Su voto ha sido registrado para " + candidatoSeleccionado.getNombre() + "!");
                } else {
                    System.out.println("Selección no válida. Intente nuevamente.");
                }
            } else if (opcion == 2) {
                // Registro de usuarios
                System.out.print("Ingrese su nombre: ");
                String nombre = scanner.nextLine();
                System.out.print("Ingrese su apellido: ");
                String apellido = scanner.nextLine();
                System.out.print("Ingrese su correo electrónico: ");
                String correoElectronico = scanner.nextLine();
                System.out.print("Ingrese su contraseña: ");
                String contraseña = scanner.nextLine();

                // Asignar un rol aleatorio
                String[] roles = {"administrador", "registrador de votos", "votante", "auditor"};
                Random random = new Random();
                int rolIndex = random.nextInt(roles.length);
                String rol = roles[rolIndex];

                Usuario usuario = new Usuario(nombre, apellido, correoElectronico, contraseña, rol);
                usuarios.add(usuario);
                System.out.println("Usuario registrado correctamente con el rol de " + rol);
            } else if (opcion == 3) {
                // Reporte de Conteo General de Votos
                reporteConteoGeneral(candidatos);
            } else if (opcion == 4) {
                // Reporte de Votos por Sexo
                reporteVotosPorSexo(votantes);
            } else if (opcion == 5) {
                // Reporte de Votos por Ubicación Geográfica
                reporteVotosPorUbicacion(votantes);
            } else if (opcion == 0) {
                break;
            }
        }
    }

    public static void reporteConteoGeneral(List<Candidato> candidatos) {
        int totalVotosEmitidos = 0;
        for (Candidato candidato : candidatos) {
            totalVotosEmitidos += candidato.getVotos();
        }

        System.out.println("Conteo General de Votos:");
        for (Candidato candidato : candidatos) {
            double porcentaje = (double) candidato.getVotos() / totalVotosEmitidos * 100;
            System.out.println(candidato.getNombre() + ": " + candidato.getVotos() + " votos (" + porcentaje + "%)");
        }
        System.out.println("Total de votos emitidos: " + totalVotosEmitidos);
    }

    public static void reporteVotosPorSexo(List<Votante> votantes) {
        int totalVotosMujeres = 0;
        int totalVotosHombres = 0;

        for (Votante votante : votantes) {
            if (votante.getSexo().equalsIgnoreCase("femenino")) {
                totalVotosMujeres++;
            } else if (votante.getSexo().equalsIgnoreCase("masculino")) {
                totalVotosHombres++;
            }
        }

        int totalVotosEmitidos = totalVotosHombres + totalVotosMujeres;

        System.out.println("Votos Emitidos por Sexo:");
        System.out.println("Mujeres: " + totalVotosMujeres + " votos");
        System.out.println("Hombres: " + totalVotosHombres + " votos");
        System.out.println("Total de votos emitidos: " + totalVotosEmitidos);
    }

    public static void reporteVotosPorUbicacion(List<Votante> votantes) {
        Map<String, Integer> votosPorPais = new HashMap<>();
        Map<String, Integer> votosPorDepartamento = new HashMap<>();
        Map<String, Integer> votosPorMunicipio = new HashMap<>();

        for (Votante votante : votantes) {
            String pais = votante.getPaisResidencia();
            String departamento = votante.getDepartamentoResidencia();
            String municipio = votante.getMunicipioResidencia();

            votosPorPais.put(pais, votosPorPais.getOrDefault(pais, 0) + 1);
            votosPorDepartamento.put(departamento, votosPorDepartamento.getOrDefault(departamento, 0) + 1);
            votosPorMunicipio.put(municipio, votosPorMunicipio.getOrDefault(municipio, 0) + 1);
        }

        System.out.println("Votos por Ubicación Geográfica:");
        for (String pais : votosPorPais.keySet()) {
            System.out.println("País: " + pais + ", Votos: " + votosPorPais.get(pais));
        }
        for (String departamento : votosPorDepartamento.keySet()) {
            System.out.println("Departamento: " + departamento + ", Votos: " + votosPorDepartamento.get(departamento));
        }
        for (String municipio : votosPorMunicipio.keySet()) {
            System.out.println("Municipio: " + municipio + ", Votos: " + votosPorMunicipio.get(municipio));
        }
    }
}
