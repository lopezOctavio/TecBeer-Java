import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Persona implements iABM{
    //private static  int ID = 0;
    private String nombre;
    private String apellido;
    private String username;
    private String password;
    private String email;
    private int rol;
    private boolean activo;

    public Persona() {
        this.activo = true;

    }

    public Persona(String nombre, String apellido, String username, String password, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.password = password;
        this.email = email;
        this.rol = 0;
        this.activo = true;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getRol() {
        return rol;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", rol=" + rol +
                ", activo=" + activo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(username, persona.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }



    //EL ALTA DE PERSONA NO TIENE QUE ESTAR ACA ME PARECE HABRIA QUE CHEQUEAR!!!
    @Override
    public void alta() {
        nombre = Consola.leerString("Ingrese el Nombre: ");
        //AGREGAR VALIDACION DE NOMBRE
        Consola.limpiar();
        apellido = Consola.leerString("Ingrese el Apellido: ");
        //AGREGAR VALIDACION DE APELLIDO
        Consola.limpiar();
        username = Consola.leerString("Ingrese el Username: ");
        //AGREGAR VALIDACION DE USERNAME (QUE NO HAYA OTRO IGUAL)
        Consola.limpiar();
        password = Consola.leerString("Ingrese Password: ");


        //VALIDACION DE PASSWORD
        while (!isValidPassword(password)) {
            System.out.println("Contraseña inválida. Asegúrese de que su contraseña tenga al menos una mayúscula, dos números y no menos de ocho caracteres en total.");
            password = Consola.leerString("Por favor ingrese una contraseña válida: ");
        }
        email = Consola.leerString("Ingrese el Email: ");


        //VALIDACION DE MAIL
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(email);
        while (!matcher.find()) {
            email = Consola.leerString("Email inválido. Por favor vuelva a ingresarlo: ");

            matcher = pattern.matcher(email);
        }

        //AL GENERO LO SAQUE PORQUE ME PARECIA AL PEDO

        /*System.out.println("Ingrese el Género (M o F): ");
        genero = sc.next().charAt(0);
        while (genero != 'M' && genero != 'F'){
            System.out.println("Género inválido. Por favor vuelva a ingresarlo: ");
            genero = sc.next().charAt(0);
        }*/

        activo = true;
    }
    private boolean isValidPassword(String password) {
        int uppercaseCount = 0;
        int numberCount = 0;

        if (password.length() < 8) {
            return false;
        }

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                uppercaseCount++;
            } else if (Character.isDigit(c)) {
                numberCount++;
            }
        }

        return (uppercaseCount >= 1) && (numberCount >= 2);
    }


    @Override
    public void baja() {

    }

    @Override
    public void modificacion() {

    }
}
