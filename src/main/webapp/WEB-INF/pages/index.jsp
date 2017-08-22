<!DOCTYPE html>
<html lang="en">
<head>

    <script type="text/javascript" src="http://code.jquery.com/jquery-1.4.3.min.js" ></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script>
        $(document).ready(function(){

            var cityNamePattern = /^[A-Za-z]{3,20}$/;

             var tableEffect = function(opacity){
                     $("#tableCity").animate({
                         //left: '250px',
                         opacity: opacity,
                         //height: height,
                         //width: width
                     });
             };

             var validatecityName = function () {

                 if (!cityNamePattern.test($("#fCity").val())) {

                     tableEffect('0.0');

                     $("#error").append("Invalid city Name");

                     return false;
                 }

                 $("#error").empty();

                 return true;
             }

            $("#submit").click(function(){
                var url = 'http://localhost:8080/weather/' + $("#fCity").val();

                if(!validatecityName()) return;

                tableEffect('0.5');

                $.get(url, function(data, status){

                    $("#tableCity").find("tr:gt(0)").remove();

                    var newRows = '';
                    for(var i = 0; i<data.length; i++){

                        //$("#tableCity").append("<tr>");
                        newRows += "<tr>" + "<td>" + data[i].name + "</td>";
                        newRows += "<td>" + data[i].city + "</td>";
                        newRows += "<td>" + data[i].state + "</td>";
                        newRows += "<td>" + data[i].country + "</td>";
                        newRows += "<td>" + data[i].country_iso3166 + "</td>";
                        newRows += "<td>" + data[i].country_name + "</td>";
                        newRows += "<td>" + data[i].zmw + "</td>";
                        newRows += "<td>" + data[i].l + "</td>" + "</tr>";
                    }

                    $("table tr:first").after(newRows);

                    if(status === "success" && data.length > 0)
                      tableEffect('1.0');
                    else tableEffect('0.0');
                });

            });

            tableEffect('0.0');
        })


    </script>

</head>
<body>

<div class="container">

    <div class="starter-template">

        <h1>Interval Weather Example</h1></br>

        <div style="padding-left: 40%">
            City name: <input type="text" name="fCity" id="fCity"></br>

            <input type="submit" value="Submit" id="submit"></br>

            <div id="error"></div>
        </div>


        <table id="tableCity" width="90%">
                <caption>City Weather</caption>
                </br>
                <tr>
                    <th>Name</th>
                    <th>City</th>
                    <th>State</th>
                    <th>Country</th>
                    <th>country Iso3166</th>
                    <th>country_name</th>
                    <th>zmw</th>
                    <th>l</th>

                </tr>
            <tbody style="width: 100%" id="tableBody">

            </tbody>
        </table>

    </div>

</div>

</body>

</html>