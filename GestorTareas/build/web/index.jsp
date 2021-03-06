<%-- 
    Document   : index
    Created on : 31/01/2019, 09:48:48 AM
    Author     : lenovo
--%>

<%@page import="java.util.List"%>
<%@page import="Entidades.TareasEntities"%>
<%@page import="Modelos.TareasModels"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestor de Tareas</title>
        <script src="librerias/jquery.js" type="text/javascript"></script>
        <script src="librerias/jquery-ui.js" type="text/javascript"></script>
        <link href="librerias/jquery-ui.css" rel="stylesheet" type="text/css"/>
        <style>
            body {
                background:url(assets/bg.png);
                font-size:14px;
                font-family:Calibri, Arial, Helvetica, sans-serif;
            }

            #logo {
                width:102px;
                height:86px;
                float:left;
            }



            #title {
                float:left;
                margin-top:30px;
                margin-left:20px;
                float:left;
            }



            #info {
                background:url(assets/icon_info.png) no-repeat left center;
                padding-left:50px;
                width:295px;
                float:right;	
                margin-top:40px;
                margin-right:30px;

                line-height:1.5;
            }

            #worldskills_bg {
                background:url(assets/ws_logo_bg.png) no-repeat;
                width:906px;
                height:678px;
                position:fixed;
                z-index:-100;
                bottom:0;
                right:10px;	
            }
            .caja{
                width: 18%; 
                float: left; 
                border: 1px #000 solid; 
                min-height: 350px;
                margin: 5px;
                padding: 5px;
            }
            #header {
                margin-top:10px;	
            }
            .cajaPequena{
                width: 200px; 
                border: 1px #000 solid; 
                min-height: 100px;
                margin: 5px;
                background-color: antiquewhite;
                padding: 10px;
            }
            .clear {
                clear:both;
                display:block;	
            }
            .button {
                border:none;
                background:url(assets/button_bg.png) no-repeat;
                width:86px;
                font-weight:bold;
                cursor:pointer;
                height:36px;
                font-size:12px;
                font-family:Arial, Helvetica, sans-serif;
                color:#fff;
                text-align:center;	
            }

        </style>
        <script>
            $(function () {
                $(".draggable_cola").draggable({
                    cursor: "move",
                    revert: "valid"

                });

                $("#backlog").droppable({
                    drop: function (event, ui) {
                        var estado = $(".draggable_cola").data("estado");
                        if (estado == "2" || estado == "4" || estado == "5") {
                            $(".draggable_cola").draggable("option", "revert", "valid");
                            console.log($(".draggable_cola").data("estado"));
                            console.log($(".draggable_cola").data("idc"));
                        } else {
                            $(".draggable_cola").draggable("option", "revert", "invalid");
                            console.log($(".draggable_cola").data("estado"));
                        }
                    }
                });
                $("#proceso").droppable({
                    drop: function (event, ui) {
                        var estado = $(".draggable_cola").data("estado");
                        if (estado == "1") {
                            $(".draggable_cola").draggable("option", "revert", "invalid");
                            $(".draggable_cola").data("estado", "2");
                            console.log($(".draggable_cola").data("estado"));
                            console.log($(".draggable_cola").data("idc"));
                            var idc = $(".draggable_cola").data("idc");
                            aprocesar(idc);
                        } else {
                            $(".draggable_cola").draggable("option", "revert", "valid");
                        }
                    }
                });
                $("#suspendido").droppable({
                    drop: function (event, ui) {
                        var estado = $(".draggable_cola").data("estado");
                        if (estado == "1" || estado == "2") {
                            $(".draggable_cola").draggable("option", "revert", "invalid");
                            $(".draggable_cola").data("estado", "3");
                            console.log($(".draggable_cola").data("estado"));
                            console.log($(".draggable_cola").data("idc"));
                            var idc = $(".draggable_cola").data("idc");
                            asuspender(idc);
                        } else {
                            $(".draggable_cola").draggable("option", "revert", "valid");
                        }
                    }
                });
                $("#cancelado").droppable({
                    drop: function (event, ui) {
                        var estado = $(".draggable_cola").data("estado");
                        if (estado == "1" ||  estado == "2") {
                            $(".draggable_cola").draggable("option", "revert", "invalid");
                            $(".draggable_cola").data("estado", "4");
                            console.log($(".draggable_cola").data("estado"));
                            console.log($(".draggable_cola").data("idc"));
                            var idc = $(".draggable_cola").data("idc");
                            acancelar(idc);
                        } else {
                            $(".draggable_cola").draggable("option", "revert", "valid");
                        }
                    }
                });
                $("#finalizado").droppable({
                    drop: function (event, ui) {
                        var estado = $(".draggable_cola").data("estado");
                        if (estado == "1" || estado == "2") {
                            $(".draggable_cola").draggable("option", "revert", "invalid");
                            $(".draggable_cola").data("estado", "5");
                            console.log($(".draggable_cola").data("estado"));
                            console.log($(".draggable_cola").data("idc"));
                            var idc = $(".draggable_cola").data("idc");
                            afinalizar(idc);
                        } else {
                            $(".draggable_cola").draggable("option", "revert", "valid");
                        }
                    }
                });
            });

            function aprocesar(idc) {
                $.ajax({
                    type: "post",
                    dataType: "html",
                    url: "TareasControllers",
                    data: {action: 'aprocesar', id: idc},
                    success: function (data) {
                        window.location.assign("TareasControllers");
                    }
                })
            }

            function asuspender(idc) {
                $.ajax({
                    type: "post",
                    dataType: "html",
                    url: "TareasControllers",
                    data: {action: 'asuspender', id: idc},
                    success: function (data) {
                        window.location.assign("TareasControllers");
                    }
                })
            }
            function acancelar(idc) {
                $.ajax({
                    type: "post",
                    dataType: "html",
                    url: "TareasControllers",
                    data: {action: 'acancelar', id: idc},
                    success: function (data) {
                        window.location.assign("TareasControllers");
                    }
                })
            }
            function afinalizar(idc) {
                $.ajax({
                    type: "post",
                    dataType: "html",
                    url: "TareasControllers",
                    data: {action: 'afinalizar', id: idc},
                    success: function (data) {
                          window.location.assign("TareasControllers");
                    }
                })
            }
        </script>
    </head>
    <body>
        <div id="header">
            <div id="logo"><a href="index.jsp"><img src="assets/logo_ws2011.png" alt="WorldSkills London 2011" title="WorldSkills London 2011" /></a></div>
            <div id="title"><h1>Gestor de Tareas</h1></div>
            <div id="info">
                <p>Añada las tareas usando el formulario de registro y arrastelas hacia las columnas de estado. Atención las nuevas tareas seran automaticamente colocadas en la columna "Pendientes".
            </div>
        </div>
        <div class="clear"></div>

        <div >
            <form action="TareasControllers" method="post">
                <label>Nombre de la tarea</label>
                <input type="text" name="nombre" size="20">
                <label>Descripción de la tarea</label>
                <input type="text" name="descripcion" size="20">
                <input type="hidden" value="crear" name="action">
                <input type="submit" class="button" value="Registrar">
            </form>
        </div>
        <br/>
        <div class="caja" id="backlog">
            <h2 align="center">Backlog</h2>
            <%

                TareasModels tareas = new TareasModels();
                List<TareasEntities> rows = tareas.listar(1);

                for (int i = 0; i < rows.size(); i++) {
                    out.println("<div class='cajaPequena draggable_cola' data-estado='" + rows.get(i).getEstado() + "' data-idc='" + rows.get(i).getId() + "'>");
                    out.println("<label><b>Tarea #" + rows.get(i).getId() + "</b></label><br/><br/>");
                    out.println("<labe><b>Nombre</b></label><br/>");
                    out.println("<label>" + rows.get(i).getNombre() + "</label><br/>");
                    out.println("<labe><b>Descripcion</b></label><br/>");
                    out.println("<label>" + rows.get(i).getDescripcion() + "</label><br/><br/>");
                    out.println("<label><a href='TareasControllers?action=aeliminar&id=" + rows.get(i).getId() + "'> <img src='assets/ICON_DELETE.png' alt='Eliminar tarea' title='Eliminar tarea' />  </a></label>");

                    out.println("</div>");
                }
            %>

        </div>
        <div class="caja" id="proceso">
            <h2 align="center">En Progreso</h2>
            <%
                List<TareasEntities> rows2 = tareas.listar(2);

                for (int i = 0; i < rows2.size(); i++) {

                    out.println("<div class='cajaPequena draggable_cola' data-estado='" + rows2.get(i).getEstado() + "' data-idc='" + rows2.get(i).getId() + "'>");
                    out.println("<label><b>Tarea #" + rows2.get(i).getId() + "</b></label><br/><br/>");
                    out.println("<labe><b>Nombre</b></label><br/>");
                    out.println("<label>" + rows2.get(i).getNombre() + "</label><br/>");
                    out.println("<labe><b>Descripcion</b></label><br/>");
                    out.println("<label>" + rows2.get(i).getDescripcion() + "</label><br/>");
                    out.println("<labe><b>Inicio</b></label><br/>");
                    out.println("<label>" + rows2.get(i).getInicio() + "</label><br/>");
                    out.println("<labe><b>Responsable</b></label><br/>");
                    out.println("<label>" + rows2.get(i).getResponsable() + "</label><br/><br/>");

                    out.println("</div>");
                }
            %>
        </div>
        <div class="caja" id="suspendido">
            <h2 align="center">Suspendido</h2>
            <%
                List<TareasEntities> rows3 = tareas.listar(3);

                for (int i = 0; i < rows3.size(); i++) {

                    out.println("<div class='cajaPequena draggable_cola' data-estado='" + rows3.get(i).getEstado() + "' data-idc='" + rows3.get(i).getId() + "'>");
                    out.println("<label><b>Tarea #" + rows3.get(i).getId() + "</b></label><br/><br/>");
                    out.println("<labe><b>Nombre</b></label><br/>");
                    out.println("<label>" + rows3.get(i).getNombre() + "</label><br/>");
                    out.println("<labe><b>Descripcion</b></label><br/>");
                    out.println("<label>" + rows3.get(i).getDescripcion() + "</label><br/>");
                    out.println("<labe><b>Inicio</b></label><br/>");
                    out.println("<label>" + rows3.get(i).getInicio() + "</label><br/>");
                    out.println("<labe><b>Responsable</b></label><br/>");
                    out.println("<label>" + rows3.get(i).getResponsable() + "</label><br/><br/>");

                    out.println("</div>");
                }
            %>
        </div>
        <div class="caja" id="cancelado">
            <h2 align="center">Cancelado</h2>
            <%
                List<TareasEntities> rows4 = tareas.listar(4);

                for (int i = 0; i < rows4.size(); i++) {

                    out.println("<div class='cajaPequena draggable_cola' data-estado='" + rows4.get(i).getEstado() + "' data-idc='" + rows4.get(i).getId() + "'>");
                    out.println("<label><b>Tarea #" + rows4.get(i).getId() + "</b></label><br/><br/>");
                    out.println("<labe><b>Nombre</b></label><br/>");
                    out.println("<label>" + rows4.get(i).getNombre() + "</label><br/>");
                    out.println("<labe><b>Descripcion</b></label><br/>");
                    out.println("<label>" + rows4.get(i).getDescripcion() + "</label><br/>");
                    out.println("<labe><b>Inicio</b></label><br/>");
                    out.println("<label>" + rows4.get(i).getInicio() + "</label><br/>");
                    out.println("<labe><b>Responsable</b></label><br/>");
                    out.println("<label>" + rows4.get(i).getResponsable() + "</label><br/><br/>");

                    out.println("</div>");
                }
            %>
        </div>
        <div class="caja" id="finalizado">
            <h2 align="center">Finalizado</h2>
            <%
                List<TareasEntities> rows5 = tareas.listar(5);

                for (int i = 0; i < rows5.size(); i++) {

                    out.println("<div class='cajaPequena draggable_cola' data-estado='" + rows5.get(i).getEstado() + "' data-idc='" + rows5.get(i).getId() + "'>");
                    out.println("<label><b>Tarea #" + rows5.get(i).getId() + "</b></label><br/><br/>");
                    out.println("<label>" + rows5.get(i).getDescripcion() + "</label><br/>");
                    //out.println("<label>" + rows.get(i).getEstado() + "</label><br/>");
                    out.println("<labe><b>Inicio</b></label><br/>");
                    out.println("<label>" + rows5.get(i).getInicio() + "</label><br/>");
                    out.println("<labe><b>Fin</b></label><br/>");
                    out.println("<label>" + rows5.get(i).getFin() + "</label><br/>");
                    out.println("<labe><b>Responsable</b></label><br/>");
                    out.println("<label>" + rows5.get(i).getResponsable() + "</label><br/><br/>");
                    out.println("<label><a href='TareasControllers?action=aeliminar&id=" + rows5.get(i).getId() + "'> <img src='assets/ICON_DELETE.png' alt='Eliminar tarea' title='Eliminar tarea' />  </a></label>");

                    out.println("</div>");
                }
            %>
        </div>
        <div id="worldskills_bg"></div>

    </body>
</html>
