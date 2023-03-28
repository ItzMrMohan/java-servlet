<%-- 
    Document   : emailOTP
    Created on : 05-Apr-2022, 5:21:58 pm
    Author     : johns
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OTP Validator</title>
        <style>

            body {
                background-image: url('https://www-cms.pipedriveassets.com/blog-assets/sales-email-templates.png');
                background-repeat: no-repeat;
                background-attachment: fixed;
                background-size: cover;
            }
            p {
                text-align: center;
                font-size: 60px;
                margin-top: 0px;
            }
        </style>
    </head>
    <body>
    <center>
        <h1>Please enter OTP</h1><br>
        An OTP has been sent to ${email}<br>
        <div>Please enter within <span id="time"></span> minutes!</div>
        <br><!-- comment --><br>
        <form action="login" method="POST">
            Enter OTP: <input name="OTP" type="text"/>
        </form>
    </center>
        <script type="text/javascript">
        window.history.forward();
        function noBack() {
            window.history.forward();
        }
        function startTimer(duration, display) {
            var start = Date.now(),
                    diff,
                    minutes,
                    seconds;
            function timer() {
                // get the number of seconds that have elapsed since 
                // startTimer() was called
                diff = duration - (((Date.now() - start) / 1000) | 0);

                // does the same job as parseInt truncates the float
                minutes = (diff / 60) | 0;
                seconds = (diff % 60) | 0;

                minutes = minutes < 10 ? "0" + minutes : minutes;
                seconds = seconds < 10 ? "0" + seconds : seconds;

                display.textContent = minutes + ":" + seconds;

                if (diff <= 0) {
                    // add one second so that the count down starts at the full duration
                    // example 05:00 not 04:59
                    start = Date.now() + 1000;
                }
            }
            ;
// we don't want to wait a full second before the timer starts
            timer();
            setInterval(timer, 1000);
        }

        window.onload = function () {
            var fiveMinutes = 60 * 1,
                    display = document.querySelector('#time');
            startTimer(fiveMinutes, display);
            timer = setTimeout(function () {
                alert('Timeout');
                window.location.href = 'dbvalidate';
            }, 60000);
        };
    </script>

</body>
</html>





