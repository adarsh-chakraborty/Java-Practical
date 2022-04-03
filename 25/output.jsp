
  
<%! 
	private String course;   
	private String[] transport;
	private String address;	 	
%>

<%
course = request.getParameter("course");
address = request.getParameter("address");

if(address == null || address == ""){
	address = "No Locality was given.";
}
String devName = config.getInitParameter("developer");
transport = request.getParameterValues("transport");
%>

<html>
<title>Transport selection</title>

<head>
        <style>
                body {
                        display: flex;
                        justify-content: center;
                        font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
                }

                .main {
                        width: 40%;
                        height: min-content;
                        border: 1px solid black;
                        border-radius: 4px;
                        padding: 2rem 5rem;
                        margin-top: 1rem;
                }

                .courses {
                        display: flex;
                        gap: .75rem;
                }

                .transport {

                        margin-left: 1rem;
                        display: flex;
                        flex-direction: column;
                        gap: 0.5rem;
                }
        </style>

<body>
        
</body>
<div class="main">
  <h2>Request received!!</h2>
  <h3>You've selected the following transportation methods for <%= course %> course:</h3>
	<%


if (transport!=null)
	for(int i=0; i<transport.length; i++)	
		out.println(i+1 + ". " + transport[i] + "<br/>");
	
if (transport==null)
	out.println("No transportation was selected.<br/>");	
%>

  <p>Locality: <%= address%></p>

  <h4>We have received your request, you will be reached out soon.</h4>
	<br/>
	<hr/>

<div style="text-align: center; padding: 1rem 0;">This site is made by <%= devName %></div>
<hr/>
</div>

</html>