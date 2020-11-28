<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<button onclick="Start()">Start</button>
<button onclick="Close();">Close</button>
<div id="ws"></div>

<script type="text/javascript">
    let ws = null;
    const Start = () => {
        ws = new WebSocket(`ws://localhost:8081/lab_16_war/ws`);
        ws.onmessage = (event) => {
            document.getElementById("ws").innerHTML += '<div>' + event.data + '</div>';
        };
    }
    const Close = () => {
        ws.close();
    }
</script>
</body>
</html>
