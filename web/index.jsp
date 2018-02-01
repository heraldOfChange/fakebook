<%@include file="/breakdown/imports.jsp" %>

<!-- HTML 5 DOCUMENT -->
<!DOCTYPE html>

<!-- HTML -->
<html>
    
    <!-- HEAD -->
    <head>
        
        <title><b:message key="index.title" /></title>
        <link rel="shortcut icon" href="favicon.ico"/>
        <!-- META -->
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        
        <!-- STYLES -->
        <link type="text/css" rel="stylesheet" href="styles/layout.css" />
        <link type="text/css" rel="stylesheet" href="styles/index.css" />
        <script src="js/jQuery.min.js"></script>
        <script>
            var body ="body";
            
            $(window).load(function(){
                $(body).fadeIn(500);
            });
        </script>
        ${signup_error} ${login_error}
         
    </head>
    
    <!-- BODY -->
    <body class="body">
        
        <!-- HEADER -->
        <%@include file="/breakdown/index/login.jsp" %>
        
        <!-- CONTENT -->
        <%@include file="/breakdown/index/mainContent.jsp" %>
        
        <!-- FOOTER -->
        <%@include file="/breakdown/index/links.jsp" %>
        
    </body>

</html>
