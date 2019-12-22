<html>
<head>
    <title>PingID Devices Management Demo</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>

    <script type="text/javascript">
        $(document).ready(function() {
            $('#userName').click(function() {
                $("#errMsg").hide();
            });
        });
    </script>

    <style type="text/css">

        .grandParentContaniner {
            display: table;
            height: 70%;
            width: 20%;
            margin: 0 auto;
        }

        .parentContainer {
            display: table-cell;
            vertical-align: middle;
            margin: 0 auto;
        }

        .paddingBtm {
            padding-bottom: 12px;
        }

         input[type=submit] {
            background-color: rgb(184,35,47);
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            width: 100%;
            font-size: 14px;
        }
        input[type=submit]:hover {
            opacity: 0.8;
        }

    </style>
</head>
<body>
<div class="grandParentContaniner">
    <div class="parentContainer">
        <h2 style="width: max-content;">PingID Devices Management Demo</h2>
        <form id="loginForm" name="loginForm" method="post" action="<%=request.getContextPath()%>/pingid/getuserdetails" >
            <div id="usernameDiv" class="paddingBtm">
                <input type="text" placeholder="Enter Username" id="userName" name="userName" required
                       style="font-size: 16px; width: 100%; height: 35px;"/>
            </div>
            <div id="loginDiv">
                <input id="btn" class=loginBtn" type="submit" value="Login" />
            </div>
        </form>
        <div id="errMsg" class="errorContainer" style="color:red; text-align:center;"><%=
            request.getAttribute("errorMsg") != null ? request.getAttribute("errorMsg") : "" %>
        </div>
    </div>
</div>
</body>
</html>
