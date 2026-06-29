public class Pedido {
    private String codigo;
    private String codigoCliente;
    private String codigoModelo;
    private String colorSolicitado;
    private int cantidad;
    private String detalleTallas;
    private String fechaEntrega;
    private String prioridad;
    private double anticipo;
    private String estado;
    private String codigoRollo;
    private double metrosEstimados;
    private double metrosConsumidos;
    private double costoEstimadoTela;
    private double totalVenta;
    private double margenBruto;
    private int prendasTerminadas;
    private int prendasDefectuosas;
    private String responsable;
    private String notas;

    public Pedido(String codigo, String codigoCliente, String codigoModelo, String colorSolicitado,
                  int cantidad, String detalleTallas, String fechaEntrega, String prioridad,
                  double anticipo, double metrosEstimados, double costoEstimadoTela,
                  double totalVenta, double margenBruto, String notas) {
        this.codigo = codigo;
        this.codigoCliente = codigoCliente;
        this.codigoModelo = codigoModelo;
        this.colorSolicitado = colorSolicitado;
        this.cantidad = cantidad;
        this.detalleTallas = detalleTallas;
        this.fechaEntrega = fechaEntrega;
        this.prioridad = prioridad;
        this.anticipo = anticipo;
        this.estado = "Pendiente";
        this.codigoRollo = "";
        this.metrosEstimados = metrosEstimados;
        this.metrosConsumidos = 0;
        this.costoEstimadoTela = costoEstimadoTela;
        this.totalVenta = totalVenta;
        this.margenBruto = margenBruto;
        this.prendasTerminadas = 0;
        this.prendasDefectuosas = 0;
        this.responsable = "";
        this.notas = notas;
    }

    public String getCodigo() { return codigo; }
    public String getCodigoCliente() { return codigoCliente; }
    public String getCodigoModelo() { return codigoModelo; }
    public String getColorSolicitado() { return colorSolicitado; }
    public int getCantidad() { return cantidad; }
    public String getDetalleTallas() { return detalleTallas; }
    public String getFechaEntrega() { return fechaEntrega; }
    public String getPrioridad() { return prioridad; }
    public double getAnticipo() { return anticipo; }
    public String getEstado() { return estado; }
    public String getCodigoRollo() { return codigoRollo; }
    public double getMetrosEstimados() { return metrosEstimados; }
    public double getMetrosConsumidos() { return metrosConsumidos; }
    public double getCostoEstimadoTela() { return costoEstimadoTela; }
    public double getTotalVenta() { return totalVenta; }
    public double getMargenBruto() { return margenBruto; }
    public int getPrendasTerminadas() { return prendasTerminadas; }
    public int getPrendasDefectuosas() { return prendasDefectuosas; }
    public String getResponsable() { return responsable; }
    public String getNotas() { return notas; }

    public void setEstado(String estado) { this.estado = estado; }
    public void setCodigoRollo(String codigoRollo) { this.codigoRollo = codigoRollo; }
    public void setMetrosConsumidos(double metrosConsumidos) { this.metrosConsumidos = metrosConsumidos; }
    public void setPrendasTerminadas(int prendasTerminadas) { this.prendasTerminadas = prendasTerminadas; }
    public void setPrendasDefectuosas(int prendasDefectuosas) { this.prendasDefectuosas = prendasDefectuosas; }
    public void setResponsable(String responsable) { this.responsable = responsable; }
    public void setNotas(String notas) { this.notas = notas; }

    public double getSaldoPendiente() {
        return totalVenta - anticipo;
    }

    public double getDiferenciaConsumo() {
        return metrosConsumidos - metrosEstimados;
    }

    public String toString() {
        return codigo + " | " + codigoModelo + " | Cantidad: " + cantidad + " | " +
                String.format("%.2f", metrosEstimados) + " m | " + estado;
    }
}
