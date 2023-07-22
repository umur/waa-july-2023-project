import React from "react";


export default function GenericTable(props) {
    let tableData = props.tableData;
    const headers = tableData.headers;
    const columnNames = tableData.columnNames;
    const rows = tableData.rows;
    var tableHtml = '<table class="table table-hover" id="'+tableData.tableId+'">';
    tableHtml += '<tr className="bg-dark text-white">';
    headers.forEach((item) => {
        tableHtml += '<th>'+item+'</th>';
    })
    tableHtml += '</tr>';
    rows.forEach((row) => {
        tableHtml += '<tr>';
        columnNames.forEach((key) => {
            tableHtml += '<th>'+row[key]+'</th>';
        })
        tableHtml += '</tr>';
    })
    tableHtml += '</table>';
    return (
        <div dangerouslySetInnerHTML={{ __html: tableHtml }} />
    )
}