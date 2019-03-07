<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-3.3.1.js" ></script>
        <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js" ></script>
        <script>

            $(document).ready(function () {

                var table = $('#example').DataTable({
                    ajax: "http://localhost:8080/klt/rest/rest/requests",
                    columns: [
                        {data: "id"},
                        {data: "firstName"},
                        {data: "lastName"},
                        {data: "age"},
                        {
                            data: null,
                            className: "center",
                            defaultContent: '<button class="editor_remove">Delete</button>'
                        }
                    ]
                });

                // Delete a record
                $('#example').on('click', 'button.editor_remove', function (e) {
                    e.preventDefault();
                    // console.log($(this).index());


                    if (confirm('Are you sure you want to delete this?')) {
                        var row = table.row($("button").index(this)).data();
                        $.ajax({
                            url: 'http://localhost:8080/klt/rest/rest/requests/'+row.id,
                            type: 'DELETE',
                            success: function (result) {
                                // alert(result.msg);
                                table.ajax.reload();
                            }
                        });
                    }
                });


            });
        </script>
        <title>Anmeldeformular - Kennenlerntagaufgabe</title>
    </head>
    <body>

        <div class="container" style="width: 50%;margin: 0 auto">
            <div>
                <table id="example" class="display" style="width:100%">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>First name</th>
                            <th>Last name</th>
                            <th>Age</th>
                            <th>Edit / Delete</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>Id</th>
                            <th>First name</th>
                            <th>Last name</th>
                            <th>Age</th>
                            <th>Edit / Delete</th>
                        </tr>
                    </tfoot>
                </table>

            </div>
        </div>
    </body>
</html>
