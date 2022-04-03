import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import java.sql.DriverManager;
import java.sql.DatabaseMetaData;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class GenerateIndexPage extends HttpServlet{

public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
  Connection conn = null;
    res.setContentType("text/html");
    PrintWriter pw=res.getWriter();

    // Normal page generation
    pw.println("""
    <!DOCTYPE html>
<html lang=\"en\">
  <head>
    <meta charset=\"UTF-8\" />
    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />
    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />
    <title>DB TABLE</title>
    
    <link rel=\"stylesheet\" href=\"style.css\" />
    <style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

.text-Bold {
  font-size: medium;
  font-weight: bold;
}

.data-area {
  margin-top: 1.5rem;
  display: flex;
  flex-direction: column;
  align-items: center;
  margin: auto;
}

.data-area table {
  display: block;
  margin-top: 1rem;
}
.container {
  width: 70%;
  margin: auto;
  display: flex;
  flex-direction: column;
  gap: 1rem;
  align-items: center;
  margin-top: 4.5rem;
}

.select_style {
  overflow: hidden;
}
.select_style select {
  -webkit-appearance: none;
  appearance: none;
  width: 120%;
  background: none;
  background: transparent;
  border: none;
  outline: none;
}

.select_style {
  background: #fff;
  overflow: hidden;
  display: inline-block;
  color: #525252;
  font-weight: 300;
  -webkit-border-radius: 5px 4px 4px 5px/5px 5px 4px 4px;
  -moz-border-radius: 5px 4px 4px 5px/5px 5px 4px 4px;
  border-radius: 5px 4px 4px 5px/5px 5px 4px 4px;
  -webkit-box-shadow: 0 0 5px rgba(123, 123, 123, 0.2);
  -moz-box-shadow: 0 0 5px rgba(123, 123, 123, 0.2);
  box-shadow: 0 0 5px rgba(123, 123, 123, 0.2);
  border: solid 1px #dadada;
  font-family: 'helvetica neue', arial;
  position: relative;
  cursor: pointer;
  padding: 10px 15px;
}

.select_style span {
  position: absolute;
  right: 10px;
  width: 10px;
  height: 10px;
  background: url('http://projects.authenticstyle.co.uk/niceselect/arrow.png')
    no-repeat;
  top: 50%;
  margin-top: -4px;
}

#dataTable {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#dataTable td,
#dataTable th {
  border: 1px solid #ddd;
  padding: 8px;
}

#dataTable tr:nth-child(even) {
  background-color: #f2f2f2;
}

#dataTable tr:hover {
  background-color: #ddd;
}

#dataTable th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #546e7a;
  color: white;
}

</style>
  </head>
  <body>
    <div class=\"container\">
      <div class=\"\">
        <span class=\"text-Bold\">Select Table: &nbsp;</span>
        <select name=\"table_name\" id=\"table_name\" class=\"select_style\">
          <option value=\"\" disabled selected>Select Table</option>
""");
          
    try{
      String url = "jdbc:mysql://localhost:3306/java_practicals";
      Properties property = new Properties();
      property.put("user", "root");
      property.put("password", "superdoge1234");
      Class.forName("com.mysql.cj.jdbc.Driver");
    
      conn = DriverManager.getConnection(url,property);

  

      DatabaseMetaData metaData = conn.getMetaData();
      String[] types = {"TABLE"};
   
      ResultSet tables = metaData.getTables("java_practicals", null, "%", types);

      
      while (tables.next()) {
        String tableName = tables.getString("TABLE_NAME");
         pw.println("<option value=\""+tableName+"\">"+tableName+"</option>");
      }

      pw.println("""
</select>
      </div>
      <div class=\"\">
        <span class=\"text-Bold\">Select Field: &nbsp;</span>
        <select name=\"field_name\" id=\"field_name\" class=\"select_style\">
          <option value=\"\" disabled selected>Select Field</option>
        </select>
      </div>
      <div class=\"data-area\"></div>
    </div>
  </body>

  <script>
  console.log('Script attached');

const baseUrl = window.location.href;

const tableSelector = document.querySelector('#table_name');
const fieldSelector = document.querySelector('#field_name');
const dataArea = document.querySelector('.data-area');

tableSelector.addEventListener('change', tableChangeHandler);
fieldSelector.addEventListener('change', fieldChangeHandler);

let currentOptions = [];

async function tableChangeHandler(e) {
  currentOptions = [];
  dataArea.innerHTML = '';
  const req = await fetch(baseUrl + `/GetTableFields?table=${e.target.value}`);
  const data = await req.text();

  removeAll(fieldSelector);

  const fields = data.split('\\r\\n');
  const newOption = document.createElement('option');
  const optionText = document.createTextNode('All');
  newOption.appendChild(optionText);
  newOption.setAttribute('value', 'all');
  fieldSelector.appendChild(newOption);

  fields.forEach((field) => {
    if (field.trim()) {
      const newOption = document.createElement('option');
      const optionText = document.createTextNode(field);
      newOption.appendChild(optionText);
      newOption.setAttribute('value', field);
      fieldSelector.appendChild(newOption);
      currentOptions.push(field);
    }
  });
}

async function fieldChangeHandler(e) {
  const selectedTable = tableSelector.options[tableSelector.selectedIndex];
  const selectedField = fieldSelector.options[fieldSelector.selectedIndex];

  const req = await fetch(
    baseUrl +
      `/GetTableData?table=${selectedTable.value}&field=${selectedField.value}`
  );
  const data = await req.text();

  renderDataTable(selectedTable.value, selectedField.value, data);
}

function removeAll(selectBox) {
  while (selectBox.options.length > 0) {
    selectBox.remove(0);
  }
}

function renderDataTable(tableName, fieldName, tableContent) {
  if (fieldName.toLowerCase() === 'all') {
    let htmlString = `<h2>${tableName}<h2><table id='dataTable'><tr>`;

    for (let field of currentOptions) {
      htmlString += `<th>${field}</th>`;
    }

    htmlString += `</tr >`;

    // Array of fields
    const records = tableContent.split('$$'); // Record split
    for (let record of records) {
      if (record) {
        const temp = record.split('\\r\\n');
        htmlString += `</tr>`;
        for (let temp2 of temp) {
          if (temp2) {
            htmlString += `
            <td>${temp2.trim()}</td>
            `;
          }
        }
        htmlString += `</tr>`;
      }
    }

    dataArea.innerHTML = htmlString + '</table>';
    return;
  }
  const data = tableContent.split('$$');
  let htmlString = `<h2>${tableName}<h2><table id='dataTable'><tr>
  <th>${fieldName}</th>
</tr>`;
  for (let item of data) {
    if (item.trim()) {
      htmlString += `<tr>
    <td>${item.trim()}</td>
    </tr>`;
    }
  }

  dataArea.innerHTML = htmlString + '</table>';
}

  </script>
  
</html>
    """);
      
    }catch(Exception e){
     e.printStackTrace();
    }finally{
      
      try{
        conn.close();
      }catch(SQLException e){
        e.printStackTrace();
      }
    }

}}