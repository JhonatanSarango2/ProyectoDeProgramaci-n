public class Validacion {

    public static boolean textoObligatorio(String texto, int maximo) {
        return texto != null && texto.trim().length() > 0 && texto.trim().length() <= maximo;
    }

    public static boolean codigoValido(String codigo, String prefijo) {
        if (codigo == null) return false;
        codigo = codigo.trim().toUpperCase();
        String inicio = prefijo + "-";
        if (!codigo.startsWith(inicio) || codigo.length() <= inicio.length()) return false;
        for (int i = inicio.length(); i < codigo.length(); i++) {
            char caracter = codigo.charAt(i);
            if (caracter < '0' || caracter > '9') return false;
        }
        return true;
    }

    public static boolean numeroPositivo(double numero) {
        return !Double.isNaN(numero) && !Double.isInfinite(numero) && numero > 0;
    }

    public static boolean numeroNoNegativo(double numero) {
        return !Double.isNaN(numero) && !Double.isInfinite(numero) && numero >= 0;
    }

    public static boolean enteroPositivo(int numero) {
        return numero > 0;
    }

    public static boolean enteroNoNegativo(int numero) {
        return numero >= 0;
    }


    public static boolean fechaValida(String fecha) {
        if (fecha == null || fecha.length() != 10) return false;
        if (fecha.charAt(2) != '/' || fecha.charAt(5) != '/') return false;
        try {
            int dia = Integer.parseInt(fecha.substring(0, 2));
            int mes = Integer.parseInt(fecha.substring(3, 5));
            int anio = Integer.parseInt(fecha.substring(6, 10));
            if (anio < 2020 || anio > 2100 || mes < 1 || mes > 12 || dia < 1) return false;

            int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            int maximo = diasPorMes[mes - 1];
            if (mes == 2 && esBisiesto(anio)) maximo = 29;
            return dia <= maximo;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean esBisiesto(int anio) {
        return (anio % 4 == 0 && anio % 100 != 0) || anio % 400 == 0;
    }

    public static boolean telefonoValido(String telefono) {
        if (telefono == null) return false;
        int digitos = 0;
        for (int i = 0; i < telefono.length(); i++) {
            char caracter = telefono.charAt(i);
            if (caracter >= '0' && caracter <= '9') {
                digitos++;
            } else if (caracter != ' ' && caracter != '-' && caracter != '+') {
                return false;
            }
        }
        return digitos >= 7 && digitos <= 15;
    }

    public static boolean correoValido(String correo) {
        if (correo == null || correo.trim().length() == 0 || correo.indexOf(' ') >= 0) return false;
        int arroba = correo.indexOf('@');
        int punto = correo.lastIndexOf('.');
        return arroba > 0 && punto > arroba + 1 && punto < correo.length() - 1;
    }

    public static boolean detalleTallasValido(String detalle, int cantidadTotal) {
        if (detalle == null || detalle.trim().length() == 0 || cantidadTotal <= 0) return false;
        String[] partes = detalle.split(",");
        int suma = 0;
        String[] tallasUsadas = new String[partes.length];

        for (int i = 0; i < partes.length; i++) {
            String parte = partes[i].trim();
            int dosPuntos = parte.indexOf(':');
            if (dosPuntos <= 0 || dosPuntos != parte.lastIndexOf(':')) return false;

            String talla = parte.substring(0, dosPuntos).trim().toUpperCase();
            String cantidadTexto = parte.substring(dosPuntos + 1).trim();
            if (talla.length() == 0 || cantidadTexto.length() == 0) return false;

            for (int j = 0; j < i; j++) {
                if (talla.equals(tallasUsadas[j])) return false;
            }

            try {
                int cantidad = Integer.parseInt(cantidadTexto);
                if (cantidad <= 0) return false;
                suma += cantidad;
                tallasUsadas[i] = talla;
            } catch (Exception e) {
                return false;
            }
        }
        return suma == cantidadTotal;
    }

}
