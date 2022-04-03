<% String devName = config.getInitParameter("developer"); %>

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
        <div class="main">
                <h2>Select your Courses:</h2>
                <form action="output.jsp" method="post">
                        <div class="courses">
                                <label>
                                        <input type="radio" checked="checked" name="course" value="BCA">
                                        BCA
                                </label>
                                <label>
                                        <input type="radio" name="course" value="MCA">
                                        MCA
                                </label>
                                <label>
                                        <input type="radio" name="course" value="MSC">
                                        MSC
                                </label>
                                <label>
                                        <input type="radio" name="course" value="BSC">
                                        BSC
                                </label>
                        </div>


                        <h3>Check all your preferred transportation :</h3>
                        <div class="transport">
                                <label>
                                        <input type="checkbox" checked="checked" name="transport" value="Bus">
                                        Bus
                                </label>
                                <label>
                                        <input type="checkbox" name="transport" value="Train">
                                        Train
                                </label>
                                <label>
                                        <input type="checkbox" name="transport" value="Taxi">
                                        Taxi
                                </label>
                                <label>
                                        <input type="checkbox" name="transport" value="Private Cab">
                                        Private Cab
                                </label>

                        </div>
                        <br />
                
                        <label style="margin-left: 1rem;">
                                Enter Local address:
                                <input type="text" name="address" style="width: 40%; margin-left: 1rem;">
                                
                        </label>
                      
                        <br />       

                        <br />
                        <button type="submit" style="margin-left: 1rem; padding: 5px 10px;">Submit</button>
                </form>
                <hr/>
                <div style="text-align: center; padding: 1rem 0;">This site is made by: <%= devName %></div>
                <hr/>
        </div>
</body>

</html>