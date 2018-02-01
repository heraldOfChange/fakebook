<%@include file="/breakdown/imports.jsp" %>

<!-- HTML 5 DOCUMENT -->
<!DOCTYPE html>

<!-- HTML -->
<html>

    <!-- HEAD -->
    <head>

        <title><b:message key="home.title" /></title>
        <link rel="shortcut icon" href="favicon.ico"/>
        <!-- META -->
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />

        <!-- STYLES -->
        <link type="text/css" rel="stylesheet" href="styles/layout.css" />
        <link type="text/css" rel="stylesheet" href="styles/home.css" />
        <link type="text/css" rel="stylesheet" href="styles/message.css" />
        <script src="js/jQuery.min.js"></script>
        <script>
            var body ="body";
            
            $(window).load(function(){
                $(body).fadeIn(500);
            });
        </script>
        ${message_error}

    </head>

    <!-- BODY -->
    <body class="body">

        <!-- HEADER -->
        <%@include file="/breakdown/home/head.jsp" %>

        <!-- CONTENT -->
        <%@include file="/breakdown/messaging/viewMessages.jsp" %>

        <!-- FOOTER -->
        <%@include file="/breakdown/index/links.jsp" %>

    </body>

</html>