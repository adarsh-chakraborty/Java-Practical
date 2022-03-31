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
