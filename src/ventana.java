import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ventana extends JFrame {
    private JPanel panelPrincipal;
    private JTabbedPane pestanasPrincipal;

    // Inicio
    private JLabel lblRollosDashboard;
    private JLabel lblMetrosDashboard;
    private JLabel lblValorDashboard;
    private JLabel lblPedidosDashboard;
    private JLabel lblNovedadesDashboard;
    private JTextArea areaAlertas;
    private JButton btnActualizarInicio;

    // Líneas
    private JTextField txtCodigoLinea;
    private JTextField txtNombreLinea;
    private JComboBox comboCategoriaLinea;
    private JComboBox comboEstadoLinea;
    private JTextArea areaNotasLinea;
    private JButton btnAgregarLinea;
    private JButton btnActualizarLinea;
    private JButton btnDesactivarLinea;
    private JTextArea areaLineas;

    // Modelos
    private JComboBox comboLineaModelo;
    private JTextField txtCodigoModelo;
    private JTextField txtNombreModelo;
    private JComboBox comboMangaModelo;
    private JComboBox comboCuelloModelo;
    private JComboBox comboTallaModelo;
    private JComboBox comboMaterialModelo;
    private JTextField txtAnchoMinimoModelo;
    private JTextField txtConsumoModelo;
    private JTextField txtPrecioModelo;
    private JComboBox comboEstadoModelo;
    private JTextArea areaNotasModelo;
    private JComboBox comboModeloSeleccionado;
    private JButton btnAgregarModelo;
    private JButton btnActualizarModelo;
    private JButton btnDuplicarModelo;
    private JButton btnDesactivarModelo;
    private JTextArea areaModelos;

    // Moldes
    private JComboBox comboModeloMolde;
    private JTextField txtCodigoMolde;
    private JTextField txtNombrePieza;
    private JComboBox comboTallaMolde;
    private JTextField txtCantidadCorte;
    private JTextField txtAnchoMolde;
    private JTextField txtAltoMolde;
    private JComboBox comboEstadoMolde;
    private JTextArea areaNotasMolde;
    private JComboBox comboMoldeSeleccionado;
    private JButton btnAgregarMolde;
    private JButton btnActualizarMolde;
    private JButton btnDesactivarMolde;
    private JButton btnListarMoldesModelo;
    private JTextArea areaMoldes;

    // Grafos y submoldes
    private JComboBox comboModeloGrafo;
    private JButton btnVerGrafoSubmoldes;
    private JTextArea areaGrafoSubmoldes;
    private JComboBox comboLoteTrazabilidad;
    private JButton btnRastrearLote;
    private JTextArea areaTrazabilidad;
    private JButton btnVerGrafoEstados;
    private JTextArea areaGrafoEstados;

    // Materiales
    private JTextField txtCodigoMaterial;
    private JTextField txtNombreMaterial;
    private JTextField txtComposicionMaterial;
    private JTextField txtProveedorMaterial;
    private JTextField txtCostoMaterial;
    private JTextField txtStockMinimoMaterial;
    private JTextArea areaNotasMaterial;
    private JComboBox comboMaterialSeleccionado;
    private JButton btnAgregarMaterial;
    private JButton btnActualizarMaterial;
    private JTextArea areaMateriales;

    // Rollos
    private JComboBox comboMaterialRollo;
    private JTextField txtColorRollo;
    private JTextField txtAnchoRollo;
    private JTextField txtLargoRollo;
    private JTextField txtCantidadRollos;
    private JTextField txtCostoRollo;
    private JTextField txtProveedorRollo;
    private JTextField txtLoteRollo;
    private JTextField txtUbicacionRollo;
    private JComboBox comboEstadoRollo;
    private JTextArea areaNotaCalidadRollo;
    private JComboBox comboRolloSeleccionado;
    private JButton btnAgregarLote;
    private JButton btnActualizarRollo;
    private JButton btnMarcarDanado;
    private JTextArea areaRollos;

    // Clientes y pedidos
    private JTextField txtCodigoCliente;
    private JTextField txtNombreCliente;
    private JTextField txtTelefonoCliente;
    private JTextField txtCorreoCliente;
    private JTextArea areaNotasCliente;
    private JComboBox comboClienteSeleccionado;
    private JButton btnAgregarCliente;
    private JButton btnActualizarCliente;
    private JTextArea areaClientes;

    private JComboBox comboClientePedido;
    private JComboBox comboModeloPedido;
    private JTextField txtColorPedido;
    private JTextField txtCantidadPedido;
    private JTextField txtTallasPedido;
    private JTextField txtFechaPedido;
    private JComboBox comboPrioridadPedido;
    private JTextField txtAnticipoPedido;
    private JTextArea areaNotasPedido;
    private JComboBox comboPedidoSeleccionado;
    private JButton btnPrevisualizarPedido;
    private JButton btnCrearPedido;
    private JButton btnCancelarPedido;
    private JTextArea areaPedidos;
    private JTextArea areaDetallePedido;

    // Producción
    private JComboBox comboPedidoProduccion;
    private JComboBox comboRolloProduccion;
    private JTextField txtMetrosProduccion;
    private JTextField txtResponsableProduccion;
    private JTextField txtTerminadasProduccion;
    private JTextField txtDefectuosasProduccion;
    private JTextArea areaNotasProduccion;
    private JButton btnSugerirRollo;
    private JButton btnIniciarProduccion;
    private JButton btnRegistrarProduccion;
    private JTextArea areaProduccion;

    // Novedades
    private JTextField txtFechaNovedad;
    private JComboBox comboAreaNovedad;
    private JComboBox comboTipoNovedad;
    private JComboBox comboPrioridadNovedad;
    private JTextField txtResponsableNovedad;
    private JTextField txtHorasNovedad;
    private JTextArea areaDescripcionNovedad;
    private JComboBox comboNovedadSeleccionada;
    private JTextArea areaSolucionNovedad;
    private JButton btnRegistrarNovedad;
    private JButton btnResolverNovedad;
    private JTextArea areaNovedades;

    // Reportes
    private JButton btnReporteInventario;
    private JButton btnReportePedidos;
    private JButton btnReporteNovedades;
    private JButton btnReporteHistorial;
    private JTextArea areaReportes;

    private GestionLineas gestionLineas;
    private GestionModelos gestionModelos;
    private GestionMoldes gestionMoldes;
    private GestionMateriales gestionMateriales;
    private GestionRollos gestionRollos;
    private GestionClientes gestionClientes;
    private GestionPedidos gestionPedidos;
    private GestionNovedades gestionNovedades;
    private PilaAcciones pilaAcciones;
    private GrafoEnsamblaje grafoEnsamblaje;
    private GrafoTrazabilidad grafoTrazabilidad;
    private boolean cargandoCombos;

    public ventana() {
        crearGestiones();
        cargarDatosDemostracion();
        configurarVentana();
        configurarOpcionesFijas();
        configurarEventos();
        actualizarTodo();
    }

    private void crearGestiones() {
        gestionLineas = new GestionLineas();
        gestionModelos = new GestionModelos();
        gestionMoldes = new GestionMoldes();
        gestionMateriales = new GestionMateriales();
        gestionRollos = new GestionRollos();
        gestionClientes = new GestionClientes();
        gestionPedidos = new GestionPedidos();
        gestionNovedades = new GestionNovedades();
        pilaAcciones = new PilaAcciones();
        grafoEnsamblaje = new GrafoEnsamblaje();
        grafoTrazabilidad = new GrafoTrazabilidad();
    }

    private void configurarVentana() {
        setContentPane(panelPrincipal);
        setTitle("TexOptiCut - Gestión Operativa para Talleres Textiles");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 760);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void configurarOpcionesFijas() {
        agregarOpciones(comboCategoriaLinea, new String[]{"Camisetas", "Uniformes", "Pantalones", "Chompas", "Ropa deportiva", "Accesorios"});
        agregarOpciones(comboEstadoLinea, new String[]{"Activa", "Descontinuada"});
        agregarOpciones(comboMangaModelo, new String[]{"Corta", "Larga", "Sin manga", "Tres cuartos", "No aplica"});
        agregarOpciones(comboCuelloModelo, new String[]{"Redondo", "V", "Polo", "Alto", "Sin cuello"});
        agregarOpciones(comboTallaModelo, new String[]{"XS", "S", "M", "L", "XL", "2XL", "Talla única"});
        agregarOpciones(comboEstadoModelo, new String[]{"Activo", "En revisión", "Descontinuado"});
        agregarOpciones(comboTallaMolde, new String[]{"XS", "S", "M", "L", "XL", "2XL", "Talla única"});
        agregarOpciones(comboEstadoMolde, new String[]{"Activo", "En revisión", "Archivado"});
        agregarOpciones(comboEstadoRollo, new String[]{"Disponible", "Reservado", "Agotado", "Dañado"});
        agregarOpciones(comboPrioridadPedido, new String[]{"Normal", "Alta", "Urgente"});
        agregarOpciones(comboAreaNovedad, new String[]{"Máquina de corte 1", "Máquina de corte 2", "Overlock 1", "Overlock 2", "Recta industrial", "Bodega", "Área de calidad"});
        agregarOpciones(comboTipoNovedad, new String[]{"Falla de máquina", "Mantenimiento", "Problema de calidad", "Falta de material", "Retraso de proveedor", "Cambio del cliente", "Nota de turno"});
        agregarOpciones(comboPrioridadNovedad, new String[]{"Baja", "Normal", "Alta", "Crítica"});
    }

    private void agregarOpciones(JComboBox combo, String[] opciones) {
        for (String opcion : opciones) combo.addItem(opcion);
    }

    private void configurarEventos() {
        btnActualizarInicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { actualizarTodo(); }
        });

        btnAgregarLinea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { agregarLinea(); }
        });
        btnActualizarLinea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { actualizarLinea(); }
        });
        btnDesactivarLinea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { desactivarLinea(); }
        });

        btnAgregarModelo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { agregarModelo(); }
        });
        btnActualizarModelo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { actualizarModelo(); }
        });
        btnDuplicarModelo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { duplicarModelo(); }
        });
        btnDesactivarModelo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { desactivarModelo(); }
        });
        comboModeloSeleccionado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!cargandoCombos) cargarModeloSeleccionado();
            }
        });

        btnAgregarMolde.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { agregarMolde(); }
        });
        btnActualizarMolde.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { actualizarMolde(); }
        });
        btnDesactivarMolde.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { desactivarMolde(); }
        });
        btnListarMoldesModelo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { listarMoldesModelo(); }
        });
        comboMoldeSeleccionado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!cargandoCombos) cargarMoldeSeleccionado();
            }
        });

        btnVerGrafoSubmoldes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { mostrarGrafoSubmoldes(); }
        });
        btnRastrearLote.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { rastrearLote(); }
        });
        btnVerGrafoEstados.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { mostrarGrafoEstados(); }
        });

        btnAgregarMaterial.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { agregarMaterial(); }
        });
        btnActualizarMaterial.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { actualizarMaterial(); }
        });
        comboMaterialSeleccionado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!cargandoCombos) cargarMaterialSeleccionado();
            }
        });

        btnAgregarLote.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { agregarLoteRollos(); }
        });
        btnActualizarRollo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { actualizarRollo(); }
        });
        btnMarcarDanado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { marcarRolloDanado(); }
        });
        comboRolloSeleccionado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!cargandoCombos) cargarRolloSeleccionado();
            }
        });

        btnAgregarCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { agregarCliente(); }
        });
        btnActualizarCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { actualizarCliente(); }
        });
        comboClienteSeleccionado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!cargandoCombos) cargarClienteSeleccionado();
            }
        });

        btnPrevisualizarPedido.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { previsualizarPedido(); }
        });
        btnCrearPedido.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { crearPedido(); }
        });
        btnCancelarPedido.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { cancelarPedido(); }
        });
        comboPedidoSeleccionado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!cargandoCombos) cargarPedidoSeleccionado();
            }
        });

        btnSugerirRollo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { sugerirRollo(); }
        });
        btnIniciarProduccion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { iniciarProduccion(); }
        });
        btnRegistrarProduccion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { registrarProduccion(); }
        });
        comboPedidoProduccion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!cargandoCombos) cargarPedidoProduccion();
            }
        });

        btnRegistrarNovedad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { registrarNovedad(); }
        });
        btnResolverNovedad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { resolverNovedad(); }
        });
        comboNovedadSeleccionada.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!cargandoCombos) cargarNovedadSeleccionada();
            }
        });

        btnReporteInventario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { generarReporteInventario(); }
        });
        btnReportePedidos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { generarReportePedidos(); }
        });
        btnReporteNovedades.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { generarReporteNovedades(); }
        });
        btnReporteHistorial.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { generarReporteHistorial(); }
        });
    }

    private void cargarDatosDemostracion() {
        gestionLineas.agregar(new LineaProducto("LIN-001", "Camisetas Urbanas", "Camisetas", "Activa", "Línea de ropa casual."));
        gestionLineas.agregar(new LineaProducto("LIN-002", "Uniformes Escolares", "Uniformes", "Activa", "Línea para pedidos institucionales."));

        gestionMateriales.agregar(new Material("MAT-001", "Algodón peinado", "100% algodón", "Textiles Andinos", 4.20, 20, "Recomendado para camisetas."));
        gestionMateriales.agregar(new Material("MAT-002", "Jersey elástico", "Algodón y elastano", "Tela Viva", 5.10, 15, "Tela flexible."));
        gestionMateriales.agregar(new Material("MAT-003", "Gabardina", "Poliéster y algodón", "Industrial Textil", 6.40, 25, "Uso para uniformes y pantalones."));

        gestionModelos.agregar(new ModeloPrenda("MOD-001", "LIN-001", "Camiseta básica manga corta", "Corta", "Redondo", "M", "MAT-001", 150, 1.20, 12.50, "Activo", "Modelo base de venta."));
        gestionModelos.agregar(new ModeloPrenda("MOD-002", "LIN-001", "Camiseta básica manga larga", "Larga", "Redondo", "M", "MAT-001", 150, 1.55, 15.50, "Activo", "Variante de manga larga."));
        gestionModelos.agregar(new ModeloPrenda("MOD-003", "LIN-002", "Pantalón de uniforme", "No aplica", "Sin cuello", "M", "MAT-003", 145, 1.80, 28.00, "Activo", "Pantalón escolar."));

        gestionMoldes.agregar(new Molde("MOL-001", "MOD-001", "Frente", "M", 1, 50, 70, "Activo", "Submolde frontal."));
        gestionMoldes.agregar(new Molde("MOL-002", "MOD-001", "Espalda", "M", 1, 50, 70, "Activo", "Submolde posterior."));
        gestionMoldes.agregar(new Molde("MOL-003", "MOD-001", "Manga corta", "M", 2, 28, 34, "Activo", "Par de mangas."));
        gestionMoldes.agregar(new Molde("MOL-004", "MOD-001", "Cuello", "M", 1, 18, 8, "Activo", "Cuello redondo."));

        gestionMoldes.agregar(new Molde("MOL-005", "MOD-002", "Frente", "M", 1, 50, 70, "Activo", "Submolde frontal."));
        gestionMoldes.agregar(new Molde("MOL-006", "MOD-002", "Espalda", "M", 1, 50, 70, "Activo", "Submolde posterior."));
        gestionMoldes.agregar(new Molde("MOL-007", "MOD-002", "Manga larga", "M", 2, 30, 58, "Activo", "Par de mangas largas."));
        gestionMoldes.agregar(new Molde("MOL-008", "MOD-002", "Puño", "M", 2, 10, 20, "Activo", "Puños de manga."));
        gestionMoldes.agregar(new Molde("MOL-009", "MOD-002", "Cuello", "M", 1, 18, 8, "Activo", "Cuello redondo."));

        gestionRollos.agregarLote("MAT-001", "Azul marino", 150, 30, 3, 4.20, "Textiles Andinos", "ALG-0626", "Bodega A - Estante 1", "Lote recibido sin novedades.");
        gestionRollos.agregarLote("MAT-002", "Blanco", 160, 25, 2, 5.10, "Tela Viva", "JER-0626", "Bodega A - Estante 2", "Revisar elasticidad antes de corte.");
        gestionRollos.agregarLote("MAT-003", "Negro", 145, 40, 2, 6.40, "Industrial Textil", "GAB-0626", "Bodega B - Estante 1", "Apto para uniformes.");

        gestionClientes.agregar(new Cliente("CLI-001", "Uniformes Quito", "0991112233", "compras@uniformesquito.ec", "Cliente corporativo."));
        gestionClientes.agregar(new Cliente("CLI-002", "Colegio Los Andes", "0982223344", "administracion@losandes.ec", "Pedidos escolares."));
        pilaAcciones.registrar("Sistema", "Se cargaron los datos de demostración del taller.");
    }


private void agregarLinea() {
    String codigo = codigo(txtCodigoLinea);
    String nombre = texto(txtNombreLinea);
    if (!Validacion.codigoValido(codigo, "LIN")) { error("El código de línea debe tener formato LIN-001."); return; }
    if (!Validacion.textoObligatorio(nombre, 80)) { error("Ingrese un nombre de línea entre 1 y 80 caracteres."); return; }
    boolean agregado = gestionLineas.agregar(new LineaProducto(codigo, nombre,
            seleccionado(comboCategoriaLinea), seleccionado(comboEstadoLinea), areaNotasLinea.getText().trim()));
    if (!agregado) { error("Ya existe una línea con ese código."); return; }
    pilaAcciones.registrar("Sistema", "Se registró la línea " + codigo + ".");
    exito("Línea de producto registrada.");
    limpiarLinea(); actualizarTodo();
}


private void actualizarLinea() {
    String codigo = codigo(txtCodigoLinea);
    LineaProducto linea = gestionLineas.buscar(codigo);
    if (linea == null) { error("Seleccione una línea existente."); return; }
    if (!Validacion.textoObligatorio(texto(txtNombreLinea), 80)) { error("Ingrese un nombre de línea válido."); return; }
    linea.setNombre(texto(txtNombreLinea));
    linea.setCategoria(seleccionado(comboCategoriaLinea));
    linea.setEstado(seleccionado(comboEstadoLinea));
    linea.setNotas(areaNotasLinea.getText().trim());
    pilaAcciones.registrar("Sistema", "Se actualizó la línea " + linea.getCodigo() + ".");
    exito("Línea actualizada."); actualizarTodo();
}

    private void desactivarLinea() {
        LineaProducto linea = gestionLineas.buscar(codigo(txtCodigoLinea));
        if (linea == null) { error("Seleccione una línea existente."); return; }
        if (!confirmar("¿Marcar esta línea como descontinuada?")) return;
        linea.setEstado("Descontinuada");
        comboEstadoLinea.setSelectedItem("Descontinuada");
        pilaAcciones.registrar("Sistema", "Se descontinuó la línea " + linea.getCodigo() + ".");
        exito("Línea marcada como descontinuada."); actualizarTodo();
    }


private void agregarModelo() {
    try {
        String codigo = codigo(txtCodigoModelo);
        String codigoLinea = codigoCombo(comboLineaModelo);
        String codigoMaterial = codigoCombo(comboMaterialModelo);
        LineaProducto linea = gestionLineas.buscar(codigoLinea);
        Material material = gestionMateriales.buscar(codigoMaterial);
        double ancho = numero(txtAnchoMinimoModelo);
        double consumo = numero(txtConsumoModelo);
        double precio = numero(txtPrecioModelo);

        if (!Validacion.codigoValido(codigo, "MOD")) { error("El código de modelo debe tener formato MOD-001."); return; }
        if (linea == null || !linea.getEstado().equals("Activa")) { error("Seleccione una línea activa."); return; }
        if (material == null) { error("Seleccione un material válido."); return; }
        if (!Validacion.textoObligatorio(texto(txtNombreModelo), 80)) { error("Ingrese un nombre de modelo válido."); return; }
        if (!Validacion.numeroPositivo(ancho) || !Validacion.numeroPositivo(consumo) || !Validacion.numeroPositivo(precio)) {
            error("Ancho mínimo, consumo por unidad y precio deben ser mayores a cero."); return;
        }
        ModeloPrenda modelo = new ModeloPrenda(codigo, codigoLinea, texto(txtNombreModelo),
                seleccionado(comboMangaModelo), seleccionado(comboCuelloModelo), seleccionado(comboTallaModelo), codigoMaterial,
                ancho, consumo, precio, seleccionado(comboEstadoModelo), areaNotasModelo.getText().trim());
        if (!gestionModelos.agregar(modelo)) { error("Ya existe un modelo con ese código."); return; }
        pilaAcciones.registrar("Sistema", "Se creó el modelo " + modelo.getCodigo() + ".");
        exito("Modelo creado. El consumo estimado se calculará al registrar un pedido.");
        limpiarModelo(); actualizarTodo();
    } catch (Exception ex) { error("Use números válidos en ancho, consumo por unidad y precio."); }
}


private void actualizarModelo() {
    try {
        String codigo = codigo(txtCodigoModelo);
        ModeloPrenda modelo = gestionModelos.buscar(codigo);
        LineaProducto linea = gestionLineas.buscar(codigoCombo(comboLineaModelo));
        Material material = gestionMateriales.buscar(codigoCombo(comboMaterialModelo));
        double ancho = numero(txtAnchoMinimoModelo);
        double consumo = numero(txtConsumoModelo);
        double precio = numero(txtPrecioModelo);

        if (modelo == null) { error("Seleccione un modelo existente."); return; }
        if (linea == null || !linea.getEstado().equals("Activa")) { error("Seleccione una línea activa."); return; }
        if (material == null) { error("Seleccione un material válido."); return; }
        if (!Validacion.textoObligatorio(texto(txtNombreModelo), 80)) { error("Ingrese un nombre de modelo válido."); return; }
        if (!Validacion.numeroPositivo(ancho) || !Validacion.numeroPositivo(consumo) || !Validacion.numeroPositivo(precio)) {
            error("Ancho mínimo, consumo por unidad y precio deben ser mayores a cero."); return;
        }
        modelo.setCodigoLinea(linea.getCodigo());
        modelo.setNombre(texto(txtNombreModelo));
        modelo.setTipoManga(seleccionado(comboMangaModelo));
        modelo.setTipoCuello(seleccionado(comboCuelloModelo));
        modelo.setTalla(seleccionado(comboTallaModelo));
        modelo.setCodigoMaterial(material.getCodigo());
        modelo.setAnchoMinimoTela(ancho);
        modelo.setConsumoPorUnidad(consumo);
        modelo.setPrecioVenta(precio);
        modelo.setEstado(seleccionado(comboEstadoModelo));
        modelo.setNotas(areaNotasModelo.getText().trim());
        pilaAcciones.registrar("Sistema", "Se actualizó el modelo " + modelo.getCodigo() + ".");
        exito("Modelo actualizado."); actualizarTodo();
    } catch (Exception ex) { error("Use números válidos en ancho, consumo por unidad y precio."); }
}


private void duplicarModelo() {
    String origen = codigoCombo(comboModeloSeleccionado);
    String nuevoCodigo = codigo(txtCodigoModelo);
    String nuevoNombre = texto(txtNombreModelo);
    ModeloPrenda modeloOrigen = gestionModelos.buscar(origen);
    if (modeloOrigen == null || !modeloOrigen.getEstado().equals("Activo")) {
        error("Seleccione un modelo activo como origen."); return;
    }
    if (!Validacion.codigoValido(nuevoCodigo, "MOD")) { error("El código nuevo debe tener formato MOD-001."); return; }
    if (!Validacion.textoObligatorio(nuevoNombre, 80)) { error("Ingrese un nombre válido para la nueva variante."); return; }
    if (gestionModelos.buscar(nuevoCodigo) != null) { error("Ya existe un modelo con ese código."); return; }
    boolean duplicado = gestionModelos.duplicar(origen, nuevoCodigo, nuevoNombre, seleccionado(comboMangaModelo));
    if (!duplicado) { error("No se pudo duplicar el modelo."); return; }
    int copias = gestionMoldes.duplicarMoldesModelo(origen, nuevoCodigo);
    pilaAcciones.registrar("Sistema", "Se duplicó el modelo " + origen + " como " + nuevoCodigo + " con " + copias + " moldes.");
    exito("Modelo duplicado con " + copias + " moldes y códigos nuevos. Ajuste solo las piezas que cambian.");
    limpiarModelo(); actualizarTodo();
}

    private void desactivarModelo() {
        ModeloPrenda modelo = gestionModelos.buscar(codigo(txtCodigoModelo));
        if (modelo == null) { error("Seleccione un modelo existente."); return; }
        if (!confirmar("¿Marcar este modelo como descontinuado?")) return;
        modelo.setEstado("Descontinuado");
        comboEstadoModelo.setSelectedItem("Descontinuado");
        pilaAcciones.registrar("Sistema", "Se descontinuó el modelo " + modelo.getCodigo() + ".");
        exito("Modelo marcado como descontinuado."); actualizarTodo();
    }


private void agregarMolde() {
    try {
        String codigo = codigo(txtCodigoMolde);
        String codigoModelo = codigoCombo(comboModeloMolde);
        ModeloPrenda modelo = gestionModelos.buscar(codigoModelo);
        String pieza = texto(txtNombrePieza);
        int cantidad = entero(txtCantidadCorte);
        double ancho = numero(txtAnchoMolde);
        double alto = numero(txtAltoMolde);
        String talla = seleccionado(comboTallaMolde);

        if (!Validacion.codigoValido(codigo, "MOL")) { error("El código de molde debe tener formato MOL-001."); return; }
        if (modelo == null || !modelo.getEstado().equals("Activo")) { error("Seleccione un modelo activo."); return; }
        if (!Validacion.textoObligatorio(pieza, 60)) { error("Ingrese un nombre válido para la pieza."); return; }
        if (!Validacion.enteroPositivo(cantidad) || !Validacion.numeroPositivo(ancho) || !Validacion.numeroPositivo(alto)) {
            error("Cantidad, ancho y alto deben ser mayores a cero."); return;
        }
        if (gestionMoldes.existePiezaActiva(codigoModelo, pieza, talla, null)) {
            error("Ya existe una pieza activa con ese nombre y talla para este modelo."); return;
        }
        Molde molde = new Molde(codigo, codigoModelo, pieza, talla, cantidad, ancho, alto,
                seleccionado(comboEstadoMolde), areaNotasMolde.getText().trim());
        if (!gestionMoldes.agregar(molde)) { error("Ya existe un molde con ese código."); return; }
        pilaAcciones.registrar("Sistema", "Se registró el molde " + molde.getCodigo() + " para el modelo " + molde.getCodigoModelo() + ".");
        exito("Molde registrado. Área calculada: " + String.format("%.2f", molde.calcularArea()) + " cm2.");
        limpiarMolde(); actualizarTodo();
    } catch (Exception ex) { error("Use números válidos en cantidad, ancho y alto."); }
}


private void actualizarMolde() {
    try {
        String codigo = codigo(txtCodigoMolde);
        Molde molde = gestionMoldes.buscar(codigo);
        String codigoModelo = codigoCombo(comboModeloMolde);
        ModeloPrenda modelo = gestionModelos.buscar(codigoModelo);
        String pieza = texto(txtNombrePieza);
        int cantidad = entero(txtCantidadCorte);
        double ancho = numero(txtAnchoMolde);
        double alto = numero(txtAltoMolde);
        String talla = seleccionado(comboTallaMolde);

        if (molde == null) { error("Seleccione un molde existente."); return; }
        if (modelo == null || !modelo.getEstado().equals("Activo")) { error("Seleccione un modelo activo."); return; }
        if (!Validacion.textoObligatorio(pieza, 60)) { error("Ingrese un nombre válido para la pieza."); return; }
        if (!Validacion.enteroPositivo(cantidad) || !Validacion.numeroPositivo(ancho) || !Validacion.numeroPositivo(alto)) {
            error("Cantidad, ancho y alto deben ser mayores a cero."); return;
        }
        if (seleccionado(comboEstadoMolde).equals("Activo") && gestionMoldes.existePiezaActiva(codigoModelo, pieza, talla, codigo)) {
            error("Ya existe una pieza activa con ese nombre y talla para este modelo."); return;
        }
        molde.setCodigoModelo(codigoModelo);
        molde.setNombrePieza(pieza);
        molde.setTalla(talla);
        molde.setCantidadCorte(cantidad);
        molde.setAnchoCm(ancho);
        molde.setAltoCm(alto);
        molde.setEstado(seleccionado(comboEstadoMolde));
        molde.setNotas(areaNotasMolde.getText().trim());
        pilaAcciones.registrar("Sistema", "Se actualizó el molde " + molde.getCodigo() + ".");
        exito("Molde actualizado."); actualizarTodo();
    } catch (Exception ex) { error("Use números válidos en cantidad, ancho y alto."); }
}


    private void desactivarMolde() {
        Molde molde = gestionMoldes.buscar(codigo(txtCodigoMolde));
        if (molde == null) { error("Seleccione un molde existente."); return; }
        if (!confirmar("¿Archivar este molde?")) return;
        molde.setEstado("Archivado");
        comboEstadoMolde.setSelectedItem("Archivado");
        pilaAcciones.registrar("Sistema", "Se archivó el molde " + molde.getCodigo() + ".");
        exito("Molde archivado. Se conserva para trazabilidad."); actualizarTodo();
    }

    private void listarMoldesModelo() {
        String codigoModelo = codigoCombo(comboModeloMolde);
        if (codigoModelo.equals("")) { error("Seleccione un modelo."); return; }
        areaMoldes.setText(gestionMoldes.listarPorModelo(codigoModelo));
    }


private void agregarMaterial() {
    try {
        String codigo = codigo(txtCodigoMaterial);
        double costo = numero(txtCostoMaterial);
        double stock = numero(txtStockMinimoMaterial);
        if (!Validacion.codigoValido(codigo, "MAT")) { error("El código de material debe tener formato MAT-001."); return; }
        if (!Validacion.textoObligatorio(texto(txtNombreMaterial), 80)
                || !Validacion.textoObligatorio(texto(txtComposicionMaterial), 100)
                || !Validacion.textoObligatorio(texto(txtProveedorMaterial), 80)) {
            error("Complete nombre, composición y proveedor del material."); return;
        }
        if (!Validacion.numeroPositivo(costo) || !Validacion.numeroNoNegativo(stock)) {
            error("El costo debe ser mayor a cero y el stock mínimo no puede ser negativo."); return;
        }
        Material material = new Material(codigo, texto(txtNombreMaterial), texto(txtComposicionMaterial),
                texto(txtProveedorMaterial), costo, stock, areaNotasMaterial.getText().trim());
        if (!gestionMateriales.agregar(material)) { error("Ya existe un material con ese código."); return; }
        pilaAcciones.registrar("Sistema", "Se registró el material " + material.getCodigo() + ".");
        exito("Material registrado."); limpiarMaterial(); actualizarTodo();
    } catch (Exception ex) { error("Costo y stock mínimo deben ser números válidos."); }
}


private void actualizarMaterial() {
    try {
        Material material = gestionMateriales.buscar(codigo(txtCodigoMaterial));
        double costo = numero(txtCostoMaterial);
        double stock = numero(txtStockMinimoMaterial);
        if (material == null) { error("Seleccione un material existente."); return; }
        if (!Validacion.textoObligatorio(texto(txtNombreMaterial), 80)
                || !Validacion.textoObligatorio(texto(txtComposicionMaterial), 100)
                || !Validacion.textoObligatorio(texto(txtProveedorMaterial), 80)) {
            error("Complete nombre, composición y proveedor del material."); return;
        }
        if (!Validacion.numeroPositivo(costo) || !Validacion.numeroNoNegativo(stock)) {
            error("El costo debe ser mayor a cero y el stock mínimo no puede ser negativo."); return;
        }
        material.setNombre(texto(txtNombreMaterial));
        material.setComposicion(texto(txtComposicionMaterial));
        material.setProveedorPrincipal(texto(txtProveedorMaterial));
        material.setCostoMetroBase(costo);
        material.setStockMinimoMetros(stock);
        material.setNotas(areaNotasMaterial.getText().trim());
        pilaAcciones.registrar("Sistema", "Se actualizó el material " + material.getCodigo() + ".");
        exito("Material actualizado."); actualizarTodo();
    } catch (Exception ex) { error("Costo y stock mínimo deben ser números válidos."); }
}


private void agregarLoteRollos() {
    try {
        String material = codigoCombo(comboMaterialRollo);
        double ancho = numero(txtAnchoRollo);
        double largo = numero(txtLargoRollo);
        int cantidad = entero(txtCantidadRollos);
        double costo = numero(txtCostoRollo);
        if (gestionMateriales.buscar(material) == null) { error("Seleccione un material existente."); return; }
        if (!Validacion.textoObligatorio(texto(txtColorRollo), 50)
                || !Validacion.textoObligatorio(texto(txtProveedorRollo), 80)
                || !Validacion.textoObligatorio(texto(txtLoteRollo), 40)
                || !Validacion.textoObligatorio(texto(txtUbicacionRollo), 80)) {
            error("Complete color, proveedor, lote y ubicación."); return;
        }
        if (!Validacion.numeroPositivo(ancho) || !Validacion.numeroPositivo(largo)
                || !Validacion.enteroPositivo(cantidad) || !Validacion.numeroPositivo(costo)) {
            error("Ancho, largo, cantidad y costo deben ser mayores a cero."); return;
        }
        boolean agregado = gestionRollos.agregarLote(material, texto(txtColorRollo), ancho,
                largo, cantidad, costo, texto(txtProveedorRollo), texto(txtLoteRollo),
                texto(txtUbicacionRollo), areaNotaCalidadRollo.getText().trim());
        if (!agregado) { error("No se pudo registrar el lote. Revise los datos."); return; }
        pilaAcciones.registrar("Bodega", "Se registró el lote " + texto(txtLoteRollo) + " con " + cantidad + " rollos.");
        exito("Lote registrado: " + cantidad + " rollos creados con código automático.");
        limpiarRollo(); actualizarTodo();
    } catch (Exception ex) { error("Use números válidos en ancho, largo, cantidad y costo."); }
}


private void actualizarRollo() {
    try {
        RolloTela rollo = gestionRollos.buscar(codigoCombo(comboRolloSeleccionado));
        double ancho = numero(txtAnchoRollo);
        double costo = numero(txtCostoRollo);
        String estado = seleccionado(comboEstadoRollo);
        if (rollo == null) { error("Seleccione un rollo existente."); return; }
        if (!Validacion.textoObligatorio(texto(txtColorRollo), 50)
                || !Validacion.textoObligatorio(texto(txtProveedorRollo), 80)
                || !Validacion.textoObligatorio(texto(txtLoteRollo), 40)
                || !Validacion.textoObligatorio(texto(txtUbicacionRollo), 80)) {
            error("Complete color, proveedor, lote y ubicación."); return;
        }
        if (!Validacion.numeroPositivo(ancho) || !Validacion.numeroPositivo(costo)) {
            error("El ancho y el costo por metro deben ser mayores a cero."); return;
        }
        if (estado.equals("Agotado") && rollo.getLargoDisponibleM() > 0) {
            error("No puede marcar agotado un rollo que aún tiene metros. El consumo debe registrarse desde Producción."); return;
        }
        if (estado.equals("Dañado") && !Validacion.textoObligatorio(areaNotaCalidadRollo.getText(), 300)) {
            error("Explique en la nota de calidad el motivo por el que el rollo está dañado."); return;
        }
        rollo.setColor(texto(txtColorRollo));
        rollo.setAnchoCm(ancho);
        rollo.setCostoMetro(costo);
        rollo.setProveedor(texto(txtProveedorRollo));
        rollo.setLote(texto(txtLoteRollo));
        rollo.setUbicacion(texto(txtUbicacionRollo));
        rollo.setEstado(estado);
        rollo.setNotaCalidad(areaNotaCalidadRollo.getText().trim());
        pilaAcciones.registrar("Bodega", "Se actualizó el rollo " + rollo.getCodigo() + ".");
        exito("Rollo actualizado."); actualizarTodo();
    } catch (Exception ex) { error("Use números válidos en ancho y costo."); }
}


private void marcarRolloDanado() {
    RolloTela rollo = gestionRollos.buscar(codigoCombo(comboRolloSeleccionado));
    if (rollo == null) { error("Seleccione un rollo existente."); return; }
    if (!Validacion.textoObligatorio(areaNotaCalidadRollo.getText(), 300)) {
        error("Escriba el motivo del daño antes de cambiar el estado del rollo."); return;
    }
    rollo.setEstado("Dañado");
    rollo.setNotaCalidad(areaNotaCalidadRollo.getText().trim());
    pilaAcciones.registrar("Bodega", "Se marcó como dañado el rollo " + rollo.getCodigo() + ". Motivo: " + rollo.getNotaCalidad());
    exito("Rollo marcado como dañado. No se usará en producción."); actualizarTodo();
}


private void agregarCliente() {
    String codigo = codigo(txtCodigoCliente);
    String nombre = texto(txtNombreCliente);
    String telefono = texto(txtTelefonoCliente);
    String correo = texto(txtCorreoCliente);
    if (!Validacion.codigoValido(codigo, "CLI")) { error("El código de cliente debe tener formato CLI-001."); return; }
    if (!Validacion.textoObligatorio(nombre, 100)) { error("Ingrese un nombre de cliente válido."); return; }
    if (!Validacion.telefonoValido(telefono)) { error("Ingrese un teléfono válido de 7 a 15 dígitos."); return; }
    if (correo.length() > 0 && !Validacion.correoValido(correo)) { error("El correo no tiene un formato válido."); return; }
    boolean agregado = gestionClientes.agregar(new Cliente(codigo, nombre, telefono, correo, areaNotasCliente.getText().trim()));
    if (!agregado) { error("Ya existe un cliente con ese código."); return; }
    pilaAcciones.registrar("Sistema", "Se registró el cliente " + codigo + ".");
    exito("Cliente registrado."); limpiarCliente(); actualizarTodo();
}


private void actualizarCliente() {
    Cliente cliente = gestionClientes.buscar(codigo(txtCodigoCliente));
    String nombre = texto(txtNombreCliente);
    String telefono = texto(txtTelefonoCliente);
    String correo = texto(txtCorreoCliente);
    if (cliente == null) { error("Seleccione un cliente existente."); return; }
    if (!Validacion.textoObligatorio(nombre, 100)) { error("Ingrese un nombre de cliente válido."); return; }
    if (!Validacion.telefonoValido(telefono)) { error("Ingrese un teléfono válido de 7 a 15 dígitos."); return; }
    if (correo.length() > 0 && !Validacion.correoValido(correo)) { error("El correo no tiene un formato válido."); return; }
    cliente.setNombre(nombre);
    cliente.setTelefono(telefono);
    cliente.setCorreo(correo);
    cliente.setNotas(areaNotasCliente.getText().trim());
    pilaAcciones.registrar("Sistema", "Se actualizó el cliente " + cliente.getCodigo() + ".");
    exito("Cliente actualizado."); actualizarTodo();
}


    private void previsualizarPedido() {
        try {
            ModeloPrenda modelo = gestionModelos.buscar(codigoCombo(comboModeloPedido));
            int cantidad = entero(txtCantidadPedido);
            if (modelo == null || !modelo.getEstado().equals("Activo")) { error("Seleccione un modelo activo."); return; }
            if (!Validacion.enteroPositivo(cantidad)) { error("La cantidad del pedido debe ser mayor a cero."); return; }
            if (!Validacion.textoObligatorio(texto(txtColorPedido), 50)) { error("Ingrese el color solicitado."); return; }
            if (!Validacion.detalleTallasValido(texto(txtTallasPedido), cantidad)) {
                error("Detalle de tallas inválido. Use formato S:10, M:20 y haga que la suma sea igual a la cantidad."); return;
            }
            Material material = gestionMateriales.buscar(modelo.getCodigoMaterial());
            double metros = modelo.calcularMetrosNecesarios(cantidad);
            double costo = metros * material.getCostoMetroBase();
            double venta = modelo.getPrecioVenta() * cantidad;
            areaDetallePedido.setText("PREVISUALIZACIÓN DEL PEDIDO\n\n" +
                    "Modelo: " + modelo.getNombre() + "\n" +
                    "Cantidad: " + cantidad + "\n" +
                    "Material: " + material.getNombre() + "\n" +
                    "Metros estimados: " + String.format("%.2f", metros) + " m\n" +
                    "Costo estimado de tela: $" + String.format("%.2f", costo) + "\n" +
                    "Venta estimada: $" + String.format("%.2f", venta) + "\n" +
                    "Margen bruto estimado: $" + String.format("%.2f", venta - costo));
        } catch (Exception ex) { error("Ingrese una cantidad válida."); }
    }

    private void crearPedido() {
    try {
        Cliente cliente = gestionClientes.buscar(codigoCombo(comboClientePedido));
        ModeloPrenda modelo = gestionModelos.buscar(codigoCombo(comboModeloPedido));
        int cantidad = entero(txtCantidadPedido);
        double anticipo = numero(txtAnticipoPedido);
        if (cliente == null) { error("Seleccione un cliente."); return; }
        if (modelo == null || !modelo.getEstado().equals("Activo")) { error("Seleccione un modelo activo."); return; }
        if (!gestionMoldes.tieneMoldesActivos(modelo.getCodigo())) { error("El modelo no tiene moldes activos registrados."); return; }
        if (!Validacion.textoObligatorio(texto(txtColorPedido), 50)) { error("Ingrese el color solicitado."); return; }
        if (!Validacion.enteroPositivo(cantidad)) { error("La cantidad del pedido debe ser mayor a cero."); return; }
        if (!Validacion.detalleTallasValido(texto(txtTallasPedido), cantidad)) {
            error("Detalle de tallas inválido. Use formato S:10, M:20 y haga que la suma sea igual a la cantidad."); return;
        }
        if (!Validacion.fechaValida(texto(txtFechaPedido))) { error("La fecha debe existir y tener formato dd/mm/aaaa."); return; }
        Material material = gestionMateriales.buscar(modelo.getCodigoMaterial());
        double metros = modelo.calcularMetrosNecesarios(cantidad);
        double costo = metros * material.getCostoMetroBase();
        double venta = modelo.getPrecioVenta() * cantidad;
        if (!Validacion.numeroNoNegativo(anticipo) || anticipo > venta) { error("El anticipo debe estar entre $0 y el total de venta."); return; }
        Pedido pedido = new Pedido(gestionPedidos.siguienteCodigo(), cliente.getCodigo(), modelo.getCodigo(), texto(txtColorPedido), cantidad,
                texto(txtTallasPedido), texto(txtFechaPedido), seleccionado(comboPrioridadPedido), anticipo,
                metros, costo, venta, venta - costo, areaNotasPedido.getText().trim());
        if (!gestionPedidos.agregar(pedido)) { error("No se pudo registrar el pedido."); return; }
        pilaAcciones.registrar("Sistema", "Se creó el pedido " + pedido.getCodigo() + " para " + cliente.getNombre() + ".");
        exito("Pedido " + pedido.getCodigo() + " creado. Revise producción para seleccionar tela y descontar el consumo.");
        limpiarPedido(); actualizarTodo();
    } catch (Exception ex) { error("Ingrese una cantidad y un anticipo válidos."); }
}

    private void cancelarPedido() {
        Pedido pedido = gestionPedidos.buscar(codigoCombo(comboPedidoSeleccionado));
        if (pedido == null) { error("Seleccione un pedido."); return; }
        if (!confirmar("¿Cancelar el pedido seleccionado?")) return;

        if (!gestionPedidos.cancelarPedido(pedido)) {
            error("El grafo de estados solo permite cancelar pedidos pendientes.");
            return;
        }

        pilaAcciones.registrar("Sistema", "Se canceló el pedido " + pedido.getCodigo() + ".");
        exito("Pedido cancelado."); actualizarTodo();
    }


    private void iniciarProduccion() {
        Pedido pedido = gestionPedidos.buscar(codigoCombo(comboPedidoProduccion));
        String responsable = texto(txtResponsableProduccion);

        if (pedido == null) { error("Seleccione un pedido."); return; }
        if (!Validacion.textoObligatorio(responsable, 60)) {
            error("Ingrese el responsable antes de iniciar producción."); return;
        }
        if (!confirmar("¿Cambiar el pedido " + pedido.getCodigo() + " al estado En producción?")) return;

        if (!gestionPedidos.iniciarProduccion(pedido, responsable)) {
            error("El grafo de estados solo permite iniciar pedidos que están Pendientes."); return;
        }

        pilaAcciones.registrar(responsable, "Inició la producción del pedido " + pedido.getCodigo() + ".");
        areaProduccion.setText("Pedido " + pedido.getCodigo() + " iniciado.\n\n" +
                "Estado actual: En producción\n" +
                "Ahora seleccione el rollo compatible y, al finalizar, registre los metros reales y las prendas obtenidas.");
        exito("Pedido iniciado. El sistema bloquea transiciones inválidas mediante el grafo de estados.");
        actualizarTodo();
    }

    private void sugerirRollo() {
        Pedido pedido = gestionPedidos.buscar(codigoCombo(comboPedidoProduccion));
        if (pedido == null || (!pedido.getEstado().equals("Pendiente") && !pedido.getEstado().equals("En producción"))) {
            error("Seleccione un pedido pendiente o en producción."); return;
        }
        ModeloPrenda modelo = gestionModelos.buscar(pedido.getCodigoModelo());
        RolloTela rollo = gestionRollos.buscarCompatible(modelo.getCodigoMaterial(), modelo.getAnchoMinimoTela(), pedido.getMetrosEstimados());
        cargarRollosCompatibles(pedido);
        txtMetrosProduccion.setText(String.format("%.2f", pedido.getMetrosEstimados()));
        if (rollo == null) {
            areaProduccion.setText("No hay un rollo con metros suficientes para el consumo estimado.\n" +
                    "Puede revisar el inventario o registrar un nuevo lote.");
            return;
        }
        seleccionarPorCodigo(comboRolloProduccion, rollo.getCodigo());
        areaProduccion.setText("Rollo sugerido: " + rollo.getCodigo() + "\n" +
                "Material: " + nombreMaterial(rollo.getCodigoMaterial()) + "\n" +
                "Color: " + rollo.getColor() + "\n" +
                "Ancho: " + rollo.getAnchoCm() + " cm\n" +
                "Disponible: " + rollo.getLargoDisponibleM() + " m\n" +
                "Consumo estimado: " + String.format("%.2f", pedido.getMetrosEstimados()) + " m\n\n" +
                "Al terminar el trabajo, registre los metros reales, las prendas terminadas y las defectuosas.");
    }

    private void registrarProduccion() {
        try {
            Pedido pedido = gestionPedidos.buscar(codigoCombo(comboPedidoProduccion));
            RolloTela rollo = gestionRollos.buscar(codigoCombo(comboRolloProduccion));
            double metrosReales = numero(txtMetrosProduccion);
            String responsable = texto(txtResponsableProduccion);
            int terminadas = entero(txtTerminadasProduccion);
            int defectuosas = entero(txtDefectuosasProduccion);
            String observacion = areaNotasProduccion.getText().trim();

            if (pedido == null || rollo == null) { error("Seleccione el pedido y el rollo usado."); return; }
            if (!pedido.getEstado().equals("En producción")) {
                error("Primero use el botón Iniciar producción para cambiar el pedido al estado En producción."); return;
            }
            ModeloPrenda modelo = gestionModelos.buscar(pedido.getCodigoModelo());
            if (modelo == null || !rollo.getCodigoMaterial().equalsIgnoreCase(modelo.getCodigoMaterial()) || rollo.getAnchoCm() < modelo.getAnchoMinimoTela()) {
                error("El rollo no cumple con el material o ancho mínimo del modelo."); return;
            }
            if (!Validacion.textoObligatorio(responsable, 60)) { error("Ingrese el responsable de producción."); return; }
            if (!Validacion.numeroPositivo(metrosReales)) { error("Los metros reales usados deben ser mayores a cero."); return; }
            if (metrosReales > rollo.getLargoDisponibleM()) { error("No puede descontar más metros de los disponibles en el rollo."); return; }
            if (!Validacion.enteroNoNegativo(terminadas) || !Validacion.enteroNoNegativo(defectuosas)) {
                error("Las prendas terminadas y defectuosas no pueden ser negativas."); return;
            }
            if (terminadas + defectuosas != pedido.getCantidad()) {
                error("Prendas terminadas más defectuosas debe ser igual a la cantidad pedida (" + pedido.getCantidad() + ")."); return;
            }
            if (defectuosas > 0 && !Validacion.textoObligatorio(observacion, 300)) {
                error("Explique en la observación el motivo de las prendas defectuosas."); return;
            }
            if (!confirmar("¿Registrar el resultado y descontar " + String.format("%.2f", metrosReales) + " m del rollo " + rollo.getCodigo() + "?")) return;

            boolean registrado = gestionPedidos.registrarProduccion(pedido, rollo, metrosReales, responsable,
                    terminadas, defectuosas, observacion);
            if (!registrado) { error("No se pudo registrar la producción. Revise los datos."); return; }

            double diferencia = pedido.getDiferenciaConsumo();
            String resultado = diferencia > 0 ? "Material adicional usado" :
                    (diferencia < 0 ? "Uso menor al estimado" : "Uso igual al estimado");
            pilaAcciones.registrar(pedido.getResponsable(), "Registró producción del pedido " + pedido.getCodigo() +
                    ". Rollo: " + rollo.getCodigo() + ", metros reales: " + String.format("%.2f", metrosReales) + ".");
            areaProduccion.setText("PRODUCCIÓN REGISTRADA\n\n" +
                    "Pedido: " + pedido.getCodigo() + "\n" +
                    "Rollo usado: " + rollo.getCodigo() + "\n" +
                    "Responsable: " + pedido.getResponsable() + "\n" +
                    "Prendas terminadas: " + pedido.getPrendasTerminadas() + "\n" +
                    "Prendas defectuosas: " + pedido.getPrendasDefectuosas() + "\n" +
                    "Consumo estimado: " + String.format("%.2f", pedido.getMetrosEstimados()) + " m\n" +
                    "Consumo real: " + String.format("%.2f", pedido.getMetrosConsumidos()) + " m\n" +
                    resultado + ": " + String.format("%.2f", Math.abs(diferencia)) + " m\n" +
                    "Saldo del rollo: " + String.format("%.2f", rollo.getLargoDisponibleM()) + " m\n" +
                    "Observación: " + pedido.getNotas());
            exito("Producción registrada y tela descontada del inventario.");
            actualizarTodo();
        } catch (Exception ex) { error("Ingrese valores numéricos válidos para metros y prendas."); }
    }


    private void registrarNovedad() {
    try {
        String fecha = texto(txtFechaNovedad);
        String responsable = texto(txtResponsableNovedad);
        String descripcion = areaDescripcionNovedad.getText().trim();
        double horas = numero(txtHorasNovedad);
        if (!Validacion.fechaValida(fecha)) { error("La fecha debe existir y tener formato dd/mm/aaaa."); return; }
        if (!Validacion.textoObligatorio(responsable, 60) || !Validacion.textoObligatorio(descripcion, 300)) {
            error("Complete responsable y descripción de la novedad."); return;
        }
        if (!Validacion.numeroNoNegativo(horas)) { error("Las horas detenidas no pueden ser negativas."); return; }
        NovedadPlanta novedad = new NovedadPlanta(gestionNovedades.siguienteCodigo(), fecha,
                seleccionado(comboAreaNovedad), seleccionado(comboTipoNovedad), seleccionado(comboPrioridadNovedad),
                responsable, horas, descripcion);
        gestionNovedades.agregar(novedad);
        pilaAcciones.registrar(responsable, "Registró la novedad " + novedad.getCodigo() + " en " + novedad.getMaquinaArea() + ".");
        exito("Novedad de planta registrada."); limpiarNovedad(); actualizarTodo();
    } catch (Exception ex) { error("Las horas detenidas deben ser un número válido."); }
}


private void resolverNovedad() {
    NovedadPlanta novedad = gestionNovedades.buscar(codigoCombo(comboNovedadSeleccionada));
    String solucion = areaSolucionNovedad.getText().trim();
    if (novedad == null) { error("Seleccione una novedad."); return; }
    if (!novedad.getEstado().equals("Abierta")) { error("La novedad seleccionada ya fue resuelta."); return; }
    if (!Validacion.textoObligatorio(solucion, 300)) { error("Escriba una solución aplicada válida."); return; }
    novedad.resolver(solucion);
    pilaAcciones.registrar("Sistema", "Se resolvió la novedad " + novedad.getCodigo() + ".");
    exito("Novedad marcada como resuelta."); actualizarTodo();
}


    private void mostrarGrafoSubmoldes() {
        ModeloPrenda modelo = gestionModelos.buscar(codigoCombo(comboModeloGrafo));
        if (modelo == null) {
            error("Seleccione un modelo para ver sus submoldes.");
            return;
        }

        grafoEnsamblaje.construir(modelo, gestionMoldes.getMoldes());
        areaGrafoSubmoldes.setText(grafoEnsamblaje.recorrerProfundidad(modelo));
    }

    private void mostrarGrafoEstados() {
        areaGrafoEstados.setText(gestionPedidos.getGrafoEstados().listarGrafo());
    }

    private void rastrearLote() {
        String lote = seleccionado(comboLoteTrazabilidad);
        if (!Validacion.textoObligatorio(lote, 40)) {
            error("Seleccione un lote para rastrear.");
            return;
        }

        grafoTrazabilidad.construir(gestionRollos.getRollos(), gestionPedidos.getPedidos());
        areaTrazabilidad.setText(grafoTrazabilidad.rastrearLote(lote, gestionPedidos.getPedidos()));
    }

    private void cargarModeloSeleccionado() {
        ModeloPrenda modelo = gestionModelos.buscar(codigoCombo(comboModeloSeleccionado));
        if (modelo == null) return;
        txtCodigoModelo.setText(modelo.getCodigo());
        txtNombreModelo.setText(modelo.getNombre());
        seleccionarPorCodigo(comboLineaModelo, modelo.getCodigoLinea());
        seleccionarPorCodigo(comboMaterialModelo, modelo.getCodigoMaterial());
        comboMangaModelo.setSelectedItem(modelo.getTipoManga());
        comboCuelloModelo.setSelectedItem(modelo.getTipoCuello());
        comboTallaModelo.setSelectedItem(modelo.getTalla());
        txtAnchoMinimoModelo.setText(String.valueOf(modelo.getAnchoMinimoTela()));
        txtConsumoModelo.setText(String.valueOf(modelo.getConsumoPorUnidad()));
        txtPrecioModelo.setText(String.valueOf(modelo.getPrecioVenta()));
        comboEstadoModelo.setSelectedItem(modelo.getEstado());
        areaNotasModelo.setText(modelo.getNotas());
    }


    private void cargarMoldeSeleccionado() {
        Molde molde = gestionMoldes.buscar(codigoCombo(comboMoldeSeleccionado));
        if (molde == null) return;
        txtCodigoMolde.setText(molde.getCodigo());
        txtNombrePieza.setText(molde.getNombrePieza());
        seleccionarPorCodigo(comboModeloMolde, molde.getCodigoModelo());
        comboTallaMolde.setSelectedItem(molde.getTalla());
        txtCantidadCorte.setText(String.valueOf(molde.getCantidadCorte()));
        txtAnchoMolde.setText(String.valueOf(molde.getAnchoCm()));
        txtAltoMolde.setText(String.valueOf(molde.getAltoCm()));
        comboEstadoMolde.setSelectedItem(molde.getEstado());
        areaNotasMolde.setText(molde.getNotas());
    }


    private void cargarMaterialSeleccionado() {
        Material material = gestionMateriales.buscar(codigoCombo(comboMaterialSeleccionado));
        if (material == null) return;
        txtCodigoMaterial.setText(material.getCodigo());
        txtNombreMaterial.setText(material.getNombre());
        txtComposicionMaterial.setText(material.getComposicion());
        txtProveedorMaterial.setText(material.getProveedorPrincipal());
        txtCostoMaterial.setText(String.valueOf(material.getCostoMetroBase()));
        txtStockMinimoMaterial.setText(String.valueOf(material.getStockMinimoMetros()));
        areaNotasMaterial.setText(material.getNotas());
    }

    private void cargarRolloSeleccionado() {
        RolloTela rollo = gestionRollos.buscar(codigoCombo(comboRolloSeleccionado));
        if (rollo == null) return;
        seleccionarPorCodigo(comboMaterialRollo, rollo.getCodigoMaterial());
        txtColorRollo.setText(rollo.getColor());
        txtAnchoRollo.setText(String.valueOf(rollo.getAnchoCm()));
        txtLargoRollo.setText(String.valueOf(rollo.getLargoDisponibleM()));
        txtCantidadRollos.setText("1");
        txtCostoRollo.setText(String.valueOf(rollo.getCostoMetro()));
        txtProveedorRollo.setText(rollo.getProveedor());
        txtLoteRollo.setText(rollo.getLote());
        txtUbicacionRollo.setText(rollo.getUbicacion());
        comboEstadoRollo.setSelectedItem(rollo.getEstado());
        areaNotaCalidadRollo.setText(rollo.getNotaCalidad());
    }

    private void cargarClienteSeleccionado() {
        Cliente cliente = gestionClientes.buscar(codigoCombo(comboClienteSeleccionado));
        if (cliente == null) return;
        txtCodigoCliente.setText(cliente.getCodigo());
        txtNombreCliente.setText(cliente.getNombre());
        txtTelefonoCliente.setText(cliente.getTelefono());
        txtCorreoCliente.setText(cliente.getCorreo());
        areaNotasCliente.setText(cliente.getNotas());
    }

    private void cargarPedidoSeleccionado() {
        Pedido pedido = gestionPedidos.buscar(codigoCombo(comboPedidoSeleccionado));
        if (pedido == null) return;
        areaDetallePedido.setText(detallePedido(pedido));
    }

    private void cargarPedidoProduccion() {
        Pedido pedido = gestionPedidos.buscar(codigoCombo(comboPedidoProduccion));
        if (pedido == null) return;
        txtMetrosProduccion.setText(String.format("%.2f", pedido.getMetrosEstimados()));
        areaProduccion.setText(detallePedido(pedido));
        cargarRollosCompatibles(pedido);
    }

    private void cargarNovedadSeleccionada() {
        NovedadPlanta novedad = gestionNovedades.buscar(codigoCombo(comboNovedadSeleccionada));
        if (novedad == null) return;
        txtFechaNovedad.setText(novedad.getFecha());
        comboAreaNovedad.setSelectedItem(novedad.getMaquinaArea());
        comboTipoNovedad.setSelectedItem(novedad.getTipo());
        comboPrioridadNovedad.setSelectedItem(novedad.getPrioridad());
        txtResponsableNovedad.setText(novedad.getResponsable());
        txtHorasNovedad.setText(String.valueOf(novedad.getHorasDetenida()));
        areaDescripcionNovedad.setText(novedad.getDescripcion());
        areaSolucionNovedad.setText(novedad.getSolucion());
    }

    private void actualizarTodo() {
        cargandoCombos = true;
        actualizarListas();
        cargarCombos();
        actualizarDashboard();
        cargandoCombos = false;
    }

    private void actualizarListas() {
        areaLineas.setText(gestionLineas.listar());
        areaModelos.setText(gestionModelos.listar());
        areaMateriales.setText(gestionMateriales.listar());
        areaRollos.setText(gestionRollos.listar());
        areaClientes.setText(gestionClientes.listar());
        areaPedidos.setText(gestionPedidos.listar());
        areaNovedades.setText(gestionNovedades.listar());
        if (comboModeloMolde != null && comboModeloMolde.getItemCount() > 0) listarMoldesModelo();
    }

    private void cargarCombos() {
        cargarComboLineas(comboLineaModelo);
        cargarComboModelos(comboModeloSeleccionado);
        cargarComboModelos(comboModeloMolde);
        cargarComboModelos(comboModeloPedido);
        cargarComboModelos(comboModeloGrafo);
        cargarComboModelos(comboPedidoProduccion); // se reemplaza abajo con pedidos
        cargarComboMoldes(comboMoldeSeleccionado);
        cargarComboMateriales(comboMaterialModelo);
        cargarComboMateriales(comboMaterialRollo);
        cargarComboMateriales(comboMaterialSeleccionado);
        cargarComboRollos(comboRolloSeleccionado);
        cargarComboLotes(comboLoteTrazabilidad);
        cargarComboClientes(comboClienteSeleccionado);
        cargarComboClientes(comboClientePedido);
        cargarComboPedidos(comboPedidoSeleccionado);
        cargarComboPedidos(comboPedidoProduccion);
        cargarComboNovedades(comboNovedadSeleccionada);
    }

    private void cargarComboLineas(JComboBox combo) {
        String actual = codigoCombo(combo); combo.removeAllItems();
        for (LineaProducto linea : gestionLineas.getLineas()) combo.addItem(linea.getCodigo() + " - " + linea.getNombre());
        seleccionarPorCodigo(combo, actual);
    }

    private void cargarComboModelos(JComboBox combo) {
        String actual = codigoCombo(combo); combo.removeAllItems();
        for (ModeloPrenda modelo : gestionModelos.getModelos()) combo.addItem(modelo.getCodigo() + " - " + modelo.getNombre());
        seleccionarPorCodigo(combo, actual);
    }

    private void cargarComboMoldes(JComboBox combo) {
        String actual = codigoCombo(combo); combo.removeAllItems();
        for (Molde molde : gestionMoldes.getMoldes()) combo.addItem(molde.getCodigo() + " - " + molde.getNombrePieza());
        seleccionarPorCodigo(combo, actual);
    }

    private void cargarComboMateriales(JComboBox combo) {
        String actual = codigoCombo(combo); combo.removeAllItems();
        for (Material material : gestionMateriales.getMateriales()) combo.addItem(material.getCodigo() + " - " + material.getNombre());
        seleccionarPorCodigo(combo, actual);
    }

    private void cargarComboRollos(JComboBox combo) {
        String actual = codigoCombo(combo); combo.removeAllItems();
        for (RolloTela rollo : gestionRollos.getRollos()) combo.addItem(rollo.getCodigo() + " - " + rollo.getColor() + " - " + rollo.getLargoDisponibleM() + "m");
        seleccionarPorCodigo(combo, actual);
    }


    private void cargarComboLotes(JComboBox combo) {
        String actual = combo.getSelectedItem() == null ? "" : combo.getSelectedItem().toString();
        combo.removeAllItems();

        ArrayList<String> lotes = new ArrayList<String>();
        for (RolloTela rollo : gestionRollos.getRollos()) {
            if (!lotes.contains(rollo.getLote())) {
                lotes.add(rollo.getLote());
                combo.addItem(rollo.getLote());
            }
        }

        for (int i = 0; i < combo.getItemCount(); i++) {
            if (combo.getItemAt(i).toString().equalsIgnoreCase(actual)) {
                combo.setSelectedIndex(i);
                return;
            }
        }
    }

    private void cargarComboClientes(JComboBox combo) {
        String actual = codigoCombo(combo); combo.removeAllItems();
        for (Cliente cliente : gestionClientes.getClientes()) combo.addItem(cliente.getCodigo() + " - " + cliente.getNombre());
        seleccionarPorCodigo(combo, actual);
    }

    private void cargarComboPedidos(JComboBox combo) {
        String actual = codigoCombo(combo); combo.removeAllItems();
        for (Pedido pedido : gestionPedidos.getPedidos()) combo.addItem(pedido.getCodigo() + " - " + pedido.getEstado());
        seleccionarPorCodigo(combo, actual);
    }

    private void cargarComboNovedades(JComboBox combo) {
        String actual = codigoCombo(combo); combo.removeAllItems();
        for (NovedadPlanta novedad : gestionNovedades.getNovedades()) combo.addItem(novedad.getCodigo() + " - " + novedad.getMaquinaArea() + " - " + novedad.getEstado());
        seleccionarPorCodigo(combo, actual);
    }

    private void cargarRollosCompatibles(Pedido pedido) {
        comboRolloProduccion.removeAllItems();
        ModeloPrenda modelo = gestionModelos.buscar(pedido.getCodigoModelo());
        for (RolloTela rollo : gestionRollos.getRollos()) {
            if (rollo.getCodigoMaterial().equalsIgnoreCase(modelo.getCodigoMaterial()) &&
                    rollo.getEstado().equals("Disponible") &&
                    rollo.getAnchoCm() >= modelo.getAnchoMinimoTela() &&
                    rollo.getLargoDisponibleM() > 0) {
                comboRolloProduccion.addItem(rollo.getCodigo() + " - " + rollo.getColor() + " - " + rollo.getLargoDisponibleM() + "m");
            }
        }
    }


    private void actualizarDashboard() {
        int disponibles = 0;
        for (RolloTela rollo : gestionRollos.getRollos()) {
            if (rollo.getEstado().equals("Disponible")) disponibles++;
        }
        lblRollosDashboard.setText(String.valueOf(disponibles));
        lblMetrosDashboard.setText(String.format("%.2f m", gestionRollos.totalMetros()));
        lblValorDashboard.setText("$" + String.format("%.2f", gestionRollos.totalValor()));
        lblPedidosDashboard.setText(String.valueOf(gestionPedidos.contarPendientes()));
        lblNovedadesDashboard.setText(String.valueOf(gestionNovedades.contarAbiertas()));

        String texto = "RESUMEN OPERATIVO DEL TALLER\n\n";
        texto += "• El sistema organiza líneas, modelos, moldes, materiales, rollos, pedidos y novedades.\n";
        texto += "• Antes de producir, el pedido calcula tela, costo estimado, venta y margen bruto.\n";
        texto += "• Al finalizar producción, se registra el consumo real y se descuenta el rollo seleccionado.\n";
        texto += "• Los grafos organizan submoldes, controlan estados y permiten rastrear lotes usados.\n\n";
        texto += "ALERTAS\n";
        boolean hayAlerta = false;
        for (Material material : gestionMateriales.getMateriales()) {
            double metros = gestionRollos.metrosPorMaterial(material.getCodigo());
            if (metros <= material.getStockMinimoMetros()) {
                texto += "⚠ Bajo stock: " + material.getNombre() + " tiene " + String.format("%.2f", metros) + " m.\n";
                hayAlerta = true;
            }
        }
        if (gestionNovedades.contarAbiertas() > 0) {
            texto += "⚠ Existen " + gestionNovedades.contarAbiertas() + " novedades de planta abiertas.\n";
            hayAlerta = true;
        }
        if (!hayAlerta) texto += "✓ No existen alertas críticas en este momento.\n";
        areaAlertas.setText(texto);
    }

    private void generarReporteInventario() {
        String texto = "REPORTE DE INVENTARIO\n\n" + gestionRollos.listar() + "\n";
        texto += "Metros totales: " + String.format("%.2f", gestionRollos.totalMetros()) + " m\n";
        texto += "Valor estimado: $" + String.format("%.2f", gestionRollos.totalValor()) + "\n";
        areaReportes.setText(texto);
    }

    private void generarReportePedidos() {
        String texto = "REPORTE DE PEDIDOS\n\n";
        for (Pedido pedido : gestionPedidos.getPedidos()) texto += detallePedido(pedido) + "\n-------------------------\n";
        areaReportes.setText(texto);
    }

    private void generarReporteNovedades() {
        areaReportes.setText("REPORTE DE NOVEDADES DE PLANTA\n\n" + gestionNovedades.listar());
    }

    private void generarReporteHistorial() {
        areaReportes.setText(pilaAcciones.mostrarHistorial());
    }

    private String detallePedido(Pedido pedido) {
        Cliente cliente = gestionClientes.buscar(pedido.getCodigoCliente());
        ModeloPrenda modelo = gestionModelos.buscar(pedido.getCodigoModelo());
        return "Pedido: " + pedido.getCodigo() + "\n" +
                "Cliente: " + (cliente == null ? pedido.getCodigoCliente() : cliente.getNombre()) + "\n" +
                "Modelo: " + (modelo == null ? pedido.getCodigoModelo() : modelo.getNombre()) + "\n" +
                "Color: " + pedido.getColorSolicitado() + " | Tallas: " + pedido.getDetalleTallas() + "\n" +
                "Cantidad: " + pedido.getCantidad() + " | Entrega: " + pedido.getFechaEntrega() + " | " + pedido.getPrioridad() + "\n" +
                "Metros estimados: " + String.format("%.2f", pedido.getMetrosEstimados()) + " m\n" +
                "Costo estimado tela: $" + String.format("%.2f", pedido.getCostoEstimadoTela()) + "\n" +
                "Venta: $" + String.format("%.2f", pedido.getTotalVenta()) + " | Anticipo: $" + String.format("%.2f", pedido.getAnticipo()) + "\n" +
                "Saldo: $" + String.format("%.2f", pedido.getSaldoPendiente()) + " | Margen bruto: $" + String.format("%.2f", pedido.getMargenBruto()) + "\n" +
                "Rollo: " + pedido.getCodigoRollo() + " | Estado: " + pedido.getEstado() + "\n" +
                "Metros reales: " + String.format("%.2f", pedido.getMetrosConsumidos()) + " | Diferencia: " + String.format("%.2f", pedido.getDiferenciaConsumo()) + " m\n" +
                "Notas: " + pedido.getNotas();
    }

    private String nombreMaterial(String codigo) {
        Material material = gestionMateriales.buscar(codigo);
        return material == null ? codigo : material.getNombre();
    }

    private String codigoCombo(JComboBox combo) {
        if (combo == null || combo.getSelectedItem() == null) return "";
        String texto = combo.getSelectedItem().toString();
        int indice = texto.indexOf(" - ");
        return indice >= 0 ? texto.substring(0, indice).trim() : texto.trim();
    }

    private String seleccionado(JComboBox combo) {
        return combo.getSelectedItem() == null ? "" : combo.getSelectedItem().toString();
    }

    private void seleccionarPorCodigo(JComboBox combo, String codigo) {
        if (codigo == null) return;
        for (int i = 0; i < combo.getItemCount(); i++) {
            String item = combo.getItemAt(i).toString();
            if (item.startsWith(codigo + " -")) { combo.setSelectedIndex(i); return; }
        }
    }

    private String texto(JTextField campo) { return campo.getText().trim(); }
    private String codigo(JTextField campo) { return campo.getText().trim().toUpperCase(); }
    private double numero(JTextField campo) { return Double.parseDouble(campo.getText().trim().replace(",", ".")); }
    private int entero(JTextField campo) { return Integer.parseInt(campo.getText().trim()); }

    private boolean confirmar(String mensaje) {
        return JOptionPane.showConfirmDialog(this, mensaje, "Confirmar acción", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }

    private void exito(String mensaje) { JOptionPane.showMessageDialog(this, mensaje, "TexOptiCut", JOptionPane.INFORMATION_MESSAGE); }
    private void error(String mensaje) { JOptionPane.showMessageDialog(this, mensaje, "Validación", JOptionPane.ERROR_MESSAGE); }

    private void limpiarLinea() { txtCodigoLinea.setText(""); txtNombreLinea.setText(""); areaNotasLinea.setText(""); }
    private void limpiarModelo() { txtCodigoModelo.setText(""); txtNombreModelo.setText(""); txtAnchoMinimoModelo.setText(""); txtConsumoModelo.setText(""); txtPrecioModelo.setText(""); areaNotasModelo.setText(""); }
    private void limpiarMolde() { txtCodigoMolde.setText(""); txtNombrePieza.setText(""); txtCantidadCorte.setText(""); txtAnchoMolde.setText(""); txtAltoMolde.setText(""); areaNotasMolde.setText(""); }
    private void limpiarMaterial() { txtCodigoMaterial.setText(""); txtNombreMaterial.setText(""); txtComposicionMaterial.setText(""); txtProveedorMaterial.setText(""); txtCostoMaterial.setText(""); txtStockMinimoMaterial.setText(""); areaNotasMaterial.setText(""); }
    private void limpiarRollo() { txtColorRollo.setText(""); txtAnchoRollo.setText(""); txtLargoRollo.setText(""); txtCantidadRollos.setText(""); txtCostoRollo.setText(""); txtProveedorRollo.setText(""); txtLoteRollo.setText(""); txtUbicacionRollo.setText(""); areaNotaCalidadRollo.setText(""); }
    private void limpiarCliente() { txtCodigoCliente.setText(""); txtNombreCliente.setText(""); txtTelefonoCliente.setText(""); txtCorreoCliente.setText(""); areaNotasCliente.setText(""); }
    private void limpiarPedido() { txtColorPedido.setText(""); txtCantidadPedido.setText(""); txtTallasPedido.setText(""); txtFechaPedido.setText("dd/mm/aaaa"); txtAnticipoPedido.setText("0"); areaNotasPedido.setText(""); }
    private void limpiarNovedad() { txtFechaNovedad.setText("dd/mm/aaaa"); txtResponsableNovedad.setText(""); txtHorasNovedad.setText("0"); areaDescripcionNovedad.setText(""); areaSolucionNovedad.setText(""); }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() { new ventana(); }
        });
    }
}
