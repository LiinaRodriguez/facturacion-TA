--
-- Base de datos: `facturacion_db`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cargo`
--

CREATE TABLE `cargo` (
                         `ID_Cargo` int(11) NOT NULL,
                         `NombreCargo` varchar(100) DEFAULT NULL,
                         `Descripcion` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalledeventa`
--

CREATE TABLE `detalledeventa` (
                                  `ID_DetalleDeVenta` int(11) NOT NULL,
                                  `ServicioID` int(11) DEFAULT NULL,
                                  `Cantidad` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresa`
--

CREATE TABLE `empresa` (
                           `ID_Empresa` int(11) NOT NULL,
                           `NombreEmpresa` varchar(100) DEFAULT NULL,
                           `DireccionEmpresa` varchar(255) DEFAULT NULL,
                           `TelefonoEmpresa` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facturacion`
--

CREATE TABLE `facturacion` (
                               `ID_Facturacion` int(11) NOT NULL,
                               `VentaServicioID` int(11) DEFAULT NULL,
                               `FechaFacturacion` date DEFAULT NULL,
                               `MontoTotal` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `login`
--

CREATE TABLE `login` (
                         `ID_Login` int(11) NOT NULL,
                         `UsuarioRegistradoID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
                           `ID_Persona` int(11) NOT NULL,
                           `Nombre` varchar(255) DEFAULT NULL,
                           `Apellido` varchar(255) DEFAULT NULL,
                           `CorreoElectronico` varchar(255) DEFAULT NULL,
                           `Telefono` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Estructura de tabla para la tabla `personacargo`
--

CREATE TABLE `personacargo` (
                                `ID_PersonaCargo` int(11) NOT NULL,
                                `PersonaID` int(11) DEFAULT NULL,
                                `CargoID` int(11) DEFAULT NULL,
                                `EmpresaID` int(11) DEFAULT NULL,
                                `FechaInicio` date DEFAULT NULL,
                                `FechaFin` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `plataforma`
--

CREATE TABLE `plataforma` (
                              `ID_Plataforma` int(11) NOT NULL,
                              `NombrePlataforma` varchar(100) DEFAULT NULL,
                              `DireccionWeb` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicio`
--

CREATE TABLE `servicio` (
                            `ID_Servicio` int(11) NOT NULL,
                            `NombreServicio` varchar(100) DEFAULT NULL,
                            `Precio` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `servicio`
--

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
                           `ID_Usuario` int(11) NOT NULL,
                           `PersonaID` int(11) DEFAULT NULL,
                           `NombreUsuario` varchar(50) DEFAULT NULL,
                           `Contrasena` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


--
-- Estructura de tabla para la tabla `usuarioregistrado`
--

CREATE TABLE `usuarioregistrado` (
                                     `ID_UsuarioRegistrado` int(11) NOT NULL,
                                     `UsuarioID` int(11) DEFAULT NULL,
                                     `PlataformaID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventaservicio`
--

CREATE TABLE `ventaservicio` (
                                 `ID_VentaServicio` int(11) NOT NULL,
                                 `DetalleDeVentaID` int(11) DEFAULT NULL,
                                 `PersonaID` int(11) DEFAULT NULL,
                                 `FechaVenta` date DEFAULT NULL,
                                 `Total` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cargo`
--
ALTER TABLE `cargo`
    ADD PRIMARY KEY (`ID_Cargo`);

--
-- Indices de la tabla `detalledeventa`
--
ALTER TABLE `detalledeventa`
    ADD PRIMARY KEY (`ID_DetalleDeVenta`),
    ADD KEY `ServicioID` (`ServicioID`);

--
-- Indices de la tabla `empresa`
--
ALTER TABLE `empresa`
    ADD PRIMARY KEY (`ID_Empresa`);

--
-- Indices de la tabla `facturacion`
--
ALTER TABLE `facturacion`
    ADD PRIMARY KEY (`ID_Facturacion`),
    ADD KEY `VentaServicioID` (`VentaServicioID`);

--
-- Indices de la tabla `login`
--
ALTER TABLE `login`
    ADD PRIMARY KEY (`ID_Login`),
    ADD KEY `UsuarioRegistradoID` (`UsuarioRegistradoID`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
    ADD PRIMARY KEY (`ID_Persona`);

--
-- Indices de la tabla `personacargo`
--
ALTER TABLE `personacargo`
    ADD PRIMARY KEY (`ID_PersonaCargo`),
    ADD KEY `PersonaID` (`PersonaID`),
    ADD KEY `CargoID` (`CargoID`),
    ADD KEY `EmpresaID` (`EmpresaID`);

--
-- Indices de la tabla `plataforma`
--
ALTER TABLE `plataforma`
    ADD PRIMARY KEY (`ID_Plataforma`);

--
-- Indices de la tabla `servicio`
--
ALTER TABLE `servicio`
    ADD PRIMARY KEY (`ID_Servicio`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
    ADD PRIMARY KEY (`ID_Usuario`),
    ADD KEY `PersonaID` (`PersonaID`);

--
-- Indices de la tabla `usuarioregistrado`
--
ALTER TABLE `usuarioregistrado`
    ADD PRIMARY KEY (`ID_UsuarioRegistrado`),
    ADD KEY `UsuarioID` (`UsuarioID`),
    ADD KEY `PlataformaID` (`PlataformaID`);

--
-- Indices de la tabla `ventaservicio`
--
ALTER TABLE `ventaservicio`
    ADD PRIMARY KEY (`ID_VentaServicio`),
    ADD KEY `DetalleDeVentaID` (`DetalleDeVentaID`),
    ADD KEY `PersonaID` (`PersonaID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cargo`
--
ALTER TABLE `cargo`
    MODIFY `ID_Cargo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `detalledeventa`
--
ALTER TABLE `detalledeventa`
    MODIFY `ID_DetalleDeVenta` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `empresa`
--
ALTER TABLE `empresa`
    MODIFY `ID_Empresa` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `facturacion`
--
ALTER TABLE `facturacion`
    MODIFY `ID_Facturacion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `login`
--
ALTER TABLE `login`
    MODIFY `ID_Login` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
    MODIFY `ID_Persona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `personacargo`
--
ALTER TABLE `personacargo`
    MODIFY `ID_PersonaCargo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `plataforma`
--
ALTER TABLE `plataforma`
    MODIFY `ID_Plataforma` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `servicio`
--
ALTER TABLE `servicio`
    MODIFY `ID_Servicio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
    MODIFY `ID_Usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `usuarioregistrado`
--
ALTER TABLE `usuarioregistrado`
    MODIFY `ID_UsuarioRegistrado` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `ventaservicio`
--
ALTER TABLE `ventaservicio`
    MODIFY `ID_VentaServicio` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalledeventa`
--
ALTER TABLE `detalledeventa`
    ADD CONSTRAINT `detalledeventa_ibfk_1` FOREIGN KEY (`ServicioID`) REFERENCES `servicio` (`ID_Servicio`);

--
-- Filtros para la tabla `facturacion`
--
ALTER TABLE `facturacion`
    ADD CONSTRAINT `facturacion_ibfk_1` FOREIGN KEY (`VentaServicioID`) REFERENCES `ventaservicio` (`ID_VentaServicio`);

--
-- Filtros para la tabla `login`
--
ALTER TABLE `login`
    ADD CONSTRAINT `login_ibfk_1` FOREIGN KEY (`UsuarioRegistradoID`) REFERENCES `usuarioregistrado` (`ID_UsuarioRegistrado`);

--
-- Filtros para la tabla `personacargo`
--
ALTER TABLE `personacargo`
    ADD CONSTRAINT `personacargo_ibfk_1` FOREIGN KEY (`PersonaID`) REFERENCES `persona` (`ID_Persona`),
    ADD CONSTRAINT `personacargo_ibfk_2` FOREIGN KEY (`CargoID`) REFERENCES `cargo` (`ID_Cargo`),
    ADD CONSTRAINT `personacargo_ibfk_3` FOREIGN KEY (`EmpresaID`) REFERENCES `empresa` (`ID_Empresa`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
    ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`PersonaID`) REFERENCES `persona` (`ID_Persona`);

--
-- Filtros para la tabla `usuarioregistrado`
--
ALTER TABLE `usuarioregistrado`
    ADD CONSTRAINT `usuarioregistrado_ibfk_1` FOREIGN KEY (`UsuarioID`) REFERENCES `usuario` (`ID_Usuario`),
    ADD CONSTRAINT `usuarioregistrado_ibfk_2` FOREIGN KEY (`PlataformaID`) REFERENCES `plataforma` (`ID_Plataforma`);

--
-- Filtros para la tabla `ventaservicio`
--
ALTER TABLE `ventaservicio`
    ADD CONSTRAINT `persona_ibfk_2` FOREIGN KEY (`PersonaID`) REFERENCES `persona` (`ID_Persona`),
    ADD CONSTRAINT `ventaservicio_ibfk_1` FOREIGN KEY (`DetalleDeVentaID`) REFERENCES `detalledeventa` (`ID_DetalleDeVenta`);
COMMIT;