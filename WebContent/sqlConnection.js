//var connection = new ActiveXObject("ADODB.Connection");
//
//var connectionstring = "Data Source=jdbc:mysql://localhost:3306/;Initial Catalog=spassignment;User ID=root;Password=SQ8wvP5d;Provider=SQLOLEDB";
//
//connection.Open(connectionstring);
//var rs = new ActiveXObject("ADODB.Recordset");
//function test() {
//	rs.Open("SELECT * FROM Users", connection);
//	rs.MoveFirst
//	while (!rs.eof) {
//		document.write(rs.fields(1));
//		rs.movenext;
//	}
//}
//
//rs.close;
//connection.close;


function test(){
	var tableRef = document.getElementById('productTable').getElementsByTagName('tbody')[0];

	// Insert a row in the table at the last row
	var newRow   = tableRef.insertRow();

	// Insert a cell in the row at index 0
	var newCell  = newRow.insertCell(0);

	// Append a text node to the cell
	var newText  = document.createTextNode('New row');
	newCell.appendChild(newText);
}